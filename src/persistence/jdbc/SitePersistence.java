package persistence.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Point;
import core.Site;

public class SitePersistence {

		private static Site searchSiteById(int id) {
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
					searchSite.setPrice(result.getFloat("price"));
					searchSite.setType(result.getString("hist_act"));

					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					searchSite.setPosition(p);
										
				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return searchSite;
		}
		
		
		private static ArrayList<Site> searchSiteByName(String name) {
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
					searchSite.setPrice(result.getFloat("price"));
					searchSite.setType(result.getString("hist_act"));
					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					searchSite.setPosition(p);
					dataSite.add(searchSite);

				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return dataSite;
		}
		private static ArrayList<Site> searchSiteByType(String type) {
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
					searchSite.setPrice(result.getFloat("price"));
					searchSite.setType(result.getString("hist_act"));
					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					searchSite.setPosition(p);

					
					dataSite.add(searchSite);
				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return dataSite;
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
					searchSite.setPrice(result.getFloat("price"));
					searchSite.setType(result.getString("hist_act"));
					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					searchSite.setPosition(p);
					siteList.add(searchSite);
				}

				preparedStatement.close();
				
				
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return siteList;
		}
		
		 
}