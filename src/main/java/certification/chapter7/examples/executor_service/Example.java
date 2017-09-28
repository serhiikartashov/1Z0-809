package certification.chapter7.examples.executor_service;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        // 200=10
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        // 3, 2, 7, 3, 1
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

        executorService1.execute(() -> System.out.println("Asynchronous task 1"));
        executorService1.execute(() -> System.out.println("Asynchronous task 2"));
        executorService1.execute(() -> System.out.println("Asynchronous task 3"));

        executorService1.submit(() -> System.out.println("Asynchronous task"));
        Future<String> future = executorService1.submit(() -> {
            System.out.println("Asynchronous Callable");
            return "Callable Result";
        });

        System.out.println("future.get(): " + future.get());

        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();

        invokeAny();
    }

    private static void invokeAny() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<>();

        callables.add(() -> "Task 1");
        callables.add(() -> "Task 2");
        callables.add(() -> "Task 3");

        String result = executorService.invokeAny(callables);
        try {
            String result2 = executorService.invokeAny(callables, 1, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println("result = " + result);

        List<Future<String>> futures = executorService.invokeAll(callables);

        List<Future<String>> futures2 = executorService.invokeAll(callables, 1, TimeUnit.SECONDS);

        futures.forEach(future -> {
            try {
//                System.out.println(future.get());
                System.out.println(future.get(1, TimeUnit.MICROSECONDS));
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
