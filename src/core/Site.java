package core;

public class Site extends Location{
	private boolean hist_act;
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Site(int id, String name, int price, int x, int y, String island, boolean hist_act, String access) {
		super(id, name, price, x, y, island, "site", access);
		this.hist_act = hist_act;
	}
	public Site(int id, String name, int price, Point position, String island, String description, String site_type, String access, boolean hist_act) {
		super(id, name, price, position, island, "site", access);
		this.hist_act = hist_act;
	}

	public boolean getHist_act() {
		return hist_act;
	}
	public void setHist_act(boolean hist_act) {
		this.hist_act = hist_act;
	}
}