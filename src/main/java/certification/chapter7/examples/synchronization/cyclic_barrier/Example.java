package certification.chapter7.examples.synchronization.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public static void main(String[] args) {
//        CyclicBarrier barrier1 = new CyclicBarrier(2);
        CyclicBarrier barrier1 = new CyclicBarrier(3, new MyAction1());


//        try {
//            barrier1.await(10, TimeUnit.SECONDS);
//        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
//            e.printStackTrace();
//        }

        CyclicBarrier barrier2 = new CyclicBarrier(3, new MyAction2());


        CyclicBarrierRunnable barrierRunnable1 =
                new CyclicBarrierRunnable(barrier1, barrier2);

        CyclicBarrierRunnable barrierRunnable2 =
                new CyclicBarrierRunnable(barrier1, barrier2);

        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();

    }
}

class CyclicBarrierRunnable implements Runnable{

    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(
            CyclicBarrier barrier1,
            CyclicBarrier barrier2) {

        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " waiting at barrier 1");
            this.barrier1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " waiting at barrier 2");
            this.barrier2.await();

            System.out.println(Thread.currentThread().getName() +
                    " done!");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class MyAction1 implements Runnable {

    @Override
    public void run() {
        System.out.println("my action 1");
    }
}

class MyAction2 implements Runnable {

    @Override
    public void run() {
        System.out.println("my action 2");
    }
}
