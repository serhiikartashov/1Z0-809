package certification.chapter7.examples.poc.completablefuture;

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
public class Launcher {

    static class Recursive<I> {
        I func;
    }

    private static Function<Integer, Double> factorial = x -> {
        Recursive<IntToDoubleFunction> recursive = new Recursive<>();
        recursive.func = n -> (n == 0) ? 1 : n * recursive.func.applyAsDouble(n - 1);
        return recursive.func.applyAsDouble(x);
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        final CompletableFuture<Integer> stage = new CompletableFuture<>();
//            final CompletableFuture<Integer> stage = CompletableFuture.completedFuture(2);
//
//            stage
//                    .thenApply(Launcher::square)
//                    .thenAccept(System.out::print)
//                    .thenRun(System.out::println);
//        stage.complete(2);

//        final CompletableFuture<Integer> answer =
//                CompletableFuture.completedFuture(42);
//
//        final int fortyTwo = answer.get();  //does not block
//        System.out.print(fortyTwo);


        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        final int nthFactorial = 25;

        CompletableFuture<Double> result = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " factorial task is called"); // 2
                    return factorial.apply(nthFactorial);
                },
                newFixedThreadPool
        );

        System.out.println(result.get());
        newFixedThreadPool.shutdown();
    }

    private static Integer square(int x) {
        return x * 2;
    }
}
