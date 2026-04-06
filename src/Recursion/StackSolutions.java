package Recursion;

import java.util.Stack;

public class StackSolutions{
    // Main function to reverse stack
    public void reverse(Stack<Integer> st) {

        // Base case: agar stack empty hai to kuch reverse nahi karna
        if (st.isEmpty()) {
            return;
        }

        // Top element ko nikal lo
        int top = st.pop();

        // Remaining stack ko recursively reverse karo
        reverse(st);

        // Removed top ko bottom me insert karo
        insertAtBottom(st, top);
    }

    // Helper function to insert element at bottom
    public void insertAtBottom(Stack<Integer> st, int element) {

        // Agar stack empty hai, yahi bottom position hai
        if (st.isEmpty()) {
            st.push(element);
            return;
        }

        // Top ko temporarily hatao
        int top = st.pop();

        // Element ko niche insert karne ke liye recursion
        insertAtBottom(st, element);

        // Removed element ko wapas same order me push karo
        st.push(top);
    }


    public void sortStack(Stack<Integer> st) {

        // Base case: agar stack empty hai to return
        if (st.isEmpty()) {
            return;
        }

        // Top element ko temporary nikal lo
        int top = st.pop();

        // Remaining stack ko recursively sort karo
        sortStack(st);

        // Removed element ko sorted stack me correct jagah insert karo
        insertInSortedOrder(st, top);
    }

    // Helper function to insert element in descending order
    public void insertInSortedOrder(Stack<Integer> st, int element) {

        // Correct position mil gayi:
        // 1) stack empty
        // 2) top element current element se bada ya equal hai
        if (st.isEmpty() || st.peek() >= element) {
            st.push(element);
            return;
        }

        // Agar top chhota hai, to use temporary hatao
        int top = st.pop();

        // Recursive call until correct place found
        insertInSortedOrder(st, element);

        // Jo element nikala tha use wapas push karo
        st.push(top);
    }
}