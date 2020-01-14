package core;

import java.util.ArrayList;

public class Trip {
	private int id;
	private Hotel hotel;
	private int duration_in_days;
	private ArrayList<Excursion> excursions;
	private float price;
	
	public Trip(int id) {
		this(id, null, 0, null, 0);
	}
	
	public Trip(int id, Hotel hotel) {
		this(id, hotel, 0, null, 0);
	}

	public Trip(int id, Hotel hotel, int duration_in_days, ArrayList<Excursion> excursions) {
		this(id, hotel, duration_in_days, excursions, 0);
	}

	public Trip(int id, Hotel hotel, int duration_in_days, ArrayList<Excursion> excursions, float price) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.duration_in_days = duration_in_days;
		this.excursions = excursions;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getDuration_in_days() {
		return duration_in_days;
	}

	public void setDuration_in_days(int duration_in_days) {
		this.duration_in_days = duration_in_days;
	}

	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(ArrayList<Excursion> excursions) {
		this.excursions = excursions;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
