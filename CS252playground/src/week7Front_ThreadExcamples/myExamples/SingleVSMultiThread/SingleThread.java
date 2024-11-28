package SingleVSMultiThread;

import java.util.Random;

public class SingleThread {
    public static void main(String[] args) {
        int[] array = new int[100_000_000]; // Large array for heavy workload
        Random random = new Random(42); // Fixed seed for reproducible results

        // Fill the array with random values
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // Random values between 0 and 99
        }

        long startTime = System.currentTimeMillis();

        // Sum the entire array in a single thread
        long totalSum = sumArray(array, 0, array.length);

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("\n\nSingle-threaded total sum: " + totalSum);
    }

    private static long sumArray(int[] array, int start, int end) {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += Math.sqrt(array[i]) * Math.sqrt(array[i]); // Simulated heavy computation
        }
        return sum;
    }
}













