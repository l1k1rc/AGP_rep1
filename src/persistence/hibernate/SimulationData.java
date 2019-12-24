package persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
class SimulationData {
	@Id
	@GeneratedValue
	private int id;
	private int simulationDuration;
	private int cashierCount;
	private int minServiceTime;
	private int maxServiceTime;
	private int clientArrivalInterval;
	private double priorityClientRate;
	private int clientPatienceTime;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ClientData.class)
	private List<ClientData> allClients = new ArrayList<ClientData>();

	public SimulationData() {

	}

	public SimulationData(int simulationDuration, int cashierCount, int minServiceTime, int maxServiceTime,
			int clientArrivalInterval, double priorityClientRate, int clientPatienceTime,
			List<ClientData> allClients) {
		this.simulationDuration = simulationDuration;
		this.cashierCount = cashierCount;
		this.minServiceTime = minServiceTime;
		this.maxServiceTime = maxServiceTime;
		this.clientArrivalInterval = clientArrivalInterval;
		this.priorityClientRate = priorityClientRate;
		this.clientPatienceTime = clientPatienceTime;
		this.allClients = allClients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSimulationDuration() {
		return simulationDuration;
	}

	public void setSimulationDuration(int simulationDuration) {
		this.simulationDuration = simulationDuration;
	}

	public int getCashierCount() {
		return cashierCount;
	}

	public void setCashierCount(int cashierCount) {
		this.cashierCount = cashierCount;
	}

	public int getMinServiceTime() {
		return minServiceTime;
	}

	public void setMinServiceTime(int minServiceTime) {
		this.minServiceTime = minServiceTime;
	}

	public int getMaxServiceTime() {
		return maxServiceTime;
	}

	public void setMaxServiceTime(int maxServiceTime) {
		this.maxServiceTime = maxServiceTime;
	}

	public int getClientArrivalInterval() {
		return clientArrivalInterval;
	}

	public void setClientArrivalInterval(int clientArrivalInterval) {
		this.clientArrivalInterval = clientArrivalInterval;
	}

	public double getPriorityClientRate() {
		return priorityClientRate;
	}

	public void setPriorityClientRate(double priorityClientRate) {
		this.priorityClientRate = priorityClientRate;
	}

	public int getClientPatienceTime() {
		return clientPatienceTime;
	}

	public void setClientPatienceTime(int clientPatienceTime) {
		this.clientPatienceTime = clientPatienceTime;
	}

	public List<ClientData> getAllClients() {
		return allClients;
	}

	public void setAllClients(List<ClientData> allClients) {
		this.allClients = allClients;
	}

}
