package unitTest;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import domain.Distances;

class DistancesTest {
	
	private static int distancesTest;
	private static int x1,x2,y1,y2;
	private static int coef_multiplicator=15;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		x1=3;
		x2=5;
		y1=3;
		y2=4;
	}

	@Test
	void test() {
		//test
		distancesTest = Distances.disanceBetweenPoints(x1, y1, x2, y2);
		//exp
		double distanceExp = Math.sqrt(Math.pow(x2-x1, 2.0)+Math.pow(y2-y1, 2.0))*coef_multiplicator;
		//comp
		assertEquals("Le résultat doit être égal !",(int)distanceExp, distancesTest);
		
	}

}