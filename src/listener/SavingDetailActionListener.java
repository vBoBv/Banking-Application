package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import data.MainAccount;
import data.SavingAccount;
import data.SeriousSavingAccount;
import data.Transaction;
import dataController.DataController;
import ui.HomeUI;

public class SavingDetailActionListener implements ActionListener{
	private HomeUI ui;
	private DataController dataHandler;
	
	ArrayList<Transaction> customerTransactionData = DataController.readTransactionFile("data/savingTransaction.csv");
	ArrayList<Transaction> filterTransaction = new ArrayList<Transaction>();
	DefaultTableModel model = new DefaultTableModel();
	ArrayList<SavingAccount> customerSavingData = DataController.readCustomerSavingFile("data/customerSavingData.csv");
	SavingAccount savingCst;

	
	public SavingDetailActionListener(HomeUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}

	void refreshData() {
		 customerTransactionData = DataController.readTransactionFile("data/savingTransaction.csv");
		 customerSavingData = DataController.readCustomerSavingFile("data/customerSavingData.csv");
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
	
	ArrayList<Transaction> getCustomer(int id, String name ) {
		//Empty the arraylist and re-add elements into it
		filterTransaction.clear();
		refreshData();
		for (Transaction c: customerTransactionData) {
			if(c.getId() == id && c.getUsername().equalsIgnoreCase(name)) {
				filterTransaction.add(c);
			}
			
		}
		return filterTransaction;
	}
	
	public void addRowToJTable()
    {	
		
		String userNo = ui.getLblIdValue().getText();
		int userNum = 0;
		String name = ui.getLblNameValue().getText();
		
		if(userNo.length() >= 0) {
			try {
				userNum = Integer.parseInt(userNo);
			}catch(NumberFormatException ex) {
				System.out.println("User id must be a number.");
			}						
		}
		savingCst = getSavingCustomer(userNum);
		String accountNum = savingCst.getAccountNumber();
		double amount = savingCst.getBalance();
		
		ui.getLblSavingAccountNumber().setText("Account Number : " + accountNum);
		ui.getLblSavingAccountBalancePanel().setText("$"+amount);
		
		
		
		getCustomer(userNum,name);
		model = (DefaultTableModel) ui.getSavingTable().getModel();
        Object rowData[] = new Object[3];
       
        for(int i = 0; i < filterTransaction.size(); i++)
        {
            rowData[0] = filterTransaction.get(i).getDate();
            rowData[1] = filterTransaction.get(i).getDescription();
            rowData[2] = filterTransaction.get(i).getAmount();
            
            model.addRow(rowData);
        }     
    }
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ui.getBtnSavingDetails()) {
			model.setRowCount(0);
			addRowToJTable();
		}
	}
}
