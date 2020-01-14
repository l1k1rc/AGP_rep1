package persistence.jdbc;

import java.util.ArrayList;

import core.Site;
import lucene.LuceneTester;

public class Mixrequest {
	private String request;
	private ArrayList<String> fileKeyIndex = new ArrayList<String>();
	
	public Mixrequest() {
	}
	/*public static void main(String[] args) {
		Mixrequest mixrequest = new Mixrequest();
		mixrequest.getIndexFileNumberForMixRequest();
	}*/
	/**
	 * Retrieve the index of usefull file depend of the request sent.
	 */
	public void getIndexFileNumberForMixRequest() {
		ArrayList<Site> resultSQLrequest = new ArrayList<Site>();
		Mixrequest mixrequest = new Mixrequest("SELECT name, id FROM site with sculpture fuerteventura;");
		String[] s = mixrequest.getSeparatedValue();
		
		//For SQL request
		resultSQLrequest=SitePersistence.request(s[0]);
		for(int i=0;i<resultSQLrequest.size();i++)
			System.out.println(resultSQLrequest.get(i).getName());
		//For Lucene part
		System.out.println(s[0] + " :::: " + s[1]);
		
		LuceneTester.searchResult(s[1]);
		System.out.println(LuceneTester.getIndexFile());
		fileKeyIndex = mixrequest.getIndexNumberOf(LuceneTester.getIndexFile());
		System.out.println(fileKeyIndex);
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

















