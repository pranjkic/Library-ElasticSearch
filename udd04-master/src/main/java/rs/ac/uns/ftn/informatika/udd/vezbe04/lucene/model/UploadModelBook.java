package rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class UploadModelBook {
	
	public String title;

	public String author;
	
	public String genre;
	
	public String ISBN;
	
	public String keywords;
	
	public String publisher;
	
	public String publishingyear;
	
	public String publishingplace;
	
	public String pagenumber;
	
	public String sysnopys;
	
	public String lectoringdata;
	
	public String directors;
	
	public String content;
	
	public MultipartFile[] files;
	
	public MultipartFile[] getFiles() {
        return files;
    }
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }   
    
    public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
    @Override
    public String toString() {
        return "UploadModel{" +
                "title='" + title + '\'' +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
