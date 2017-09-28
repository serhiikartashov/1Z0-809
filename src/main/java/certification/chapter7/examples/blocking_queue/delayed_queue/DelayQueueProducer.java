package certification.chapter7.examples.blocking_queue.delayed_queue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class DelayQueueProducer implements Runnable {

    protected BlockingQueue<DelayElement> blockingQueue;
    final Random random = new Random();

    public DelayQueueProducer(BlockingQueue<DelayElement> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int delay = random.nextInt(10000);
                DelayElement delayElement = new DelayElement(UUID.randomUUID()
                        .toString(), delay, delay);
                System.out.println("Put: "+ delayElement);
                blockingQueue.put(delayElement);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
