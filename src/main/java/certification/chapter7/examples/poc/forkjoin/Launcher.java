package certification.chapter7.examples.poc.forkjoin;

import certification.chapter7.examples.poc.DataBean;
import certification.chapter7.examples.poc.DataProvider;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Launcher {

//    static class Recursive<I> {
//        public I func;
//    }
//
//    static Function<Integer, Double> factorial = x -> {
//        Launcher.Recursive<IntToDoubleFunction> recursive = new Launcher.Recursive<>();
//        recursive.func = n -> (n == 0) ? 1 : n * recursive.func.applyAsDouble(n - 1);
//        return recursive.func.applyAsDouble(x);
//    };

    public static void main(String[] args) throws InterruptedException {

        PriorityBlockingQueue<DataBean> dataBeans = DataProvider.provideTestData();
//        dataBeans.forEach(System.out::println);

        ForkJoinPool threadPool =  new ForkJoinPool(4);
        PriorityBlockingQueue<DataBean> invoke = threadPool.invoke(new DataRecursiveTask(dataBeans, true));
        invoke.forEach(System.out::println);

//        final int nthFactorial = 25;
//
//        CompletableFuture<Double> result = CompletableFuture.supplyAsync(
//                () -> {
//                    System.out.println(Thread.currentThread().getName() + " factorial task is called"); // 2
//                    Double factorialResult = factorial.apply(nthFactorial);
//                    return factorialResult;
//                },
//                newFixedThreadPool
//        );


    }
}
