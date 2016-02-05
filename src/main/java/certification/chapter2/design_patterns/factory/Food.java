package certification.chapter2.design_patterns.factory;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public abstract class Food {

    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void consumed();
}
