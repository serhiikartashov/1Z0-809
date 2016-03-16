package certification.chapter7.execution_service.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Serhii K. on 3/7/2016.
 */
public class SheepManager {

    private int sheepCount = 0;
    /*private void incrementAndReport() {
        System.out.print((++sheepCount)+" ");
    }*/

    private void incrementAndReport() {
        synchronized (this) {
            System.out.print((++sheepCount) + " ");
        }
    }

    private static void printDaysWork1() {
        synchronized (SheepManager.class) {
            System.out.print("Print someting ");
        }
    }

    public static synchronized void printDaysWork2() {
        System.out.print("Finished work");
    }

/*    private synchronized void incrementAndReport() {
        System.out.print((++sheepCount)+" ");
    }*/

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for(int i=0; i<100; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
