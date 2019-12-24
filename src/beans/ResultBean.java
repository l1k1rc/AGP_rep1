package beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.PieChartModel;

import business.simulation.Simulation;
import dao.StatisticPersistence;

/**
 * 
 * Proxy design pattern is used for getting simulation results.
 *
 */
@ManagedBean
@RequestScoped
public class ResultBean {

	private PieChartModel pieModel1;

	@ManagedProperty(value = "#{entryBean}")
	private EntryBean entryBean;
	
	public ResultBean() {

	}

	@PostConstruct
	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		pieModel1.set("Served Clients", getServedClientCount());
		pieModel1.set("Non-Served Clients", getNonServedClientCount());

		pieModel1.setTitle("Client service rate");
		pieModel1.setLegendPosition("w");
		pieModel1.setShadow(false);
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public EntryBean getEntryBean() {
		return entryBean;
	}

	public void setEntryBean(EntryBean entryBean) {
		this.entryBean = entryBean;
	}

	public int getServedClientCount() {
		Simulation simulation = entryBean.getSimulation();
		int idEntry = simulation.getIdEntry();
		StatisticPersistence statisticPersistence = simulation.getStatisticPersistence();
		return statisticPersistence.servedClientCount(idEntry);
	}

	public int getNonServedClientCount() {
		Simulation simulation = entryBean.getSimulation();
		int idEntry = simulation.getIdEntry();
		StatisticPersistence statisticPersistence = simulation.getStatisticPersistence();
		return statisticPersistence.nonServedClientCount(idEntry);
	}

	public double getAverageClientWaitingTime() {
		Simulation simulation = entryBean.getSimulation();
		return simulation.getStatisticManager().calculateAverageClientWaitingTime();
	}

	public double getAverageClientServiceTime() {
		Simulation simulation = entryBean.getSimulation();
		return simulation.getStatisticManager().calculateAverageClientServiceTime();
	}

	public double getCashierOccupationRate() {
		Simulation simulation = entryBean.getSimulation();
		return simulation.getStatisticManager().calculateAverageCashierOccupationRate(entryBean.getCashierCount());
	}

	public double getClientSatisfactionRate() {
		Simulation simulation = entryBean.getSimulation();
		return simulation.getStatisticManager().calculateClientSatisfactionRate();
	}
}
