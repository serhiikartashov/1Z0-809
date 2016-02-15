package certification.chapter3.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Serhii K. on 2/15/2016.
 */
public class MapExample {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("koala", "bamboo");
        map1.put("lion", "meat");
        map1.put("giraffe", "leaf");
        String food1 = map1.get("koala");        // bamboo
        for (String key : map1.keySet())
            System.out.print(key + ",");    // koala,giraffe,lion

        System.out.println();

        Map<String, String> map2 = new TreeMap<>();
        map2.put("koala", "bamboo");
        map2.put("lion", "meat");
        map2.put("giraffe", "leaf");
        String food2 = map2.get("koala");        // bamboo
        for (String key : map2.keySet())
            System.out.print(key + ",");    // koala,giraffe,lion

        System.out.println();

        // System.out.println(map1.contains("lion")); // DOES NOT COMPILE
        System.out.println(map1.containsKey("lion"));   // true
        System.out.println(map1.containsValue("lion")); // false
        System.out.println(map1.size());                // 3
    }
}
