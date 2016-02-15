package certification.chapter3.generics.bounds;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Serhii K. on 2/9/2016.
 */
public class Upper {

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));
        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
        /*List<Object> lo = Arrays.asList(new Object(),new Object());
        System.out.println("sum = " + sumOfList(lo));*/
    }
}
