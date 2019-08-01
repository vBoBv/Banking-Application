package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import data.Customer;
import data.MainAccount;
import data.SavingAccount;
import data.SeriousSavingAccount;
import dataController.DataController;
import main.MyApplication;
import ui.HomeUI;
import ui.SignInUI;
import ui.SignUpUI;

public class SignUpOperationActionListener implements ActionListener {

	private SignUpUI ui;
	private DataController dataHandler;
	

	
	public SignUpOperationActionListener(SignUpUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ui.getBtnBack()) {
			//Close the SignUpUI
			this.ui.setVisible(false);
			//Call back to main 
			MyApplication main = new MyApplication();
			main.main(null);
		}
		else if(event.getSource() == ui.getBtnPinNo0())
		{
			String pinNo0 = ui.getBtnPinNo0().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();

			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo0);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo0);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo0);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo0);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnPinNo1()) {
			String pinNo1 = ui.getBtnPinNo1().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();
			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo1);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo1);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo1);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo1);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnPinNo2()) {
			String pinNo2 = ui.getBtnPinNo2().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();
			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo2);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo2);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo2);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo2);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnPinNo3()) {
			String pinNo3 = ui.getBtnPinNo3().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();
			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo3);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo3);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo3);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo3);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnPinNo4()) {
			String pinNo4 = ui.getBtnPinNo4().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();
			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo4);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo4);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo4);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo4);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnPinNo5()) {
			String pinNo5 = ui.getBtnPinNo5().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();
			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo5);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo5);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo5);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo5);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnPinNo6()) {
			String pinNo6 = ui.getBtnPinNo6().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();
			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo6);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo6);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo6);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo6);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnPinNo7()) {
			String pinNo7 = ui.getBtnPinNo7().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();
			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo7);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo7);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo7);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo7);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnPinNo8()) {
			String pinNo8 = ui.getBtnPinNo8().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();
			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo8);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo8);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo8);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo8);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnPinNo9()) {
			String pinNo9 = ui.getBtnPinNo9().getText();
			String txtPin1 = ui.getTxtFieldPinNo1().getText();
			String txtPin2 = ui.getTxtFieldPinNo2().getText();
			String txtPin3 = ui.getTxtFieldPinNo3().getText();
			String txtPin4 = ui.getTxtFieldPinNo4().getText();
			String username = ui.getTxtFieldUsername().getText();
			if (txtPin1.equals("")) {
				ui.getTxtFieldPinNo1().setText(pinNo9);
			}
			else if (txtPin2.equals("")) {
				ui.getTxtFieldPinNo2().setText(pinNo9);
			}
			else if (txtPin3.equals("")) {
				ui.getTxtFieldPinNo3().setText(pinNo9);
			}
			else if (txtPin4.equals("")) {
				ui.getTxtFieldPinNo4().setText(pinNo9);
				if (username.length() >= 3) {
					ui.getLblShowError().setText("**Strong username & password**");
				}
			}
		}
		else if (event.getSource() == ui.getBtnReset()) {
			ui.getTxtFieldUsername().setText(null);
			ui.getTxtFieldPinNo1().setText(null);
			ui.getTxtFieldPinNo2().setText(null);
			ui.getTxtFieldPinNo3().setText(null);
			ui.getTxtFieldPinNo4().setText(null);
		}
		else if (event.getSource() == ui.getBtnSignUp()) {
			//Data validation
			int confirmation = JOptionPane.showConfirmDialog(ui, "Do you want to submit?" , "Form submission",JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE); 
			
			if(confirmation == JOptionPane.YES_OPTION )
			{	
				
				//if yes, we get data from inputs and validate it
				String username = ui.getTxtFieldUsername().getText();
				String pinNumber = ui.getTxtFieldPinNo1().getText() + ui.getTxtFieldPinNo2().getText() + ui.getTxtFieldPinNo3().getText() + ui.getTxtFieldPinNo4().getText();
				int pinNo = 0;
				
				Boolean all_data_valid = true;
			    String Error_Message = "";
				
				//Validate Username
				if( username.length() <= 2 )
				{
					Error_Message  += "+ Username must contain at least 3 characters.\n";
					all_data_valid = false;
				}
				//Validate Pin Number
				if(pinNumber.length() >= 3) {
					try {
					  pinNo = Integer.parseInt(pinNumber);
					}catch(NumberFormatException ex) {
						Error_Message += "+ Pin must contain at least 4 numbers.\n";
						all_data_valid = false;
					}						
				}
				else if (pinNumber == "" || pinNumber.length() <= 3) 
				{
					Error_Message += "+ Pin must contain at least 4 numbers.\n";
					all_data_valid = false;
				}
				
				//check whether there is any error or not	
				if(all_data_valid == true)	
				{	
					
					ArrayList<Customer> customerLoginData = DataController.readLoginFile("data/customerLoginData.csv");
					int totalArraySize = customerLoginData.size();
					int id = totalArraySize + 1;
					
					
					
					String loginData = id + "," + username + "," + pinNumber;
					String mainData = id + "," + username + "," + pinNumber + "," + MainAccount.mainAccountNo() + "," + "Main" + "," + 0 + "," + "null";
					String savingData = id + "," + username + "," + pinNumber + "," + SavingAccount.savingAccountNo() + "," + "Saving" + "," + 0 + "," + "null";
					String seriousData = id + "," + username + "," + pinNumber + "," + SeriousSavingAccount.seriousAccountNo() + "," + "Serious Saving" + "," + 0 + "," + "null";
					
					
					for (int i = 0; i<=3; i++) {
						if (i == 0) {
							this.dataHandler.writeCustomerLoginData(loginData);
						}
						if (i == 1) {
							this.dataHandler.writeCustomerMainData(mainData);
						}
						if (i == 2) {
							this.dataHandler.writeCustomerSavingData(savingData);
						}
						if (i==3) {
							this.dataHandler.writeCustomerSeriousData(seriousData);
						}
					}
					
					JOptionPane.showMessageDialog(ui, "Your details have been saved", "Info Message", JOptionPane.INFORMATION_MESSAGE);
					//reset form
					ui.getTxtFieldUsername().setText(null);
					ui.getTxtFieldPinNo1().setText(null);
					ui.getTxtFieldPinNo2().setText(null);
					ui.getTxtFieldPinNo3().setText(null);
					ui.getTxtFieldPinNo4().setText(null);
					
					
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
