package certification.chapter7.examples.synchronization.phaser;

import java.util.concurrent.Phaser;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example2 {

    static final Phaser p = new Phaser(1);
    public static void main(String[] args) {
        t("ping");
        t("pong");
    }
    private static void t(final String msg) {
        new Thread() { public void run() {
            while (true) {
                System.out.println(msg);
                p.awaitAdvance(p.arrive()+1);
            }
        }}.start();
    }
}
