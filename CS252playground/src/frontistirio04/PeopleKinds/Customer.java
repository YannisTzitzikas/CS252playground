package csd.uoc.gr.PeopleKinds;

public class Customer extends PeopleInFs {

    private String address;
    private double budget;

    public Customer(String name, String address, double budget){
        super(name);    // Εδώ καλείται ο constructor της PeopleInFs που ήταν ο public PeopleInFs(String name)
        this.address = address;
        this.budget = budget;
    }

    public String getAddress() {
        return address;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return super.toString() + " | Addr: " + this.address + " | Budget " + this.budget;
    }

}
