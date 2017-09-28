package certification.chapter7.examples.blocking_queue.synchronous_queue;

import java.util.concurrent.SynchronousQueue;

import static certification.chapter7.examples.blocking_queue.synchronous_queue.PrintUtils.print;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class TakerRunnable<T> implements Runnable {
    private T value;
    private SynchronousQueue<T> syncQ;
    TakerRunnable(SynchronousQueue<T> syncQ) {
        this.syncQ = syncQ;
    }
    public void run() {
        try {
            print("Retrieve using take");
            value = syncQ.take();
            print("take() returned " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public T getValue() {
        return value;
    }
}
