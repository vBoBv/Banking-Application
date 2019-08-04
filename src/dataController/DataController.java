package dataController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import data.Account;
import data.Customer;
import data.MainAccount;
import data.SavingAccount;
import data.SeriousSavingAccount;
import data.Transaction;


public class DataController {
	private final String customerMainData = "data/customerMainData.csv";
	private final String customerSavingData = "data/customerSavingData.csv";
	private final String customerSeriousData = "data/customerSeriousSavingData.csv";
	private final String customerLoginData = "data/customerLoginData.csv";
	private final String mainTransaction = "data/mainTransaction.csv";
	private final String savingTransaction = "data/savingTransaction.csv";
	private final String seriousTransaction = "data/seriousTransaction.csv";
	
	
	//Write saving transaction into file
	public void writeSeriousTransactionData(String mainData) {
		PrintWriter WriterForCustomer = null;
		try {
			File file = new File(seriousTransaction);
			if(file.exists() != true) {
				file.getParentFile().mkdir();
			}
			WriterForCustomer = new PrintWriter(new FileWriter(seriousTransaction, true));
			WriterForCustomer.println(mainData);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			WriterForCustomer.close();
		}
	}
		
	
	//Write saving transaction into file
	public void writeSavingTransactionData(String mainData) {
		PrintWriter WriterForCustomer = null;
		try {
			File file = new File(savingTransaction);
			if(file.exists() != true) {
				file.getParentFile().mkdir();
			}
			WriterForCustomer = new PrintWriter(new FileWriter(savingTransaction, true));
			WriterForCustomer.println(mainData);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			WriterForCustomer.close();
		}
	}
	
	//Write main transaction into file
	public void writeMainTransactionData(String mainData) {
		PrintWriter WriterForCustomer = null;
		try {
			File file = new File(mainTransaction);
			if(file.exists() != true) {
				file.getParentFile().mkdir();
			}
			WriterForCustomer = new PrintWriter(new FileWriter(mainTransaction, true));
			WriterForCustomer.println(mainData);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			WriterForCustomer.close();
		}
	}
	
	//Write main customer into file
	public void writeCustomerMainData(String mainData) {
		PrintWriter WriterForCustomer = null;
		try {
			File file = new File(customerMainData);
			if(file.exists() != true) {
				file.getParentFile().mkdir();
			}
			WriterForCustomer = new PrintWriter(new FileWriter(customerMainData, true));
			WriterForCustomer.println(mainData);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			WriterForCustomer.close();
		}
	}
	//Write saving customer into file
	public void writeCustomerSavingData(String formData) {
		PrintWriter WriterForCustomer = null;
		try {
			File file = new File(customerSavingData);
			if(file.exists() != true) {
				file.getParentFile().mkdir();
			}
			WriterForCustomer = new PrintWriter(new FileWriter(customerSavingData, true));
			WriterForCustomer.println(formData);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			WriterForCustomer.close();
		}
	}
	//Write serious saving customer into file
	public void writeCustomerSeriousData(String formData) {
		PrintWriter WriterForCustomer = null;
		try {
			File file = new File(customerSeriousData);
			if(file.exists() != true) {
				file.getParentFile().mkdir();
			}
			WriterForCustomer = new PrintWriter(new FileWriter(customerSeriousData, true));
			WriterForCustomer.println(formData);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			WriterForCustomer.close();
		}
	}
	//Write username and password into file
	public void writeCustomerLoginData(String formData) {
		PrintWriter WriterForCustomer = null;
		try {
			File file = new File(customerLoginData);
			if(file.exists() != true) {
				file.getParentFile().mkdir();
			}
			WriterForCustomer = new PrintWriter(new FileWriter(customerLoginData, true));
			WriterForCustomer.println(formData);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			WriterForCustomer.close();
		}
	}
	//Overwrite main data
	public void overwriteMainData(){
		PrintWriter Overwriter = null;
		try {
			File file1 = new File("data/customerMainData.csv");
			if(file1.exists() != true)
			{
				//create folder
				file1.getParentFile().mkdir();
			}
			
			Overwriter = new PrintWriter(new FileWriter("data/customerMainData.csv", false));
			//Overwriter1.println(formData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Overwriter.close();
		}
	}
	//Overwrite saving data
	public void overwriteSavingData(){
		PrintWriter Overwriter = null;
		try {
			File file1 = new File("data/customerSavingData.csv");
			if(file1.exists() != true)
			{
				//create folder
				file1.getParentFile().mkdir();
			}
			
			Overwriter = new PrintWriter(new FileWriter("data/customerSavingData.csv", false));
			//Overwriter1.println(formData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Overwriter.close();
		}
	}
	//Overwrite serious saving data
	public void overwriteSeriousData(){
		PrintWriter Overwriter = null;
		try {
			File file1 = new File("data/customerSeriousSavingData.csv");
			if(file1.exists() != true)
			{
				//create folder
				file1.getParentFile().mkdir();
			}
			
			Overwriter = new PrintWriter(new FileWriter("data/customerSeriousSavingData.csv", false));
			//Overwriter1.println(formData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			Overwriter.close();
		}
	}
	
	//Read data from main account
	public static ArrayList<MainAccount> readCustomerMainFile(String userData) {
		ArrayList<MainAccount> accountArrayList = new ArrayList<MainAccount>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(userData));
			String line = reader.readLine();
			while (line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				int id = Integer.parseInt(tokenizer.nextToken());
				String username = tokenizer.nextToken();
				int pinNumber = Integer.parseInt(tokenizer.nextToken());
				String accountNo = tokenizer.nextToken();
				String accountName = tokenizer.nextToken();
				double accountBalance = Double.parseDouble(tokenizer.nextToken());
				String description = tokenizer.nextToken();
				
				accountArrayList.add(new MainAccount(id, username, pinNumber, accountNo, accountName, accountBalance, description));
				line = reader.readLine();
				
			}
			reader.close();
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read");
		}
		
		return accountArrayList;
	}
	//Read data from saving account
	public static ArrayList<SavingAccount> readCustomerSavingFile(String userData) {
		ArrayList<SavingAccount> accountArrayList = new ArrayList<SavingAccount>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(userData));
			String line = reader.readLine();
			while (line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				int id = Integer.parseInt(tokenizer.nextToken());
				String username = tokenizer.nextToken();
				int pinNumber = Integer.parseInt(tokenizer.nextToken());
				String accountNo = tokenizer.nextToken();
				String accountName = tokenizer.nextToken();
				double accountBalance = Double.parseDouble(tokenizer.nextToken());
				String description = tokenizer.nextToken();
				
				accountArrayList.add(new SavingAccount(id, username, pinNumber, accountNo, accountName, accountBalance, description));
				line = reader.readLine();
				
			}
			reader.close();
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read");
		}
		
		return accountArrayList;
	}
	//Read data from serious saving account
	public static ArrayList<SeriousSavingAccount> readCustomerSeriousSavingFile(String userData) {
		ArrayList<SeriousSavingAccount> accountArrayList = new ArrayList<SeriousSavingAccount>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(userData));
			String line = reader.readLine();
			while (line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				int id = Integer.parseInt(tokenizer.nextToken());
				String username = tokenizer.nextToken();
				int pinNumber = Integer.parseInt(tokenizer.nextToken());
				String accountNo = tokenizer.nextToken();
				String accountName = tokenizer.nextToken();
				double accountBalance = Double.parseDouble(tokenizer.nextToken());
				String description = tokenizer.nextToken();
				
				accountArrayList.add(new SeriousSavingAccount(id, username, pinNumber, accountNo, accountName, accountBalance, description));
				line = reader.readLine();
				
			}
			reader.close();
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read");
		}
		
		return accountArrayList;
	}
	//Read the login file
	public static ArrayList<Customer> readLoginFile(String userData) {
		ArrayList<Customer> loginArrayList = new ArrayList<Customer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(userData));
			String line = reader.readLine();
			while (line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				
				int id = Integer.parseInt(tokenizer.nextToken());
				String username = tokenizer.nextToken();
				int pinNumber = Integer.parseInt(tokenizer.nextToken());
				
				loginArrayList.add(new Customer(id, username, pinNumber));
				line = reader.readLine();
				
			}
			reader.close();
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to read");
		}
		
		return loginArrayList;
	}
	
	//Read the login file
		public static ArrayList<Transaction> readTransactionFile(String userData) {
			ArrayList<Transaction> transactionArrayList = new ArrayList<Transaction>();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(userData));
				String line = reader.readLine();
				while (line != null) {
					StringTokenizer tokenizer = new StringTokenizer(line, ",");
					
					int id = Integer.parseInt(tokenizer.nextToken());
					String username = tokenizer.nextToken();
					String date = tokenizer.nextToken();
					String description = tokenizer.nextToken();
					double amount = Double.parseDouble(tokenizer.nextToken());
					
					transactionArrayList.add(new Transaction(id, username, date, description, amount));
					line = reader.readLine();
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Unable to open file");
			}catch(IOException e) {
				JOptionPane.showMessageDialog(null, "Unable to read");
			}
			
			return transactionArrayList;
		}

}
