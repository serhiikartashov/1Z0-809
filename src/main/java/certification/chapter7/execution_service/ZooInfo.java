package certification.chapter7.execution_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Serhii K. on 3/7/2016.
 */
public class ZooInfo {

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {for(int i=0; i<3; i++)
                        System.out.println("Printing record: "+i);}
            );
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");
        } finally {
            if(service != null) service.shutdown();

            // attempts to stop all running tasks and returns a List<Runnable> of tasks that were submitted to the
            // thread executor but that were never started
            // List<Runnable> listNotStartedTasks = service.shutdownNow();
        }
    }
}
