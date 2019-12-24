package business.client;

public class Transfer extends AbstractOperation {

    public Transfer() {

    }

    public Transfer(int serviceTime) {
        super(serviceTime);
    }

    @Override
    public boolean isUrgent() {
        return true;
    }

    @Override
    public String toString() {
        return "Operation : Transfer";
    }

}
