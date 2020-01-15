package core;

public class Location {
	private int id;
	private String name;
	private int price;
	private Point position;
	
	public Location() {}
	
	public Location(int id, String name, int price, Point position) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.position = position;
	}

	public Location(int id, String name, int price, int x, int y) {
		super();
		this.id = id;
		this.name = name;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
		
}
