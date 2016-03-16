package certification.chapter7.parallel_streams;

import java.util.Arrays;

/**
 * Created by Serhii K. on 3/9/2016.
 */
public class Unordered {

    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().unordered();
        // if use skip(5), will skip any 5 elements, not first 5 elements

        // will improve performance
        Arrays.asList(1,2,3,4,5,6).stream().unordered().parallel();

    }
}
