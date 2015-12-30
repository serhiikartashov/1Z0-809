package certification.exceptionsandassertions.trywithresources;

/**
 * Created by Serhii K. on 12/30/2015.
 */
public class JammedTurkeyCage implements AutoCloseable {

    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }

    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            System.out.println("put turkey in");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable t : e.getSuppressed())
                System.out.println(t.getMessage());
        }
    }

/*
    // throws exception with suppressed exceptions
    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new RuntimeException("turkeys	ran	off");
        } catch (IllegalStateException e) {
            System.out.println("caught:	" + e.getMessage());
        }
    }*/

    /*public static void main(String[] args) {
        try (JammedTurkeyCage t1 = new JammedTurkeyCage();
             JammedTurkeyCage t2 = new JammedTurkeyCage()) {
            System.out.println("turkeys	entered	cages");
        } catch (IllegalStateException e) {
            System.out.println("caught:	" + e.getMessage());
            for (Throwable t : e.getSuppressed())
                System.out.println(t.getMessage());
        }
    }*/
}
