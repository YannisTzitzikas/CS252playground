package synchronization;

class PingPong {
    private boolean pingTurn = true;

    public synchronized void ping() throws InterruptedException {
        while (!pingTurn) {
            wait();
        }
        System.out.println("Ping");
        pingTurn = false;
        notify();
    }

    public synchronized void pong() throws InterruptedException {
        while (pingTurn) {
            wait();
        }
        System.out.println("    Pong");
        pingTurn = true;
        notify();
    }
}


public class PinkPonk {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong();

        Thread pingThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pingPong.ping();
                    Thread.sleep(500); // Simulate delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread pongThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pingPong.pong();
                    Thread.sleep(500); // Simulate delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        pingThread.start();
        pongThread.start();
    }
}
