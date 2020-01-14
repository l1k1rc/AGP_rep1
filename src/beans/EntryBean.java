package beans;

import javax.faces.bean.ApplicationScoped;
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
@ApplicationScoped
public class EntryBean {

	/**
	 * Proxy encapsulated object. All get/set of parameters work on this proxy object.
	 */
	private String keyword;
	private String excursion;
	private String price;
	private String typeStay;
	private String price1;
	private String price2;

	private SimulationEntry entry = new SimulationEntry();
	/********************************/

	public String getKeyword() {
		System.out.println("get the keyword value : "+keyword);
		return keyword;
	}

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		System.out.println("Prix 1 : "+price1);
		this.price1 = price1;
	}

	public String getPrice2() {
		return price2;
	}

	public void setPrice2(String price2) {
		System.out.println("Prix 2 :"+price2);
		this.price2 = price2;
	}

	public void setKeyword(String keyword) {
		System.out.println("set the keyword value : "+keyword);
		this.keyword = keyword;
	}

	public String getExcursion() {
		System.out.println("get the excursion value : "+excursion);
		return excursion;
	}

	public void setExcursion(String excursion) {
		System.out.println("set the excursion value : "+excursion);
		this.excursion = excursion;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String gettypeStay() {
		System.out.println("get typeStay value : "+typeStay);
		return typeStay;
	}

	public void settypeStay(String typeStay) {
		System.out.println("set typeStay value : "+typeStay);
		this.typeStay = typeStay;
	}
	/********************************/

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
