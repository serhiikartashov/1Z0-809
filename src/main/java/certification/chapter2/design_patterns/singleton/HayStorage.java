package certification.chapter2.design_patterns.singleton;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public class HayStorage {

    private int quantity = 0;

    private HayStorage() {
    }

    private static final HayStorage instance = new HayStorage();

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount) return false;
        quantity -= amount;
        return true;
    }

    public synchronized int getHayQuantity() {
        return quantity;

    }

}
