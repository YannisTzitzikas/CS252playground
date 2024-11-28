package synchronization;

import java.util.LinkedList;
import java.util.Random;

class Buffer {
    private final LinkedList<Integer> list = new LinkedList<>();
    private final int capacity = 3;                                 //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    public synchronized void produce(int value) throws InterruptedException {
        while (list.size() == capacity) {
            System.out.println("Buffer is full. Producer is waiting...");
            wait(); // Wait until space becomes available
        }
        list.add(value);
        System.out.println("Produced: " + value);
        notify(); // Notify the consumer
    }

    public synchronized void consume() throws InterruptedException {
        while (list.isEmpty()) {
            System.out.println("Buffer is empty. Consumer is waiting...");
            wait(); // Wait until items are available
        }
        int value = list.removeFirst();
        System.out.println("Consumed: " + value);
        notify(); // Notify the producer
    }
}


public class ProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Random random = new Random();

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(random.nextInt(1500) + 1); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    buffer.consume();
                    Thread.sleep(random.nextInt(1500)+ 1); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
