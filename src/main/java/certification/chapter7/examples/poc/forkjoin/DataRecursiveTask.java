package certification.chapter7.examples.poc.forkjoin;

import certification.chapter7.examples.poc.DataBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RecursiveTask;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class DataRecursiveTask extends RecursiveTask<PriorityBlockingQueue<DataBean>> {
    private int taskName;
    private boolean isRootTask;
    private PriorityBlockingQueue<DataBean> data;

    private DataBean older;
    private DataBean younger;

    public DataRecursiveTask(PriorityBlockingQueue<DataBean> data, boolean isRootTask) throws InterruptedException {
        this.data = data;
        younger = data.take();
        older = data.take();
        taskName = younger.getDate();
        this.isRootTask = isRootTask;
        System.out.println("Created task for: " + younger + " and " + older);
    }

    @Override
    protected PriorityBlockingQueue<DataBean> compute() {
        if (data.size() > 1) {

            splitOnTasks();
            data.put(sumTwoBeans());

            while (isRootTask && data.size() > 1) {
                splitOnTasks();
            }

            return data;
        } else {
            data.put(sumTwoBeans());
            return data;
        }
    }

    private void splitOnTasks() {
        List<DataRecursiveTask> subtasks = new ArrayList<>();
        try {
            subtasks.addAll(createSubtasks());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (DataRecursiveTask subtask : subtasks) {
            subtask.fork();
        }

        for (DataRecursiveTask subtask : subtasks) {
            subtask.join();
        }
    }

    private List<DataRecursiveTask> createSubtasks() throws InterruptedException {
        List<DataRecursiveTask> subtasks = new ArrayList<>();

        while (data.size() > 1) {
            subtasks.add(new DataRecursiveTask(data, false));
        }

        return subtasks;
    }

    private DataBean sumTwoBeans() {
        younger.getValue().getAndSet(younger.getValue().intValue() + older.getValue().intValue());
        return younger;
    }
}
