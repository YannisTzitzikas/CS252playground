package ThreadCreation;

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
        try {
            Thread.sleep(2000); // Simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread is still  running...");
    }
}

public class createImplement {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());//!!!!
        t1.setDaemon(true); // Set as daemon thread
        t1.start(); // Starts the thread
        System.out.println("Main thread finished");
    }
}
