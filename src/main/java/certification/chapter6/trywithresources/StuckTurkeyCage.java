package certification.chapter6.trywithresources;

/**
 * Created by Serhii K. on 12/30/2015.
 */
public class StuckTurkeyCage implements AutoCloseable {

    @Override
    public void close() throws Exception {

    }

    /*public static void main(String[] args) {
        try(StuckTurkeyCage t = new StuckTurkeyCage()) { // DOES NOT COMPILE
            System.out.println("put turkey in");
        }
    }*/

    // because main method throws Exception
    public static void main(String[] args) throws Exception {
        try (StuckTurkeyCage t = new StuckTurkeyCage()) { // WILL COMPILE
            System.out.println("put turkey in");
        }
    }

    // Java recommends to make the close() method idempotent!
}

// the best implementation
class ExampleOne implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage	door	does	not	close");
    }
}

// throws Excetion rather than a more specific subclass, which is not recommended
class ExampleTwo implements AutoCloseable {
    public void close() throws Exception {
        throw new Exception("Cage	door	does	not	close");
    }
}

// has side effect. It changes the state of a variable.
// Side effect are not recommended!
class ExampleThree implements AutoCloseable {
    static int COUNT = 0;

    public void close() {
        COUNT++;
    }
}
