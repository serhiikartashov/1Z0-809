package certification.chapter7.parallel_streams;

import java.util.Arrays;

/**
 * Created by Serhii K. on 3/9/2016.
 */
public class Reduce {

    public static void main(String[] args) {
        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .stream()
                .reduce("",(c,s1) -> c + s1,
                        (s2,s3) -> s2 + s3));

        System.out.println();

        System.out.println(Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0,(a,b) -> (a-b))); // NOT AN ASSOCIATIVE ACCUMULATOR

        System.out.println(Arrays.asList("w","o","l","f","1","2")
                .parallelStream()
                .reduce("X",String::concat));
    }
}
