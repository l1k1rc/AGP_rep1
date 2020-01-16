package core;

import java.util.ArrayList;

public class Excursion {
	private int id;
	private int excursionFee;
	private ArrayList<Location> locations;
	private int locationsPrice;
	private ArrayList<Transport> transports;
	private int transportsPrice;
	private int totalPrice;

	
	public Excursion(int id) {
		this(id, null, 0, null, 0, 0);
	}
	
	public Excursion(int id, ArrayList<Location> sites) {
		this(id, sites, 0, null, 0, 0);
	}

	public Excursion(int id, ArrayList<Location> sites, ArrayList<Transport> transports) {
		this(id, sites, 0, transports, 0, 0);
	}
	
	public Excursion(int id, ArrayList<Location> locations, int locationsPrice,
			ArrayList<Transport> transports, int transportsPrice, int totalPrice) {
		super();
		this.id = id;
		this.excursionFee = StaticData.excursion_fee;
		this.locationsPrice = locationsPrice;
		this.transportsPrice = transportsPrice;
		this.totalPrice = totalPrice;
		if(locations == null) 	this.locations = new ArrayList<Location>();
		else this.locations = locations;
		
		if(transports == null) this.transports = new ArrayList<Transport>();
		else this.transports = transports;

	}

	public Excursion(int id, int excursionFee, ArrayList<Location> locations, int locationsPrice,
			ArrayList<Transport> transports, int transportsPrice, int totalPrice) {
		super();
		this.id = id;
		this.excursionFee = excursionFee;
		this.locations = locations;
		this.locationsPrice = locationsPrice;
		this.transports = transports;
		this.transportsPrice = transportsPrice;
		this.totalPrice = totalPrice;
	}

	public void addLocation(Location newLocation) {
		locations.add(newLocation);
	}
	
	public void locationsPriceRecalculator() {
		this.locationsPrice = 0;
		for(Location location: locations) {
			locationsPrice += location.getPrice();
		}
	}
	
	public void addTransport(Transport newTransport) {
		//System.out.println("Ajout du transport dans Excursion.java : " + newTransport + " : " + newTransport.getType());

		this.transports.add(newTransport);
	}
	
	public void transportsPriceRecalculator() {
		this.transportsPrice = 0;
		for(Transport transport: transports) {
			transport.priceRecalculator();
			transportsPrice += transport.getPrice();
		}
	}
	
	public void totalPriceRecalculator() {
		this.locationsPriceRecalculator();
		this.transportsPriceRecalculator();
		this.totalPrice = this.excursionFee+this.locationsPrice+this.transportsPrice;
	}
	
	public void endExcursion() {
		Location hotel = this.locations.get(0);
		//Be sure to not pay hotel 2 times by day
		hotel.setPrice(0);
		this.locations.add(hotel);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExcursionFee() {
		return excursionFee;
	}

	public void setExcursionFee(int excursionFee) {
		this.excursionFee = excursionFee;
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}

	public int getLocationsPrice() {
		return locationsPrice;
	}

	public void setLocationsPrice(int locationsPrice) {
		this.locationsPrice = locationsPrice;
	}

	public ArrayList<Transport> getTransports() {
		return transports;
	}

	public void setTransports(ArrayList<Transport> transports) {
		this.transports = transports;
	}

	public int getTransportsPrice() {
		return transportsPrice;
	}

	public void setTransportsPrice(int transportsPrice) {
		this.transportsPrice = transportsPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Excursion [locations=" + locations + ", transports=" + transports + "]";
	}
	
	
	

}