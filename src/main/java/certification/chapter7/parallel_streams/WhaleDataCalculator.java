package certification.chapter7.parallel_streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii K. on 3/9/2016.
 */
public class WhaleDataCalculator {

    public int processRecord(int input) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        // Handle interrupted exception
        }
        return input + 1;
    }

    public void processAllData(List<Integer> data) {
        //data.stream().map(a -> processRecord(a)).count(); // 41.699
        data.parallelStream().map(a -> processRecord(a)).count(); // 4CPU: 10.628
    }

    public static void main(String[] args) {
        WhaleDataCalculator calculator = new WhaleDataCalculator();
        // Define the data
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 4000; i++) data.add(i);
        // Process the data
        long start = System.currentTimeMillis();
        calculator.processAllData(data);
        double time = (System.currentTimeMillis() - start) / 1000.0;
        // Report results
        System.out.println("\nTasks completed in: " + time + " seconds");

    }
}
