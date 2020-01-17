package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Site extends Location {
	private boolean hist_act;

	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Site(int id, String name, int price, int x, int y, int island, boolean hist_act, String access) {
		super(id, name, price, x, y, island, "site", access);
		this.hist_act = hist_act;
	}

	public Site(int id, String name, int price, Point position, int island, String description, String site_type,
			String access, boolean hist_act) {
		super(id, name, price, position, island, "site", access);
		this.hist_act = hist_act;
	}

	public boolean getHist_act() {
		return hist_act;
	}

	public void setHist_act(boolean hist_act) {
		this.hist_act = hist_act;
	}

	public String getTextSite(int id) {
		StringWriter out = new StringWriter();
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("/home/l1k1/Bureau/AGP/" + id + ".txt"))) {
			for (String ligne = reader.readLine(); ligne != null; ligne = reader.readLine()) {
				out.write(ligne);
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = out.toString();
		return data;
	}

}