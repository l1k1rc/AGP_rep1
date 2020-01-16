package core;

public class Location {
	private int id;
	private String name;
	private int price;
	private Point position;
	private int island;
	private String type;
	private String access;
	
	public Location() {}
	
	public Location(int id, String name, int price, Point position, int island, String type, String access) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.position = position;
		this.island = island;
		this.type = type;
		this.access = access;
	}

	public Location(int id, String name, int price, int x, int y, int island, String type, String access) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.position = new Point(x,y);
		this.island = island;
		this.type = type;
		this.access = access;
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

	public int getIsland() {
		return island;
	}

	public void setIsland(int island) {
		this.island = island;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
		
}
