package business.simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import business.client.AbstractClient;

/**
 * A FIFO queue for clients.
 */
public class Queue {
	private LinkedList<AbstractClient> clients = new LinkedList<AbstractClient>();

	public boolean isEmpty() {
		return clients.isEmpty();
	}

	public void addQueueLast(AbstractClient client) {
		clients.addLast(client);
	}

	public AbstractClient getQueueFirst() {
		return clients.removeFirst();
	}

	public AbstractClient findPriorityClient() {
		for (AbstractClient client : clients) {
			if (client.isPriority()) {
				return client;
			}
		}
		return null;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();
		results.append("Queue size[" + clients.size() + "] : ");
		for (AbstractClient client : clients) {
			results.append(client.toString() + "-->");
		}
		return results.toString();
	}

	public void removePriorityClient(AbstractClient client) {
		clients.remove(client);
	}

	public void updateClientPatience() {
		for (AbstractClient client : clients) {
			client.reducePatience();
		}
	}

	public List<AbstractClient> removeImpatientClients() {
		List<AbstractClient> removeList = new ArrayList<AbstractClient>();
		for (AbstractClient client : clients) {
			if (!client.isPatient()) {
				removeList.add(client);
			}
		}

		for (AbstractClient client : removeList) {
			clients.remove(client);
		}
		return removeList;
	}

}
