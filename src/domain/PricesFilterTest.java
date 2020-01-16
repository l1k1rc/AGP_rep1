package domain;

import java.util.ArrayList;

import core.Excursion;
import core.Historical;
import core.Hotel;
import core.Site;

public class PricesFilterTest {
	public static void main(String[] args) {
		//decl
		Historical site1 = new Historical(1, "site1", 10, 1, 1, 1, "bus");
		Historical site2 = new Historical(2, "site2", 15, 2, 3, 1, "bus");
		Historical site3 = new Historical(3, "site3", 20, 7, 8, 2, "bus");
		ArrayList<Site> sites = new ArrayList<Site>();
		sites.add(site1); sites.add(site2); sites.add(site3);
		
		Hotel hotel1 = new Hotel(0, "hotel1", 30, 6, 4, 1, "Playa carmen", true, 3);
		
		int prix_min = 1;
		int prix_max = 1000;
		
		
		ArrayList<Excursion> excursions = new ArrayList<Excursion>();
		excursions = PricesFilter.excursions_Listener(prix_min, prix_max, sites, hotel1);
		System.out.println("Liste finale d'excursions : " + excursions);
	}
}
