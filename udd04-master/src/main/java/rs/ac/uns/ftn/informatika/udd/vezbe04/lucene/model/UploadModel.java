package rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class UploadModel {
	
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

	//title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	//author
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	//genre
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	//ISBN
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String isbn) {
		this.ISBN = isbn;
	}
	//keywords
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}	
	
	//publisher
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}	
	//publishingyear
	public String getPublishingyear() {
		return publishingyear;
	}
	public void setPublishingyear(String publishingyear) {
		this.publishingyear = publishingyear;
	}	
	//publishingplace
	public String getPublishingplace() {
		return publishingplace;
	}
	public void setPublishingplace(String publishingplace) {
		this.publishingplace = publishingplace;
	}	
	//pagenumber
	public String getpagenumber() {
		return pagenumber;
	}
	public void setpagenumber(String pagenumber) {
		this.pagenumber = pagenumber;
	}	
	//sysnopys
	public String getsysnopys() {
		return sysnopys;
	}
	public void setsysnopys(String sysnopys) {
		this.sysnopys = sysnopys;
	}	
	//lectoringdata
	public String getlectoringdata() {
		return lectoringdata;
	}
	public void setlectoringdata(String lectoringdata) {
		this.lectoringdata = lectoringdata;
	}	
	//directors;
	public String getDirectors() {
		return directors;
	}
	public void setDirectors(String directors) {
		this.directors = directors;
	}	
	//content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
	//multipart file
	public MultipartFile[] getFiles() {
        return files;
    }
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    } 
	
    @Override
    public String toString() {
        return "UploadModel{" +
                "title='" + title + '\'' +
                ", files=" + Arrays.toString(files) +
                '}';
    }
	/*
    private String title;
    
    private String keywords;

    private MultipartFile[] files;

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "UploadModel{" +
                "title='" + title + '\'' +
                ", files=" + Arrays.toString(files) +
                '}';
    }
    */
}
