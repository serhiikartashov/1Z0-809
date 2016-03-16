package certification.chapter7.execution_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii K. on 3/7/2016.
 */
public class AwaitTermination {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            service.execute(()-> System.out.println("print"));
            service.submit(() -> {
                for (int i = 0; i < 60; i++)
                    System.out.println("print: " + i); return null;

            });
            // Add tasks to the thread executor
        } finally {
            if(service != null) service.shutdown();
        }if(service != null) {
            service.awaitTermination(1, TimeUnit.MINUTES);
            // Check whether all tasks are finished
            if(service.isTerminated())
                System.out.println("All tasks finished");
            else
                System.out.println("At least one task is still running");
        }
    }
}
