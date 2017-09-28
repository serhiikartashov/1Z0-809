package certification.chapter7.examples.executor_service;

import java.util.concurrent.*;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class ScheduledExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(5);

        ScheduledFuture<String> scheduledFuture =
                scheduledExecutorService.schedule(() -> {
                            System.out.println("Executed!");
                            return "Called!";
                        },
                        5,
                        TimeUnit.SECONDS);

        System.out.println("result = " + scheduledFuture.get());

        scheduledExecutorService.shutdown();
    }
}
