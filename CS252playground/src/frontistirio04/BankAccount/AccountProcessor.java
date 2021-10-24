package csd.uoc.gr.BankAccount;

import java.util.Scanner;

public abstract class AccountProcessor {
	private AccountReader inputAccount = new AccountReader();

	protected BankAccount[] account;

	abstract public void processAccounts();
	
	public void readAccounts()
	{
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("How many accounts?");
		int size = reader.nextInt();
		
		account = new BankAccount[size];
		for (int k = 0; k < account.length; k++)
		{
			account[k] = inputAccount.readAccount();
		}
	}
}
