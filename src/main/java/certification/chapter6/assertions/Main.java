package certification.chapter6.assertions;

/**
 * Created by Serhii K. on 2/5/2016.
 */
public class Main {

    // run with parameter "-ea", i.e java -ea Main
    // or java -enableassertions Main
    public static void main(String[] args) {
        int numGuests = -5;
        assert numGuests > 0;
        System.out.println(numGuests);
    }
}
