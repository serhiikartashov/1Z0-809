package certification.chapter3.collections.set;

import java.util.*;

class POJO {

    String v1;
    Integer v2;
}

public class SortedSetExample {

    public static void main(String[] args) {
        POJO pojo1 = new POJO();
        pojo1.v1 = "abc";
        pojo1.v2 = 7;

        POJO pojo2 = new POJO();
        pojo2.v1 = "Hello world";
        pojo2.v2 = 2;

        POJO pojo3 = new POJO();
        pojo3.v1 = "lambda";
        pojo3.v2 = 3;

        POJO pojo4 = new POJO();
        pojo4.v1 = "facade";
        pojo4.v2 = 4;

        POJO pojo5 = new POJO();
        pojo5.v1 = "class";
        pojo5.v2 = 5;

        List<POJO> list = new ArrayList<>();
        list.add(pojo1);
        list.add(pojo2);
        list.add(pojo3);
        list.add(pojo4);
        list.add(pojo5);

        TreeSet<POJO> set = new TreeSet<>((a, b) -> a.v2 - b.v2);
//        TreeSet<POJO> set = new TreeSet<>(Comparator.comparing(a -> a.v2));
        set.addAll(list);
        POJO first = set.first();
        System.out.println(first.v1 + ":" + first.v2);

//        SortedSet<POJO> set = Collections.synchronizedSortedSet(set1);
    }
}
