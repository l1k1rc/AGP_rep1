package core;

public class Hotel {
	private String name;
	private String beach;
	private boolean entertainment;
	private int stars;
	private float price_per_night;
	private String position;
	
	public Hotel(String name, String beach, boolean entertainment, int stars, float price_per_night, String position) {
		super();
		this.name = name;
		this.beach = beach;
		this.entertainment = entertainment;
		this.stars = stars;
		this.price_per_night = price_per_night;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeach() {
		return beach;
	}

	public void setBeach(String beach) {
		this.beach = beach;
	}

	public boolean isEntertainment() {
		return entertainment;
	}

	public void setEntertainment(boolean entertainment) {
		this.entertainment = entertainment;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public float getPrice_per_night() {
		return price_per_night;
	}

	public void setPrice_per_night(float price_per_night) {
		this.price_per_night = price_per_night;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
