package ThreadCreation;

// Base class representing a generic vehicle
class Vehicle {
    protected String name;
    protected int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void displayInfo() {
        System.out.println(name + " is moving at " + speed + " km/h.");
    }
}

// Derived class representing a car that implements Runnable
class Car extends Vehicle implements Runnable {
    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void run() {
        System.out.println(name + " has started moving...");
        for (int i = 1; i <= 5; i++) { // Simulate 5 seconds of movement
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted!");
            }
            System.out.println(name + " covered " + (i * speed) + " km.");
        }
        System.out.println(name + " has finished its journey.");
    }
}


public class moreComplexImplemt {
    public static void main(String[] args) {
        Car car1 = new Car("Car A", 60); // Moving at 60 km/h
        Car car2 = new Car("Car B", 80); // Moving at 80 km/h

        Thread thread1 = new Thread(car1);
        Thread thread2 = new Thread(car2);

        car1.displayInfo(); // Call method from Vehicle
        car2.displayInfo();

        thread1.start(); // Start Car A's thread
        thread2.start(); // Start Car B's thread
    }
}
