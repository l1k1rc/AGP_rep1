package unitTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import core.Boat;
import core.Bus;
import core.Excursion;
import core.Location;
import core.Site;
import core.Transport;
import domain.PricesFilter;

class PricesFilterTest {
	
	private static boolean redondancyTest;
	private static Site siteToCompare1;
	private static Site siteToCompare2;
	private static Excursion excursion;
	private static ArrayList<Location> locations;
	private static Location location1;
	private static Location location2;
	private static Location location3;
	private static Location location4;
	
	private static Transport transportTest;
	
	


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		location1 = new Location(1, "name", 14, 0, 1, 1, "site", "bus");
		location2 = new Location(2, "name", 14, 0, 1, 1, "site", "bus");
		location3 = new Location(3, "name", 14, 0, 1, 1, "site", "boat");
		location4 = new Location(4, "name", 14, 0, 1, 2, "site", "bus");
		
		locations = new ArrayList<Location>();
		locations.add(location1);
		locations.add(location2);
		locations.add(location3);
		
		siteToCompare1 = new Site();
		siteToCompare1.setId(7);
		siteToCompare2 = new Site();
		siteToCompare2.setId(3);
		
		excursion = new Excursion(1);
		excursion.setLocations(locations);

	}

	@Test
	void test() {
		//test1 site_redudancy method
		redondancyTest = PricesFilter.site_redudancy(siteToCompare1, excursion);
		//exp
		boolean redondancyExp = false;
		//comp
		assertEquals("le retour doit être false",redondancyExp,redondancyTest);
		
		//test2 site_redudancy method
		redondancyTest = PricesFilter.site_redudancy(siteToCompare2, excursion);
		//exp
		redondancyExp = false;
		//comp
		assertEquals("le retour doit être false",redondancyExp,redondancyTest);
		
		
		//test1 transport_type method
		transportTest = PricesFilter.transport_type(location1, location2);
		//exp
		Transport transportExp = new Bus();
		//comp
		assertEquals("Le retour doit être un bus",transportExp.getType(), transportTest.getType());
		
		//test2 transport_type method
		transportTest = PricesFilter.transport_type(location1, location3);
		//exp
		transportExp = new Boat();
		//comp
		assertEquals("Le retour doit être un boat",transportExp.getType(), transportTest.getType());
		
		//test3 transport_type method
		transportTest = PricesFilter.transport_type(location1, location4);
		//exp is boat
		//comp
		assertEquals("Le retour doit être boat",transportExp.getType(),transportTest.getType());
		
		
	}

}