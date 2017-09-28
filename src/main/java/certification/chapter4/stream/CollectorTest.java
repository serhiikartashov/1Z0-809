package certification.chapter4.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.minBy;

/**
 * Created by Serhii K. on 2/29/2016.
 */
public class CollectorTest {

    public static void main(String[] args) {
        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        String result1 = ohMy1
                .collect(Collectors.joining(", "));
        System.out.println(result1);    //	lions,	tigers,	bears

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Double result2 = ohMy2
                .collect(Collectors.averagingInt(String::length));
        System.out.println(result2);

        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result3 = ohMy3
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result3);    //	[tigers]

        Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map1 = ohMy4
                .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map1); // {lions=5, bears=5, tigers=6}

        Stream<String> ohMy5 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map2 = ohMy5
                .collect(Collectors.toMap(
                        String::length,
                        k -> k,
                        // merge function, how to union values
                        // with the same key
                        (s1, s2) -> s1 + "," + s2,
                        TreeMap::new));
        System.out.println(map2);    //	//	{5=lions,bears,	6=tigers} System.out.println(map.getClass());		//	class.	java.util.TreeMap

        // groupingBy
        Stream<String> ohMy6 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map3 = ohMy6.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map3); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMy7 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map4 = ohMy7
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map4); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMy8 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map5 = ohMy8
                .collect(Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toSet()));
        System.out.println(map5); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMy9 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map6 = ohMy9
                .collect(Collectors.partitioningBy(
                        s -> s.length() <= 5
                ));
        System.out.println(map6); // {false=[tigers], true=[lions, bears]}

        Stream<String> ohMy11 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map8 = ohMy11
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                ));
        System.out.println(map8); // {5=2, 6=1}

        Stream<String> ohMy10 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map7 = ohMy10
                .collect(Collectors.groupingBy(
                                String::length,
                                mapping(
                                        (String s) -> s.charAt(0),
                                        minBy(Comparator.naturalOrder()))
                        )
                );

        System.out.println(map7); // {5=Optional[b], 6=Optional[t]}

        String[] ids = {"1", "2", "3"};
        List<String> entities = Arrays.asList(ids);

        Map<Integer, String> mapIds = entities.stream()
                .collect(Collectors.toMap(e -> entities.indexOf(e), e -> e));

        System.out.println(mapIds); // {0=1, 1=2, 2=3}

        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "e", "f", "g" };
        String[] arr3 = { "h", "i", "j" };
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        Stream<String> stream3 = Stream.of(arr3);

        //use Stream.of(T... values)
        Stream<String> stream = Stream.of(stream1, stream2, stream3).flatMap(x -> x);

        String[] arr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
