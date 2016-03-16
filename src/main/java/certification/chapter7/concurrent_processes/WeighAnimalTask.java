package certification.chapter7.concurrent_processes;

import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Serhii K. on 3/10/2016.
 */
public class WeighAnimalTask extends RecursiveTask<Double> {

    private int start;
    private int end;
    private Double[] weights;

    public WeighAnimalTask(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    protected Double compute() {
        if (end - start <= 3) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
                sum += weights[i];
            }
            return sum;
        } else {
            int middle = start + ((end - start) / 2);
            System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
            RecursiveTask<Double> otherTask = new
                    WeighAnimalTask(weights, start, middle);
            otherTask.fork();
            return new WeighAnimalTask(weights, middle, end).compute() +
                    otherTask.join();
        }
    }
}

