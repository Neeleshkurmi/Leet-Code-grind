package heap;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");

        String input = new String("hello");
        if (input == "hello") { // Evaluates to false!
            System.out.println("Match found");
        }


        // The Problem: Attempting to remove an item while iterating with a for-each loop
        for (String item : items) {
            if (item.equals("Banana")) {
                items.remove(item); // Throws ConcurrentModificationException
            }
        }

        System.out.println(items);
    }
}
