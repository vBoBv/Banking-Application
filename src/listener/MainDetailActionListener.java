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

public class MainDetailActionListener implements ActionListener{
	private HomeUI ui;
	private DataController dataHandler;
	
	ArrayList<Transaction> customerTransactionData = DataController.readTransactionFile("data/mainTransaction.csv");
	ArrayList<Transaction> filterTransaction = new ArrayList<Transaction>();
	ArrayList<MainAccount> customerMainData = DataController.readCustomerMainFile("data/customerMainData.csv");
	MainAccount mainCst;
	DefaultTableModel model = new DefaultTableModel();
	

	
	public MainDetailActionListener(HomeUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}

	void refreshData() {
		 customerTransactionData = DataController.readTransactionFile("data/mainTransaction.csv");
		 customerMainData = DataController.readCustomerMainFile("data/customerMainData.csv");
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
		
		mainCst = getMainCustomer(userNum);
		String accountNum = mainCst.getAccountNumber();
		double amount = mainCst.getBalance();
		
		ui.getLblMainAccountNumber().setText("Account Number : " + accountNum);
		ui.getLblMainBalancePanel().setText("$"+amount);
		
		
		getCustomer(userNum,name);
		model = (DefaultTableModel) ui.getMainTable().getModel();
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
		if (event.getSource() == ui.getBtnMainDetails()) {
		
			model.setRowCount(0);
			addRowToJTable();
		}
	}
}
