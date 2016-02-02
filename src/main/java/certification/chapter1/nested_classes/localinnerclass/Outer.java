package certification.chapter1.nested_classes.localinnerclass;

/**
 * Created by Serhii K. on 2/1/2016.
 */
public class Outer {

    private int length = 5;

    public void calculate() {
        final int width = 20; // final
        // int width = 20; // effectively final
        // width = 1; // DOES NOT COMPILE  multiply() method!
        class Inner {

            public void multiply() {
                System.out.println(length * width);
            }

        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.calculate();
    }
}
