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
	
	public static boolean site_redudancy(Location siteToCompare, Excursion excursion) {
		boolean redondancy = false;

		for(Location site: excursion.getLocations()) {
			if(site == siteToCompare) redondancy = true;
		}
		
		return redondancy;
	}
	
	public static Transport transport_type(Location A, Location B) {
		if((B.getAccess() == "boat") || (A.getIsland() != B.getIsland())) {
			Boat transport = new Boat();
			return transport;
		} else {
			Bus transport = new Bus();
			return transport;
		}
	}
	
	
	public static Excursion excursion_price(Excursion excursion) {
		int distance;
		int pos = 0;
		Transport transportAtoB;
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

				excursion.addTransport(transportAtoB); 
			}	
			pos++;
		}
		
		excursion.totalPriceRecalculator();
		
		return excursion;
	}
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Excursion> excursions_Listener(int minimal_price, int maximal_price, ArrayList<Site> sites, Hotel hotel){		
		int id = 0;
		//Init of first itération (the hotel)
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
				id++;
				//New excursion
				Excursion pointerExcursion = new Excursion(id, tempExcursions.get(pointer).getExcursionFee(), 
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
					
					if((pointerExcursion.getTotalPrice() <= maximal_price) && (pointerExcursion.getLocations().size() <= core.StaticData.hard_site_limit)) {
						tempExcursions.add(pointerExcursion);
					}
				}
				//System.out.println("Après excursion : " + pointerExcursion.toString());
			}
			
			pointer++;
			if (pointer == tempExcursions.size()) stopCounter = 1;
		}
		
		//Check if minimal price is respected
		ArrayList<Excursion> finalExcursions = new ArrayList<Excursion>();
		for(Excursion excur: tempExcursions) {
			if(excur.getTotalPrice()>=minimal_price) {
				finalExcursions.add(excur);
			}
		}
		
		//Delete first excursion; it's a hotel only excursion
		tempExcursions.remove(0);
		return finalExcursions;
	}
			
}