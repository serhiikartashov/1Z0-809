package certification.chapter2.functional_interface;

/**
 * Created by Serhii K. on 2/4/2016.
 */
// FUNCTIONAL INTERFACE!
public interface Skip extends Sprint {

    default int getHopCount(Animal animal){
        return 10;
    }

    static void skip(int speed){}

}
