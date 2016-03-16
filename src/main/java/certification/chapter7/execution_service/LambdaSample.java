package certification.chapter7.execution_service;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * Created by Serhii K. on 3/7/2016.
 */
public class LambdaSample {

    public static void useCallable(Callable<Integer> expression) {}
    public static void useSupplier(Supplier<Integer> expression) {}
    public static void use(Supplier<Integer> expression) {}
    public static void use(Callable<Integer> expression) {}
    public static void main(String[] args) {
        useCallable(() -> {throw new IOException();}); // COMPILES
        //useSupplier(() -> {throw new IOException();}); // DOES NOT COMPILE
        //use(() -> {throw new IOException();}); // DOES NOT COMPILE
        use((Callable<Integer>)() -> {throw new IOException("");});
    }
}
