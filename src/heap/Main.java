package heap;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Bug 1: Uninitialized object reference (will cause NullPointerException if used)
    private static String globalText;

    public static void main(String[] args) {
        System.out.println("Starting the buggy program...");

        // Bug 2: Compile-time error - missing semicolon
        int x = 10

        // Bug 3: Arithmetic exception - division by zero
        int result = 50 / 0;

        // Bug 4: String comparison using '==' instead of '.equals()'
        String name1 = new String("Java");
        String name2 = new String("Java");
        if (name1 == name2) {
            System.out.println("Strings are equal!");
        }

        // Bug 5: ArrayIndexOutOfBoundsException (off-by-one error with '<=')
        int[] numbers = {1, 2, 3, 4, 5};
        for (int i = 0; i <= numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // Bug 6: ConcurrentModificationException (modifying a list while iterating)
        List<String> items = new ArrayList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Cherry");

        for (String item : items) {
            if (item.equals("Banana")) {
                items.remove(item);
            }
        }

        // Bug 7: Logical error - infinite loop due to wrong update condition
        int count = 5;
        while (count > 0) {
            System.out.println("Countdown: " + count);
            count++; // Increases instead of decreases, causing an infinite loop!
            if (count > 1000) break; // Emergency safety break to prevent total lockup
        }

        // Bug 8: NullPointerException - calling a method on a null reference
        int length = globalText.length();
        System.out.println("Length: " + length);
    }
}
