package certification.chapter7.examples.blocking_queue.synchronous_queue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public static void main(String[] args) {
        SynchronousQueue<String> sq = new SynchronousQueue<>();
        Thread putThread = new Thread(new PutRunnable<>(sq, "One"), "PutThread");
        putThread.start();
        Thread takerThread = new Thread(new TakerRunnable<>(sq), "TakerThread");
        takerThread.start();


    }
}
