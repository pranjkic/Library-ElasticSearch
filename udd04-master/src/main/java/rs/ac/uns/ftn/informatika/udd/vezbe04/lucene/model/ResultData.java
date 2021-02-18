package rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model;

public final class ResultData {
	
	private String title;	
	private String keywords;
	private String location;
	private String highlight;
	
	private String author;
	private String genre;
	private String ISBN;		
	private String publisher;	
	private String publishingyear;	
	private String publishingplace;	
	private String pagenumber;	
	private String sysnopys;	
	private String lectoringdata;	
	private String directors;	
	private String content;
	private String internalId;
	
	public ResultData() {
		super();
	}

	public ResultData(String title, String keywords, String location, String highlight) {
		super();
		this.title = title;
		this.keywords = keywords;
		this.location = location;
		this.highlight = highlight;
	}
	
	public ResultData(String internalID, String title, String author, String genre, String ISBN, String keywords, String publisher,
			String publishingyear, String publishingplace, String pagenumber, String sysnopys, String lectoringdata,
			String directors, String content, String location, String highlight) {
		super();
		this.internalId = internalID;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.ISBN = ISBN;		
		this.keywords = keywords;
		this.publisher = publisher;
		this.publishingyear = publishingyear;
		this.publishingplace = publishingplace;
		this.pagenumber = pagenumber;
		this.sysnopys = sysnopys;
		this.lectoringdata = lectoringdata;
		this.directors = directors;
		this.content = content;
		this.location = location;
		this.highlight = highlight;
	}
	
	public String getInternalId() {
		return internalId;
	}
	public void setInternalId(String internalId) {
		this.internalId = internalId;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
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

}
