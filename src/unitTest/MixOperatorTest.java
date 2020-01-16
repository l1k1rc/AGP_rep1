package unitTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import persistence.jdbc.Mixrequest;
import persistence.API.MixOperator;
import persistence.jdbc.Mixrequest;

class MixOperatorTest {
	private ArrayList<String> mixOperatorTest = new ArrayList<String>();
	private static String requestTest;
	private static String requestTest1;
	private static Mixrequest apiMix;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		apiMix = new Mixrequest();
		requestTest = "SELECT * FROM site WHERE price=50 with plongée";
		requestTest1 = "SELECT id FROM site WHERE price=50 with plongée";
	}

	@Test
	void test() {
		//test
		mixOperatorTest = apiMix.getIndexFileNumberForMixRequest(requestTest);
		//Exp
		String requestExp = "SELECT * FROM site WHERE price=50 with plongée";
		Mixrequest mixrequestExp = new Mixrequest();
		ArrayList<String> mixOperatorTExp = mixrequestExp.getIndexFileNumberForMixRequest(requestExp);
		//Comp
		assertEquals("Le résultat de la requête aurait dû être le même", mixOperatorTExp, mixOperatorTest);
		
		//test
		mixOperatorTest = apiMix.getIndexFileNumberForMixRequest(requestTest1);
		//Exp
		ArrayList<String> mixOperatorTExp1 = new ArrayList<String>();
		//Comp
		assertEquals("Le résultat aurait dû être vide", mixOperatorTExp1, mixOperatorTest);
	}

}
