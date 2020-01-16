package core;

public class Bus extends Transport{
	private static int kilometric_price = StaticData.kilometric_price_base;

	public Bus() {
		super("bus", kilometric_price);

	}
	
	public Bus(int distance, int price) {
		super("bus", kilometric_price, distance, price);
		// TODO Auto-generated constructor stub
	}


}
