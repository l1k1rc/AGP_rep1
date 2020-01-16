package core;

public class Transport {
	private String type;
	private int kilometric_price;
	private int distance;
	private int price;
	
	
	public Transport(String type, int kilometric_price) {
		this(type, kilometric_price, 0, 0);
	}

	public Transport(String type, int kilometric_price, int distance, int price) {
		super();
		this.type = type;
		this.kilometric_price = kilometric_price;
		this.distance = distance;
		this.price = price;
		priceRecalculator();
	}
	
	public void priceRecalculator() {
		this.price = this.distance*this.kilometric_price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getKilometric_price() {
		return kilometric_price;
	}

	public void setKilometric_price(int kilometric_price) {
		this.kilometric_price = kilometric_price;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
