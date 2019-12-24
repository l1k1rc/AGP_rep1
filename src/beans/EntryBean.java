package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.client.SimulationEntry;
import business.simulation.Simulation;
import business.spring.SpringIoC;

/**
 * Simulation bean controller used to collect simulation entry parameters and to start the simulation.
 * 
 * The proxy design pattern is used for avoiding redundant code copy.
 */
@ManagedBean
@SessionScoped
public class EntryBean {

	/**
	 * Proxy encapsulated object. All get/set of parameters work on this proxy object.
	 */
	private SimulationEntry entry = new SimulationEntry();

	private Simulation simulation = (Simulation) SpringIoC.getBean("simulation");;

	public EntryBean() {
	}

	public String startSimulation() {
		simulation.setSimulationEntry(entry);
		simulation.buildBank();
		simulation.simulate();
		return "result";
	}

	public SimulationEntry getEntry() {
		return entry;
	}

	public void setEntry(SimulationEntry entry) {
		this.entry = entry;
	}

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

	public int getSimulationDuration() {
		return entry.getSimulationDuration();
	}

	public void setSimulationDuration(int simulationDuration) {
		entry.setSimulationDuration(simulationDuration);
	}

	public int getCashierCount() {
		return entry.getCashierCount();
	}

	public void setCashierCount(int cashierCount) {
		entry.setCashierCount(cashierCount);
	}

	public int getMinServiceTime() {
		return entry.getMinServiceTime();
	}

	public void setMinServiceTime(int minServiceTime) {
		entry.setMinServiceTime(minServiceTime);
	}

	public int getMaxServiceTime() {
		return entry.getMaxServiceTime();
	}

	public void setMaxServiceTime(int maxServiceTime) {
		entry.setMaxServiceTime(maxServiceTime);
	}

	public int getClientArrivalInterval() {
		return entry.getClientArrivalInterval();
	}

	public void setClientArrivalInterval(int clientArrivalInterval) {
		entry.setClientArrivalInterval(clientArrivalInterval);
	}

	public double getPriorityClientRate() {
		return entry.getPriorityClientRate();
	}

	public void setPriorityClientRate(double priorityClientRate) {
		entry.setPriorityClientRate(priorityClientRate);
	}

	public int getClientPatienceTime() {
		return entry.getClientPatienceTime();
	}

	public void setClientPatienceTime(int clientPatienceTime) {
		entry.setClientPatienceTime(clientPatienceTime);
	}

}
