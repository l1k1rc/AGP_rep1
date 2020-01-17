package domain;

import java.util.ArrayList;

public class tripBuilderTest {

	public static void main(String[] args) {
		ArrayList<String> sitesID = new ArrayList<String>();
		sitesID.add("1"); sitesID.add("2"); sitesID.add("4"); sitesID.add("5");sitesID.add("6");
		
		ArrayList<String> hotelsID = new ArrayList<String>();
		hotelsID.add("1"); hotelsID.add("2"); hotelsID.add("3");  hotelsID.add("4");  hotelsID.add("5");
		
		String price_min = "50";
		String price_max = "10000";
		
		String comfort = "sportif";
		String typeSite = "7";
		
		System.out.println(tripBuilder.tripBuilderAgent(sitesID, hotelsID, price_min, price_max, comfort, typeSite));
		System.out.println(tripBuilder.tripBuilderAgent(sitesID, hotelsID, price_min, price_max, comfort, typeSite).size());



	}
}
