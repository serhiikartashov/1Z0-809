package certification.chapter4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Serhii K. on 2/16/2016.
 */
public class Creating {

    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        Stream<Double> randoms = Stream.generate(Math::random);

        //randoms.forEach(System.out::println);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
    }
}
