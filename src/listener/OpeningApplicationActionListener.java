package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import data.Account;
import data.Customer;

import dataController.DataController;
import ui.HomeUI;
import ui.SignInUI;
import ui.SignUpUI;

public class OpeningApplicationActionListener implements ActionListener {
	
	private SignInUI ui;
	private DataController dataHandler;
	
	

	public OpeningApplicationActionListener(SignInUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ui.getBtnSignUp()) {
			//Open the SignUpUI
			SignUpUI uiSignUp = new SignUpUI();
			uiSignUp.setVisible(true);
			this.ui.setVisible(false);
		
			
			//Add listener to source in SignUpUI
			
			DataController dc = new DataController();
			SignUpOperationActionListener listenerForSignUpUI = new SignUpOperationActionListener(uiSignUp,dc);
			
			JButton btnBack = uiSignUp.getBtnBack();
			btnBack.addActionListener(listenerForSignUpUI);
			
			JButton btnRegister = uiSignUp.getBtnSignUp();
			btnRegister.addActionListener(listenerForSignUpUI);
			
			//Add each btn of Pin here
			JButton btnPin1 = uiSignUp.getBtnPinNo0();
			btnPin1.addActionListener(listenerForSignUpUI);
			
			JButton btnPin2 = uiSignUp.getBtnPinNo1();
			btnPin2.addActionListener(listenerForSignUpUI);
			
			JButton btnPin3 = uiSignUp.getBtnPinNo2();
			btnPin3.addActionListener(listenerForSignUpUI);
			
			JButton btnPin4 = uiSignUp.getBtnPinNo3();
			btnPin4.addActionListener(listenerForSignUpUI);
			
			JButton btnPin5 = uiSignUp.getBtnPinNo4();
			btnPin5.addActionListener(listenerForSignUpUI);
			
			JButton btnPin6 = uiSignUp.getBtnPinNo5();
			btnPin6.addActionListener(listenerForSignUpUI);
			
			JButton btnPin7 = uiSignUp.getBtnPinNo6();
			btnPin7.addActionListener(listenerForSignUpUI);
			
			JButton btnPin8 = uiSignUp.getBtnPinNo7();
			btnPin8.addActionListener(listenerForSignUpUI);
			
			JButton btnPin9 = uiSignUp.getBtnPinNo8();
			btnPin9.addActionListener(listenerForSignUpUI);
			
			JButton btnPin10 = uiSignUp.getBtnPinNo9();
			btnPin10.addActionListener(listenerForSignUpUI);
			
			JButton btnReset = uiSignUp.getBtnReset();
			btnReset.addActionListener(listenerForSignUpUI);
		
		}
		else if(event.getSource() == ui.getBtnPin10())
		{
			String pinNo10 = ui.getBtnPin10().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo10);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo10);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo10);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo10);
			}
		}
		else if(event.getSource() == ui.getBtnPin1())
		{
			String pinNo1 = ui.getBtnPin1().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo1);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo1);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo1);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo1);
			}
		}
		else if(event.getSource() == ui.getBtnPin2())
		{
			String pinNo2 = ui.getBtnPin2().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo2);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo2);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo2);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo2);
			}
		}
		else if(event.getSource() == ui.getBtnPin3())
		{
			String pinNo3 = ui.getBtnPin3().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo3);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo3);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo3);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo3);
			}
		}
		else if(event.getSource() == ui.getBtnPin4())
		{
			String pinNo4 = ui.getBtnPin4().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo4);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo4);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo4);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo4);
			}
		}
		else if(event.getSource() == ui.getBtnPin5())
		{
			String pinNo5 = ui.getBtnPin5().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo5);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo5);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo5);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo5);
			}
		}
		else if(event.getSource() == ui.getBtnPin6())
		{
			String pinNo6 = ui.getBtnPin6().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo6);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo6);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo6);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo6);
			}
		}
		else if(event.getSource() == ui.getBtnPin7())
		{
			String pinNo7 = ui.getBtnPin7().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo7);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo7);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo7);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo7);
			}
		}
		else if(event.getSource() == ui.getBtnPin8())
		{
			String pinNo8 = ui.getBtnPin8().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo8);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo8);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo8);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo8);
			}
		}
		else if(event.getSource() == ui.getBtnPin9())
		{
			String pinNo9 = ui.getBtnPin9().getText();
			String txtPin1 = ui.getTxtPin1SignIn().getText();
			String txtPin2 = ui.getTxtPin2SignIn().getText();
			String txtPin3 = ui.getTxtPin3SignIn().getText();
			String txtPin4 = ui.getTxtPin4SignIn().getText();

			if (txtPin1.equals("")) {
				ui.getTxtPin1SignIn().setText(pinNo9);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtPin2SignIn().setText(pinNo9);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtPin3SignIn().setText(pinNo9);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtPin4SignIn().setText(pinNo9);
			}
		}
		else if (event.getSource() == ui.getBtnReset()) {
			ui.getTxtUsernameSignIn().setText(null);
			ui.getTxtPin1SignIn().setText(null);
			ui.getTxtPin2SignIn().setText(null);
			ui.getTxtPin3SignIn().setText(null);
			ui.getTxtPin4SignIn().setText(null);
		}
		else if (event.getSource() == ui.getBtnSignIn()){
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			if(confirmation == JOptionPane.YES_OPTION ) {
				
				String username = ui.getTxtUsernameSignIn().getText();
				String pinNumber = ui.getTxtPin1SignIn().getText() + ui.getTxtPin2SignIn().getText() + ui.getTxtPin3SignIn().getText() + ui.getTxtPin4SignIn().getText();
				int pinNo = 0;
				Boolean all_data_valid = true;
				String Error_Message = "";
				
				//Data validation
				if (username.length() <= 0) {
					Error_Message  += "+ Username must be filled.\n";
			    	all_data_valid = false;
				}
				
				if(pinNumber.length() >= 3) {
					try {
					  pinNo = Integer.parseInt(pinNumber);
					}catch(NumberFormatException ex) {
						Error_Message += "+ Pin numbers must be numbers.\n";
						all_data_valid = false;
					}						
				}
				else if (pinNumber == "" || pinNumber.length() <= 3) 
				{
					Error_Message += "+ Pin numbers must be filled.\n";
					all_data_valid = false;
				}
				else
				{
					Error_Message += "+ Pin numbers must be filled.\n";
					all_data_valid = false;
				}
				
				if (all_data_valid == true)	{

					ArrayList<Customer> customerLoginData = DataController.readLoginFile("data/customerLoginData.csv");
					Customer cst;
					try {
						cst = Account.getCustomer(username, pinNo);
						if (cst.getUsername().equals(username) && cst.getPinNumber() == pinNo) {
							int customerId = cst.getId();
							
							HomeUI uiHome = new HomeUI();
							uiHome.setVisible(true);
							this.ui.setVisible(false);
							uiHome.getLblId().setText(customerId+"");
							uiHome.getLblIdValue().setText(customerId+ "");
							uiHome.getLblNameValue().setText(username+"");
							
							DataController dc = new DataController();
							
							//
							DepositActionListener listenerForDeposit = new DepositActionListener(uiHome,dc);
							
							JButton btnDeposit = uiHome.getBtnDepositTo();
							btnDeposit.addActionListener(listenerForDeposit);
							
							//
							WithdrawActionListener listenerForWithdraw = new WithdrawActionListener(uiHome,dc);
							
							JButton btnWithdraw = uiHome.getBtnWithdrawFrom();
							btnWithdraw.addActionListener(listenerForWithdraw);
							
							//
							
							AccountActionListener listenerForAccount = new AccountActionListener(uiHome, dc);
							JButton btnAccount = uiHome.getBtnAccount();
							btnAccount.addActionListener(listenerForAccount);
							
							//
							LogOutActionListener listenerForLogOut = new LogOutActionListener(uiHome, dc);
							JButton btnLogOut = uiHome.getBtnLogOut();
							btnLogOut.addActionListener(listenerForLogOut);
							
							//
							TransferActionListener listenerForTransfer = new TransferActionListener(uiHome, dc);
							JButton btnTransfer = uiHome.getBtnTransferPanel();
							btnTransfer.addActionListener(listenerForTransfer);
							
							//
							MainDetailActionListener listenerForViewMain = new MainDetailActionListener(uiHome, dc);
							JButton btnViewMain = uiHome.getBtnMainDetails();
							btnViewMain.addActionListener(listenerForViewMain);
							
							//
							SavingDetailActionListener listenerForViewSaving = new SavingDetailActionListener(uiHome, dc);
							JButton btnViewSaving = uiHome.getBtnSavingDetails();
							btnViewSaving.addActionListener(listenerForViewSaving);
							
							//
							SeriousDetailActionListener listenerForViewSerious = new SeriousDetailActionListener(uiHome, dc);
							JButton btnViewSerious = uiHome.getBtnSeriousDetails();
							btnViewSerious.addActionListener(listenerForViewSerious);
							
						}
					}catch(NullPointerException e) {
						JOptionPane.showMessageDialog(ui, "+ Incorrect username or pin numbers." , "Info Message", JOptionPane.ERROR_MESSAGE);
					}	
				}
				else
				{
					JOptionPane.showMessageDialog(ui, Error_Message , "Info Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}

}
