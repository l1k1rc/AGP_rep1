package core;

public class Site {
	private String description;
	private float price;
	private String position;
	private String type;
	private String name;
	private String access_type;
	
	public Site(String description, float price, String position, String type, String name, String access_type) {
		super();
		this.description = description;
		this.price = price;
		this.position = position;
		this.type = type;
		this.name = name;
		this.access_type = access_type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccess_type() {
		return access_type;
	}

	public void setAccess_type(String access_type) {
		this.access_type = access_type;
	}
	
	
}
