package certification.chapter7.examples.poc;;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class DataProvider {

    public static PriorityBlockingQueue<DataBean> provideTestData() {
        PriorityBlockingQueue<DataBean> dataBeanList = new PriorityBlockingQueue<>(20, Comparator.comparing(DataBean::getDate));
//        ConcurrentSkipListSet<DataBean> dataBeanList = new ConcurrentSkipListSet<>(Comparator.comparing(DataBean::getDate));

        // 100
        dataBeanList.add(new DataBean(1, 50));
        dataBeanList.add(new DataBean(2, 50));
        // 200
        dataBeanList.add(new DataBean(3, 100));
        dataBeanList.add(new DataBean(4, 100));
        // 300
        dataBeanList.add(new DataBean(5, 150));
        dataBeanList.add(new DataBean(6, 150));
        // 400
        dataBeanList.add(new DataBean(7, 200));
        dataBeanList.add(new DataBean(8, 200));
        // 500
        dataBeanList.add(new DataBean(9, 250));
        dataBeanList.add(new DataBean(10, 250));
        // 600
        dataBeanList.add(new DataBean(11, 300));
        dataBeanList.add(new DataBean(12, 300));
        // 700
        dataBeanList.add(new DataBean(13, 350));
        dataBeanList.add(new DataBean(14, 350));
        // 800
        dataBeanList.add(new DataBean(15, 400));
        dataBeanList.add(new DataBean(16, 400));
        // 900
        dataBeanList.add(new DataBean(17, 450));
        dataBeanList.add(new DataBean(18, 450));
        // 1000
        dataBeanList.add(new DataBean(19, 500));
        dataBeanList.add(new DataBean(20, 500));

        // Summary: 5_500

        return dataBeanList;
    }

    public static PriorityBlockingQueue<DataBean> provideHugeData() {
        PriorityBlockingQueue<DataBean> dataBeanList = new PriorityBlockingQueue<>(20, Comparator.comparing(DataBean::getDate));

        return dataBeanList;
    }
}
