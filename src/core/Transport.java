package core;

public class Transport {
	private String type;
	private float kilometric_price;
	
	public Transport(String type, float kilometric_price) {
		super();
		this.type = type;
		this.kilometric_price = kilometric_price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getKilometric_price() {
		return kilometric_price;
	}

	public void setKilometric_price(float kilometric_price) {
		this.kilometric_price = kilometric_price;
	}
	
}
