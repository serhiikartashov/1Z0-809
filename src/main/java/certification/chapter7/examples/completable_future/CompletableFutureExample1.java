package certification.chapter7.examples.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class CompletableFutureExample1 {

    static class Recursive<I> {
        I func;
    }

    private static Function<Integer, Double> factorial = x -> {
        Recursive<IntToDoubleFunction> recursive = new Recursive<>();
        recursive.func = n -> (n == 0) ? 1 : n * recursive.func.applyAsDouble(n - 1);
        return recursive.func.applyAsDouble(x);
    };

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + " thread enters main method"); // 1

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);

        final int nthFactorial = 25;

        CompletableFuture<Double> result = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " factorial task is called"); // 2
                    return factorial.apply(nthFactorial);
                },
                newFixedThreadPool
        );

        System.out.println("isDone = " + result.isDone());
        System.out.println("isCancelled = " + result.isCancelled());

        // result.cancel(true); //You may cancel it conditionally

        Double res = result.get(); // blocked until result is returned

        System.out.println(Thread.currentThread().getName() + " result is " + res); // 3

        newFixedThreadPool.shutdown();
    }
}
