package persistence.jdbc;

import java.util.ArrayList;

import core.Site;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SitePersistence {

		private static Site readSiteById(int id) {
			Site readSite = new Site();
			try {
				String selectSiteQuery = "SELECT * FROM site AS a WHERE a.id = ? ";
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSiteQuery);
				preparedStatement.setInt(1, id);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					readSite.setId(result.getInt("id"));
					readSite.setPrice(result.getFloat("price"));
					
					//modifier position partout
					readSite.getPosition().setX(result.getInt("position"));
					readSite.getPosition().setY(result.getInt("position"));
					
					
					readSite.setType(result.getString("type"));
					readSite.setName(result.getString("name"));
				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return readSite;
		}
		
		
		private static Site readSiteByName(String name) {
			Site readSite = new Site();
			try {
				String selectSiteQuery = "SELECT * FROM site AS a WHERE a.name = ? ";
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSiteQuery);
				preparedStatement.setString(1, name);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					readSite.setId(result.getInt("id"));
					readSite.setPrice(result.getFloat("price"));
					readSite.getPosition().setX(result.getInt("position"));
					readSite.getPosition().setY(result.getInt("position"));
					readSite.setType(result.getString("type"));
					readSite.setName(result.getString("name"));
				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return readSite;
		}
		
		
		private static Site readSiteByType(String type) {
			Site readSite = new Site();
			try {
				String selectSiteQuery = "SELECT * FROM site AS a WHERE a.hist_act = ? ";
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSiteQuery);
				preparedStatement.setString(1, type);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					readSite.setId(result.getInt("id"));
					readSite.setPrice(result.getFloat("price"));
					readSite.getPosition().setX(result.getInt("position"));
					readSite.getPosition().setY(result.getInt("position"));
					readSite.setType(result.getString("type"));
					readSite.setName(result.getString("name"));
				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return readSite;
		}
		
		
		public static ArrayList<Site> request(String query) {
			ArrayList<Site> siteList = new ArrayList<Site>();
			try {
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
				ResultSet result = preparedStatement.executeQuery();
				
				while (result.next()) {
					Site searchSite = new Site();
					searchSite.setId(result.getInt("id"));
					searchSite.setPrice(result.getFloat("price"));
					searchSite.getPosition().setX(result.getInt("position"));
					searchSite.getPosition().setY(result.getInt("position"));
					searchSite.setType(result.getString("type"));
					searchSite.setName(result.getString("name"));
					siteList.add(searchSite);
				}

				preparedStatement.close();
				
				
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return siteList;
		}
		
		 
}