package certification.chapter2.functional_interface;

/**
 * Created by Serhii K. on 2/4/2016.
 */
public class Animal {

    private String species;
    private boolean canHop;
    private boolean canSwim;
    public Animal(String speciesName, boolean hopper, boolean swimmer){
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }

    public boolean isCanHop(){
        return canHop;
    }

    public boolean isCanSwim(){
        return canSwim;
    }

    public String toString(){
        return species;
    }
}
