package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import persistence.jdbc.HotelPersistence;

/**
 * A utility class for providing data simulation (act as a simple database).
 * 
 */
public class MockCore {

	private static List<Hotel> hotelFound = new ArrayList<Hotel>();

	public static List<Hotel> getHotelFound(String island, String price1, String price2, String stars) {
		System.out.println("Get hotel found by request : "+island+price1+price2+stars);
		hotelFound = HotelPersistence.operatorSQL("SELECT * FROM hotel WHERE price>"+price1+" AND price<"+price2+" AND quality="+stars+" AND island_id="+island);
		return hotelFound;
	}

	

}
