package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.MainAccount;
import data.SavingAccount;
import data.SeriousSavingAccount;
import dataController.DataController;
import ui.HomeUI;
import ui.SignInUI;

public class AccountActionListener implements ActionListener{
	
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
	
	public AccountActionListener(HomeUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ui.getBtnAccount()) {
			
			String custId = ui.getLblId().getText();
			int custIdNum = 0;
			if(custId.length()>=0) {
				try {
					custIdNum = Integer.parseInt(custId);
					}catch(NumberFormatException ex) {
						System.out.println("Must be a number.");
					}catch(NullPointerException e) {
						System.out.println("Unable to find.");
					}
			}
			
			mainCst = getMainCustomer(custIdNum);
			
			if (mainCst.getId() == custIdNum) {
				int index = customerMainData.indexOf(mainCst);
				MainAccount thisCust = customerMainData.get(index);
				
				double mainBalance = thisCust.getBalance();
				ui.getLblMainBalance().setText("$"+mainBalance+"");
			
			}
			if(mainCst.getId() == custIdNum) {
				savingCst = getSavingCustomer(custIdNum);
				int index = customerSavingData.indexOf(savingCst);
				SavingAccount thisCust = customerSavingData.get(index);
				
				double savingBalance = thisCust.getBalance();
				ui.getLblSavingBalance().setText("$"+savingBalance+"");
				
			}
			if(mainCst.getId() == custIdNum) {
				seriousCst = getSeriousCustomer(custIdNum);
				int index = customerSeriousSavingData.indexOf(seriousCst);
				SeriousSavingAccount thisCust = customerSeriousSavingData.get(index);
				
				double seriousBalance = thisCust.getBalance();
				ui.getLblSeriousBalance().setText("$"+seriousBalance+"");
				
			}
		}
	}
}
