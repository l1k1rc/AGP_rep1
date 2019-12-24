package persistence.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
class ClientData {
	@Id
	@GeneratedValue
	private int id;
	private int arrivalTime;
	private int serviceStartTime;
	private int departureTime;
	private boolean served;
	private boolean isPriority;

	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = OperationData.class)
	private OperationData operation;

	public ClientData() {

	}
	

	public ClientData(int arrivalTime, int serviceStartTime, int departureTime, boolean served, boolean isPriority,
			OperationData operation) {
		this.arrivalTime = arrivalTime;
		this.serviceStartTime = serviceStartTime;
		this.departureTime = departureTime;
		this.served = served;
		this.isPriority = isPriority;
		this.operation = operation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceStartTime() {
		return serviceStartTime;
	}

	public void setServiceStartTime(int serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public boolean isServed() {
		return served;
	}

	public void setServed(boolean served) {
		this.served = served;
	}

	public boolean isPriority() {
		return isPriority;
	}

	public void setPriority(boolean isPriority) {
		this.isPriority = isPriority;
	}

	public OperationData getOperation() {
		return operation;
	}

	public void setOperation(OperationData operation) {
		this.operation = operation;
	}

}
