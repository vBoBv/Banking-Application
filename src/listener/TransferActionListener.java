package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import data.MainAccount;
import data.SavingAccount;
import data.SeriousSavingAccount;
import data.Transaction;
import dataController.DataController;
import ui.HomeUI;

public class TransferActionListener implements ActionListener {
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
	
	public TransferActionListener(HomeUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ui.getBtnTransferPanel()) {
			//Data Validation
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{
				
				String spinnerFrom = ui.getSpinnerFrom().getValue().toString();
				String spinnerTo = ui.getSpinnerTo().getValue().toString();
				String transferAmount = ui.getTxtAmountTo().getText();
				double transfer = 0;
				String transferDescription = ui.getTxtDescription().getText();
				String custId = ui.getLblId().getText();
				int custIdNum = 0;
				String name = ui.getLblNameValue().getText();
				Boolean all_data_valid = true;
			    String Error_Message = "";
			    Transaction info = new Transaction();
			   
			    if(transferAmount.length()>0) {
					try {
					  transfer = Double.parseDouble(transferAmount);
					  if(transfer <= 0) {
						  Error_Message += "+ Amount must be a positive number.\n";
						  all_data_valid = false;
					  }
					}catch(NumberFormatException ex) {
						Error_Message += "+ Amount must be numbers.\n";
						all_data_valid = false;
					}			
				}else if(transferAmount == "" || transferAmount.length() <= 0) {
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
						}catch(NullPointerException event) {
							System.out.println("Unable to find.");
						}
				}
			    
			    if (spinnerFrom.equals("Main") && spinnerTo.equals("Main")) {
			    	Error_Message += "+ Cannot transfer from Main account to Main account.\n";
					all_data_valid = false;
				}
			    else if (spinnerFrom.equals("Saving") && spinnerTo.equals("Saving")) {
			    	Error_Message += "+ Cannot transfer from Saving account to Saving account.\n";
					all_data_valid = false;
				}
			    else if (spinnerFrom.equals("Serious Saving") && spinnerTo.equals("Serious Saving")) {
			    	Error_Message += "+ Cannot transfer from Serious Saving account to Serious Saving account.\n";
					all_data_valid = false;
				}
			    
				
			    if (all_data_valid == true)	{
			    	
			    	mainCst = getMainCustomer(custIdNum);
			    	int mainIndex = customerMainData.indexOf(mainCst);
			    	
			    	savingCst = getSavingCustomer(custIdNum);
					
			    	
			    	//seriousCst = getSeriousCustomer(custIdNum);
			    	
			    	//int seriousIndex = customerSeriousSavingData.indexOf(seriousCst);
			    	
			    	
			    	if (mainCst.getId() == custIdNum && spinnerFrom.equals("Main") && spinnerTo.equals("Saving")) {
			    		
			    			savingCst = getSavingCustomer(custIdNum);
	
					    	int savingIndex = customerSavingData.indexOf(savingCst);
			    		
				    		MainAccount thisMainCust = customerMainData.get(mainIndex);
			    			SavingAccount thisSavingCust = customerSavingData.get(savingIndex);
			    		
			    			double amountWithdrawFromMain = MainAccount.withdraw(mainCst.getBalance(), transfer);
			    			double amountTransferToSaving = SavingAccount.deposit(savingCst.getBalance(), transfer);
			    			
			    			if(mainCst.getBalance() >= transfer) {
								thisMainCust.setBalance(amountWithdrawFromMain);
			    				thisSavingCust.setBalance(amountTransferToSaving);
								if(transferDescription.length() <= 0) {
									thisMainCust.setDescription("null");
									thisSavingCust.setDescription("null");
								}
								else {
									thisMainCust.setDescription(transferDescription);
									thisSavingCust.setDescription(transferDescription);
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
								
								String transaction = info.saveTransaction(custIdNum, name, transferDescription, transfer);
								this.dataHandler.writeMainTransactionData(transaction);
								this.dataHandler.writeSavingTransactionData(transaction);
								
								JOptionPane.showMessageDialog(ui, "+ Transfer Successful." , "Info Message", JOptionPane.INFORMATION_MESSAGE);
							}	
			    	}
					else if (spinnerFrom.equals("Main") && spinnerTo.equals("Serious Saving")) {
						seriousCst = getSeriousCustomer(custIdNum);
						
				    	int seriousIndex = customerSeriousSavingData.indexOf(seriousCst);
		    		
			    		MainAccount thisMainCust = customerMainData.get(mainIndex);
		    			SeriousSavingAccount thisSeriousCust = customerSeriousSavingData.get(seriousIndex);
		    		
		    			double amountWithdrawFromMain = MainAccount.withdraw(mainCst.getBalance(), transfer);
		    			double amountTransferToSerious = SeriousSavingAccount.deposit(seriousCst.getBalance(), transfer);
		    			
		    			if(mainCst.getBalance() >= transfer) {
							thisMainCust.setBalance(amountWithdrawFromMain);
		    				thisSeriousCust.setBalance(amountTransferToSerious);
							if(transferDescription.length() <= 0) {
								thisMainCust.setDescription("null");
								thisSeriousCust.setDescription("null");
							}
							else {
								thisMainCust.setDescription(transferDescription);
								thisSeriousCust.setDescription(transferDescription);
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
							
							String transaction = info.saveTransaction(custIdNum, name, transferDescription, transfer);
							this.dataHandler.writeMainTransactionData(transaction);
							this.dataHandler.writeSeriousTransactionData(transaction);
							JOptionPane.showMessageDialog(ui, "+ Transfer Successful." , "Info Message", JOptionPane.INFORMATION_MESSAGE);
						}
		    			else {
							JOptionPane.showMessageDialog(ui, "Not enough money" , "Info Message", JOptionPane.ERROR_MESSAGE);

						}
					}
					else if (spinnerFrom.equals("Saving") && spinnerTo.equals("Main")) {
						
						savingCst = getSavingCustomer(custIdNum);
						
				    	int savingIndex = customerSavingData.indexOf(savingCst);
		    		
			    		MainAccount thisMainCust = customerMainData.get(mainIndex);
		    			SavingAccount thisSavingCust = customerSavingData.get(savingIndex);
		    		
		    			double amountWithdrawFromSaving = SavingAccount.withdraw(savingCst.getBalance(), transfer);
		    			double amountTransferToMain = MainAccount.deposit(mainCst.getBalance(), transfer);
		    			
		    			if(savingCst.getBalance() >= transfer) {
							thisSavingCust.setBalance(amountWithdrawFromSaving);
		    				thisMainCust.setBalance(amountTransferToMain);
		    				
							if(transferDescription.length() <= 0) {
								thisSavingCust.setDescription("null");
								thisMainCust.setDescription("null");
							}
							else {
								thisSavingCust.setDescription(transferDescription);
								thisMainCust.setDescription(transferDescription);
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
							
							String transaction = info.saveTransaction(custIdNum, name, transferDescription, transfer);
							this.dataHandler.writeSavingTransactionData(transaction);
							this.dataHandler.writeMainTransactionData(transaction);
							JOptionPane.showMessageDialog(ui, "+ Transfer Successful." , "Info Message", JOptionPane.INFORMATION_MESSAGE);
						}
		    			else {
							JOptionPane.showMessageDialog(ui, "Not enough money" , "Info Message", JOptionPane.ERROR_MESSAGE);

						}
					}
					else if (spinnerFrom.equals("Saving") && spinnerTo.equals("Serious Saving")) {
						
						
						int savingIndex = customerSavingData.indexOf(savingCst);
						seriousCst = getSeriousCustomer(custIdNum);
						
				    	
				    	int seriousIndex = customerSeriousSavingData.indexOf(seriousCst);
				    	
		    			double amountWithdrawFromSaving = SavingAccount.withdraw(savingCst.getBalance(), transfer);
		    			double amountTransferToSerious = SeriousSavingAccount.deposit(seriousCst.getBalance(), transfer);
		    		
		    			if(savingCst.getBalance() >= transfer) {
		    				SavingAccount thisSavingCust = customerSavingData.get(savingIndex);
			    			SeriousSavingAccount thisSeriousCust = customerSeriousSavingData.get(seriousIndex);
							thisSavingCust.setBalance(amountWithdrawFromSaving);
		    				thisSeriousCust.setBalance(amountTransferToSerious);
		    				
							if(transferDescription.length() <= 0) {
								thisSavingCust.setDescription("null");
								thisSeriousCust.setDescription("null");
							}
							else {
								thisSavingCust.setDescription(transferDescription);
								thisSeriousCust.setDescription(transferDescription);
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
							String transaction = info.saveTransaction(custIdNum, name, transferDescription, transfer);
							this.dataHandler.writeSavingTransactionData(transaction);
							this.dataHandler.writeSeriousTransactionData(transaction);
							JOptionPane.showMessageDialog(ui, "+ Transfer Successful." , "Info Message", JOptionPane.INFORMATION_MESSAGE);
		    			}
		    			else {
							JOptionPane.showMessageDialog(ui, "Not enough money" , "Info Message", JOptionPane.ERROR_MESSAGE);
						}
					}
					else if (spinnerFrom.equals("Serious Saving") && spinnerTo.equals("Main")) {
						seriousCst = getSeriousCustomer(custIdNum);
						
				    	int seriousIndex = customerSeriousSavingData.indexOf(seriousCst);
		    		
			    		MainAccount thisMainCust = customerMainData.get(mainIndex);
		    			SeriousSavingAccount thisSeriousCust = customerSeriousSavingData.get(seriousIndex);
		    		
		    			double amountWithdrawFromSerious = SeriousSavingAccount.withdraw(seriousCst.getBalance(), transfer);
		    			double amountTransferToMain = MainAccount.deposit(mainCst.getBalance(), transfer);
		    			
		    			if(seriousCst.getBalance() >= transfer) {
							thisSeriousCust.setBalance(amountWithdrawFromSerious);
		    				thisMainCust.setBalance(amountTransferToMain);
							if(transferDescription.length() <= 0) {
								thisSeriousCust.setDescription("null");
								thisMainCust.setDescription("null");
							}
							else {
								thisSeriousCust.setDescription(transferDescription);
								thisMainCust.setDescription(transferDescription);
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
							String transaction = info.saveTransaction(custIdNum, name, transferDescription, transfer);
							this.dataHandler.writeSeriousTransactionData(transaction);
							this.dataHandler.writeMainTransactionData(transaction);
							JOptionPane.showMessageDialog(ui, "+ Transfer Successful." , "Info Message", JOptionPane.INFORMATION_MESSAGE);
						}
		    			else {
							JOptionPane.showMessageDialog(ui, "Not enough money" , "Info Message", JOptionPane.ERROR_MESSAGE);

						}
						
					}
					else if (spinnerFrom.equals("Serious Saving") && spinnerTo.equals("Saving")) {
						
						int savingIndex = customerSavingData.indexOf(savingCst);
						seriousCst = getSeriousCustomer(custIdNum);
						
				    	
				    	int seriousIndex = customerSeriousSavingData.indexOf(seriousCst);
				    	
		    			double amountWithdrawFromSerious = SeriousSavingAccount.withdraw(seriousCst.getBalance(), transfer);
		    			double amountTransferToSaving = SavingAccount.deposit(savingCst.getBalance(), transfer);
		    		
		    			if(seriousCst.getBalance() >= transfer) {
		    				SavingAccount thisSavingCust = customerSavingData.get(savingIndex);
			    			SeriousSavingAccount thisSeriousCust = customerSeriousSavingData.get(seriousIndex);
							thisSeriousCust.setBalance(amountWithdrawFromSerious);
		    				thisSavingCust.setBalance(amountTransferToSaving);
		    				
							if(transferDescription.length() <= 0) {
								thisSeriousCust.setDescription("null");
								thisSavingCust.setDescription("null");
							}
							else {
								thisSeriousCust.setDescription(transferDescription);
								thisSavingCust.setDescription(transferDescription);
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
							String transaction = info.saveTransaction(custIdNum, name, transferDescription, transfer);
							this.dataHandler.writeSeriousTransactionData(transaction);
							this.dataHandler.writeSavingTransactionData(transaction);
							JOptionPane.showMessageDialog(ui, "+ Transfer Successful." , "Info Message", JOptionPane.INFORMATION_MESSAGE);
		    			}
		    			else {
							JOptionPane.showMessageDialog(ui, "Not enough money" , "Info Message", JOptionPane.ERROR_MESSAGE);
						}
						
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


