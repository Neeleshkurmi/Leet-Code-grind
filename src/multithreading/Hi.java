package multithreading;

class Main {
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