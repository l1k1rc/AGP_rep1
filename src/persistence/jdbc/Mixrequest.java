package persistence.jdbc;

import lucene.LuceneTester;

public class Mixrequest {
	private String request;
	
	public static void main(String[] args) {
		Mixrequest mixrequest = new Mixrequest("SELECT nom, clé FROM T with sculpture voyage;");
		String[] s=mixrequest.getSeparatedValue();
		System.out.println(s[0]+" :::: "+s[1]);
		LuceneTester.searchResult(s[1]);
		System.out.println(LuceneTester.getIndexFile());
	}
	public Mixrequest(String request) {
		this.request = request;
	}
	public String[] getSeparatedValue() {
		String separator ="with";
		return request.split(separator);
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
}
