package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	private int id;
	private String username;
	private String date;
	private String description;
	private double amount;
	
	public Transaction(int id, String username, String date, String description, double amount) {
		this.id = id;
		this.username = username;
		this.date = date;
		this.description = description;
		this.amount = amount;
	}
	
	public Transaction() {
		this.id = id;
		this.username = username;
		this.date = date;
		this.description = description;
		this.amount = amount;
	}

	
	
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}
	
	public String saveTransaction(int id, String username, String description, double amount) {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("hh:mma-dd/MM/YY");
		String todayDate;
		String transactionInfo;
		
		todayDate = dateForm.format(thisDate);
		transactionInfo = id + "," + username + "," + todayDate + "," + description + "," + amount;
		
		return transactionInfo;
		
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", username=" + username + ", date=" + date + ", description=" + description
				+ ", amount=" + amount + "]";
	}
	
	
}
