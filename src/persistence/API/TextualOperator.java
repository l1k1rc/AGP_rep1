package persistence.API;

import java.util.ArrayList;

import lucene.LuceneTester;

public class TextualOperator implements FacadeAPI {

	public ArrayList<String> indexFile = new ArrayList<String>();

	@SuppressWarnings("static-access")
	@Override
	public ArrayList<String> queryAPI(String query) {
		// TODO Auto-generated method stub

		ArrayList<String> indexFile = new ArrayList<String>();
		LuceneTester tester = new LuceneTester();
		tester.searchResult(query);
		indexFile = tester.getIndexFile();
		return indexFile;
	}

}