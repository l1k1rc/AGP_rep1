package domain;

import java.util.ArrayList;

import core.Excursion;
import core.Hotel;
import core.Site;
import core.Trip;

public class PricesFilter {
	private int minimal_price;
	private int maximal_price;
	private ArrayList<Site> sites;
	private Hotel hotel;
	private ArrayList<Excursion> excursions;
	private ArrayList<Trip> trips;
	
	public PricesFilter(int minimal_price, int maximal_price, ArrayList<Site> sites, Hotel hotel) {
		super();
		this.minimal_price = minimal_price;
		this.maximal_price = maximal_price;
		this.sites = sites;
		this.hotel = hotel;
		excursions_Listener(this.minimal_price, this.maximal_price, this.sites, this.hotel);
	}
	
	private void excursions_Listener(int minimal_price, int maximal_price, ArrayList<Site> sites, Hotel hotel){
		
		
	}
	
	
	
	
	
	
	
	

	public int getMinimal_price() {
		return minimal_price;
	}

	public void setMinimal_price(int minimal_price) {
		this.minimal_price = minimal_price;
	}

	public int getMaximal_price() {
		return maximal_price;
	}

	public void setMaximal_price(int maximal_price) {
		this.maximal_price = maximal_price;
	}

	public ArrayList<Site> getSites() {
		return sites;
	}

	public void setSites(ArrayList<Site> sites) {
		this.sites = sites;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(ArrayList<Excursion> excursions) {
		this.excursions = excursions;
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}
	
}
