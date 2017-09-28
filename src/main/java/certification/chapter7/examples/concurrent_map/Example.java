package certification.chapter7.examples.concurrent_map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public final static int THREAD_POOL_SIZE = 5;

    public static Map<String, Integer> crunchifyHashTableObject = null;
    public static Map<String, Integer> crunchifySynchronizedMapObject = null;
    public static Map<String, Integer> crunchifyConcurrentHashMapObject = null;

    public static void main(String[] args) throws InterruptedException {

        // Test with Hashtable Object
        crunchifyHashTableObject = new Hashtable<String, Integer>();
        crunchifyPerformTest(crunchifyHashTableObject);

        // Test with synchronizedMap Object
        crunchifySynchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
        crunchifyPerformTest(crunchifySynchronizedMapObject);

        // Test with ConcurrentHashMap Object
        crunchifyConcurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
        crunchifyPerformTest(crunchifyConcurrentHashMapObject);

    }

    public static void crunchifyPerformTest(final Map<String, Integer> crunchifyThreads) throws InterruptedException {

        System.out.println("Test started for: " + crunchifyThreads.getClass());
        long averageTime = 0;
        for (int i = 0; i < 5; i++) {

            long startTime = System.nanoTime();
            ExecutorService crunchifyExServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            for (int j = 0; j < THREAD_POOL_SIZE; j++) {
                crunchifyExServer.execute(new Runnable() {
                    @SuppressWarnings("unused")
                    @Override
                    public void run() {

                        for (int i = 0; i < 500000; i++) {
                            Integer crunchifyRandomNumber = (int) Math.ceil(Math.random() * 550000);

                            // Retrieve value. We are not using it anywhere
                            Integer crunchifyValue = crunchifyThreads.get(String.valueOf(crunchifyRandomNumber));

                            // Put value
                            crunchifyThreads.put(String.valueOf(crunchifyRandomNumber), crunchifyRandomNumber);
                        }
                    }
                });
            }

            // Make sure executor stops
            crunchifyExServer.shutdown();

            // Blocks until all tasks have completed execution after a shutdown request
            crunchifyExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
        }
        System.out.println("For " + crunchifyThreads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
    }
}
