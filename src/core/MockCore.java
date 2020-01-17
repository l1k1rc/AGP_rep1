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
	private static ArrayList<Trip> tripFound = new ArrayList<Trip>();

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

	public static List<Trip> getTripFound(String keyword, String excursion, String price1, String price2,
			String valueComfort) {
		ArrayList<String> resultMixQuery = new ArrayList<String>();
		FacadeAPI facadeAPI = new MixOperator();
		ArrayList<String> siteQUERYId = new ArrayList<String>();
		String comfort;
		// tripFound = tripBuilder.tripBuilderAgent(null, null, "", "", "", "");
		/*System.out.println("Prix 1 : " + price1 + " Prix 2 : " + price2 + " confort : " + comfort + " Excursion : "
				+ excursion + "Keyword = " + keyword);
		System.out.println("Requete API keyword :" + facadeAPI.queryAPI("SELECT * FROM site with " + keyword));

		// if (excursion.contains("2"))*/
		ArrayList<String> hotelID = new ArrayList<String>();
		ArrayList<Hotel> hotelsALL = new ArrayList<Hotel>();
		
		hotelsALL = HotelPersistence.operatorSQL("SELECT * FROM hotel");

		for (Hotel h : hotelsALL) {
			hotelID.add(String.valueOf(h.getId()));
		}
		siteQUERYId = facadeAPI.queryAPI("SELECT * FROM site with " + keyword);
		System.err.println("\n Site id sent : "+siteQUERYId);
		System.err.println("\n Hotel ID sent : " + hotelID);
		/*tripFound = tripBuilder.tripBuilderAgent(facadeAPI.queryAPI("SELECT * FROM site with " + keyword), hotelID,
				price1, price2, comfort, "7");*/
		// else
		// resultMixQuery = facadeAPI.queryAPI("SELECT * FROM site WHERE hist_act=" +
		// excursion + " with " + keyword);
		//////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////
		ArrayList<String> sitesID = new ArrayList<String>();
		sitesID.add("1"); sitesID.add("2"); sitesID.add("4"); sitesID.add("5");sitesID.add("6");
		
		ArrayList<String> hotelsID = new ArrayList<String>();
		hotelsID.add("1"); hotelsID.add("2"); hotelsID.add("3");  hotelsID.add("4");  hotelsID.add("5");
		

		
		System.err.println("CONFORT   :"+valueComfort);
		System.out.println("\n"+tripBuilder.tripBuilderAgent(siteQUERYId, hotelID, price1, price2, "sportif", excursion));
		System.out.println("\n"+tripBuilder.tripBuilderAgent(siteQUERYId, hotelID, price1, price2, "sportif", excursion).size());
		System.out.println("Get trips found by request : " + tripFound);

		tripFound=tripBuilder.tripBuilderAgent(siteQUERYId, hotelID, price1, price2, "sportif", excursion);
		return tripFound;
	}
	/*public static void main(String[] args) {
		getTripFound(null, null, null, null, null);
		ArrayList<String> sitesID = new ArrayList<String>();
		sitesID.add("1"); sitesID.add("2"); sitesID.add("4"); sitesID.add("5");sitesID.add("6");
		
		ArrayList<String> hotelsID = new ArrayList<String>();
		hotelsID.add("1"); hotelsID.add("2"); hotelsID.add("3");  hotelsID.add("4");  hotelsID.add("5");
		
		String price_min = "50";
		String price_max = "10000";
		
		String comfort = "sportif";
		String typeSite = "7";
		
		System.out.println("\n"+tripBuilder.tripBuilderAgent(sitesID, hotelsID, price_min, price_max, comfort, typeSite));
		System.out.println("\n"+tripBuilder.tripBuilderAgent(sitesID, hotelsID, price_min, price_max, comfort, typeSite).size());
		
	}*/
}
