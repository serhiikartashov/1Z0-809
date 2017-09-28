package certification.chapter7.examples.synchronization.count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example2 {

    public static void main(String[] args) {
        int num_thread = 20;

        Example2 example2 = new Example2();

        final CountDownLatch countdown = new CountDownLatch(num_thread);
        for (int i = 0; i < num_thread; ++i) {
            Thread t = new Thread(() -> {
                example2.doSomething();
                countdown.countDown();
                System.out.printf("Waiting on %d other threads.\n", countdown.getCount());
                try {
                    Thread.sleep(1000);
                    countdown.await();     //waits until everyone reaches this point
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                example2.finish();
            });
            t.start();
        }
    }

    private void doSomething(){
        System.out.println("Do smth");
    }

    private void finish(){
        System.out.println("Finished");
    }
}
