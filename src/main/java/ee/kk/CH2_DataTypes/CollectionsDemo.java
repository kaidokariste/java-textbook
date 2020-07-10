package ee.kk.CH2_DataTypes;

import java.util.*;

public class CollectionsDemo {
    public static void main(String... args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.forEach(element -> System.out.println(element));
        List<String> myList = List.of("neli","viis","kuus");
        myList.forEach(numbrike -> System.out.println(numbrike));

        // Map - objekt of key value pairs
        Map<String, Integer> stringMap = Map.of("one", 1,"two", 2, "three", 3);
        stringMap.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}