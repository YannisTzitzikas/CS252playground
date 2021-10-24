package csd.uoc.gr.BankAccount;

public class JointBankAccount extends BankAccount{
	private String ownerName2;
	
	public JointBankAccount(int i, String o, String o2, double b) {
		super(i, o, b);
		this.ownerName2 = o2;
	}
	
	public String getJointOwner() {
		return this.ownerName2;
	}
	
	public String toString() {
		return "JointBankAccount with id: " + super.getId() + " ,owner1: " + super.getOwner() + " ,owner2: " + this.ownerName2 + " and balance: " + super.getBalance();
	}
}
