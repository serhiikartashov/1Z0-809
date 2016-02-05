package certification.chapter2.design_patterns.factory;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public class Pellets extends Food {

    public Pellets(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Pellets	eaten:	" + getQuantity());
    }
}
