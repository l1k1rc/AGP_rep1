package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Site extends Location{
<<<<<<< HEAD
	private String description;
	private String site_type;
=======
	private boolean hist_act;
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
	
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	public Site(int id, String name, int price, int x, int y, String island, String description, String site_type, String access) {
		super(id, name, price, x, y, island, "site", access);
		this.description = description;
		this.site_type = site_type;
	}
	public Site(int id, String name, int price, Point position, String island, String description, String site_type, String access) {
		super(id, name, price, position, island, "site", access);
		this.description = description;
		this.site_type = site_type;
=======
	public Site(int id, String name, int price, int x, int y, int island, boolean hist_act, String access) {
		super(id, name, price, x, y, island, "site", access);
		this.hist_act = hist_act;
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
	}
	public Site(int id, String name, int price, Point position, int island, String description, String site_type, String access, boolean hist_act) {
		super(id, name, price, position, island, "site", access);
		this.hist_act = hist_act;
	}

	public boolean getHist_act() {
		return hist_act;
	}
<<<<<<< HEAD
	public String getSite_Type() {
		return site_type;
	}
	public void setSite_Type(String type) {
		this.site_type = type;
=======
	public void setHist_act(boolean hist_act) {
		this.hist_act = hist_act;
	}
	
	public String getTextSite(int id) {
		StringWriter out = new StringWriter();
		try(BufferedReader reader = Files.newBufferedReader(Paths.get("/home/l1k1/Bureau/AGP/" + id + ".txt"))) {
		    for(String ligne = reader.readLine(); ligne!=null; ligne = reader.readLine()) {
		    	out.write(ligne);
		        out.flush();
		        out.close();
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		String data = out.toString();
		return data;
>>>>>>> 997cd47e8694a80fa07b3e26d6d1ca70d9c620b5
	}

	
}