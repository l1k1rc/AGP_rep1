package core;

import java.util.ArrayList;

public class Excursion {
	private int id;
	private ArrayList<Site> sites;
	private ArrayList<Transport> transports;
	private float price;
	
	public Excursion(int id) {
		this(id, null, null, 0);
	}

	public Excursion(int id, ArrayList<Site> sites, ArrayList<Transport> transports) {
		this(id, sites, transports, 0);
	}

	public Excursion(int id, ArrayList<Site> sites, ArrayList<Transport> transports, float price) {
		super();
		this.id = id;
		this.sites = sites;
		this.transports = transports;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Site> getSites() {
		return sites;
	}

	public void setSites(ArrayList<Site> sites) {
		this.sites = sites;
	}

	public ArrayList<Transport> getTransports() {
		return transports;
	}

	public void setTransports(ArrayList<Transport> transports) {
		this.transports = transports;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}