package certification.chapter7.examples.fork_join;

import java.util.concurrent.ForkJoinPool;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);
        forkJoinPool.invoke(myRecursiveAction);

//        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);
//        long mergedResult = forkJoinPool.invoke(myRecursiveTask);

//        System.out.println("mergedResult = " + mergedResult);
    }
}
