package certification.chapter4.stream;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by Serhii K. on 2/29/2016.
 */
public class PrimitivesTest {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println(stream.mapToInt(x -> x).sum());

        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble());

        DoubleStream doubleStream = DoubleStream.empty();

        DoubleStream oneValue = DoubleStream.of(3.14);
        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
        oneValue.forEach(System.out::println);
        System.out.println();
        varargs.forEach(System.out::println);

        DoubleStream random = DoubleStream.generate(Math::random);
        DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
        random.limit(3).forEach(System.out::println);
        System.out.println();
        fractions.limit(3).forEach(System.out::println);

        IntStream intStream1 = new Random().ints(1, 9);
        //intStream1.limit(30).forEach(System.out::println);

        new Random().ints(1, 9).limit(30).forEach(System.out::println);

        IntStream count = IntStream.iterate(1, n -> n + 1).limit(5);
        count.forEach(System.out::println);

        IntStream range = IntStream.range(1, 6);
        range.forEach(System.out::println);

        IntStream rangeClosed = IntStream.rangeClosed(1, 5);
        rangeClosed.forEach(System.out::println);

        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream2 = objStream.mapToInt(s -> s.length());

        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum();
        System.out.println(sum);    // 15
        DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
        OptionalDouble min = doubles.min();    // runs infinitely

        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > .5;
        System.out.println(b1.getAsBoolean());
        System.out.println(b2.getAsBoolean());

        double d = 1.0;
        DoubleToIntFunction f1 = x -> 1;
        f1.applyAsInt(d);
    }

    private static int range(IntStream ints) {
        // LongSummaryStatistics
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) throw new RuntimeException();
        return stats.getMax() - stats.getMin();
    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3

        //Optional<Integer>	result	= optional.map(String::length);

    }

}
