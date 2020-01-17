package domain;

import java.util.ArrayList;

import core.Boat;
import core.Bus;
import core.Excursion;
import core.Historical;
import core.Hotel;
import core.Location;
import core.Site;
import core.Transport;
import core.Trip;

public class PricesFilter {
	
<<<<<<< HEAD
	private static boolean site_redudancy(Site siteToCompare, Excursion excursion) {
		boolean redondancy = false;
=======
	private static boolean site_redudancy(Location siteToCompare, Excursion excursion) {
		boolean redondancy = false;

>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
		for(Location site: excursion.getLocations()) {
			if(site.getId() == siteToCompare.getId()) redondancy = true;
		}
		
		return redondancy;
	}
	
	private static Transport transport_type(Location A, Location B) {
		if((B.getAccess() == "boat") || (A.getIsland() != B.getIsland())) {
			Boat transport = new Boat();
			return transport;
		} else {
			Bus transport = new Bus();
			return transport;
		}
	}
	
	
	private static Excursion excursion_price(Excursion excursion) {
		int distance;
		int pos = 0;
		Transport transportAtoB;
<<<<<<< HEAD
		
		//Add hotel to end of list, end of excursion loop
		excursion.endExcursion();
		for(Location location: excursion.getLocations()) {
			if((pos+1) <= excursion.getLocations().size()) {
				//Calculate distance in Km between A and B
				distance = Distances.disanceBetweenPoints(location.getPosition().getX(), location.getPosition().getY(), 
						excursion.getLocations().get(pos+1).getPosition().getX(), excursion.getLocations().get(pos+1).getPosition().getY());
				//Define transport type between Site A and Site B
				transportAtoB = transport_type(location, excursion.getLocations().get(pos+1));
				//Adding transport distance
				transportAtoB.setDistance(distance);
				//Calculate transport price
				transportAtoB.priceRecalculator();
				//Adding transport to transport list in excursion
=======
		//Add hotel to end of list, end of excursion loop
		excursion.endExcursion();
		for(Location location: excursion.getLocations()) {
			if((pos+1) < excursion.getLocations().size()) {

				//Calculate distance in Km between A and B
				distance = Distances.disanceBetweenPoints(location.getPosition().getX(), location.getPosition().getY(), 
						excursion.getLocations().get(pos+1).getPosition().getX(), excursion.getLocations().get(pos+1).getPosition().getY());

				//Define transport type between Site A and Site B
				transportAtoB = transport_type(location, excursion.getLocations().get(pos+1));
				
				//Adding transport distance
				transportAtoB.setDistance(distance);
				
				//Calculate transport price
				transportAtoB.priceRecalculator();
				
				//Adding transport to transport list in excursion

>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
				excursion.addTransport(transportAtoB); 
			}	
			pos++;
		}
		excursion.totalPriceRecalculator();
		
<<<<<<< HEAD
		return excursion;
	}
	
	/*private int validExcursionTester(Excursion excursion, Location site) {
		Location lastSite = excursion.getLocations().get(excursion.getLocations().size()-1);
		//Dist
		int distance = Distances.disanceBetweenPoints(
				lastSite.getPosition().getX(), lastSite.getPosition().getY(),
				site.getPosition().getX(), site.getPosition().getY()
				);
		//Transport
		Transport AtoB = this.transport_type(lastSite, site);
		
		return 0;
	}*/
	
	private static ArrayList<Excursion> excursions_Listener(int minimal_price, int maximal_price, ArrayList<Site> sites, Hotel hotel){		
=======
		excursion.totalPriceRecalculator();
		
		return excursion;
	}
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Excursion> excursions_Listener(int minimal_price, int maximal_price, ArrayList<Site> sites, Hotel hotel){		 
		//Init of first itération (the hotel)
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
		ArrayList<Location> begining = new ArrayList<Location>();
		begining.add(hotel);
		
		Excursion beginingExcursion = new Excursion(0, (ArrayList<Location>) begining.clone());
		
		ArrayList<Excursion> tempExcursions = new ArrayList<Excursion>();
		tempExcursions.add(beginingExcursion);
		
		//Indicate when while will stop
		int stopCounter = 0;
		//Will browse excursion list
		int pointer = 0;
		while (stopCounter != 1) {		
	
			for(Site site: sites) {
<<<<<<< HEAD
				if(!site_redudancy(site, actual_excu)) {
					actual_excu.addLocation(site);
					actual_excu = excursion_price(actual_excu);
					if(actual_excu.getTotalPrice() <= maximal_price) {
						//TODO: voir id clonage etc
						tempExcursions.add(actual_excu);
=======
				//New excursion
				Excursion pointerExcursion = new Excursion(tempExcursions.get(pointer).getId(), tempExcursions.get(pointer).getExcursionFee(), 
						(ArrayList<Location>) tempExcursions.get(pointer).getLocations().clone(),
						tempExcursions.get(pointer).getLocationsPrice(), (ArrayList<Transport>) tempExcursions.get(pointer).getTransports().clone(),
						tempExcursions.get(pointer).getTransportsPrice(), tempExcursions.get(pointer).getTotalPrice());
				
				
				//System.out.println("Actual excursion : " + pointerExcursion.toString());
				//In order to avoid redondancy
				if(!site_redudancy(site, pointerExcursion)) {
					if(site_redudancy(pointerExcursion.getLocations().get(pointerExcursion.getLocations().size()-1), pointerExcursion)) {
						//Delete last site, the hotel
						if(pointerExcursion.getTransports().size() > 1) pointerExcursion.getLocations().remove(pointerExcursion.getLocations().size()-1);
						//Reset transports, it will be Recalculated below
						pointerExcursion.resetTransport();
						pointerExcursion.totalPriceRecalculator();
					}
					
					pointerExcursion.addLocation(site);
					pointerExcursion = excursion_price(pointerExcursion);
					
					if(pointerExcursion.getTotalPrice() <= maximal_price) {
						tempExcursions.add(pointerExcursion);
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
					}
				}
				//System.out.println("Après excursion : " + pointerExcursion.toString());
			}
			
			pointer++;
			if (pointer == tempExcursions.size()) stopCounter = 1;
		}
		
<<<<<<< HEAD
		ArrayList<Excursion> finalExcursions = new ArrayList<Excursion>();
		for(Excursion actual_excu: tempExcursions) {
			if(actual_excu.getTotalPrice()>=minimal_price) {
				finalExcursions.add(actual_excu);
=======
		//Check if minimal price is respected
		ArrayList<Excursion> finalExcursions = new ArrayList<Excursion>();
		for(Excursion excur: tempExcursions) {
			if(excur.getTotalPrice()>=minimal_price) {
				finalExcursions.add(excur);
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
			}
		}
		
		return finalExcursions;
	}
<<<<<<< HEAD
		
=======
			
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
}
