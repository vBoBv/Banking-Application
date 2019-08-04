package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dataController.DataController;
import main.MyApplication;
import ui.HomeUI;
import ui.SignInUI;

public class LogOutActionListener implements ActionListener {
	private HomeUI ui;
	private DataController dataHandler;
	
	public LogOutActionListener(HomeUI ui, DataController dataHandler) {
		this.ui = ui;
		this.dataHandler = dataHandler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ui.getBtnLogOut()) {
			this.ui.setVisible(false);
			//Call back to main 
			MyApplication main = new MyApplication();
			main.main(null);
		}
		
	}
	
	
	
}
