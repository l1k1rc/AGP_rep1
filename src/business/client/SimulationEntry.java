package business.client;

/**
 * This class encapsulates simulation entry parameters.
 */
public class SimulationEntry {
    private int simulationDuration;
    private int cashierCount;
    private int minServiceTime;
    private int maxServiceTime;
    private int clientArrivalInterval;
    private double priorityClientRate;
    private int clientPatienceTime;

    public SimulationEntry() {
    }

    public SimulationEntry(int simulationDuration, int cashierCount,
            int minServiceTime, int maxServiceTime, int clientArrivalInterval,
            double priorityClientRate, int clientPatienceTime) {
        this.simulationDuration = simulationDuration;
        this.cashierCount = cashierCount;
        this.minServiceTime = minServiceTime;
        this.maxServiceTime = maxServiceTime;
        this.clientArrivalInterval = clientArrivalInterval;
        this.priorityClientRate = priorityClientRate;
        this.clientPatienceTime = clientPatienceTime;
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

}
