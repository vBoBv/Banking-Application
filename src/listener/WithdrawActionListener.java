package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import data.Account;
import data.MainAccount;
import data.SavingAccount;
import data.SeriousSavingAccount;
import data.Transaction;
import dataController.DataController;
import ui.HomeUI;


public class WithdrawActionListener implements ActionListener{

	
	private HomeUI ui;
	private DataController dataHandler;
	ArrayList<MainAccount> customerMainData = DataController.readCustomerMainFile("data/customerMainData.csv");
	ArrayList<SavingAccount> customerSavingData = DataController.readCustomerSavingFile("data/customerSavingData.csv");
	ArrayList<SeriousSavingAccount> customerSeriousSavingData = DataController.readCustomerSeriousSavingFile("data/customerSeriousSavingData.csv");
	MainAccount mainCst;
	SavingAccount savingCst;
	SeriousSavingAccount seriousCst;
	
	void refreshData() {
		 customerMainData = DataController.readCustomerMainFile("data/customerMainData.csv");
		 customerSavingData = DataController.readCustomerSavingFile("data/customerSavingData.csv");
		 customerSeriousSavingData = DataController.readCustomerSeriousSavingFile("data/customerSeriousSavingData.csv");
	}
	
	MainAccount getMainCustomer(int id) {
			
			refreshData();
			MainAccount cst=null;
			for (MainAccount c: customerMainData) {
				if(c.getId() == id) {
					cst=c;
					break;
				}
			}
			return cst;
	}
	
	SavingAccount getSavingCustomer(int id) {
		
		refreshData();
		SavingAccount cst=null;
		for (SavingAccount c: customerSavingData) {
			if(c.getId() == id) {
				cst=c;
				break;
			}
		}
		return cst;
	}
	
	SeriousSavingAccount getSeriousCustomer(int id) {
		
		refreshData();
		SeriousSavingAccount cst=null;
		for (SeriousSavingAccount c: customerSeriousSavingData) {
			if(c.getId() == id) {
				cst=c;
				break;
			}
		}
		return cst;
	}
	
	public WithdrawActionListener(HomeUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == ui.getBtnWithdrawFrom()) {
			
			//Data validation
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{	
				String userNo = ui.getLblIdValue().getText();
				int userNum = 0;
				String name = ui.getLblNameValue().getText();
				
				String accountType = ui.getSpinnerWithdrawFrom().getValue().toString();
//				System.out.println(accountType);
				String withdrawAmount = ui.getTxtWithdrawAmount().getText();
				double withdraw = 0;
				String withdrawDescription = ui.getTxtWithdrawDescription().getText();
				
				String custId = ui.getLblId().getText();
				int custIdNum = 0;
				
				Boolean all_data_valid = true;
			    String Error_Message = "";
			    Transaction info = new Transaction();
			    
			    if(userNo.length() >= 0) {
					try {
					  userNum = Integer.parseInt(userNo);
					}catch(NumberFormatException ex) {
						Error_Message += "+ User id must be a number.\n";
						all_data_valid = false;
					}						
				}
				else if (userNo == "") 
				{
					Error_Message += "+ User id is empty.\n";
					all_data_valid = false;
				}
			    
				if(withdrawAmount.length()>0) {
					try {
					  withdraw = Double.parseDouble(withdrawAmount);
					  if(withdraw <= 0) {
						  Error_Message += "+ Amount must be a positive number.\n";
						  all_data_valid = false;
					  }
					}catch(NumberFormatException ex) {
						Error_Message += "+ Amount must be numbers.\n";
						all_data_valid = false;
					}			
				}else if(withdrawAmount == "" || withdrawAmount.length() <= 0) {
					Error_Message += "+ Amount must be filled.\n";
					all_data_valid = false;
				}else {
					Error_Message += "+ Amount must be filled.\n";
					all_data_valid = false;
				}
				
				
				
				if(custId.length()>=0) {
					try {
						custIdNum = Integer.parseInt(custId);
						}catch(NumberFormatException ex) {
							System.out.println("Must be a number.");
						}catch(NullPointerException e) {
							System.out.println("Unable to find.");
						}
				}
				
				
				if (all_data_valid == true)	{
					//Select that specific customer id and set and change value on that
					mainCst = getMainCustomer(custIdNum);
					
					
					if (mainCst.getId() == custIdNum && accountType.equalsIgnoreCase("Main")) {
												
						int index = customerMainData.indexOf(mainCst);
						
						double amount = MainAccount.withdraw(mainCst.getBalance(), withdraw);
						MainAccount thisCust = customerMainData.get(index);
						
						
						
						if(mainCst.getBalance() >= withdraw) {
							thisCust.setBalance(amount);
							if(withdrawDescription.length() <= 0) {
								thisCust.setDescription("null");
							}
							else {
								thisCust.setDescription(withdrawDescription);
							}
						
						}
						ArrayList<String> newMainData = new ArrayList<String>();
						String newMainDataList;
						
						for (MainAccount eachAccount : customerMainData) {
							int userId = eachAccount.getId();
							String username = eachAccount.getUsername();
							int pinNumber = eachAccount.getPinNumber();
							String accountNo = eachAccount.getAccountNumber();
							String accountName = eachAccount.getName();
							double accountBalance = eachAccount.getBalance();
							String description = eachAccount.getDescription();
							
							newMainDataList = userId + "," + username + "," + pinNumber + "," + accountNo + "," + accountName + "," + accountBalance + "," + description;
							newMainData.add(newMainDataList);
						}
						
						this.dataHandler.overwriteMainData();
						for (String account : newMainData) {
							this.dataHandler.writeCustomerMainData(account);
						}
						//Write transaction info into file
						
						String transaction = info.saveTransaction(userNum, name, withdrawDescription, withdraw);
						this.dataHandler.writeMainTransactionData(transaction);
						
						JOptionPane.showMessageDialog(ui, "+ Withdraw Successful." , "Info Message", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else if(mainCst.getId() == custIdNum && accountType.equalsIgnoreCase("Saving")) {
						savingCst = getSavingCustomer(custIdNum);
						
						int index = customerSavingData.indexOf(savingCst);
						
						double amount = MainAccount.withdraw(savingCst.getBalance(), withdraw);
						SavingAccount thisCust = customerSavingData.get(index);
						
						
						if(savingCst.getBalance() >= withdraw) {
							thisCust.setBalance(amount);
							if(withdrawDescription.length() <= 0) {
								thisCust.setDescription("null");
							}
							else {
								thisCust.setDescription(withdrawDescription);
							}
							
							ArrayList<String> newSavingData = new ArrayList<String>();
							String newSavingDataList;
							
							for (SavingAccount eachAccount : customerSavingData) {
								int userId = eachAccount.getId();
								String username = eachAccount.getUsername();
								int pinNumber = eachAccount.getPinNumber();
								String accountNo = eachAccount.getAccountNumber();
								String accountName = eachAccount.getName();
								double accountBalance = eachAccount.getBalance();
								String description = eachAccount.getDescription();
								
								newSavingDataList = userId + "," + username + "," + pinNumber + "," + accountNo + "," + accountName + "," + accountBalance + "," + description;
								newSavingData.add(newSavingDataList);
							}
							
							this.dataHandler.overwriteSavingData();
							for (String account : newSavingData) {
								this.dataHandler.writeCustomerSavingData(account);
							}
							
							//Write transaction info into file
							
							String transaction = info.saveTransaction(userNum, name, withdrawDescription, withdraw);
							this.dataHandler.writeSavingTransactionData(transaction);
							
							JOptionPane.showMessageDialog(ui, "+ Withdraw Successful." , "Info Message", JOptionPane.INFORMATION_MESSAGE);
							
							
							
						}
						else {
							JOptionPane.showMessageDialog(ui, "Not enough money" , "Info Message", JOptionPane.ERROR_MESSAGE);

						}
						
					}
					else if(mainCst.getId() == custIdNum && accountType.equalsIgnoreCase("Serious Saving")) {
						
						seriousCst = getSeriousCustomer(custIdNum);
						int index = customerSeriousSavingData.indexOf(seriousCst);
						
						
						double amount = SeriousSavingAccount.withdraw(seriousCst.getBalance(), withdraw);
						SeriousSavingAccount thisCust = customerSeriousSavingData.get(index);
						
						if(seriousCst.getBalance() >= withdraw) {
							thisCust.setBalance(amount);
							if(withdrawDescription.length() <= 0) {
								thisCust.setDescription("null");
							}
							else {
								thisCust.setDescription(withdrawDescription);
							}
							
							ArrayList<String> newSeriousData = new ArrayList<String>();
							String newSeriousDataList;
							
							for (SeriousSavingAccount eachAccount : customerSeriousSavingData) {
								int userId = eachAccount.getId();
								String username = eachAccount.getUsername();
								int pinNumber = eachAccount.getPinNumber();
								String accountNo = eachAccount.getAccountNumber();
								String accountName = eachAccount.getName();
								double accountBalance = eachAccount.getBalance();
								String description = eachAccount.getDescription();
								
								newSeriousDataList = userId + "," + username + "," + pinNumber + "," + accountNo + "," + accountName + "," + accountBalance + "," + description;
								newSeriousData.add(newSeriousDataList);
							}
							
							this.dataHandler.overwriteSeriousData();
							for (String account : newSeriousData) {
								this.dataHandler.writeCustomerSeriousData(account);
							}
							//Write transaction info into file
							
							String transaction = info.saveTransaction(userNum, name, withdrawDescription, withdraw);
							this.dataHandler.writeSeriousTransactionData(transaction);
							
							JOptionPane.showMessageDialog(ui, "+ Withdraw Successful." , "Info Message", JOptionPane.INFORMATION_MESSAGE);
							
						}
						else {
							JOptionPane.showMessageDialog(ui, "Not enough money" , "Info Message", JOptionPane.ERROR_MESSAGE);

						}
					}
					else {
						JOptionPane.showMessageDialog(ui, "+ Account must be main, saving or serious saving." , "Info Message", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				else
				{
					//if there are errors, show the message
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}

}
