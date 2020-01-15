package persistence.jdbc;

import java.util.ArrayList;

import core.Site;
import lucene.LuceneTester;
import persistence.API.APIDatabase;
import persistence.API.MixOperator;
/**
 * This class allow to merge data from SQL query and textual query.
 * @see APIDatabase
 * @see MixOperator
 *
 */
public class Mixrequest {
	private String request;
	private ArrayList<String> fileKeyIndex = new ArrayList<String>();

	public Mixrequest() {
	}

	/**
	 * This method allows the results of the two previously separate queries to be
	 * grouped together in order to match the keys of the articles in the database
	 * with the keys of the text files.
	 * 
	 * @return the result of the mix query.
	 * @see SitePersistence
	 */
	public ArrayList<String> getIndexFileNumberForMixRequest() {
		ArrayList<String> finalIndex = new ArrayList<String>();
		ArrayList<Site> resultSQLrequest = new ArrayList<Site>();
		Mixrequest mixrequest = new Mixrequest("SELECT * FROM site WHERE price=50 with plongée;");
		String[] s = mixrequest.getSeparatedValue();

		// For SQL request
		resultSQLrequest = SitePersistence.querySQL(s[0]);
		for (int i = 0; i < resultSQLrequest.size(); i++)
			System.out.println(resultSQLrequest.get(i).getId());
		// For Lucene part
		// System.out.println(s[0] + " :::: " + s[1]);

		LuceneTester.searchResult(s[1]);
		// System.out.println(LuceneTester.getIndexFile());
		fileKeyIndex = mixrequest.getIndexNumberOf(LuceneTester.getIndexFile());
		// System.out.println(fileKeyIndex);
		for (int i = 0; i < fileKeyIndex.size(); i++) {
			for (int j = 0; j < resultSQLrequest.size(); j++) {
				if (fileKeyIndex.get(i).equals(Integer.toString(resultSQLrequest.get(j).getId()))) {
					finalIndex.add(String.valueOf(resultSQLrequest.get(j).getId()));
				}
			}
		}

		// Contains the fusion between SQL request AND the textual request.
		// System.err.println("Final obtenue avec mix : " + finalIndex);
		return finalIndex;
	}

	/**
	 * This method gotta split the path received to retrieve only the name of the
	 * file.
	 * 
	 * @param data : is the path of the indexed file
	 * @return
	 */
	public ArrayList<String> getIndexNumberOf(ArrayList<String> data) {
		String separator = "/";
		ArrayList<String> resultS = new ArrayList<String>();
		for (String s : data) {
			System.out.println(s);
			String[] segmentation = s.split(separator);
			resultS.add(segmentation[segmentation.length - 1].replaceAll(".[^.]*\\z", ""));
		}
		return resultS;
	}

	public ArrayList<String> getFileKeyIndex() {
		return fileKeyIndex;
	}

	public Mixrequest(String request) {
		this.request = request;
	}

	public String[] getSeparatedValue() {
		String separator = "with";
		return request.split(separator);
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
