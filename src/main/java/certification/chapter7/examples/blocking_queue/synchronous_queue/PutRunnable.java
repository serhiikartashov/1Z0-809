package certification.chapter7.examples.blocking_queue.synchronous_queue;

import java.util.concurrent.SynchronousQueue;

import static certification.chapter7.examples.blocking_queue.synchronous_queue.PrintUtils.print;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class PutRunnable<T> implements Runnable {
    private T value;
    private SynchronousQueue<T> syncQ;
    PutRunnable(SynchronousQueue<T> syncQ, T value) {
        this.syncQ = syncQ;
        this.value = value;
    }
    public void run() {
        try {
            print("Put " + value);
            syncQ.put(value);
            print("Returned from put");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
