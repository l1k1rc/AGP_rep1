package persistence.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import business.client.SimulationEntry;
import business.simulation.StatisticManager;
import dao.StatisticPersistence;

public class HibernatePersistence implements StatisticPersistence {

	@Override
	public void dataInit() {
		HiberanteDataInit.createTables();
	}

	@Override
	public int persist(SimulationEntry entry, StatisticManager statisticManager) {
		Session session = HibernateConnection.getSession();
		Transaction transaction = session.beginTransaction();
		SimulationData data = ORMBuilder.buildData(entry, statisticManager);

		Serializable id = session.save(data);
		transaction.commit();

		session.close();
		return (Integer) id;
	}

	@Override
	public int servedClientCount(int simulationEntryId) {
		Session session = HibernateConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from SimulationData sd where sd.id = :id");
		readQuery.setInteger("id", simulationEntryId);
		List<?> result = readQuery.list();
		SimulationData data = (SimulationData) result.get(0);
		int count = 0;
		for (ClientData client : data.getAllClients()) {
			if (client.isServed()) {
				count++;
			}
		}
		readTransaction.commit();
		session.close();

		return count;
	}

	@Override
	public int nonServedClientCount(int simulationEntryId) {
		Session session = HibernateConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from SimulationData sd where sd.id = :id");
		readQuery.setInteger("id", simulationEntryId);
		List<?> result = readQuery.list();
		SimulationData data = (SimulationData) result.get(0);
		int count = 0;
		for (ClientData client : data.getAllClients()) {
			if (!client.isServed()) {
				count++;
			}
		}
		readTransaction.commit();
		session.close();

		return count;
	}

}
