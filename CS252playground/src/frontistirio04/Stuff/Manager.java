package frontistirio04.Stuff;

import frontistirio04.PeopleKinds.Employee;

public class Manager extends Employee {

    private int bonus;

    public Manager(String name, int employeeNum, double salary) {
        super(name, employeeNum, salary);
    }

    @Override
    public double getNetSalary() {
        return this.getGrossSalary() * 0.9;
    }

    @Override
    public double getGrossSalary() {
        return this.salary + this.bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString() + " | Bonus " + this.bonus;
    }

}
