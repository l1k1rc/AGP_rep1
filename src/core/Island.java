package core;

import java.util.ArrayList;

public class Island {
	private String name;
	private ArrayList<Site> sites;
	private ArrayList<Hotel> hotels;
	
	public Island(String name) {
		this(name,null,null);
	}
	
	public Island(String name, ArrayList<Site> sites, ArrayList<Hotel> hotels) {
		super();
		this.name = name;
		this.sites = sites;
		this.hotels = hotels;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Site> getSites() {
		return sites;
	}

	public void setSites(ArrayList<Site> sites) {
		this.sites = sites;
	}

	public ArrayList<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}

}
