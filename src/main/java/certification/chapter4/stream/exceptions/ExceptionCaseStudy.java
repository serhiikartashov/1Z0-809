package certification.chapter4.stream.exceptions;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Serhii K. on 2/29/2016.
 */
public class ExceptionCaseStudy {

    private static List<String> create() throws IOException {
        throw new IOException();
    }

    private static List<String> createSafe() {
        try {
            return ExceptionCaseStudy.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        ExceptionCaseStudy.create().stream().count();

        // Supplier<List<String>> s = ExceptionCaseStudy::create; // DOES NOT COMPILE

        // variant 1
        Supplier<List<String>> s = () -> {
            try {
                return ExceptionCaseStudy.create();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        // variant 2
        Supplier<List<String>> s2 = ExceptionCaseStudy::createSafe;


    }
}
