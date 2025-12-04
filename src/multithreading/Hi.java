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