package certification.chapter7.examples.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        int  corePoolSize  =    5;
        int  maxPoolSize   =   10;
        long keepAliveTime = 5000;

        /*
         *
         * If less than corePoolSize threads are created in the the thread pool when a task is delegated
         * to the thread pool, then a new thread is created, even if idle threads exist in the pool.
         *
         * If the internal queue of tasks is full, and corePoolSize threads or more are running,
         * but less than maximumPoolSize threads are running, then a new thread is created to execute the task.
         *
         */

        ExecutorService threadPoolExecutor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>()
                );
    }
}
