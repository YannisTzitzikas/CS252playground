package synchronization;

class SharedData {
    private int readers = 0;
    private boolean isWriting = false; // Tracks if a writer is active

    public synchronized void startRead() throws InterruptedException {
        // Wait if a writer is active
        while (isWriting) {
            wait();
        }
        readers++;
        System.out.println(Thread.currentThread().getName() + " is reading. Readers: " + readers);
    }

    public synchronized void endRead() {
        readers--;
        System.out.println(Thread.currentThread().getName() + " finished reading. Readers: " + readers);
        if (readers == 0) notifyAll(); // Notify writers if no readers are present
    }

    public synchronized void startWrite() throws InterruptedException {
        // Wait until no readers are present and no writer is active
        while (readers > 0 || isWriting) {
            wait();
        }
        isWriting = true; // Indicate a writer is active
        System.out.println(Thread.currentThread().getName() + " is writing...");
    }

    public synchronized void endWrite() {
        isWriting = false; // Writer is done
        System.out.println(Thread.currentThread().getName() + " finished writing.");
        notifyAll(); // Notify waiting readers and writers
    }
}


public class ReadWriteSharedData {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        // Reader Threads
        Runnable readerTask = () -> {
            try {
                while (true) {
                    sharedData.startRead();
                    Thread.sleep(500); // Simulate reading
                    sharedData.endRead();
                    Thread.sleep(1000); // Wait before reading again
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Writer Threads
        Runnable writerTask = () -> {
            try {
                while (true) {
                    sharedData.startWrite();
                    Thread.sleep(1000); // Simulate writing
                    sharedData.endWrite();
                    Thread.sleep(2000); // Wait before writing again
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(readerTask, "Reader-1").start();
        new Thread(readerTask, "Reader-2").start();
        new Thread(writerTask, "Writer").start();
    }
}
