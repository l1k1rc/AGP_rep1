package core;

public class ExcursionPrice {
	private float total_price;
	private float kilometric_price;
	private float hourly_price;
	private float activity_price;
	private float commission;
	private Transport transport_type;
	
	public ExcursionPrice(float kilometric_price, float hourly_price, float activity_price, float commission,
			Transport transport_type) {
		super();
		this.kilometric_price = kilometric_price;
		this.hourly_price = hourly_price;
		this.activity_price = activity_price;
		this.commission = commission;
		this.transport_type = transport_type;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public float getKilometric_price() {
		return kilometric_price;
	}

	public void setKilometric_price(float kilometric_price) {
		this.kilometric_price = kilometric_price;
	}

	public float getHourly_price() {
		return hourly_price;
	}

	public void setHourly_price(float hourly_price) {
		this.hourly_price = hourly_price;
	}

	public float getActivity_price() {
		return activity_price;
	}

	public void setActivity_price(float activity_price) {
		this.activity_price = activity_price;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public Transport getTransport_type() {
		return transport_type;
	}

	public void setTransport_type(Transport transport_type) {
		this.transport_type = transport_type;
	}
	
	
}
