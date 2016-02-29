package certification.chapter4.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Serhii K. on 2/26/2016.
 */
public class ChangingStateTest {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');

//        Stream<List<?>> stream = Stream.of(numbers, letters);
//        stream.map(List::size).forEach(System.out::print); // 11

        System.out.println();

        StringBuilder builder = new StringBuilder();
        Stream<List<?>> good = Stream.of(numbers, letters);
        good.peek(l -> builder.append(l)).map(List::size).forEach(System.out::print);
        System.out.println(builder);
        // modifying the data structure
        //good.peek(l -> l.remove(0)).map(List::size).forEach(System.out::print);

    }
}
