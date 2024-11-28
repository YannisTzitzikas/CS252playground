package synchronization;

class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing...");
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw but insufficient balance.");
        }
    }
}


public class bankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable task = () -> account.withdraw(80);

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
