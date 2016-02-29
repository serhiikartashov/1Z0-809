package certification.chapter4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Serhii K. on 2/16/2016.
 */
public class StreamCreating {

    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);

        long c1 = empty.count();
        long c2 = singleElement.count();
        long c3 = fromArray.count();


        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        Stream<Double> randoms = Stream.generate(Math::random);

        //randoms.forEach(System.out::println);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        randoms.limit(1000).sorted().forEach(System.out::println);

    }
}
