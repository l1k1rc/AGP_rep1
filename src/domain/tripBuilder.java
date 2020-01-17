package domain;

import java.util.ArrayList;

import core.Activity;
import core.Boat;
import core.Bus;
import core.Excursion;
import core.Historical;
import core.Hotel;
import core.Location;
import core.Transport;
import core.Site;
import core.StaticData;
import core.Trip;
import persistence.jdbc.HotelPersistence;
import persistence.jdbc.SitePersistence;

public class tripBuilder {

	@SuppressWarnings("unchecked")
	public static ArrayList<Trip> tripCreator(ArrayList<Excursion> excursions, Hotel hotel, String comfort){
		ArrayList<Excursion> hotelExcursions = new ArrayList<Excursion>();
		for(Excursion exc: excursions) {
			if(exc.getLocations().get(0).getId() == hotel.getId()) hotelExcursions.add(exc);
		}
		
		int compt = 0;
		int id = 0;
		ArrayList<Trip> trips = new ArrayList<Trip>();
		//Trip trip = new Trip(0, hotel);
		for(Excursion hEs1: hotelExcursions) {
			Trip trip = new Trip(id, hotel);
			if (comfort == "sportif") {
				if (compt+StaticData.trip_duration <= hotelExcursions.size()) {
					id++;
					trip.addExcursion(hotelExcursions.get(compt));
					compt++;
					trip.addExcursion(hotelExcursions.get(compt));
					compt++;
					trip.addExcursion(hotelExcursions.get(compt));
					compt++;
					trip.addExcursion(hotelExcursions.get(compt));
					compt++;
					trip.addExcursion(hotelExcursions.get(compt));
					compt++;
					trip.priceRecalculator();
					trips.add(trip);
					
				}
			} else {
				if (compt+StaticData.trip_duration <= 3) {
					id++;
					ArrayList<Location> endroit = new ArrayList<Location>();
					Site plage = new Site(-1, "plage", 0, hotel.getPosition(), hotel.getIsland(), "Journée a la plage", "site", "bus", false);
					endroit.add(plage);
					Excursion plageE = new Excursion(-1, endroit, 0, null, 0, 0);
					trip.addExcursion(hotelExcursions.get(compt));
					compt++;
					trip.addExcursion(plageE);
					trip.addExcursion(hotelExcursions.get(compt));
					compt++;
					trip.addExcursion(plageE);
					trip.addExcursion(hotelExcursions.get(compt));
					compt++;
					trip.priceRecalculator();
					trips.add(trip);	
				}
			}
		}

		return trips;
	}


	public static ArrayList<Trip> tripBuilderAgent(ArrayList<String> sitesID, ArrayList<String> hotelsID,
			String minimal_price_str, String maximal_price_str, String comfort, String typeSite){
		
		//Init return ArrayList of trip
		ArrayList<Trip> trips = new ArrayList<Trip>();
		
		//If nothing then return nothing
		if(sitesID.size() == 0) return trips;
		if(hotelsID.size() == 0) return trips;
		
		int intID;
		//Get Site list from api
		ArrayList<Site> sites = new ArrayList<Site>();
		for(String id: sitesID) {
			//Convert string to int
			intID = Integer.parseInt(id);
			sites.add(SitePersistence.searchSiteById(intID));
		}
		
		//Get Hotel list from api
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		for(String id: hotelsID) {
			//Convert string to int
			intID = Integer.parseInt(id);
			hotels.add(HotelPersistence.searchHotelById(intID));
		}
		
		//Convert string to int
		int minimal_price = Integer.parseInt(minimal_price_str)/StaticData.trip_duration;
		int maximal_price = Integer.parseInt(maximal_price_str)/StaticData.trip_duration;
		
		//Init of our excursions lists
		ArrayList<Excursion> excursionsByPrice = new ArrayList<Excursion>();
		ArrayList<Excursion> excursionsByComfort = new ArrayList<Excursion>();
		ArrayList<Excursion> excursionsBySiteType = new ArrayList<Excursion>();
		
		//Harvest excursion by price, comfort, type
		for(Hotel hotel: hotels) {
			excursionsByPrice.addAll(PricesFilter.excursions_Listener(minimal_price, maximal_price, sites, hotel));
			excursionsByComfort.addAll(ComfortExcursionBuilder.comfortExcursionBuilderAgent(sites, hotel, comfort));
			if((typeSite == "0") || (typeSite == "1")) excursionsBySiteType.addAll(TypeExcursionBuilder.typeExcursionBuilderAgent(sites, hotel, typeSite));
			else excursionsBySiteType.addAll(ComfortExcursionBuilder.comfortExcursionBuilderAgent(sites, hotel, comfort));
		}
		
		System.out.println("By price : " + excursionsByPrice);
		System.out.println("Iterrations : " + excursionsByPrice.size());

		System.out.println("YOOO prix: " + excursionsByPrice.get(1).getId());
		System.out.println("By comfort : " + excursionsByComfort);
		System.out.println("Iterrations : " + excursionsByComfort.size());

		System.out.println("By type : " + excursionsBySiteType);
		System.out.println("Iterrations : " + excursionsBySiteType.size());



		//fusion between price and comfort
		ArrayList<Excursion> interExcursions = new ArrayList<Excursion>();
		for(Excursion ePrice: excursionsByPrice) {
			for(Excursion eComfort: excursionsByComfort) {
				if(eComfort.getId() == ePrice.getId()) {
					interExcursions.add(ePrice);
					break;
				}
			}
		}
		
		//fusion between price/comfort and typeSite
		ArrayList<Excursion> finalExcursions = new ArrayList<Excursion>();
		for(Excursion eInter: interExcursions) {
			for(Excursion eType: excursionsBySiteType) {
				if(eInter.getId() == eType.getId()) {
					finalExcursions.add(eInter);
					break;
				}
			}
		}
		
		System.out.println("All : " + finalExcursions);
		System.out.println("Iterrations : " + finalExcursions.size());

		for(Hotel hotel: hotels) {
			trips.addAll(tripCreator(finalExcursions, hotel, comfort));
		}
		
		
		return trips;
	}

	/*
	 * Historical site1 = new Historical(1, "site1", 10, 1, 1, 1, "bus"); Historical
	 * site2 = new Historical(2, "site2", 15, 2, 3, 1, "bus"); Historical site3 =
	 * new Historical(3, "site3", 20, 7, 8, 2, "boat"); Activity site4 = new
	 * Activity(4, "site4", 10, 10, 10, 2, "bus"); Activity site5 = new Activity(5,
	 * "site5", 10, 11, 11, 2, "bus"); Activity site6 = new Activity(6, "site6", 10,
	 * 12, 12, 2, "boat");
	 * 
	 * Hotel hotel1 = new Hotel(0, "hotel1 laveurlaveur", 30, 6, 4, 1,
	 * "Playa GUIAULLME", true, 3); Hotel hotel2 = new Hotel(0, "hotel7 ratonraton",
	 * 30, 6, 4, 1, "Playa RATON", true, 3); Hotel hotel3 = new Hotel(0,
	 * "hotel9 lalalala", 30, 6, 4, 1, "Playa LAVEUR", true, 3);
	 * 
	 * Boat boat1 = new Boat(50, 50); Bus bus1 = new Bus(30, 80);
	 * 
	 * ArrayList<Location> listLoca1 = new ArrayList<Location>();
	 * listLoca1.add(hotel1); listLoca1.add(site1); listLoca1.add(site2);
	 * listLoca1.add(site4);listLoca1.add(site6); listLoca1.add(hotel1);
	 * ArrayList<Transport> listTrans1 = new ArrayList<Transport>();
	 * listTrans1.add(boat1); listTrans1.add(bus1); listTrans1.add(boat1);
	 * listTrans1.add(bus1); listTrans1.add(boat1); Excursion excursion1 = new
	 * Excursion(0, 10, listLoca1, 50, listTrans1, 100, 160); Excursion excursion2 =
	 * new Excursion(0, 10, listLoca1, 50, listTrans1, 100, 160); Excursion
	 * excursion3 = new Excursion(0, 10, listLoca1, 50, listTrans1, 100, 160);
	 * Excursion excursion4 = new Excursion(0, 10, listLoca1, 50, listTrans1, 100,
	 * 160); Excursion excursion5 = new Excursion(0, 10, listLoca1, 50, listTrans1,
	 * 100, 160);
	 * 
	 * ArrayList<Excursion> listExcur1 = new ArrayList<Excursion>();
	 * listExcur1.add(excursion1); listExcur1.add(excursion1);
	 * listExcur1.add(excursion1); listExcur1.add(excursion1);
	 * listExcur1.add(excursion1); Trip trip1 = new Trip(1, hotel1, listExcur1,
	 * 1022); Trip trip2 = new Trip(1, hotel2, listExcur1, 1022); Trip trip3 = new
	 * Trip(1, hotel1, listExcur1, 1022); Trip trip4 = new Trip(1, hotel2,
	 * listExcur1, 1022); Trip trip5 = new Trip(1, hotel3, listExcur1, 1022); Trip
	 * trip6 = new Trip(1, hotel1, listExcur1, 1022); Trip trip7 = new Trip(1,
	 * hotel3, listExcur1, 1022); Trip trip8 = new Trip(1, hotel1, listExcur1,
	 * 1022); Trip trip9 = new Trip(1, hotel2, listExcur1, 1022); Trip trip10 = new
	 * Trip(1, hotel2, listExcur1, 1022); Trip trip11 = new Trip(1, hotel3,
	 * listExcur1, 1022);
	 * 
	 * ArrayList<Trip> listTrip = new ArrayList<Trip>(); listTrip.add(trip1);
	 * listTrip.add(trip2); listTrip.add(trip3); listTrip.add(trip4);
	 * listTrip.add(trip5); listTrip.add(trip6); listTrip.add(trip7);
	 * listTrip.add(trip8); listTrip.add(trip9); listTrip.add(trip10);
	 * listTrip.add(trip11); listTrip.add(trip1);
	 * 
	 * return listTrip;
	 * 
	 */
}
