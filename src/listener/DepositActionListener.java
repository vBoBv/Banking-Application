package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.Account;
import data.MainAccount;
import data.SavingAccount;
import data.SeriousSavingAccount;
import dataController.DataController;
import ui.HomeUI;


public class DepositActionListener implements ActionListener{

	
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
	
	public DepositActionListener(HomeUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == ui.getBtnDepositTo()) {
			//Data validation
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{	
				
				String accountType = ui.getSpinnerDepositTo().getValue().toString();

				String depositAmount = ui.getTxtDepositAmount().getText();
				int deposit = 0;
				String depositDescription = ui.getTxtDepositDescription().getText();
				
				String custId = ui.getLblId().getText();
				int custIdNum = 0;
				
				Boolean all_data_valid = true;
			    String Error_Message = "";
			    
			    
				if(depositAmount.length()>0) {
					try {
					  deposit = Integer.parseInt(depositAmount);
					  if(deposit <= 0) {
						  Error_Message += "+ Amount must be a positive number.\n";
						  all_data_valid = false;
					  }
					}catch(NumberFormatException ex) {
						Error_Message += "+ Amount must be numbers.\n";
						all_data_valid = false;
					}			
				}else if(depositAmount == "" || depositAmount.length() <= 0) {
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
						
						double amount = MainAccount.deposit(mainCst.getBalance(), deposit);
						MainAccount thisCust = customerMainData.get(index);
						thisCust.setBalance(amount);
						if(depositDescription.length() <= 0) {
							thisCust.setDescription("null");
						}
						else {
							thisCust.setDescription(depositDescription);
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
						JOptionPane.showMessageDialog(ui, "+ Deposit Successful." , "Info Message", JOptionPane.ERROR_MESSAGE);
						
					}
					else if(mainCst.getId() == custIdNum && accountType.equalsIgnoreCase("Saving")) {
						savingCst = getSavingCustomer(custIdNum);
						
						int index = customerSavingData.indexOf(savingCst);
						
						double amount = MainAccount.deposit(savingCst.getBalance(), deposit);
						SavingAccount thisCust = customerSavingData.get(index);
						thisCust.setBalance(amount);
						if(depositDescription.length() <= 0) {
							thisCust.setDescription("null");
						}
						else {
							thisCust.setDescription(depositDescription);
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
						JOptionPane.showMessageDialog(ui, "+ Deposit Successful." , "Info Message", JOptionPane.ERROR_MESSAGE);
						
					}
					else if(mainCst.getId() == custIdNum && accountType.equalsIgnoreCase("Serious Saving")) {
						
						seriousCst = getSeriousCustomer(custIdNum);
						int index = customerSeriousSavingData.indexOf(seriousCst);
						
						double amount = SeriousSavingAccount.deposit(seriousCst.getBalance(), deposit);
						SeriousSavingAccount thisCust = customerSeriousSavingData.get(index);
						thisCust.setBalance(amount);
						if(depositDescription.length() <= 0) {
							thisCust.setDescription("null");
						}
						else {
							thisCust.setDescription(depositDescription);
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
						JOptionPane.showMessageDialog(ui, "+ Deposit Successful." , "Info Message", JOptionPane.ERROR_MESSAGE);
						
						
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
