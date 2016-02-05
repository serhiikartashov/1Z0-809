package certification.chapter2.design_patterns.singleton;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public class LamaTrainer {

    public boolean feedLamas(int num){
        int amountNeeded = 5 * num;
        HayStorage hayStorage = HayStorage.getInstance();
        if (hayStorage.getHayQuantity()<amountNeeded){
            hayStorage.addHay(amountNeeded + 10);
        }
        boolean fed  = hayStorage.removeHay(amountNeeded);
        if (fed) System.out.println("Lamas have been fed");
        return fed;

    }
}
