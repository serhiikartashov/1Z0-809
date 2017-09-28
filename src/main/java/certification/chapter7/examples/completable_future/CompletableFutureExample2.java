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
public class CompletableFutureExample2 {

    // recursion declaration
    static class Recursive<I> {
        public I func;
    }

    static Function<Integer, Double> factorial = x -> {
        Recursive<IntToDoubleFunction> recursive = new Recursive<>();
        recursive.func = n -> (n == 0) ? 1 : n * recursive.func.applyAsDouble(n - 1);

        return recursive.func.applyAsDouble(x);
    };

    static Function<Double, Double> square = x -> {
        return x * x;
    };

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() + " thread enters main method");

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);

        final int nthFactorial = 5;

        // 1 CompletableFuture stage for calculating factorial
        CompletableFuture<Double> factorialCalcStage = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " factorial task is called");
            Double factorialResult = factorial.apply(nthFactorial);
            return factorialResult;
        }, newFixedThreadPool);

        // 2 creates another CompletableFuture.
        factorialCalcStage.thenAcceptAsync(t -> System.out.println(Thread.currentThread().getName() + " The result after factorial: " + t));

        // 3 creates another CompletableFuture for squaring .
        CompletableFuture<Double> squareCalcStage = factorialCalcStage.thenApplyAsync(r -> {
            System.out.println(Thread.currentThread().getName() + " square task is called");
            Double squareResult = square.apply(r);

            return squareResult;
        }, newFixedThreadPool);

        // 4 creates another CompletableFuture.
        CompletableFuture<Void> lastStage = squareCalcStage.thenAcceptAsync(t -> System.out
                .println(Thread.currentThread().getName() + " The result after square: " + t));

        lastStage.join(); //waits for the lastStage to complete

        newFixedThreadPool.shutdown();

    }
}
