package domain;

import java.util.ArrayList;

import core.Boat;
import core.Bus;
import core.Excursion;
import core.Hotel;
import core.Location;
import core.Site;
import core.Transport;
import core.Trip;

public class PricesFilter {
	
	private static boolean site_redudancy(Site siteToCompare, Excursion excursion) {
		boolean redondancy = false;
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
				excursion.addTransport(transportAtoB); 
			}	
			pos++;
		}
		excursion.totalPriceRecalculator();
		
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
		ArrayList<Location> begining = new ArrayList<Location>();
		begining.add(hotel);
		
		@SuppressWarnings("unchecked")
		Excursion beginingExcursion = new Excursion(0, (ArrayList<Location>) begining.clone());
		
		ArrayList<Excursion> tempExcursions = new ArrayList<Excursion>();
		tempExcursions.add(beginingExcursion);
		
		for(Excursion actual_excu: tempExcursions) {
			for(Site site: sites) {
				if(!site_redudancy(site, actual_excu)) {
					actual_excu.addLocation(site);
					actual_excu = excursion_price(actual_excu);
					if(actual_excu.getTotalPrice() <= maximal_price) {
						//TODO: voir id clonage etc
						tempExcursions.add(actual_excu);
					}
				}
			}
		}
		
		ArrayList<Excursion> finalExcursions = new ArrayList<Excursion>();
		for(Excursion actual_excu: tempExcursions) {
			if(actual_excu.getTotalPrice()>=minimal_price) {
				finalExcursions.add(actual_excu);
			}
		}
		
		return finalExcursions;
	}
		
}
