package unitTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import persistence.API.FacadeAPI;
import persistence.API.SQLOperator;

class SQLOperatorTest {
	
	private ArrayList<String> sqlOperatorTest = new ArrayList<String>();
	private static FacadeAPI apiSQL;
	private static String requestTest1;
	private static String requestTest2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		apiSQL = new SQLOperator();
		requestTest1 = "";
		requestTest2 = "SELECT * FROM site WHERE position_x=9 and position_y=6";
		
	}

	@Test
	void test() {
		//test
		sqlOperatorTest = apiSQL.queryAPI(requestTest1);
		//exp
		ArrayList<String> sqlOperatorTExp = new ArrayList<String>();
		//comp
		assertEquals("Le résultat de la requête aurait dû être le même", sqlOperatorTExp, sqlOperatorTest);
		
		//test
		sqlOperatorTest = apiSQL.queryAPI(requestTest2);
		//comp
		ArrayList<String> sqlOperatorTExp1 = new ArrayList<String>();
		sqlOperatorTExp1.add("1");
		sqlOperatorTExp1.add("parc Loro parque");
		sqlOperatorTExp1.add("38.0");
		sqlOperatorTExp1.add("false");
		sqlOperatorTExp1.add("[9,6]");
		assertEquals("Le résultat de la requête aurait dû être vide", sqlOperatorTExp1, sqlOperatorTest);
		
	}

}
