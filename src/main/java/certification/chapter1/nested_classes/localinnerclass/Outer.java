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
//      1.  They do not have an access specifier.
//      2.  They cannot be declared static and cannot declare static fields or methods.
//      3.  They have access to all fields and methods of the enclosing class.
//      4.  They do not have access to local variables of a method unless those variables are final or effectively final. More on this shortly.
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
