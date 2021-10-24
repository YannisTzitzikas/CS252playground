package csd.uoc.gr.BankAccount;

public class BankAccount {
	private int id;
	private String ownerName;
	private double balance;
	
	public BankAccount() {
		this.id = -1;
		this.ownerName = "";
		this.balance = 0;
	}
	
	public BankAccount(int i, String o, double b) {
		this.id = i;
		this.ownerName = o;
		this.balance = b;
	}
	
	public String getOwner() {
		return this.ownerName;
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String toString() {
		return "BankAccount with id: " + this.id + " ,owner: " + this.ownerName + " and balance: " + this.balance;
	}
	
	public boolean withdraw(double amount) {
		if(this.balance - amount >= 0) {
			this.balance -= amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
}
