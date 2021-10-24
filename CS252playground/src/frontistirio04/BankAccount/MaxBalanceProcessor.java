package csd.uoc.gr.BankAccount;

public class MaxBalanceProcessor extends AccountProcessor {

	@Override
	public void processAccounts() {
		double max = account[0].getBalance();
		for (int k = 1; k < account.length; k++)
		{
			double b = account[k].getBalance();
			if (b > max) max = b;
		}
		System.out.println("The maximum balance is " + max); 	
	}
}
