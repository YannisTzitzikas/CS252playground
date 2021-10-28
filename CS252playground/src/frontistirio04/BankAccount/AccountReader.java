package frontistirio04.BankAccount;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AccountReader {
	
	public BankAccount readAccount() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a account type 1 for BankAccount or 2 for JointBankAccount: ");
		int type = reader.nextInt(); // Scans the next token of the input as an int.
		
		System.out.println("Enter owner name: ");
		String ownerName = reader.next();
		
		System.out.println("Enter balance: ");
		double accountBalance = reader.nextDouble();
		
		int id = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
		
		if (type == 2)
		 {
			System.out.println("Enter joint owner name: ");
			String jointOwnerName = reader.next();
			
			return new JointBankAccount(id, ownerName, jointOwnerName, accountBalance);
		 }
		 else
			 return new BankAccount(id, ownerName, accountBalance);

	}
}
