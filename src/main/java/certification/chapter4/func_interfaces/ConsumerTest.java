package certification.chapter4.func_interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class ConsumerTest {

    public static void main(String[] args) {

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Annie");
        c2.accept("Annie");

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("chicken", 7);
        b2.accept("chick", 1);
        System.out.println(map);

        Function<List<String>, String> ex1 = x -> x.get(0);

        //UnaryOperator<Long> ex2 = (Long l) -> 3.14;
    }
}
