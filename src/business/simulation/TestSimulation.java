package business.simulation;

import business.spring.SpringIoC;

public class TestSimulation {

	public static void main(String[] args) {

		Simulation simulation = (Simulation) SpringIoC.getBean("simulation");
		simulation.buildBank();

		simulation.simulate();

	}
}
