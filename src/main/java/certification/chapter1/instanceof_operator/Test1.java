package certification.chapter1.instanceof_operator;

/**
 * Created by Serhii K. on 11/4/2015.
 */
class OO{}

public class Test1 {

    public static void main(String[] args) {
        OO o1 = new OO();
        if (o1 instanceof Object) System.out.println("true");

        String s = new String("11");
        //if (s instanceof java.util.Date)  // DOES NOT COMPILE

        short s1 = 9;
        Integer i = 9; System.out.println( s1 == i );
    }
}
