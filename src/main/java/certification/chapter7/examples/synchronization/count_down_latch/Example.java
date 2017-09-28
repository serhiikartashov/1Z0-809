package certification.chapter7.examples.synchronization.count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();

        Thread.sleep(4000);
    }
}

class Waiter implements Runnable {

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await(); //all threads waiting
            System.out.println("Waiter done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }
}

class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {

        try {
            Thread.sleep(1000);
            this.latch.countDown(); //all threads start now!
            System.out.println("Decrement 1");

            Thread.sleep(1000);
            this.latch.countDown(); //all threads start now!
            System.out.println("Decrement 2");

            Thread.sleep(1000);
            this.latch.countDown(); //all threads start now!
            System.out.println("Decrement 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}