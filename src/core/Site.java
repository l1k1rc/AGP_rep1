package core;

public class Site extends Location{
	private String description;
	private String type;
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Site(int id, String name, int price, int x, int y, String description, String type) {
		super(id, name, price, x, y);
		this.description = description;
		this.type = type;
	}
	public Site(int id, String name, int price, Point position, String description, String type) {
		super(id, name, price, position);
		this.description = description;
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}