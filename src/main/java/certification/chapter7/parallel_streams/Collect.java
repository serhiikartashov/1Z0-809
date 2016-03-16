package certification.chapter7.parallel_streams;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Serhii K. on 3/9/2016.
 */
public class Collect {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add,
                Set::addAll);
        System.out.println(set); // [f, l, o, w]

        Stream<String> stream2 = Stream.of("w", "o", "l", "f").parallel();
        Set<String> set2 = stream2.collect(Collectors.toSet());
        System.out.println(set2); // [f, w, l, o]


        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors.toConcurrentMap(String::length, k -> k,
                        (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap
    }
}
