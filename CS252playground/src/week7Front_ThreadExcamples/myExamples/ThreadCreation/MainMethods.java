package ThreadCreation;

class MyThreadM extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is starting...");
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " is working: step " + i);
                Thread.sleep(1000); // Pauses for 1 second (moves to Waiting state)
                Thread.yield();    // Allows other threads of equal priority to execute
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted!");
        }
        System.out.println(Thread.currentThread().getName() + " has finished.");
    }
}


public class MainMethods {
    public static void main(String[] args) {
        System.out.println("Main thread has started.");
        MyThreadM t1 = new MyThreadM();
        MyThreadM t2 = new MyThreadM();

        t1.start(); // Moves t1 to Runnable
        t2.start(); // Moves t2 to Runnable

        try {
            t1.join(); // Main thread waits for t1 to finish
            t2.join(); // Main thread waits for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread has finished.");
    }
}
