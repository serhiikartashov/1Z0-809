package certification.chapter7.parallel_streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Serhii K. on 3/9/2016.
 */
public class Creating {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        Stream<Integer> parallelStream = stream.parallel();

        Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5,6).parallelStream();

        Stream.concat(parallelStream, parallelStream2);

        Arrays.asList(1,2,3,4,5,6)
                .stream()
                .forEach(s -> System.out.print(s+" "));

        System.out.println();

        Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .forEach(s -> System.out.print(s+" "));

        System.out.println();

        Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .forEachOrdered(s -> System.out.print(s + " "));
    }
}
