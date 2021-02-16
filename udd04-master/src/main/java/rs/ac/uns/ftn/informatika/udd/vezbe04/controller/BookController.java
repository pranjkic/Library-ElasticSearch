package rs.ac.uns.ftn.informatika.udd.vezbe04.controller;

import java.io.File;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.indexing.Indexer;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.IndexUnit;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.UploadModel;

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
        /*try {
        	
        	//indexUploadedFile(model);

        } catch (IOException e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }*/
    	
        return new ResponseEntity<String>(model.getTitle(), HttpStatus.OK);

    }

}
