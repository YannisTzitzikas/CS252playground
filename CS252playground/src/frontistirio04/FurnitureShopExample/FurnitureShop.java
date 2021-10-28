package frontistirio04.FurnitureShopExample;

import frontistirio04.PeopleKinds.Customer;
import frontistirio04.PeopleKinds.Employee;
import frontistirio04.Stuff.Manager;
import frontistirio04.Stuff.SalesPerson;

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
         * Î‘Ï�Ï‡Î¹ÎºÎ¿Ï€Î¿Î¹Î¿Ï�Î¼Îµ Î­Î½Î±Î½ array Î¼Îµ Ï„Î¿Ï…Ï‚ 3 Ï…Ï€Î±Î»Î»Î®Î»Î¿Ï…Ï‚. Î‘Ï…Ï„ÏŒ ÎµÎ¯Î½Î±Î¹ ÎµÏ†Î¹ÎºÏ„ÏŒ ÎµÏ†ÏŒÏƒÎ¿Î½ Î¿Î¹ ÎºÎ»Î¬ÏƒÎµÎ¹Ï‚ Ï€Î¿Ï…
         * Î±Î½Î®ÎºÎ¿Ï…Î½ Ï„Î± Î±Î½Ï„Î¹ÎºÎµÎ¯Î¼ÎµÎ½Î± Ï€Î¿Ï… ÎµÎ¯Î½Î±Î¹ Î¿Î¹ Manager, SalesPerson Î­Ï‡Î¿Ï…Î½ ÎºÎ»Î·Ï�Î¿Î½Î¿Î¼Î®ÏƒÎµÎ¹ Ï„Î·Î½ ÎºÎ»Î¬ÏƒÎ·
         * Employee. Î†Ï�Î± ÎºÎ±Î¹ Î­Î½Î±Ï‚ Manager ÎºÎ±Î¹ Î­Î½Î±Ï‚ SalesPerson ÎµÎ¯Î½Î±Î¹ Employees
         */
        Employee[] employees = {nikos, kostas, giannis};
        double totalGrossSalaries = 0;
        /*
         * H Ï€Î±Ï�Î±ÎºÎ¬Ï„Ï‰ for loop ÎµÎ¯Î½Î±Î¹ Ï€Î¿Î»Ï…Î¼Î¿Ï�Ï†Î¹ÎºÎ® Î´Î¹ÏŒÏ„Î¹ Î¼ÏŒÎ½Î¿ Î¼Îµ Î¼Î¹Î± Î³Ï�Î±Î¼Î¼Î® ÎºÏŽÎ´Î¹ÎºÎ± ÎºÎ±Î»Î¿Ï�Î¼Îµ
         * ÎºÎ±Ï„Î¬ Ï„Î·Î½ ÎµÎºÏ„Î­Î»ÎµÏƒÎ· Ï„Î¿Ï… Ï€Ï�Î¿Î³Ï�Î¬Î¼Î¼Î±Ï„Î¿Ï‚ Î´Î¹Î±Ï†Î¿Ï�ÎµÏ„Î¹ÎºÎ¬ ÎºÎ¿Î¼Î¼Î¬Ï„Î¹Î± ÎºÏŽÎ´Î¹ÎºÎ± Î±Î½Î±Î»ÏŒÎ³Ï‰Ï‚ Ï„Î¿Î½ Ï„Ï�Ï€Î¿Ï… Ï„Î¿Ï…
         * Î±Î½Ï„Î¹ÎºÎµÎ¹Î¼Î­Î½Î¿Ï…. Î‘Ï†Î¿Ï� ÎµÏ€Î¹Î²Î¬Î»Î»Î±Î¼Îµ ÏƒÏ„Î¹Ï‚ ÎºÎ»Î¬ÏƒÎµÎ¹Ï‚ Manager, SalesPerson Î½Î± Ï…Î»Î¿Ï€Î¿Î¹Î®ÏƒÎ¿Ï…Î½ Ï„Î·Î½ ÏƒÏ…Î½Î¬Ï�Ï„Î·ÏƒÎ·
         * getGrossSalary() Î´Î·Î»ÏŽÎ½Î¿Î½Ï„Î¬Ï‚ Ï„Î· Ï‰Ï‚ abstract ÏƒÏ„Î·Î½ ÎºÎ»Î¬ÏƒÎ· Employee, Î¾Î­Ï�Î¿Ï…Î¼Îµ Ï€Ï‰Ï‚ ÎºÎ¬Î¸Îµ Î±Î½Ï„Î¹ÎºÎµÎ¯Î¼ÎµÎ½Î¿
         * Manager Î® SalesPerson Î¸Î± Î­Ï‡ÎµÎ¹ Ï„Î· Î´Î¹ÎºÎ® Ï„Î¿Ï… Ï…Î»Î¿Ï€Î¿Î¯Î·ÏƒÎ· Î³Î¹Î± Î±Ï…Ï„Î® Ï„Î· ÏƒÏ…Î½Î¬Ï�Ï„Î·ÏƒÎ· Î±Ï†Î¿Ï� ÎºÎ»Î·Ï�Î¿Î½Î¿Î¼ÎµÎ¯ Ï„Î·Î½ Employee
         * */
        System.out.println("\nCalculating Gross Salary for Employees:");
        for(int i=0; i < employees.length; i++){
            System.out.println(employees[i].getName() + ", Gross Salary: " + employees[i].getGrossSalary());
            totalGrossSalaries += employees[i].getGrossSalary();
        }
        System.out.println("\nTotal gross salaries " + totalGrossSalaries);

    }

}
