package business.simulation;

import java.util.ArrayList;

import business.client.AbstractClient;

/**
 * This class regroup statistic information. It calculates the simulation
 * result.
 */
public class StatisticManager {
	private ArrayList<AbstractClient> servedClients = new ArrayList<AbstractClient>();
	private ArrayList<AbstractClient> nonServedClients = new ArrayList<AbstractClient>();

	/**
	 * Effective simulation duration.
	 */
	private int simulationDuration = 0;

	/**
	 * Time unit count of occupied cashier. For each unit time, if we have an
	 * occupied cashier, we get this count + 1.
	 */
	private int occupiedCashier = 0;

	public void registerServedClient(AbstractClient client) {
		servedClients.add(client);
	}

	public void registerNonServedClient(AbstractClient client) {
		nonServedClients.add(client);
	}

	public void simulationDurationRecord() {
		simulationDuration++;
	}

	public void cashierOccupationRecord() {
		occupiedCashier++;
	}

	/**
	 * Calculates the average occupation percentage per cashier.
	 * 
	 * @param cashierCount cashier count
	 * @return occupation percentage
	 */
	public double calculateAverageCashierOccupationRate(int cashierCount) {
		return (occupiedCashier * 100 / simulationDuration) / cashierCount;
	}

	/**
	 * Calculates the average waiting time per client.
	 * 
	 * @return average waiting time
	 */
	public double calculateAverageClientWaitingTime() {
		int totalWaitingTime = 0;
		for (AbstractClient client : servedClients) {
			int serviceStartTime = client.getServiceStartTime();
			int arrivalTime = client.getArrivalTime();
			totalWaitingTime += serviceStartTime - arrivalTime;
		}
		int servedClientCount = servedClientCount();
		return totalWaitingTime / servedClientCount;
	}

	/**
	 * Calculates the average effective service time per client.
	 * 
	 * @return average service time
	 */
	public double calculateAverageClientServiceTime() {
		int totalServiceTime = 0;
		for (AbstractClient client : servedClients) {
			int departureTime = client.getDepartureTime();
			int serviceStartTime = client.getServiceStartTime();
			totalServiceTime += departureTime - serviceStartTime;
		}
		return totalServiceTime / servedClientCount();
	}

	public int servedClientCount() {
		return servedClients.size();
	}

	public int nonServedClientCount() {
		return nonServedClients.size();
	}

	/**
	 * Calculates the rate of served client among all clients. This indicates the
	 * client satisfaction.
	 * 
	 * @return the rate of served client
	 */
	public double calculateClientSatisfactionRate() {
		return servedClientCount() * 100 / (servedClientCount() + nonServedClientCount());
	}

	public ArrayList<AbstractClient> getServedClients() {
		return servedClients;
	}

	public void setServedClients(ArrayList<AbstractClient> servedClients) {
		this.servedClients = servedClients;
	}

	public ArrayList<AbstractClient> getNonServedClients() {
		return nonServedClients;
	}

	public void setNonServedClients(ArrayList<AbstractClient> nonServedClients) {
		this.nonServedClients = nonServedClients;
	}

	public int getSimulationDuration() {
		return simulationDuration;
	}

	public void setSimulationDuration(int simulationDuration) {
		this.simulationDuration = simulationDuration;
	}

	public int getOccupiedCashier() {
		return occupiedCashier;
	}

	public void setOccupiedCashier(int occupiedCashier) {
		this.occupiedCashier = occupiedCashier;
	}

}
