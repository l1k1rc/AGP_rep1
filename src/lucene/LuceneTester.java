package lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import beans.EntryBean;
public class LuceneTester {
	
   // Passer par le web content !!!
   static String indexDir = "/home/l1k1/Bureau/index";
   String dataDir = "/home/l1k1/Bureau/AGP";
   Indexer indexer;
   Searcher searcher;
   public static void main(String[] args) {
	      searchResult("hello");
	   }
   //Add jar lucene to WEB-CONTENT/WEB-INF/lib
   public static void searchResult(String keywords) {
	  System.out.println("Searching..."+keywords);
      LuceneTester tester;
      try {
         tester = new LuceneTester();
         System.out.println("TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"+keywords);
         Directory index = FSDirectory.open (Paths.get(indexDir));
         if (!DirectoryReader.indexExists(index)) {
        	 tester.createIndex(); 
         }
         System.out.println("TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"+keywords);
         tester.search("fuerteventura"); // GET KEYWORD HERE
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
   }
   public static void testlucene(String keyword) {
	   System.out.println(keyword);
   }
   private void createIndex() throws IOException {
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println(numIndexed+" File indexed, time taken: "
         +(endTime-startTime)+" ms");		
   }
   private void search(String searchQuery) throws IOException, ParseException {
      searcher = new Searcher(indexDir);
      long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      long endTime = System.currentTimeMillis();
   
      System.out.println(hits.totalHits +
         " documents found. Time :" + (endTime - startTime));
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
            System.out.println("File: "
            + doc.get(LuceneConstants.FILE_PATH));
      }  
   }
}