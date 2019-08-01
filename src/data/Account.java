package data;

import java.util.ArrayList;

import dataController.DataController;

public class Account extends Customer{
	static ArrayList<Customer> customerLoginData = DataController.readLoginFile("data/customerLoginData.csv");
	protected String accountNumber;
	protected String name;
	protected double balance;
	protected String description;


	public Account(int id, String username, int pinNumber, String accountNumber, String name, double balance, String description) {
		super(id, username, pinNumber);
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.description = description;
	}

	
	
	static void refreshData() {
		 customerLoginData = DataController.readLoginFile("data/customerLoginData.csv");
	}
	
	public static Customer getCustomer(String name, int number ) {
			
			refreshData();
			Customer cst=null;
			for (Customer c: customerLoginData) {
				if(c.getUsername().equals(name) && c.getPinNumber() == number) {
					cst=c;
					break;
				}
			}
			return cst;
	}
	
	
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public String getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public static int generateId(int arraySize) {
		int count = 1;
		count = count + arraySize;
		return count;
		
	}
	
	public double interestRate(double rate, double balance) {
		double interestAmount = 0;
		
		return interestAmount;
	}
	
	public static double deposit(double balance, double amount) {
		double depositAmount = balance + amount;
		return depositAmount;
	}
	
	public static double withdraw(double balance, double amount) {
		double withdrawAmount = balance - amount;
		return withdrawAmount;
	}
	
//	public double transfer(double balanceFromAcc, double balanceToAcc, double amount) {
//		double transferAmount = 0;
//		double amountAdded = 0;
//	
//		transferAmount = balanceFromAcc - amount;
//		amountAdded = transferAmount + balanceToAcc;
//	
//		return amountAdded;
//	}

}
