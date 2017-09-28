package certification.chapter7.examples.blocking_queue.delayed_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public static void main(String[] args) {
        final BlockingQueue<DelayElement> queue = new DelayQueue<>();

        DelayQueueProducer queueProducer = new DelayQueueProducer(queue);
        new Thread(queueProducer).start();

        DelayQueueConsumer queueConsumer1 = new DelayQueueConsumer(queue);
        new Thread(queueConsumer1).start();

        DelayQueueConsumer queueConsumer2 = new DelayQueueConsumer(queue);
        new Thread(queueConsumer2).start();

    }
}
