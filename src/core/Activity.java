package core;

public class Activity extends Site{

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activity(int id, String name, int price, int x, int y, String island, String access) {
		super(id, name, price, x, y, island, false, access);
		// TODO Auto-generated constructor stub
	}

	public Activity(int id, String name, int price, Point position, String island, String description, String site_type,
			String access) {
		super(id, name, price, position, island, description, site_type, access, false);
		// TODO Auto-generated constructor stub
	}


}
