package business.client;

public abstract class AbstractOperation {

    private int id;
    private int serviceTime;

    public AbstractOperation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public AbstractOperation(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public abstract boolean isUrgent();
}
