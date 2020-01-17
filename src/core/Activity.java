package core;

public class Activity extends Site{

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public Activity(int id, String name, int price, int x, int y, String island, String description, String access) {
		super(id, name, price, x, y, island, description, "activity", access);
		// TODO Auto-generated constructor stub
	}

	public Activity(int id, String name, int price, Point position, String island, String description, String access) {
		super(id, name, price, position, island, description, "activity", access);
=======
	public Activity(int id, String name, int price, int x, int y, int island, String access) {
		super(id, name, price, x, y, island, false, access);
		// TODO Auto-generated constructor stub
	}

	public Activity(int id, String name, int price, Point position, int island, String description, String site_type,
			String access) {
		super(id, name, price, position, island, description, site_type, access, false);
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
		// TODO Auto-generated constructor stub
	}


}
