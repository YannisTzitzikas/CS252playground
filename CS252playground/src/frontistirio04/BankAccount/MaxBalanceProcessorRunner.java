package csd.uoc.gr.BankAccount;

public class MaxBalanceProcessorRunner {
	public static void main(String[] args)
	{
		MaxBalanceProcessor program = new MaxBalanceProcessor();
		
		program.readAccounts();
		
		program.processAccounts();
	}
}
