package data;

public class Customer {
	private int id;
	private String username;
	private int pinNumber;
	
	public Customer(int id, String username, int pinNumber) {
		this.id = id;
		this.username = username;
		this.pinNumber = pinNumber;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public int getPinNumber() {
		return pinNumber;
	}
	
	

}
