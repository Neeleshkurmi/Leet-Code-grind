package collectionframework;

import java.util.Stack;

public class CustomStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        Integer pop = stack.pop();
        System.out.println(stack);
        System.out.println(pop);

    }
}
