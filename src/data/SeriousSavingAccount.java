package data;

public class SeriousSavingAccount extends Account{

	public SeriousSavingAccount(int id, String username, int pinNumber, String accountNumber, String name, double balance, String description) {
		super(id, username, pinNumber, accountNumber, name, balance, description);
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public static String seriousAccountNo() {
		int totalArraySize = customerLoginData.size();
		int initialNo = (int) (Math.random() * Math.pow(10,4));
		String accountNo = initialNo + "serious"  + generateId(totalArraySize);
		return accountNo;
		
	}
	
}
