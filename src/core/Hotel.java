package core;

public class Hotel extends Location {
	private String beach;
	private boolean entertainment;
	private int stars;
	
	public Hotel() {
		super();
	}
	
	public Hotel(int id, String name, int price, int x, int y, String beach, boolean entertainment, int stars) {
		super(id, name, price, x, y);
		this.beach = beach;
		this.entertainment = entertainment;
		this.stars = stars;
	}
	public Hotel(int id, String name, int price, Point position, String beach, boolean entertainment, int stars) {
		super(id, name, price, position);
		this.beach = beach;
		this.entertainment = entertainment;
		this.stars = stars;
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
	
}
