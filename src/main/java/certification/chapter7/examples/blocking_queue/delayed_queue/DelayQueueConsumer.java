package certification.chapter7.examples.blocking_queue.delayed_queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class DelayQueueConsumer implements Runnable {

    protected BlockingQueue<DelayElement> blockingQueue;

    public DelayQueueConsumer(BlockingQueue<DelayElement> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                DelayElement delayElement = blockingQueue.take();
                System.out.println(Thread.currentThread().getName()
                        + " take(): " + delayElement);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
