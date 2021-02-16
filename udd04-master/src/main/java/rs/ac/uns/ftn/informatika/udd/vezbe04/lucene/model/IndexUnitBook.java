package rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
/*
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
*/
@Document(indexName = IndexUnit.INDEX_NAME, type = IndexUnit.TYPE_NAME, shards = 1, replicas = 0)
public class IndexUnitBook {
	public static final String INDEX_NAME = "digitallibrary";
	public static final String TYPE_NAME = "book";

	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	@Id
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

	/*
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String language;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String category;
	
	@Id
	@Field(type = FieldType.String, index = FieldIndex.not_analyzed, store = true)
	private String filename;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private String filedate;
	
	@Field(type = FieldType.Long, index = FieldIndex.analyzed, store = true)
	private Long internalId;
	
	@Field(type = FieldType.String, index = FieldIndex.analyzed, store = true)
	private String text;
	*/
}
