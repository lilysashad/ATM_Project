package packageATM;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.*; 


public class UserMenu extends Account{
	
	DecimalFormat moneyConvert = new DecimalFormat("'$'###,##0.00");
	
	HashMap<String, Integer> data = new HashMap<String, Integer>();

	//Check if login credentials match up with what's currently hard-coded in system
	public void getLogin(){
		
		JFrame errorframe = new JFrame("Error!");
		
		JFrame loginframe = new JFrame("Username Log-In");
		
		JFrame PINframe = new JFrame("PIN Log-In");
				
		data.put("Pablo", 82958);
		data.put("Xin", 28433);
		data.put("Dipti", 14382);
		data.put("William", 73858);
						
		//prompt for username
		String nameInput = JOptionPane.showInputDialog(loginframe, "Welcome to the ATM!\nPlease enter username");
				
		setUsername(nameInput);
		
		boolean nameMatch = data.containsKey(getUsername());
				
		//prompt for pin
		String PINInput = JOptionPane.showInputDialog(PINframe, "Please enter password");
				
		int PINinputInt = Integer.parseInt(PINInput); //turn string into actual int
				
		setPIN(PINinputInt);
		
		boolean pinMatch = data.containsValue(PINinputInt);
			
		if(nameMatch && pinMatch) {
			
			getAccountType();
				
		}
			
		else {				
			
			JOptionPane.showMessageDialog(errorframe, "Incorrect credentials! ATM lockdown!");
				
		}
		
		System.exit(0); 
		
	}
	
	//Prompt account type with selection menu
	public void getAccountType() {
		
		JFrame frame = new JFrame("Accounts Input Dialog");
		
		String[] accountOptions = {"Checkings", "Savings"};
		
		String chooseAccount = (String) JOptionPane.showInputDialog(frame, "Select account", "Account Selection", JOptionPane.QUESTION_MESSAGE, null, accountOptions, accountOptions[0]);
		
		if(chooseAccount == "Checkings") {
			
			getCheckings();
			
		}
		
		else if(chooseAccount == "Savings") {
			
			getSavings();
			
		}
		
		else if(chooseAccount == null) {
			
			JOptionPane.showMessageDialog(frame, "Thank you for using the ATM!");
			
		}
		
		System.exit(0); 
		
	}
	
	//Display checkings account menu with selection menu
	public void getCheckings() {
		
		JFrame frame = new JFrame("Checkings Dialog");
	
		String[] checkingsOptions = {"View balance", "Withdraw funds", "Deposit funds"};
	
		String chooseCheckings = (String) JOptionPane.showInputDialog(frame, "Select checkings account activity", "Checkings Account Options", JOptionPane.QUESTION_MESSAGE, null, checkingsOptions, checkingsOptions[0]);
	
		if(chooseCheckings == "View balance") {
			
			JOptionPane.showMessageDialog(frame, "Current balance: " + moneyConvert.format(getCheckingsBalance()));
			
			getCheckings();
		
		}
	
		else if(chooseCheckings == "Withdraw funds") {
			
			getCheckingsWithdrawalInput();
		
			getCheckings();
		
		}
		
		else if(chooseCheckings == "Deposit funds") {
			
			getCheckingsDepositInput();
			
			getCheckings();
			
		}
	
		else if(chooseCheckings == null) {
		
			getAccountType();
		
		}
		
		System.exit(0); 
	
	}
	
	//Display savings account menu with selection menu
		public void getSavings() {
			
			JFrame frame = new JFrame("Savings Dialog");
		
			String[] savingsOptions = {"View balance", "Withdraw funds", "Deposit funds"};
		
			String chooseSavings = (String) JOptionPane.showInputDialog(frame, "Select savings activity", "Savings Account Options", JOptionPane.QUESTION_MESSAGE, null, savingsOptions, savingsOptions[0]);
		
			if(chooseSavings == "View balance") {
				
				JOptionPane.showMessageDialog(frame, "Current balance: " + moneyConvert.format(getSavingsBalance()));
				
				getAccountType();
			
			}
		
			else if(chooseSavings == "Withdraw funds") {
				
				getSavingsWithdrawalInput();
			
				getAccountType();
			
			}
			
			else if(chooseSavings == "Deposit funds") {
				
				getSavingsDepositInput();
				
				getAccountType();
				
			}
		
			else if(chooseSavings == null) {
			
				getAccountType();
			
			}
			
			System.exit(0); 
		
		}
	
}
	
