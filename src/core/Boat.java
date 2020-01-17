package core;

public class Boat extends Transport{
	private static int kilometric_price = StaticData.kilometric_price_base*2;

	public Boat() {
		super("boat", kilometric_price);

	}
	
	public Boat(int distance, int price) {
		super("boat", kilometric_price, distance, price);
		// TODO Auto-generated constructor stub
	}


}
