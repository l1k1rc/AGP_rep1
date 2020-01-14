package core;

public class Site {
	private String name;
	private String description;
	private float price;
	private String position;
	
	public Site(String name, String description, float price, String position) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}	
}