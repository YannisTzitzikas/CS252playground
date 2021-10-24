package csd.uoc.gr.BankAccount;

public class BankAccountExample {
	public static void main(String argv[ ]) {

		BankAccount fred = new BankAccount(123, "Fred", 345.50);
		JointBankAccount fredMary = new JointBankAccount(345, "Fred", "Mary", 450.65);
		
		BankAccount ellenFrank = new JointBankAccount(456, "Ellen", "Frank", 3450);

		//JointBankAccount fred2 = new BankAccount(123, "Fred", 345.50); //--> Illegal: A BankAccount is not necessarily a JointBankAccount
		
		String owner = fredMary.getOwner();
		String jointOwner = fredMary.getJointOwner();
		//String jointOwner2 = ellenFrank.getJointOwner(); //--> Illegal: ellenFrank is an instance of BankAccount.
	
		
		BankAccount joan = new BankAccount(1, "Joan", 899);
		JointBankAccount joanBob =new JointBankAccount(122, "Joan", "Bob", 200);
		
		transfer(fred, joan, 89.55);
		transfer(fred, fredMary, 49.35);
		transfer(joanBob, fredMary, 100.00);
		transfer(joanBob, joan, 50.00);
	}
	
	public static void transfer(BankAccount from, BankAccount to, double amount)
	{
		boolean ok = from.withdraw(amount);
		if (ok)
		{
			to.deposit(amount);
		}
		System.out.println("Successful transfer. Current account states:\n" + from.getOwner() + "--->" + from.getBalance() +"\n" + to.getOwner() + "--->" + to.getBalance());
		
	}
}
