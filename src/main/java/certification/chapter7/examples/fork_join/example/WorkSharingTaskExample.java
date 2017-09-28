package certification.chapter7.examples.fork_join.example;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class WorkSharingTaskExample implements Callable<Map<String, Double>> {

    private Proposal proposal;

    public WorkSharingTaskExample(Proposal proposal) {
        super();
        this.proposal = proposal;
    }

    @Override
    public Map<String, Double> call() throws Exception {
        return new PricingEngine().calculatePrices(proposal);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Proposal> proposals = Arrays.asList(new Proposal("Niklas", "Schlimm", "7909",
                        "AAL", true, true, true), new Proposal("Andreas", "Fritz", "0005", "432", true, true, true),
                new Proposal("Christian", "Toennessen", "0583", "442", true, true, true), new Proposal("Frank",
                        "Hinkel", "4026", "AAA", true, true, true));
        CompletionService<Map<String, Double>> pool = new ExecutorCompletionService<>(Executors.newCachedThreadPool());
        Collection<Future<Map<String, Double>>> futures = new ArrayList<>();
        System.out.println(new Date());
        for (int i = 0; i < proposals.size(); i++) {
            futures.add(pool.submit(new WorkSharingTaskExample(proposals.get(i))));
        }
        List<Map<String, Double>> prices = new ArrayList<>();
        for (int i = 0; i < proposals.size(); i++) {
            prices.add(pool.take().get());
        }
        System.out.println(prices);
        System.out.println(new Date());
    }
}
