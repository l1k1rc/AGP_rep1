package core;

public class Transport {
	private String transport;
	private float kilometric_price;
	
	public Transport(String transport, float kilometric_price) {
		super();
		this.transport = transport;
		this.kilometric_price = kilometric_price;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public float getKilometric_price() {
		return kilometric_price;
	}

	public void setKilometric_price(float kilometric_price) {
		this.kilometric_price = kilometric_price;
	}
}
