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
	
	private static boolean site_redudancy(Location siteToCompare, Excursion excursion) {
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
		/////
		//System.out.println("##################### Excursion_price ##################");
		//System.out.println("On calcul le prix de l'excursion : " + excursion + " pour les sites : " + excursion.getLocations());

		//Add hotel to end of list, end of excursion loop
		excursion.endExcursion();
		for(Location location: excursion.getLocations()) {
			//System.out.println("Iteration :  " + pos);

			if((pos+1) < excursion.getLocations().size()) {
				//System.out.println("Première loca : " + location.getName() + " Deuxième loca : " + excursion.getLocations().get(pos+1).getName());

				//Calculate distance in Km between A and B
				distance = Distances.disanceBetweenPoints(location.getPosition().getX(), location.getPosition().getY(), 
						excursion.getLocations().get(pos+1).getPosition().getX(), excursion.getLocations().get(pos+1).getPosition().getY());
				/////////
				//System.out.println("Distance entre les deux : " + distance);
				//Define transport type between Site A and Site B
				transportAtoB = transport_type(location, excursion.getLocations().get(pos+1));
				////////
				//m.out.println("Transport type entre les 2 : " + transportAtoB.getType());
				//Adding transport distance
				transportAtoB.setDistance(distance);
				/////////
				//System.out.println("Distance reset : " + transportAtoB.getDistance());
				//Calculate transport price
				transportAtoB.priceRecalculator();
				//////
				//System.out.println("Prix recalculé : " + transportAtoB.getPrice());
				//Adding transport to transport list in excursion
				//System.out.println("Transport actuel " + excursion.getTransports());

				excursion.addTransport(transportAtoB); 
				//System.out.println("Transport après ajout " + excursion.getTransports());

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
	
	public static ArrayList<Excursion> excursions_Listener(int minimal_price, int maximal_price, ArrayList<Site> sites, Hotel hotel){		 
		
		ArrayList<Location> begining = new ArrayList<Location>();
		begining.add(hotel);
		
		@SuppressWarnings("unchecked")
		Excursion beginingExcursion = new Excursion(0, (ArrayList<Location>) begining.clone());
		
		ArrayList<Excursion> tempExcursions = new ArrayList<Excursion>();
		tempExcursions.add(beginingExcursion);
		//////
		
		for(Excursion actual_excu: tempExcursions) {

			for(Site site: sites) {
				Excursion ouiExcursion = new Excursion(actual_excu.getId(), actual_excu.getExcursionFee(), (ArrayList<Location>) actual_excu.getLocations().clone(),
						actual_excu.getLocationsPrice(), (ArrayList<Transport>) actual_excu.getTransports().clone(), actual_excu.getTransportsPrice(), actual_excu.getTotalPrice());
				//System.out.println("//////// Excursions temporaire : " + tempExcursions + " \\\\\\\\\\\\\\\\\\");
				//System.out.println(tempExcursions.toString());

				///////
				System.out.println("///////La con de tes morts\\\\\\\\");
				System.out.println("Actual excursion : " + ouiExcursion.toString());
				///////
				System.out.println("Actual site : " + site.getName());
				
				if(!site_redudancy(site, ouiExcursion)) {
					if(site_redudancy(ouiExcursion.getLocations().get(ouiExcursion.getLocations().size()-1), ouiExcursion)) {
						if(ouiExcursion.getTransports().size() > 1) ouiExcursion.getLocations().remove(ouiExcursion.getLocations().size()-1);
						if(ouiExcursion.getTransports().size() > 0) ouiExcursion.getTransports().remove(ouiExcursion.getLocations().size()-1);
						ouiExcursion.totalPriceRecalculator();
					}
					
					ouiExcursion.addLocation(site);
					ouiExcursion = excursion_price(ouiExcursion);
					if(ouiExcursion.getTotalPrice() <= maximal_price) {
						//TODO: voir id clonage etc
						tempExcursions.add(ouiExcursion);
					}
				}
				System.out.println("Apreès excursion : " + ouiExcursion.toString());

				System.out.println("\\\\\\\\La con de tes morts///////////");

			}
			System.out.println("tempExcursion  Loool : " + tempExcursions.toString());

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
