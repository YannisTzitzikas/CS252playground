package frontistirio04.PeopleKinds;

abstract public class Employee extends PeopleInFs {

    private int employeeNum;
    /*
    * Î¤Î¿ Ï€ÎµÎ´Î¯Î¿ salary Ï…Ï€Î¬Ï�Ï‡ÎµÎ¹ Î®Î´Î· ÎºÎ±Î¹ ÏƒÏ„Î·Î½ ÎºÎ»Î¬ÏƒÎ· PeopleInFs Î±Î»Î»Î¬ ÎµÎ¬Î½ ÎºÎ±Î»Î­ÏƒÎ¿Ï…Î¼Îµ Î¿Ï€Î¿Ï…Î´Î®Ï€Î¿Ï„Îµ Ï„Î¿ Ï€ÎµÎ´Î¯Î¿
    * salary ÏƒÏ„Î·Î½ ÎºÎ»Î¬ÏƒÎ· Employee Î±Ï…Ï„ÏŒ Ï€Î¿Ï… Î¸Î± Ï€Î¬Ï�Î¿Ï…Î¼Îµ Ï‰Ï‚ Ï„Î¹Î¼Î® Î¸Î± ÎµÎ¯Î½Î±Î¹ Ï„Î¿ 700. Î”Î·Î»Î±Î´Î® Î¸Î± Î³Î¯Î½ÎµÎ¹
    * shadowing. Î•Î¬Î½ Î³Ï�Î¬Ï†Î±Î¼Îµ super.salary Ï„ÏŒÏ„Îµ Î¸Î± Ï€Î±Î¯Ï�Î½Î±Î¼Îµ Ï„Î· Ï„Î¹Î¼Î® Ï„Î¿Ï… Ï€ÎµÎ´Î¯Î¿Ï… ÏƒÏ„Î·Î½ PeopleInFs
    */
    protected double salary = 700;

    public Employee(){

    }

    public Employee(String name, int employeeNum, double salary) {
        super(name);  // Î•Î´ÏŽ ÎºÎ±Î»ÎµÎ¯Ï„Î±Î¹ Î¿ constructor Ï„Î·Ï‚ PeopleInFs Ï€Î¿Ï… Î®Ï„Î±Î½ Î¿ public PeopleInFs(String name)
        this.employeeNum = employeeNum;
        this.salary = salary;
    }

    public Employee(String name, int employeeNum){
        super(name);
        this.employeeNum = employeeNum;
    }

    /*
     * ÎŒÎ»ÎµÏ‚ Î¿Î¹ ÎºÎ»Î¬ÏƒÎµÎ¹Ï‚ Ï€Î¿Ï… Î´ÎµÎ½ ÎµÎ¯Î½Î±Î¹ Î´Î·Î»Ï‰Î¼Î­Î½ÎµÏ‚ Ï‰Ï‚ abstract ÎºÎ±Î¹ ÎºÎ»Î·Ï�Î¿Î½Î¿Î¼Î®ÏƒÎ¿Ï…Î½ Ï„Î·Î½ Employee
     * Î¸Î± ÎºÎ»Î·Î¸Î¿Ï�Î½ Î½Î± Ï…Î»Î¿Ï€Î¿Î¹Î®ÏƒÎ¿Ï…Î½ Ï„Î¹Ï‚ ÏƒÏ…Î½Î±Ï�Ï„Î®ÏƒÎµÎ¹Ï‚ getGrossSalary() ÎºÎ±Î¹ getNetSalary() Î· Î¿Ï€Î¿Î¯ÎµÏ‚
     * Î­Ï‡Î¿Ï…Î½ Î´Î·Î»Ï‰Î¸ÎµÎ¯ Ï‰Ï‚ abstract
     */
    abstract public double getGrossSalary();

    abstract public double getNetSalary();

    @Override
    public String toString() {
        return super.toString() + " | EmplNum " + this.employeeNum +
                " | Gross Salary " + this.getGrossSalary() + " | Net Salary " + this.getNetSalary();
    }

}
