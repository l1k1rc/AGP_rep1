package persistence.jdbc;

public class TestHotelPersistence {
	
		
		public static void main (String args[]){
			System.out.println("The list of hotels with entertainment: ");
			HotelPersistence.simulatehotel(4);
			
			System.out.println("The result of the search by hotel id");
			HotelPersistence.testSearchById(2);
			
			System.out.println("The result of the search by hotel name:");
			HotelPersistence.testSerachByName("Hotel SBH Costa Calma Palace");
		}
		
		

}
