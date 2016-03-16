package certification.chapter7.scheduled_execution_service;

import java.util.concurrent.*;

/**
 * Created by Serhii K. on 3/7/2016.
 */
public class Creation {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";

        /*Future<?> result1 = service.schedule(task1, 2, TimeUnit.SECONDS);
        Future<?> result2 = service.schedule(task2, 1, TimeUnit.MINUTES);*/

        // The following example executes a Runnable task every 2 seconds, following an
        // initial one second delay
        //Future<?> result3 = service.scheduleAtFixedRate(task1, 1, 2, TimeUnit.SECONDS);
        // if the first task runs at 12:00 and takes five minutes to finish, with a period
        // of 2 minutes, then the second task will start at 12:07
        //Future<?> result4 = service.scheduleWithFixedDelay(task1, 1, 2, TimeUnit.SECONDS);

        ScheduledExecutorService service1 = Executors.newScheduledThreadPool(3);
        service1.scheduleAtFixedRate(()->{
            System.out.println(1);
        },3,1,TimeUnit.SECONDS);
        service1.scheduleAtFixedRate(()->{
            System.out.println(2);
        },3,1,TimeUnit.SECONDS);
        service1.scheduleAtFixedRate(()->{
            System.out.println(3);
        },3,1,TimeUnit.SECONDS);
        service1.scheduleAtFixedRate(()->{
            System.out.println(4);
        },3,1,TimeUnit.SECONDS);
        service1.scheduleAtFixedRate(()->{
            System.out.println(5);
        },3,1,TimeUnit.SECONDS);

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
