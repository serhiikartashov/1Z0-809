package certification.chapter4.func_interfaces;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class OperatorsTest {

    public static void main(String[] args) {

        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));

        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick


    }
}
