package certification.chapter7.execution_service;

import java.util.concurrent.*;

/**
 * Created by Serhii K. on 3/7/2016.
 */
public class CheckResults {

    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for(int i=0; i<50000; i++) CheckResults.counter++;
                System.out.println("print " + CheckResults.counter);
            });
            result.get(1, TimeUnit.SECONDS);

            System.out.println("Reached!");
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
