package core;

public class Activity extends Site{

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activity(int id, String name, int price, int x, int y, String description, String type) {
		super(id, name, price, x, y, description, type);
		// TODO Auto-generated constructor stub
	}

	public Activity(int id, String name, int price, Point position, String description, String type) {
		super(id, name, price, position, description, type);
		// TODO Auto-generated constructor stub
	}

}
