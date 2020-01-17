package core;

public class Historical extends Site {

	public Historical() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public Historical(int id, String name, int price, int x, int y, String island, String description, String access) {
		super(id, name, price, x, y, island, description, "historical", access);
		// TODO Auto-generated constructor stub
	}

	public Historical(int id, String name, int price, Point position, String island, String description, String access) {
		super(id, name, price, position, island, description, "historical", access);
=======
	public Historical(int id, String name, int price, int x, int y, int island, String access) {
		super(id, name, price, x, y, island, true, access);
		// TODO Auto-generated constructor stub
	}

	public Historical(int id, String name, int price, Point position, int island, String description,
			String site_type, String access) {
		super(id, name, price, position, island, description, site_type, access, true);
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
		// TODO Auto-generated constructor stub
	}



}
