package core;

import java.util.ArrayList;

public class Trip {
	private int id;
	private Hotel hotel;
	private int duration;
	private ArrayList<Excursion> excursions;
	private int price;
	
	public Trip(int id) {
		this(id, null, null, 0);
	}
	
	public Trip(int id, Hotel hotel) {
		this(id, hotel, null, 0);
	}

	public Trip(int id, Hotel hotel, ArrayList<Excursion> excursions) {
		this(id, hotel, excursions, 0);
		this.priceRecalculator();
	}

	public Trip(int id, Hotel hotel, ArrayList<Excursion> excursions, int price) {
		super();
		this.id = id;
		this.hotel = hotel;
		if(excursions == null) 	this.excursions = new ArrayList<Excursion>();
		else this.excursions = excursions;
		this.duration = StaticData.trip_duration;
		this.price = price;
	}

	public void addExcursion(Excursion newExcursion) {
		this.excursions.add(newExcursion);
	}
	
	public void priceRecalculator() {
		this.price = 0;
		for(Excursion excursion: this.excursions) {
			excursion.totalPriceRecalculator();
			price += excursion.getTotalPrice();
		}
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(ArrayList<Excursion> excursions) {
		this.excursions = excursions;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
