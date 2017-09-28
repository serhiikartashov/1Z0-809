package certification.chapter7.examples.blocking_queue.delayed_queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class DelayElement implements Delayed {

    private String element;
    private long expiryTime;
    private long generatedTime;

    public DelayElement(String element, long delay, long generatedTime) {
        this.element = element;
        this.expiryTime = System.currentTimeMillis() + delay;
        this.generatedTime = generatedTime;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        long diff = expiryTime - System.currentTimeMillis();
        return timeUnit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.expiryTime < ((DelayElement) o).expiryTime) {
            return -1;
        }
        if (this.expiryTime > ((DelayElement) o).expiryTime) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return element + ": " + expiryTime + ": " + generatedTime;
    }
}
