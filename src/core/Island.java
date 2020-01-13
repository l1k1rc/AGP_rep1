package core;

import java.util.HashMap;

public class Island {
	private String name;
	private HashMap<String,Hotel> hotels;
	
	public Island(String name) {
		super();
		this.name = name;
		this.hotels = new HashMap<String,Hotel>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(HashMap<String, Hotel> hotels) {
		this.hotels = hotels;
	}
	
	
}
