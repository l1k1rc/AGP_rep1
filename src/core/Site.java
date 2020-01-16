package core;

public class Site extends Location{
	private String description;
	private String site_type;
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Site(int id, String name, int price, int x, int y, String island, String description, String site_type, String access) {
		super(id, name, price, x, y, island, "site", access);
		this.description = description;
		this.site_type = site_type;
	}
	public Site(int id, String name, int price, Point position, String island, String description, String site_type, String access) {
		super(id, name, price, position, island, "site", access);
		this.description = description;
		this.site_type = site_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSite_Type() {
		return site_type;
	}
	public void setSite_Type(String type) {
		this.site_type = type;
	}

	
}