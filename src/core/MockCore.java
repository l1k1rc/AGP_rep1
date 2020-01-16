package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import persistence.jdbc.HotelPersistence;
import persistence.jdbc.SitePersistence;

/**
 * A utility class for providing data simulation (act as a simple database).
 * 
 */
public class MockCore {

	private static List<Hotel> hotelFound = new ArrayList<Hotel>();
	private static List<Site>  siteFound = new ArrayList<Site>();

	public static List<Hotel> getHotelFound(String island, String price1, String price2, String stars) {
		System.out.println("Get hotel found by request : "+island+price1+price2+stars);
		hotelFound = HotelPersistence.operatorSQL("SELECT * FROM hotel WHERE price>="+price1+" AND price<="+price2+" AND quality="+stars+" AND island_id="+island);
		return hotelFound;
	}
	
	// attention activity String !!
	public static List<Site> getSiteFound(String island , String price1 , String price2 , String activity ) {
		System.out.println("Get site found by request : "+island+price1+price2+activity);
		siteFound = SitePersistence.querySQL("SELECT * FROM site WHERE price>="+price1+" AND price<="+price2+" AND hist_act="+activity+" AND island_id="+island);
		return siteFound;
	}
	

}
