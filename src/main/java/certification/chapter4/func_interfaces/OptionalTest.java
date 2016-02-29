package certification.chapter4.func_interfaces;

import java.util.Optional;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class OptionalTest {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) return Optional.empty();
        int sum = 0;
        for (int score : scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

    public static void main(String[] args) {
        System.out.println(average(90, 100)); //Optional[95.0]
        System.out.println(average()); //Optional.empty

        Optional<Double> opt1 = average(90, 100);
        if (opt1.isPresent())
            System.out.println(opt1.get());    // 95.0

        Optional<Double> opt2 = average();
        // System.out.println(opt2.get());        // bad
        // java.util.NoSuchElementException: No value present

        Object value = new Object();
        Optional o1 = (value == null) ? Optional.empty() : Optional.of(value);

        // the same
        Optional o2 = Optional.ofNullable(value);

        Optional<Double> opt = average();
        System.out.println(opt.orElse(Double.NaN));
        System.out.println(opt.orElseGet(() -> Math.random()));
//        System.out.println(opt.orElseThrow(
//                () -> new IllegalStateException()));

        Optional<Double> opt4 = average(90, 100);
        System.out.println(opt4.orElse(Double.NaN));
        System.out.println(opt4.orElseGet(() -> Math.random()));
        System.out.println(opt4.orElseThrow(
                () -> new IllegalStateException()));



    }
}
