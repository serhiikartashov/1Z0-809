package certification.chapter7.examples.blocking_queue.priority_blocking_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public static void main(String[] args) {
        final String[] names =
                {"carol", "alice", "malory", "bob", "alex", "jacobs","carol2", "alice2", "malory2", "bob2", "alex2", "jacobs2", "bob2", "alex2", "jacobs2"};

        final BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread(() -> {
            try {
                while(true)
                /*for (int i = 0; i < names.length; i++)*/ {
                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer1").start();

        new Thread(() -> {
            try {
                while (true)
                /*for (int i = 0; i < names.length; i++)*/ {
                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer2").start();

        new Thread(() -> {
            for (int i = 0; i < names.length; i++) {
                try {
                    queue.put(names[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer").start();
    }

}
