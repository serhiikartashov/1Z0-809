package certification.chapter4.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by serhii on 20.02.16.
 */
public class StreamMethods {

    public static void main(String[] args) {
        // count
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count());    // 3

        // min/max
        Stream<String> s1 = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s1.min((s11, s12) -> s11.length() - s12.length());
        min.ifPresent(System.out::println);    // ape

        Optional<?> minEmpty = Stream.empty().min((s11, s12) -> 0);
        System.out.println(minEmpty.isPresent()); // false

        // findAny/findFirst
        Stream<String> str = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        str.findAny().ifPresent(System.out::println);    //	monkey
        infinite.findAny().ifPresent(System.out::println);    //	chimp

        // allMatch/anyMatch/noneMatch
        List<String> list1 = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite1 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list1.stream().anyMatch(pred));    // true
        System.out.println(list1.stream().allMatch(pred));    // false
        System.out.println(list1.stream().noneMatch(pred));    // false
        System.out.println(infinite1.anyMatch(pred));    // true

        // forEach
        Stream<String> str2 = Stream.of("Monkey", "Gorilla", "Bonobo");
        str2.forEach(System.out::print); // MonkeyGorillaBonobo
        System.out.println();

        // reduce
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (s3, c) -> s3 + c);
        // String word = stream.reduce("", String::concat);
        System.out.println(word); // wolf

        Stream<Integer> stream1 = Stream.of(3, 5, 6);
        System.out.println(stream1.reduce(1, (a, b) -> a * b));

        // collect
        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        StringBuilder word2 = stream2.collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append);
        System.out.println(word2);

        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream3.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set);    //	[f,	l,	o,	w]

        Stream<String> stream4 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set2 = stream4.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set2);    //	[f,	l,	o,	w]

        // Common Intermediate Operation
        // filter
        Stream<String> s_01 = Stream.of("monkey", "gorilla", "bonobo");
        s_01.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey
        System.out.println();

        // distinct
        Stream<String> s_02 = Stream.of("duck", "duck", "duck", "goose");
        s_02.distinct().forEach(System.out::print); // duckgoose
        System.out.println();

        // limit/skip
        Stream<Integer> s_03 = Stream.iterate(1, n -> n + 1);
        s_03.skip(5).limit(2).forEach(System.out::print); // 67
        System.out.println();

        // map
        Stream<String> s_04 = Stream.of("monkey", "gorilla", "bonobo");
        s_04.map(String::length).forEach(System.out::print); // 676
        System.out.println();

        // flatMap
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
//        animals.map(l -> l.stream()).forEach(System.out::println);
        animals.flatMap(l -> l.stream()).map(String::length).forEach(System.out::println);
//        Bonobo
//        Mama Gorilla
//        Baby Gorilla

        // sorted
        Stream<String> s_05 = Stream.of("brown-", "bear-");
        s_05.sorted().forEach(System.out::print); // bear-brown-
        System.out.println();

        Stream<String> s_06 = Stream.of("black bear", "brown bear", "grizzly");
        long count = s_06.filter(sq -> sq.startsWith("g"))
                .peek(System.out::println).count(); // grizzly
        System.out.println(count); // 1

        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        list.stream().filter(n -> n.length() == 4).sorted()
                .limit(2).forEach(System.out::println);

        System.out.println();


        Map<String, String> originMap = new HashMap<>();
        originMap.put("k1", "v1");
        originMap.put("k2", "v2");
        originMap.put("k3", "v3");

        Map<String, String> destMap = new HashMap<>();
        destMap.put("k2", "v2");
        destMap.put("k3", "v3");
        destMap.put("k4", "v4");

        Map<String, String> joint = originMap
                .entrySet()
                .stream()
                .filter(key -> destMap.entrySet().contains(key))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        joint.forEach((k,v) -> System.out.println("Joint\t Key: " + k + " | Value: " + v));
        System.out.println();

        // find by key only
        Map<String, String> joint2 = originMap
                .entrySet()
                .stream()
                .filter(key -> destMap.keySet().contains(key.getKey()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        joint2.forEach((k,v) -> System.out.println("Joint2\t Key: " + k + " | Value: " + v));
        System.out.println();


        Map<String, String> right = originMap
                .entrySet()
                .stream()
                .filter(key -> !destMap.entrySet().contains(key))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        right.forEach((k,v) -> System.out.println("Right\t Key: " + k + " | Value: " + v));
        System.out.println();

        Map<String, String> left = destMap
                .entrySet()
                .stream()
                .filter(key -> !originMap.entrySet().contains(key))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        left.forEach((k,v) -> System.out.println("Left\t Key: " + k + " | Value: " + v));
        System.out.println();

//        Integer date,
//        List<Long> securityIds
//            Map<Long, Security> map =  securitiesByDate.get(date)
//                    .stream()
//                    .filter(security -> securityIds
//                            .stream()
//                            .anyMatch(securityId -> security.getSecurityId().equals(securityId))
//                    )
//                    .collect(Collectors.toMap(Security::getSecurityId, p -> p));
    }
}
