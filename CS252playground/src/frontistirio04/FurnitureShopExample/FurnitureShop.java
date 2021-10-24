package csd.uoc.gr.FurnitureShopExample;

import csd.uoc.gr.PeopleKinds.Customer;
import csd.uoc.gr.PeopleKinds.Employee;
import csd.uoc.gr.Stuff.Manager;
import csd.uoc.gr.Stuff.SalesPerson;

public final class FurnitureShop{

    public static void main(String[] args) {
        Employee nikos = new Manager("Nikos", 11, 2000);
        SalesPerson kostas = new SalesPerson("Kostas", 21);
        Employee giannis = new SalesPerson("Giannis", 22);
        Customer anna = new Customer("Anna", "lion square", 200);

        System.out.println(anna.toString() + "\n");

        System.out.println("*" + nikos.getName() + " no bonus*: " + nikos.toString());

        ((Manager)nikos).setBonus(100);

        System.out.println("*" + nikos.getName() + " with bonus*: " + nikos.toString());

        System.out.println("\n" + kostas.toString());

        ((SalesPerson)giannis).setEarningsFromSales(5000);

        System.out.println("\n" + giannis.toString());

        /*
         * Αρχικοποιούμε έναν array με τους 3 υπαλλήλους. Αυτό είναι εφικτό εφόσον οι κλάσεις που
         * ανήκουν τα αντικείμενα που είναι οι Manager, SalesPerson έχουν κληρονομήσει την κλάση
         * Employee. Άρα και ένας Manager και ένας SalesPerson είναι Employees
         */
        Employee[] employees = {nikos, kostas, giannis};
        double totalGrossSalaries = 0;
        /*
         * H παρακάτω for loop είναι πολυμορφική διότι μόνο με μια γραμμή κώδικα καλούμε
         * κατά την εκτέλεση του προγράμματος διαφορετικά κομμάτια κώδικα αναλόγως τον τύπου του
         * αντικειμένου. Αφού επιβάλλαμε στις κλάσεις Manager, SalesPerson να υλοποιήσουν την συνάρτηση
         * getGrossSalary() δηλώνοντάς τη ως abstract στην κλάση Employee, ξέρουμε πως κάθε αντικείμενο
         * Manager ή SalesPerson θα έχει τη δική του υλοποίηση για αυτή τη συνάρτηση αφού κληρονομεί την Employee
         * */
        System.out.println("\nCalculating Gross Salary for Employees:");
        for(int i=0; i < employees.length; i++){
            System.out.println(employees[i].getName() + ", Gross Salary: " + employees[i].getGrossSalary());
            totalGrossSalaries += employees[i].getGrossSalary();
        }
        System.out.println("\nTotal gross salaries " + totalGrossSalaries);

    }

}
