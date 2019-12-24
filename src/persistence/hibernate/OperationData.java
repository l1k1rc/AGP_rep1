package persistence.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class OperationData {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int serviceTime;
	private boolean isUrgent;

	public OperationData() {

	}

	public OperationData(String name, int serviceTime, boolean isUrgent) {
		this.name = name;
		this.serviceTime = serviceTime;
		this.isUrgent = isUrgent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

}
