package data;

public class SavingAccount extends Account{

	
	public SavingAccount(int id, String username, int pinNumber, String accountNumber, String name, double balance, String description) {
		super(id, username, pinNumber, accountNumber, name, balance, description);
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		
	}
	
	public static String savingAccountNo() {
		int totalArraySize = customerLoginData.size();
		int initialNo = (int) (Math.random() * Math.pow(10,3));
		String accountNo = initialNo + "saving"  + generateId(totalArraySize);
		return accountNo;
		
	}

}
