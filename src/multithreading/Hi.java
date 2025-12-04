package multithreading;

public class Hi{
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for (int i = 0; i <=5 ; i++)
                System.out.println("hi");
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i <=5; i++)
                System.out.println("hello");
        });
        thread1.start();
        try{thread2.join();}catch (Exception e){}
        thread2.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <=5; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread m = new MyThread();
        m.start();
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("implementing runnable");
    }

    public static void main(String[] args) {
        MyRunnable m = new MyRunnable();
        Thread t = new Thread(m);
        t.start();
    }
}
class Daemon extends Thread{
    @Override
    public void run() {
        if(this.isDaemon()){
            System.out.println("its a daemon thread");
        }
        else System.out.println("not a daemon thread");
    }

    public static void main(String[] args) {
        Daemon d = new Daemon();
        Daemon daemon = new Daemon();
        d.setDaemon(true);
        d.start();
        daemon.start();
    }
}

class Example extends Thread{
    private static boolean LOCK = false;
    @Override
    public void run() {
        try {
            this.mySynchronisedBlock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void mySynchronisedBlock() throws InterruptedException {
        synchronized (this){
            for (int i = 0; i <=6; i++) {
                System.out.println(STR."\{this.getName()} accessing sync block");
            }
        }
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.start();
        Example example1 = new Example();
        example1.start();
    }
}

class Node{
    Node head;
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
    void insert(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    Node getHead(){
        return head;
    }
    void display() {
        Node temp = head;
        while (temp!=null){
            System.out.print(STR."\{temp.val}->");
            temp = temp.next;
        }
        System.out.print("END");
    }
    void display(Node temp){
        while (temp!=null){
            System.out.print(STR."\{temp.val}->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    Node reverse(Node temp){
        return null;
    }

    public static void main(String[] args) {
        Node node = new Node(-1);
        node.insert(1);
        node.insert(2);
        node.insert(3);
        node.display();
        Node temp = node.reverse(node.getHead());
        node.display(temp);
    }
}