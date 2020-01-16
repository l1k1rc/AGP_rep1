package core;

public class Historical extends Site {

	public Historical() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Historical(int id, String name, int price, int x, int y, int island, String access) {
		super(id, name, price, x, y, island, true, access);
		// TODO Auto-generated constructor stub
	}

	public Historical(int id, String name, int price, Point position, int island, String description,
			String site_type, String access) {
		super(id, name, price, position, island, description, site_type, access, true);
		// TODO Auto-generated constructor stub
	}



}
