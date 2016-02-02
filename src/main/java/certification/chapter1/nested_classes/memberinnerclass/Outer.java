package certification.chapter1.nested_classes.memberinnerclass;

/**
 * Created by Serhii K. on 2/1/2016.
 */
public class Outer {
    private String greeting = "Hi";

    // Outer$Inner.class
    protected class Inner {
        public int repeat = 3;

        public void go() {
            for (int i = 0; i < repeat; i++) System.out.println(greeting);
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();

        Inner inner = outer.new Inner();
        inner.go();
    }
}
