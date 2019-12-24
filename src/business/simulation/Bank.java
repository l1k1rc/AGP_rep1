package business.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * A bank is composed of cashiers and a queue.
 */
public class Bank {
	private List<Cashier> cashiers = new ArrayList<Cashier>();
	private Queue queue = new Queue();

	public Bank(int cashierCount) {
		createCashiers(cashierCount);
	}

	public List<Cashier> getCashiers() {
		return cashiers;
	}

	public Queue getQueue() {
		return queue;
	}

	private void createCashiers(int cashierCount) {
		for (int cashierId = 1; cashierId <= cashierCount; cashierId++) {
			Cashier cashier = new Cashier();
			cashiers.add(cashier);
		}
	}

	public Cashier getFreeCashier() {
		for (Cashier cashier : cashiers) {
			if (cashier.isFree()) {
				return cashier;
			}
		}
		return null;
	}

	public String toString() {
		StringBuffer results = new StringBuffer();
		results.append(queue.toString() + "\n");
		results.append("Cashiers : ");
		for (Cashier cashier : cashiers) {
			results.append(cashier.toString() + " ");
		}
		return results.toString();
	}
}
