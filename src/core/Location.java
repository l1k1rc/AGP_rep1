package core;

public class Location {
	private int id;
	private String name;
	private int price;
	private Point position;
<<<<<<< HEAD
	private String island;
=======
	private int island;
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
	private String type;
	private String access;
	
	public Location() {}
	
<<<<<<< HEAD
	public Location(int id, String name, int price, Point position, String island, String type, String access) {
=======
	public Location(int id, String name, int price, Point position, int island, String type, String access) {
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.position = position;
		this.island = island;
		this.type = type;
		this.access = access;
	}

<<<<<<< HEAD
	public Location(int id, String name, int price, int x, int y, String island, String type, String access) {
=======
	public Location(int id, String name, int price, int x, int y, int island, String type, String access) {
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
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

<<<<<<< HEAD
	public String getIsland() {
		return island;
	}

	public void setIsland(String island) {
=======
	public int getIsland() {
		return island;
	}

	public void setIsland(int island) {
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
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
