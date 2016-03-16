package certification.chapter7.parallel_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Serhii K. on 3/9/2016.
 */
public class IndependentOperations {

    public static void main(String[] args) {
        Arrays.asList("jackal", "kangaroo", "lemur")
                .parallelStream()
                .map(s -> {System.out.println(s); return s.toUpperCase();})
                .forEach(System.out::println);

        System.out.println();

        //List<Integer> data = Collections.synchronizedList(new ArrayList<>());
        List<Integer> data = new ArrayList<>(); // will produce unexpected results
        /*Arrays.asList(1,2,3,4,5,6).parallelStream()
                .map(i -> {data.add(i); return i;}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
                .forEachOrdered(i -> System.out.print(i+" "));*/

        Arrays.asList(1,2,3,4,5,6).stream()
                .map(i -> {
                    data.add(i);
                    return i;
                })
                .forEachOrdered(i -> System.out.print(i + " "));

        System.out.println();
        for(Integer e: data) {
            System.out.print(e+" ");
        }

        System.out.println();

        System.out.print(Arrays.asList(1,2,3,4,5,6).stream().findAny().get());
        System.out.println();
        // Any stream operation that is based on order, including findFirst(), limit(), or skip(), may
        // actually perform more slowly in a parallel environment.
        System.out.print(Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get());
    }
}
