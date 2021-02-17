package rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = IndexUnit.INDEX_NAME, type = IndexUnit.TYPE_NAME, shards = 1, replicas = 0)
public class IndexUnit {
	public static final String INDEX_NAME = "digitallbookibrary";
	public static final String TYPE_NAME = "digitallbook";

	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	
	//@Id
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String title;	
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String author;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String genre;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String ISBN;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String keywords;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String publisher;
	
	@Field(type = FieldType.Integer, index = FieldIndex.analyzed, store = true)
	private String publishingyear;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String publishingplace;
	
	@Field(type = FieldType.Integer, index = FieldIndex.analyzed, store = true)
	private String pagenumber;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String sysnopys;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String lectoringdata;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String directors;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String content;
	
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private String filedate;
	
	@Field(type = FieldType.Long, index = FieldIndex.analyzed, store = true)
	private Long internalId;
	
	//addition
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String text;
	
	@Id
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
	private String filename;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiledate() {
		return filedate;
	}
	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}
	
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
	/*
	//multipart file
	public MultipartFile[] getFiles() {
        return files;
    }
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    } 
    */
	
	
	/*
	public static final String INDEX_NAME = "digitallibrary";
	public static final String TYPE_NAME = "book";
	
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String text;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String title;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String keywords;
	@Id
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
	private String filename;
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private String filedate;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiledate() {
		return filedate;
	}
	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}
	*/
	
}
