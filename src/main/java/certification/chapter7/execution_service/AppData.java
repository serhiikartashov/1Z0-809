package certification.chapter7.execution_service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Serhii K. on 3/7/2016.
 */
public class AppData {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> 30+11);
            System.out.println(result.get());

            // first lambda expression has a return type, the compiler
            // treats this as a Callable expression that supports checked exceptions.
            service.submit(() -> {Thread.sleep(10_000); return null;});
            // The second lambda expression does not return a value; therefore, the
            // compiler treats this as a Runnable expression. Since Runnable methods
            // do not support checked exceptions, the compiler will report an error
            // trying to compile this code snippet.
            // service.submit(() -> {Thread.sleep(1000);});
            System.out.println("wait");
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
