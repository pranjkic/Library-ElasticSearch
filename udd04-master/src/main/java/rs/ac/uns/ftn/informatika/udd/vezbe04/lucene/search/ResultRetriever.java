package rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.search;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.indexing.handlers.DocumentHandler;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.indexing.handlers.PDFHandler;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.indexing.handlers.TextDocHandler;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.indexing.handlers.Word2007Handler;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.indexing.handlers.WordHandler;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.IndexUnit;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.RequiredHighlight;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.ResultData;

@Service
public class ResultRetriever {
	
	private ElasticsearchTemplate template;
	
	@Autowired
	public ResultRetriever(ElasticsearchTemplate template){
		this.template = template;
	}

	public List<ResultData> getResults(org.elasticsearch.index.query.QueryBuilder query,
			List<RequiredHighlight> requiredHighlights) {
		if (query == null) {
			return null;
		}
			
		List<ResultData> results = new ArrayList<ResultData>();
		
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(query)
				.build();
       
        List<IndexUnit> indexUnits = template.queryForList(searchQuery, IndexUnit.class);

        /*for (IndexUnit indexUnit : indexUnits) {
        	results.add(new ResultData(indexUnit.getTitle(), 
        							   indexUnit.getKeywords(), 
        							   indexUnit.getFilename(),
        							   ""));*/
        
        for (IndexUnit indexUnit : indexUnits) {
        	results.add(new ResultData(indexUnit.getInternalId(),
        							   indexUnit.getTitle(), 
        							   indexUnit.getAuthor(),
        							   indexUnit.getGenre(),
        							   indexUnit.getISBN(),
        							   indexUnit.getKeywords(), 
        							   indexUnit.getPublisher(),
        							   indexUnit.getPublishingyear(),
        							   indexUnit.getPublishingplace(),
        							   indexUnit.getpagenumber(),
        							   indexUnit.getsysnopys(),
        							   indexUnit.getlectoringdata(),
        							   indexUnit.getDirectors(),
        							   indexUnit.getContent(),
        							   indexUnit.getFilename(),
        							   ""));
		}
        
        //if (requiredHighlights.get(0).getFieldName() != null && results.size() != 0) {
			//mapHighlightedContent(searchQuery, results);
		//}
		
		return results;
	}
	
	private void mapHighlightedContent(SearchQuery searchQuery, final List<ResultData> books) {
		template.queryForPage(searchQuery, IndexUnit.class, new SearchResultMapper() {

			public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
				//for (int i = 0; i < searchResponse.getHits().totalHits(); i++) {
				for (int i = 0; i < books.size(); i++) {
					if (searchResponse.getHits().getHits().length <= 0) {
						return null;
					}
					String highlight = "";
					if (searchResponse.getHits().getAt(i).getHighlightFields() != null) {
						for (Text s : searchResponse.getHits()
								.getAt(i)
								.getHighlightFields()
								.get("text")
								.getFragments()) {
							highlight += s.string();
						}
					}
					books.get(i).setHighlight(highlight);
				}
				return null;
			}
		});
	}
	
	protected DocumentHandler getHandler(String fileName){
		if(fileName.endsWith(".txt")){
			return new TextDocHandler();
		}else if(fileName.endsWith(".pdf")){
			return new PDFHandler();
		}else if(fileName.endsWith(".doc")){
			return new WordHandler();
		}else if(fileName.endsWith(".docx")){
			return new Word2007Handler();
		}else{
			return null;
		}
	}
}
