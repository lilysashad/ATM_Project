package packageATM;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.*; 

public class Account {
	
	private String username;
	
	private int PIN;
	
	private double checkingsBalance = 0;
	
	private double savingsBalance = 0;
	
	DecimalFormat moneyConvert = new DecimalFormat("'$'###,##0.00");

	//getters and setters
	public String getUsername() {
		
		return username;
		
	}
	
	public String setUsername(String userInput) {
		
		this.username = userInput;
		
		return this.username;
		
	}
	
	public int getPIN() {
		
		return PIN;
		
	}
	
	public int setPIN(int PINinput) {
		
		this.PIN = PINinput;
		
		return this.PIN;
		
	}
	
	public double getCheckingsBalance() {
		
		return checkingsBalance;
		
	}
	
	public double getSavingsBalance() {
		
		return savingsBalance;
		
	}
	
	//calculating deposits
	public double newCheckingsDeposit(double amount) {
		
		checkingsBalance = checkingsBalance + amount;
		
		return checkingsBalance;
		
	}
	
	public double newSavingsDeposit(double amount) {
		
		savingsBalance = savingsBalance + amount;
		
		return savingsBalance;
		
	}
	
	//calculating withdrawals
	public double newCheckingsWithdrawal(double amount) {
		
		checkingsBalance = checkingsBalance - amount;
		
		return checkingsBalance;
		
	}
	
	public double newSavingsWithdrawal(double amount) {
		
		savingsBalance = savingsBalance - amount;
		
		return savingsBalance;
		
	}
	
	//calculating withdrawals
	public void getCheckingsWithdrawalInput() {
		
		JFrame currentframe = new JFrame("Current Balance");
				
		String stringAmount = JOptionPane.showInputDialog("Withdrawal amount");
		
		double doubleAmount = Double.parseDouble(stringAmount);
		
		if((checkingsBalance - doubleAmount) >= 0) {
			
			newCheckingsWithdrawal(doubleAmount);
			
			JOptionPane.showMessageDialog(currentframe, getUsername() + "'s new balance: " + moneyConvert.format(getCheckingsBalance()) + "\nThank you for using the ATM!");
		
		}
		
		else {
			
			JOptionPane.showMessageDialog(currentframe, "Insufficient funds");
			
			return;
			
		}
		
		System.exit(0); 
		
	}
	
	public void getSavingsWithdrawalInput() {
		
		JFrame currentframe = new JFrame("Current Balance");
				
		String stringAmount = JOptionPane.showInputDialog("Withdrawal amount");
		
		double doubleAmount = Double.parseDouble(stringAmount);
		
		if((savingsBalance - doubleAmount) >= 0) {
			
			newSavingsWithdrawal(doubleAmount);
			
			JOptionPane.showMessageDialog(currentframe, getUsername() + "'s new balance: " + moneyConvert.format(getSavingsBalance()) + "\nThank you for using the ATM!");
		
		}
		
		else {
			
			JOptionPane.showMessageDialog(currentframe, "Insufficient funds");

			return;
			
		}
		
		System.exit(0); 
		
	}
	
	//executing deposits
		public void getCheckingsDepositInput() {
			
			JFrame currentframe = new JFrame("Current Balance");
						
			String stringAmount = JOptionPane.showInputDialog("Deposit amount");
			
			double doubleAmount = Double.parseDouble(stringAmount);
			
			if((checkingsBalance + doubleAmount) >= 0) {
				
				newCheckingsDeposit(doubleAmount);
				
				JOptionPane.showMessageDialog(currentframe, getUsername() + "'s new balance: " + moneyConvert.format(getCheckingsBalance()) + "\nThank you for using the ATM!");
			
			}
			
			else {
				
				JOptionPane.showMessageDialog(currentframe, "Invalid amount!");

				return;
				
			}
				
			System.exit(0); 
			
		}
		
		public void getSavingsDepositInput() {
			
			JFrame currentframe = new JFrame("Current Balance");
						
			String stringAmount = JOptionPane.showInputDialog("Deposit amount");
			
			double doubleAmount = Double.parseDouble(stringAmount);
			
			if((savingsBalance + doubleAmount) >= 0) {
				
				newSavingsDeposit(doubleAmount);
				
				JOptionPane.showMessageDialog(currentframe, getUsername() + "'s new balance: " + moneyConvert.format(getSavingsBalance()) + "\nThank you for using the ATM!");
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(currentframe, "Invalid amount!");

				return;
				
			}
						
			System.exit(0); 
		
		}
	
}
