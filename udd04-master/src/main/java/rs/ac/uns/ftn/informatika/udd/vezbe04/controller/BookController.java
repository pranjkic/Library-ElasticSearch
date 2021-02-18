package rs.ac.uns.ftn.informatika.udd.vezbe04.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import com.google.common.net.HttpHeaders;
//import com.google.common.net.MediaType;
import org.springframework.http.HttpHeaders;
//import javax.ws.rs.core.MediaType;

import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.indexing.Indexer;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.indexing.IndexerBook;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.IndexUnit;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.IndexUnitBook;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.UploadModel;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.UploadModelBook;

@RestController
public class BookController {
	
	private static String DATA_DIR_PATH;
	
	static {
		ResourceBundle rb=ResourceBundle.getBundle("application");
		DATA_DIR_PATH=rb.getString("dataDir");
	}
	
	@Autowired
	private Indexer indexer;
	
    @PostMapping("/indexbook/add")
    public ResponseEntity<String> multiUploadFileModel(@ModelAttribute UploadModel model) {
        try {
        	
        	indexUploadedFile(model);

        } catch (IOException e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    	
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    private void indexUploadedFile(UploadModel model) throws IOException{
    	
    	for (MultipartFile file : model.getFiles()) {

            if (file.isEmpty()) {
                continue; //next please
            }
            String fileName = saveUploadedFile(file);
            if(fileName != null){
            	IndexUnit indexUnit = indexer.getHandler(fileName).getIndexUnit(new File(fileName));
            	indexUnit.setTitle(model.getTitle());
            	indexUnit.setAuthor(model.getAuthor());
            	indexUnit.setGenre(model.getGenre());
            	indexUnit.setISBN(model.getISBN());
            	indexUnit.setKeywords(model.getKeywords());
            	indexUnit.setPublisher(model.getPublisher());
            	indexUnit.setPublishingyear(model.getPublishingyear());
            	indexUnit.setPublishingplace(model.getPublishingplace());
            	indexUnit.setpagenumber(model.getpagenumber());
            	indexUnit.setsysnopys(model.getsysnopys());
            	indexUnit.setlectoringdata(model.getlectoringdata());
            	indexUnit.setDirectors(model.getDirectors());
            	indexUnit.setContent(model.getContent());
            	indexUnit.setFilename(fileName);
            	indexer.add(indexUnit);
            }
    	}
    }
    
    private String saveUploadedFile(MultipartFile file) throws IOException {
    	
    	String retVal = null;
        if (! file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(getResourceFilePath(DATA_DIR_PATH).getAbsolutePath() + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);
            retVal = path.toString();
        }
        return retVal;
    }
    
    private File getResourceFilePath(String path) {
	    URL url = this.getClass().getClassLoader().getResource(path);
	    File file = null;
	    try {
	        file = new File(url.toURI());
	    } catch (URISyntaxException e) {
	        file = new File(url.getPath());
	    }   
	    return file;
	}
    
    @RequestMapping(value = "/download/{filename}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadBook(@PathVariable String filename) throws IOException {
		/*
		Book book = iBookRepository.findOne(id);

		if (book == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		

		File pdf = new File(book.getFilename());
		*/
		File pdf = new File(filename);
		FileSystemResource fileResource = new FileSystemResource(pdf);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.add("filename", fileResource.getFilename());

		// convert file to byte[]
		//byte[] bFile = readBytesFromFile(book.getFilename());
		byte[] bFile = readBytesFromFile(filename);

		return new ResponseEntity<byte[]>(bFile, headers, HttpStatus.OK);
	}
	
	private static byte[] readBytesFromFile(String filePath) {

		FileInputStream fileInputStream = null;
		byte[] bytesArray = null;
		try {

			File file = new File(filePath);
			bytesArray = new byte[(int) file.length()];

			// read file into bytes[]
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bytesArray);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bytesArray;

	}
}
