package domain;

import java.util.ArrayList;

public class tripBuilderTest {

	public static void main(String[] args) {
		ArrayList<String> sitesID = new ArrayList<String>();
		sitesID.add("1"); sitesID.add("2"); sitesID.add("4"); 
		
		ArrayList<String> hotelsID = new ArrayList<String>();
		hotelsID.add("1"); hotelsID.add("2"); hotelsID.add("3");
		
		String price_min = "50";
		String price_max = "1000";
		
		String comfort = "sportif";
		String typeSite = "0";
		
		tripBuilder.tripBuilderAgent(sitesID, hotelsID, price_min, price_max, comfort, typeSite);


	}
}
