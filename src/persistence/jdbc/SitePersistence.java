package persistence.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Hotel;
import core.Point;
import core.Site;

public class SitePersistence {

		public static Site searchSiteById(int id) {
			Point p = new Point();
			Site searchSite = new Site();
			try {
				String selectSiteQuery = "SELECT * FROM site AS a WHERE a.id = ? ";
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSiteQuery);
				preparedStatement.setInt(1, id);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					searchSite.setId(result.getInt("id"));
					searchSite.setName(result.getString("name"));
					searchSite.setPrice(result.getInt("price"));
					if (Integer.parseInt(result.getString("hist_act")) == 1) searchSite.setHist_act(true);
					else searchSite.setHist_act(false);
					

					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					searchSite.setPosition(p);
					searchSite.setIsland(result.getInt("island_id"));
										
				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return searchSite;
		}
		
		
		public static ArrayList<Site> searchSiteByName(String name) {
			ArrayList<Site> dataSite = new ArrayList<Site>();
			try {
				String selectSiteQuery = "SELECT * FROM site AS a WHERE a.name = ? ";
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSiteQuery);
				preparedStatement.setString(1, name);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					Site searchSite = new Site();
					Point p = new Point();

					searchSite.setId(result.getInt("id"));
					searchSite.setName(result.getString("name"));
					searchSite.setPrice(result.getInt("price"));
					searchSite.setType(result.getString("hist_act"));
					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					searchSite.setPosition(p);
					searchSite.setIsland(result.getInt("island_id"));
					dataSite.add(searchSite);

				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return dataSite;
		}
		public static ArrayList<Site> searchSiteByType(String type) {
			ArrayList<Site> dataSite = new ArrayList<Site>();
			try {
				String selectSiteQuery = "SELECT * FROM site AS a WHERE a.hist_act = ? ";
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSiteQuery);
				preparedStatement.setString(1, type);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					Site searchSite = new Site();
					Point p = new Point();
					searchSite.setId(result.getInt("id"));
					searchSite.setName(result.getString("name"));
					searchSite.setPrice(result.getInt("price"));
					searchSite.setType(result.getString("hist_act"));
					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					searchSite.setPosition(p);
					searchSite.setIsland(result.getInt("island_id"));
					
					dataSite.add(searchSite);
				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return dataSite;
		}
		
		
		public static ArrayList<Site> searchSiteByIsland(String name) {
			ArrayList<Site> dataSite = new ArrayList<Site>();
			try {
				String selectSiteQuery = "SELECT * FROM site AS a WHERE a.island_id = (SELECT id FROM island WHERE name=?) ";
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSiteQuery);
				preparedStatement.setString(1, name);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					Site searchSite = new Site();
					Point p = new Point();
					searchSite.setId(result.getInt("id"));
					searchSite.setName(result.getString("name"));
					searchSite.setPrice(result.getInt("price"));
					searchSite.setType(result.getString("hist_act"));
					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					searchSite.setPosition(p);
					//searchSite.setIsland(result.getInt("island_id"));
					searchSite.setIsland(result.getInt("island_id"));
					
					dataSite.add(searchSite);
				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return dataSite;
		}
		
		public static void main(String[] args) {
			ArrayList<Site> result=searchSiteByIsland("Tenerife");
			if(result.size()!=0){
				for(Site a : result){
					System.out.println(a.getIsland());
				}
			}
		}
		
		private static ArrayList<Site> allSites() {
			ArrayList<Site> siteList = new ArrayList<Site>();
			try {
				String selectSiteQuery = "SELECT * FROM site ";
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSiteQuery);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					Site readSite = new Site();
					Point p = new Point();
					readSite.setId(result.getInt("id"));
					readSite.setName(result.getString("name"));
					readSite.setPrice(result.getInt("price"));
					readSite.setType(result.getString("hist_act"));
					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					readSite.setPosition(p);
					readSite.setIsland(result.getInt("island_id"));
					siteList.add(readSite);
				}
				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return siteList;
		}
		
		public static ArrayList<Site> querySQL(String query) {
			ArrayList<Site> siteList = new ArrayList<Site>();
			try {
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
				ResultSet result = preparedStatement.executeQuery();
				
				while (result.next()) {
					Site searchSite = new Site();
					Point p = new Point();

					searchSite.setId(result.getInt("id"));
					searchSite.setName(result.getString("name"));
					searchSite.setPrice(result.getInt("price"));
					searchSite.setType(result.getString("hist_act"));
					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					searchSite.setPosition(p);
					searchSite.setIsland(result.getInt("island_id"));
					siteList.add(searchSite);
				}

				preparedStatement.close();
				
				
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return siteList;
		}
		
		 
}