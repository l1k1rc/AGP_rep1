package business.simulation;

import business.client.AbstractClient;


/**
 * We need to identify a cashier for statistics. Information about the current
 * service is also very important.
 */
public class Cashier {
	private AbstractClient servingClient = null;
	private int remainingServiceTime = 0;

	public boolean isFree() {
		return servingClient == null;
	}

	public void work() {
		if (remainingServiceTime > 0) {
			remainingServiceTime--;
		}
	}

	public boolean serviceFinished() {
		return servingClient != null && remainingServiceTime == 0;
	}

	public AbstractClient getServingClient() {
		return servingClient;
	}

	public void serve(AbstractClient servingClient) {
		this.servingClient = servingClient;
		remainingServiceTime = servingClient.getOperation().getServiceTime();
	}

	public void setServingClient(AbstractClient servingClient) {
		this.servingClient = servingClient;
	}

	public String toString() {
		return "Cashier[Remains : " + remainingServiceTime + "]";
	}

}
