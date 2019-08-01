package data;

import java.util.ArrayList;

import dataController.DataController;

public class MainAccount extends Account {
	public static ArrayList<MainAccount> customerMainData = DataController.readCustomerMainFile("data/customerMainData.csv");
	
	public MainAccount(int id, String username, int pinNumber, String accountNumber, String name, double balance, String description) {
		super(id, username, pinNumber, accountNumber, name, balance, description);
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public static String mainAccountNo() {
		int totalArraySize = customerLoginData.size();
		int initialNo = (int) (Math.random() * Math.pow(10,2));
		String accountNo = initialNo + "main" + generateId(totalArraySize);
		return accountNo;
		
	}
	
	

	@Override
	public String toString() {
		return "MainAccount [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance
				+ ", description=" + description + ", getAccountNumber()=" + getAccountNumber() + ", getName()="
				+ getName() + ", getBalance()=" + getBalance() + ", getId()=" + getId() + ", getUsername()="
				+ getUsername() + ", getPinNumber()=" + getPinNumber() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}


