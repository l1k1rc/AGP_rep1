package unitTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import lucene.LuceneTester;
import persistence.API.APIDatabase;

import persistence.API.TextualOperator;

class TextualOperatorTest {
	private ArrayList<String> textOperatorTest = new ArrayList<String>();
	private static String requestTest;
	private static APIDatabase apiText;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		apiText = new TextualOperator();
		requestTest = "Plongée";
	}

	@Test
	void test() {
		//test
		textOperatorTest = apiText.queryAPI(requestTest);
		//Exp
		String requestExp = "Plongée";
		ArrayList<String> textOperatorTExp = new ArrayList<String>();
		LuceneTester.searchResult(requestExp);
		textOperatorTExp = LuceneTester.getIndexFile();
		//Comp
		assertEquals("Le résultat de la requête aurait dû être le même", textOperatorTExp, textOperatorTest);
		System.out.println(textOperatorTest);
				
	}

}
