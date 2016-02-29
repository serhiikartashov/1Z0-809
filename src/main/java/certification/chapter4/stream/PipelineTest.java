package certification.chapter4.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Serhii K. on 2/26/2016.
 */
public class PipelineTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        List<String> filtered = new ArrayList<>();
        for (String name : list) {
            if (name.length() == 4) filtered.add(name);
        }
        Collections.sort(filtered);
        Iterator<String> iter = filtered.iterator();
        if (iter.hasNext()) System.out.println(iter.next());
        if (iter.hasNext()) System.out.println(iter.next());

        // java 8 equivalent
        list.stream()
                .filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);

        // infinite stream
        /*Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);*/

        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .limit(2)
                .sorted()
                .forEach(System.out::println);

        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
        infinite
                .limit(5)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::print); // 135

        System.out.println();

        Stream<Integer> infinite2 = Stream.iterate(1, x -> x + 1);
        infinite2
                .limit(5)
                .peek(System.out::print)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::print);

        System.out.println();

        Stream<Integer> infinite3 = Stream.iterate(1, x -> x + 1);
        infinite3
                .filter(x -> x % 2 == 1)
                .peek(System.out::print)
                .limit(5)
                .forEach(System.out::print);

    }
}
