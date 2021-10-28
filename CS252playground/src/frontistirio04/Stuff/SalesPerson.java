package frontistirio04.Stuff;

import frontistirio04.PeopleKinds.Employee;

public class SalesPerson extends Employee {

    private double commision;
    private double commisionPortion = 0.5;
    protected double salary = 1000.0;

    public SalesPerson(String name, int employeeNum) {
        super(name, employeeNum);
    }

    public void setEarningsFromSales(double earnings){
        this.commision = this.commisionPortion * earnings;
    }

    @Override
    public double getGrossSalary() {
        return this.salary + commision;
    }

    @Override
    public double getNetSalary() {
        return this.getGrossSalary() * 0.95;
    }

    @Override
    public String toString() {
        return super.toString() + " | Commission " + this.commision;
    }
}
