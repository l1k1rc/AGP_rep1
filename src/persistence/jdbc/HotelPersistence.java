package persistence.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import core.Hotel;
import core.Point;


public class HotelPersistence {
	/**
	 * 
	 * @param id
	 * @return hotel object
	 */
	public static ArrayList<Hotel> operatorSQL(String query) {
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		try {
			Connection dbConnection = JdbcConnection.getConnection();
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Hotel hotel = new Hotel();
				Point p = new Point();
				hotel.setId(result.getInt("id"));
				hotel.setName(result.getString("name"));
				hotel.setPrice_per_night(result.getFloat("price"));
				hotel.setBeach(result.getString("beach"));
				hotel.setEntertainment(result.getBoolean("entertainment"));
				hotel.setStars(result.getInt("quality"));
				p.setX(result.getInt("position_x"));
				p.setY(result.getInt("position_y"));
				hotel.setPosition(p);
				hotelList.add(hotel);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return hotelList;
	}
	private static Hotel searchHotelById(int id) {
		Hotel hotel = new Hotel();
		try {
			String selectHotelQuery = "SELECT * FROM hotel AS a WHERE a.id = ? ";
			Connection dbConnection = JdbcConnection.getConnection();
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectHotelQuery);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Point p = new Point();
				hotel.setId(result.getInt("id"));
				hotel.setName(result.getString("name"));
				hotel.setPrice_per_night(result.getFloat("price"));
				hotel.setBeach(result.getString("beach"));
				hotel.setEntertainment(result.getBoolean("entertainment"));
				hotel.setStars(result.getInt("quality"));
				p.setX(result.getInt("position_x"));
				p.setY(result.getInt("position_y"));
				hotel.setPosition(p);
			}

			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return hotel;
	}
	/**
	 * 
	 * @param star
	 * @return Array list of hotels 
	 */
	
	@SuppressWarnings("unused")
	private static ArrayList<Hotel> searchByStar(int star) {
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		try {

			String selectExcursionQuery = "SELECT * FROM hotel WHERE quality=?";
			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectExcursionQuery);
			preparedStatement.setInt(1, star);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {	
				Hotel hotel = new Hotel();
				Point p = new Point();
				hotel.setId(result.getInt("id"));
				hotel.setName(result.getString("name"));
				hotel.setPrice_per_night(result.getFloat("price"));
				hotel.setBeach(result.getString("beach"));
				hotel.setEntertainment(result.getBoolean("entertainment"));
				hotel.setStars(result.getInt("quality"));
				p.setX(result.getInt("position_x"));
				p.setY(result.getInt("position_y"));
				hotel.setPosition(p);
				hotelList.add(hotel);
			
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return hotelList;
	
		  
	}
	
	@SuppressWarnings("unused")
	private static ArrayList<Hotel> searchByEntertainment(int enter) {
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();					;
		try {

			String selectExcursionQuery = "SELECT * FROM hotel WHERE entertainment=?";
			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectExcursionQuery);
			preparedStatement.setInt(1, enter);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Hotel hotel = new Hotel();
				Point p = new Point();
				hotel.setId(result.getInt("id"));
				hotel.setName(result.getString("name"));
				hotel.setPrice_per_night(result.getFloat("price"));
				hotel.setBeach(result.getString("beach"));
				hotel.setEntertainment(result.getBoolean("entertainment"));
				hotel.setStars(result.getInt("quality"));
				p.setX(result.getInt("position_x"));
				p.setY(result.getInt("position_y"));
				hotel.setPosition(p);
				hotelList.add(hotel);
        
               
			}

			result.close();
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return hotelList;
		  
	}
	

	
	
	private static ArrayList<Hotel> allHotels() {
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		try {
			String selectHotelQuery = "SELECT * FROM hotel ";
			Connection dbConnection = JdbcConnection.getConnection();
			java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectHotelQuery);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Hotel readHotel = new Hotel();
				Point p = new Point();
				readHotel.setId(result.getInt("id"));
				readHotel.setName(result.getString("name"));
				readHotel.setPrice_per_night(result.getFloat("price"));
				readHotel.setBeach(result.getString("beach"));
				readHotel.setEntertainment(result.getBoolean("entertainment"));
				readHotel.setStars(result.getInt("quality"));
				p.setX(result.getInt("position_x"));
				p.setY(result.getInt("position_y"));
				readHotel.setPosition(p);
				hotelList.add(readHotel);
			}
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return hotelList;
	}
	
	public static int entertainmentToStar(int star){
		int entertainment = 0;
		 if (star < 4 ) {
			 entertainment = 0;
		 }else {
			 entertainment = 1;
		 }
		return entertainment;
	}
	public static void simulatehotel(int star){
		int  enter = entertainmentToStar(star);
		ArrayList<Hotel> result = searchByEntertainment(enter);
		
		if(result.size()!=0){
		for(Hotel a : result){
			System.out.println(a.getName());
		}
		}
	}
	
	public static void testSearchById(int id ) {
		Hotel result = searchHotelById(id);
		System.out.println(result.getName());
		
	}
	
	private ArrayList<Hotel> searchByPrice(int price) {
		ArrayList<Hotel> priceResult = new ArrayList<Hotel>();
		try {
			String selectExcursionQuery = "SELECT * FROM hotel WHERE price < ?";
			Connection dbConnection = JdbcConnection.getConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(selectExcursionQuery);
			preparedStatement.setInt(1, price);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				
				Hotel hotel = new Hotel();
				Point p = new Point();
				hotel.setId(result.getInt("id_hotel"));
				hotel.setName(result.getString("name"));
				hotel.setPrice_per_night(result.getInt("price"));
				hotel.setBeach(result.getString("beach"));
				hotel.setEntertainment(result.getBoolean("entertainment"));
				hotel.setStars(result.getInt("quality"));
				p.setX(result.getInt("position_x"));
				p.setY(result.getInt("position_y"));
	            hotel.setPosition(p);
				priceResult.add(hotel);
			}
			result.close();
			preparedStatement.close();
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		return priceResult;
	}
	

@SuppressWarnings("unused")
private static Hotel searchHotelByname(String id) {
	Hotel hotel = new Hotel();
	try {
		String selectHotelQuery = "SELECT * FROM hotel AS a WHERE a.name = ? ";
		Connection dbConnection = JdbcConnection.getConnection();
		java.sql.PreparedStatement preparedStatement = dbConnection.prepareStatement(selectHotelQuery);
		preparedStatement.setString(1, id);
		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			Point p = new Point();
			hotel.setId(result.getInt("id"));
			hotel.setName(result.getString("name"));
			hotel.setPrice_per_night(result.getFloat("price"));
			hotel.setBeach(result.getString("beach"));
			hotel.setEntertainment(result.getBoolean("entertainment"));
			hotel.setStars(result.getInt("quality"));
			p.setX(result.getInt("position_x"));
			p.setY(result.getInt("position_y"));
			hotel.setPosition(p);
		}

		preparedStatement.close();

	} catch (SQLException se) {
		System.err.println(se.getMessage());
	}
	return hotel;
}

public static void testSerachByName(String name){
	Hotel result = searchHotelByname(name);
	System.out.println("Price  by night : "+result.getPrice_per_night()+"\nNearest beach: "+result.getBeach()+"\nstars: "+result.getStars());
		
}

}
