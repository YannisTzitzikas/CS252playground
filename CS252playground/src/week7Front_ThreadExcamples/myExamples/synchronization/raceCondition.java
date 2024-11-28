package synchronization;

class Counter {
    private int count = 0;
    private Object o = new Object();

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}


public class raceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join(); // Wait for t1 to finish
        t2.join(); // Wait for t2 to finish

        System.out.println("Final count: " + counter.getCount());
    }
}
