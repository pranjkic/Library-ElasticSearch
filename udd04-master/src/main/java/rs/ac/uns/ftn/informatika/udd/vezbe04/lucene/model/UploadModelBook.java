package rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class UploadModelBook {
	
	private String title;	

	private String author;
	
	private String genre;
	
	private String ISBN;
	
	private String keywords;
	
	private String publisher;
	
	private String publishingyear;
	
	private String publishingplace;
	
	private String pagenumber;
	
	private String sysnopys;
	
	private String lectoringdata;
	
	private String directors;
	
	private String content;
	
	private MultipartFile[] files;

    @Override
    public String toString() {
        return "UploadModel{" +
                "title='" + title + '\'' +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
