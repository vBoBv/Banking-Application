package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.MainAccount;
import data.SavingAccount;
import data.SeriousSavingAccount;
import dataController.DataController;
import ui.HomeUI;

public class MainDetailActionListener implements ActionListener{
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
	
	public MainDetailActionListener(HomeUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
	}
}
