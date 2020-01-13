package core;

import java.util.HashMap;

public class Excursion {
	private HashMap<String,Site> sites;
	private Transport transport;
	private ExcursionPrice excursion_price;
	private String date;
	private boolean all_day_long;
	
	
	public Excursion(HashMap<String, Site> sites, Transport transport, ExcursionPrice excursion_price, String date,
			boolean all_day_long) {
		super();
		this.sites = sites;
		this.transport = transport;
		this.excursion_price = excursion_price;
		this.date = date;
		this.all_day_long = all_day_long;
	}


	public HashMap<String, Site> getSites() {
		return sites;
	}


	public void setSites(HashMap<String, Site> sites) {
		this.sites = sites;
	}


	public Transport getTransport() {
		return transport;
	}


	public void setTransport(Transport transport) {
		this.transport = transport;
	}


	public ExcursionPrice getExcursion_price() {
		return excursion_price;
	}


	public void setExcursion_price(ExcursionPrice excursion_price) {
		this.excursion_price = excursion_price;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public boolean isAll_day_long() {
		return all_day_long;
	}


	public void setAll_day_long(boolean all_day_long) {
		this.all_day_long = all_day_long;
	}
		
	
}
