package csd.uoc.gr.PeopleKinds;

abstract public class Employee extends PeopleInFs {

    private int employeeNum;
    /*
    * Το πεδίο salary υπάρχει ήδη και στην κλάση PeopleInFs αλλά εάν καλέσουμε οπουδήποτε το πεδίο
    * salary στην κλάση Employee αυτό που θα πάρουμε ως τιμή θα είναι το 700. Δηλαδή θα γίνει
    * shadowing. Εάν γράφαμε super.salary τότε θα παίρναμε τη τιμή του πεδίου στην PeopleInFs
    */
    protected double salary = 700;

    public Employee(){

    }

    public Employee(String name, int employeeNum, double salary) {
        super(name);  // Εδώ καλείται ο constructor της PeopleInFs που ήταν ο public PeopleInFs(String name)
        this.employeeNum = employeeNum;
        this.salary = salary;
    }

    public Employee(String name, int employeeNum){
        super(name);
        this.employeeNum = employeeNum;
    }

    /*
     * Όλες οι κλάσεις που δεν είναι δηλωμένες ως abstract και κληρονομήσουν την Employee
     * θα κληθούν να υλοποιήσουν τις συναρτήσεις getGrossSalary() και getNetSalary() η οποίες
     * έχουν δηλωθεί ως abstract
     */
    abstract public double getGrossSalary();

    abstract public double getNetSalary();

    @Override
    public String toString() {
        return super.toString() + " | EmplNum " + this.employeeNum +
                " | Gross Salary " + this.getGrossSalary() + " | Net Salary " + this.getNetSalary();
    }

}
