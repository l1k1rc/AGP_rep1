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
import core.Trip;

public class tripBuilder {
	
	public static ArrayList<Trip> tripBuilderAgent(ArrayList<Site> sites, ArrayList<Hotel> hotels, int minimal_price, int maximal_price, String confort){
		Historical site1 = new Historical(1, "site1", 10, 1, 1, 1, "bus");
		Historical site2 = new Historical(2, "site2", 15, 2, 3, 1, "bus");
		Historical site3 = new Historical(3, "site3", 20, 7, 8, 2, "boat");
		Activity site4 = new Activity(4, "site4", 10, 10, 10, 2, "bus");
		Activity site5 = new Activity(5, "site5", 10, 11, 11, 2, "bus");
		Activity site6 = new Activity(6, "site6", 10, 12, 12, 2, "boat");
		
		Hotel hotel1 = new Hotel(0, "hotel1 laveurlaveur", 30, 6, 4, 1, "Playa GUIAULLME", true, 3);
		Hotel hotel2 = new Hotel(0, "hotel7 ratonraton", 30, 6, 4, 1, "Playa RATON", true, 3);
		Hotel hotel3 = new Hotel(0, "hotel9 lalalala", 30, 6, 4, 1, "Playa LAVEUR", true, 3);

		Boat boat1 = new Boat(50, 50);
		Bus bus1 = new Bus(30, 80);

		ArrayList<Location> listLoca1 = new ArrayList<Location>();
		listLoca1.add(hotel1); listLoca1.add(site1); listLoca1.add(site2); listLoca1.add(site4);listLoca1.add(site6); listLoca1.add(hotel1);
		ArrayList<Transport> listTrans1 = new ArrayList<Transport>();
		listTrans1.add(boat1); listTrans1.add(bus1); listTrans1.add(boat1); listTrans1.add(bus1); listTrans1.add(boat1);
		Excursion excursion1 = new Excursion(0, 10, listLoca1, 50, listTrans1, 100, 160);
		Excursion excursion2 = new Excursion(0, 10, listLoca1, 50, listTrans1, 100, 160);
		Excursion excursion3 = new Excursion(0, 10, listLoca1, 50, listTrans1, 100, 160);
		Excursion excursion4 = new Excursion(0, 10, listLoca1, 50, listTrans1, 100, 160);
		Excursion excursion5 = new Excursion(0, 10, listLoca1, 50, listTrans1, 100, 160);

		ArrayList<Excursion> listExcur1 = new ArrayList<Excursion>();
		listExcur1.add(excursion1); listExcur1.add(excursion1); listExcur1.add(excursion1); listExcur1.add(excursion1); listExcur1.add(excursion1);
		Trip trip1 = new Trip(1, hotel1, listExcur1, 1022);
		Trip trip2 = new Trip(1, hotel2, listExcur1, 1022);
		Trip trip3 = new Trip(1, hotel1, listExcur1, 1022);
		Trip trip4 = new Trip(1, hotel2, listExcur1, 1022);
		Trip trip5 = new Trip(1, hotel3, listExcur1, 1022);
		Trip trip6 = new Trip(1, hotel1, listExcur1, 1022);
		Trip trip7 = new Trip(1, hotel3, listExcur1, 1022);
		Trip trip8 = new Trip(1, hotel1, listExcur1, 1022);
		Trip trip9 = new Trip(1, hotel2, listExcur1, 1022);
		Trip trip10 = new Trip(1, hotel2, listExcur1, 1022);
		Trip trip11 = new Trip(1, hotel3, listExcur1, 1022);

		ArrayList<Trip> listTrip = new ArrayList<Trip>();
		listTrip.add(trip1); listTrip.add(trip2); listTrip.add(trip3); listTrip.add(trip4); listTrip.add(trip5);
		listTrip.add(trip6); listTrip.add(trip7); listTrip.add(trip8); listTrip.add(trip9); listTrip.add(trip10);
		listTrip.add(trip11); listTrip.add(trip1);

		return listTrip;
	}

}
