package stack;

import java.util.LinkedList;

public class MyStack<T> {
    static final int DEFAULT_CAPACITY =10;
    int capacity;
    T[] data;
    int top;

    public MyStack(){
        this(DEFAULT_CAPACITY);
    }

    public MyStack(int capacity){
        this.capacity = capacity;
        this.top = -1;
        this.data = (T[]) new Object[this.capacity];
    }

    public void push(T val){
        if(top==capacity-1) {
            System.out.println("Stack overflow");
            return;
        }
        data[++top] = val;
    }

    void display(){
        for (int i = data.length-1; i >=0; i--) {
            System.out.println("|"+data[i]+"|");
            System.out.println("_____");
        }
    }

    T pop(){
        if(top==-1){
            System.out.println("stack is empty");
            return null;
        }
        return data[top--];
    }

    T peek(){
        return data[top];
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        MyStack<LinkedList<Integer>> m = new MyStack<>(2);
        LinkedList<Integer> list2 = new LinkedList<>();

        list.add(8); list.add(9); list2.add(7); list2.add(10);
        m.push(list);
        m.push(list2);
        m.peek();
        m.display();

    }
}
