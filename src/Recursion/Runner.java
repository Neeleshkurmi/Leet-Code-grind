package Recursion;

import java.util.*;
public class Runner{
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        StackSolutions s = new StackSolutions();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println("Before Reverse: " + st);

        s.reverse(st);

        System.out.println("After Reverse: " + st);

        s.sortStack(st);

        System.out.println("After Sorting: " + st);

    }
}