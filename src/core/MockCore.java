package core;

import java.util.ArrayList;
import java.util.List;

import domain.tripBuilder;
import persistence.API.FacadeAPI;
import persistence.API.MixOperator;
import persistence.jdbc.HotelPersistence;
import persistence.jdbc.SitePersistence;

/**
 * A utility class for providing data simulation (act as a simple database).
 * 
 */
public class MockCore {

	private static List<Hotel> hotelFound = new ArrayList<Hotel>();
	private static List<Site> siteFound = new ArrayList<Site>();
	private static List<Trip> tripFound = new ArrayList<Trip>();

	public static List<Hotel> getHotelFound(String island, String price1, String price2, String stars) {
		// System.out.println("Get hotel found by request : " + island + price1 + price2
		// + stars);
		if (island.contains("0"))
			hotelFound = HotelPersistence.operatorSQL(
					"SELECT * FROM hotel WHERE price>=" + price1 + " AND price<=" + price2 + " AND quality=" + stars);
		else
			hotelFound = HotelPersistence.operatorSQL("SELECT * FROM hotel WHERE price>=" + price1 + " AND price<="
					+ price2 + " AND quality=" + stars + " AND island_id=" + island);
		return hotelFound;
	}

	// attention activity String !!
	public static List<Site> getSiteFound(String island, String price1, String price2, String activity) {
		// System.out.println("Get site found by request : " + island + price1 + price2
		// + activity);
		if (island.contains("0"))
			siteFound = SitePersistence.querySQL("SELECT * FROM site WHERE price>=" + price1 + " AND price<=" + price2
					+ " AND hist_act=" + activity);
		else
			siteFound = SitePersistence.querySQL("SELECT * FROM site WHERE price>=" + price1 + " AND price<=" + price2
					+ " AND hist_act=" + activity + " AND island_id=" + island);
		return siteFound;
	}

	public static List<Trip> getTripFound(String keyword, String excursion) {
		ArrayList<String> resultMixQuery = new ArrayList<String>();
		FacadeAPI facadeAPI = new MixOperator();

		tripFound = tripBuilder.tripBuilderAgent(null, null, "", "", "", "");

		if (excursion.contains("2"))
			resultMixQuery = facadeAPI.queryAPI("SELECT * FROM site with " + keyword);
		else
			resultMixQuery = facadeAPI.queryAPI("SELECT * FROM site WHERE hist_act=" + excursion + " with " + keyword);
		// System.out.println("Get trips found by request : " + tripFound);
		System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG" + resultMixQuery);
		return tripFound;
	}

}
