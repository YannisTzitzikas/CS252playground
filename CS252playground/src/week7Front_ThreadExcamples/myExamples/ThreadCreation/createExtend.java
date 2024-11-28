package ThreadCreation;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class createExtend {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Starts the thread
    }
}
