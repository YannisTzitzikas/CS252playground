package SingleVSMultiThread;

import java.util.Random;

public class multiThread {
    public static void main(String[] args) {
        int numberOfThreads = 1; // Set the number of threads here
        int[] array = new int[100_000_000]; // Large array for heavy workload
        Random random = new Random(42); // Fixed seed for reproducible results

        // Fill the array with random values
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // Random values between 0 and 99
        }

        long startTime = System.currentTimeMillis();

        // Divide the array into equal parts based on the number of threads
        int chunkSize = array.length / numberOfThreads;
        SumThread[] threads = new SumThread[numberOfThreads];

        // Create and start all threads
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numberOfThreads - 1) ? array.length : start + chunkSize; // Last thread handles remaining
            threads[i] = new SumThread(array, start, end);
            threads[i].start();
        }

        // Wait for all threads to complete and aggregate the results
        long totalSum = 0;
        for (SumThread thread : threads) {
            try {
                thread.join();
                totalSum += thread.getSum(); // Aggregate each thread's result
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Number of threads: " + numberOfThreads);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");

        System.out.println("\n\nTotal sum: " + totalSum);
    }
}

class SumThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private long sum;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            sum += Math.sqrt(array[i]) * Math.sqrt(array[i]); // Simulated heavy computation
        }
    }

    public long getSum() {
        return sum;
    }
}










