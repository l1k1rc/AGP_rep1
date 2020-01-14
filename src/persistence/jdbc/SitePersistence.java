package persistence.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.Point;
import core.Site;

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
		public static void main(String[] args) {
			ArrayList<Site> resultSQLrequest = new ArrayList<Site>();
			resultSQLrequest = readSiteByType("0");
			for(int i=0;i<resultSQLrequest.size();i++)
				System.out.println(resultSQLrequest.get(i).getPrice());
		}
		
		private static ArrayList<Site> readSiteByType(String type) {
			ArrayList<Site> dataSite = new ArrayList<Site>();
			try {
				String selectSiteQuery = "SELECT * FROM site AS a WHERE a.hist_act = ? ";
				Connection dbConnection = JdbcConnection.getConnection();
				java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSiteQuery);
				preparedStatement.setString(1, type);
				ResultSet result = preparedStatement.executeQuery();

				while (result.next()) {
					Site readSite = new Site();
					Point p = new Point();
					readSite.setId(result.getInt("id"));
					readSite.setName(result.getString("name"));
					readSite.setPrice(result.getFloat("price"));
					readSite.setType(result.getString("hist_act"));
					p.setX(result.getInt("position_x"));
					p.setY(result.getInt("position_y"));
					readSite.setPosition(p);

					
					dataSite.add(readSite);
				}

				preparedStatement.close();

			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return dataSite;
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
					searchSite.setName(result.getString("name"));
					searchSite.setPrice(result.getFloat("price"));
					/*searchSite.getPosition().setX(result.getInt("position"));
					searchSite.getPosition().setY(result.getInt("position"));
					searchSite.setType(result.getString("type"));*/
					siteList.add(searchSite);
				}

				preparedStatement.close();
				
				
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return siteList;
		}
		
		 
}