package certification.chapter7.examples.concurrent_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Serhii Kartashov
 * @since 1.0.0
 */
public class Example2 {

    public static void main(String[] args) {

        //ConcurrentHashMap
        Map<String, String> myMap = new ConcurrentHashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap before iterator: " + myMap);
        Iterator<String> it = myMap.keySet().iterator();

        while (it.hasNext()) {
            String key = it.next();
            if (key.equals("3")) myMap.put(key + "new", "new3");
        }
        System.out.println("ConcurrentHashMap after iterator: " + myMap);

        //HashMap
        myMap = new HashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("HashMap before iterator: " + myMap);
        Iterator<String> it1 = myMap.keySet().iterator();

        while (it1.hasNext()) {
            String key = it1.next();
            // will throw ConcurrentModificationException
            // It means that the new entry got inserted in the HashMap but Iterator is failing.
            // Actually Iterator on Collection objects are fail-fast i.e
            // any modification in the structure or the number of entry in the collection object will trigger this exception thrown by iterator.
            if (key.equals("3")) myMap.put(key + "new", "new3");
        }
        System.out.println("HashMap after iterator: " + myMap);
    }
}
