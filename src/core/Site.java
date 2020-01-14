package core;

public class Site {
	private int id;
	private String name;
	private String description;
	private float price;
	private String type;
	private Point position;
	
	public Site(int id, String name, String description, float price, String type, Point position) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
		this.position = position;
	}
	
	public Site(int id, String name, String description, float price, int x, int y) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.position = new Point(x,y);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}	
}