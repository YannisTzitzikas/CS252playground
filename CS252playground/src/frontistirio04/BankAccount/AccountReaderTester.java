package frontistirio04.BankAccount;

public class AccountReaderTester {
	public AccountReaderTester()
	 {
		AccountReader accountInput = new AccountReader();
		
		BankAccount a = accountInput.readAccount();
		System.out.println(a);
	 }
	
	 public static void main(String[] args)
	 { 
		 new AccountReaderTester();
	 }
}
