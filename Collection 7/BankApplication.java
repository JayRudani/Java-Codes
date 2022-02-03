 /* Bank Application that allows the user to select from different accounts and perform different actions on them for two banks.
 */
package Project1;

import java.text.DecimalFormat;  //importing Decimal Format Specifier Class
import java.util.Scanner;   //importing Scanner class

/*Account class has 3 methods i.e. deposit, withdraw and check balance */
class Account {
	Scanner a_input = new Scanner(System.in); // declaring and assigning object of the scanner class for Account class
	DecimalFormat df = new DecimalFormat("#.##"); // specifying formatting number to 2 decimal places
	double balance = Math.random() * 10000; // generating random balance
	double deposit_Amount, withdraw_Amount;

	public void deposit() // declaring deposit method
	{
		System.out.println("Available Balance in Your Account:" + df.format(balance));
		System.out.println("Enter Amount for Deposit:");
		deposit_Amount = a_input.nextDouble(); // prompt user to input deposit amount
		balance = balance + deposit_Amount; // formula for deposit
		System.out.println("Deposit Sucessful");
		System.out.println("Available Balance in Your Account:" + df.format(balance)); // showing main balance after
																						// transaction
	}

	public void withdraw() // declaring withdraw method
	{
		System.out.println("Available Balance in Your Account:" + df.format(balance));
		System.out.println("Enter Amount for Withdraw:");
		do {
			withdraw_Amount = a_input.nextDouble(); // prompt user to input withdraw amount
			if (withdraw_Amount > balance) // checking if withdraw amount is greater then balance
			{
				System.out.println("Withdraw Amount cannot be more then Balance!");
				System.out.println("Enter Amount for Withdraw:");
			}
		} while (withdraw_Amount > balance); // looping till user enter withdraw amount less then or equal to balance

		balance = balance - withdraw_Amount; // formula for withdraw
		System.out.println("Withdraw Sucessful");
		System.out.println("Available Balance in Your Account:" + df.format(balance)); // showing main balance after
																						// transaction
	}

	public void checkBalance() // declaring checkBalance method
	{
		System.out.println("Available Balance in Your Account:" + df.format(balance)); //// showing main balance
	}
}

/*
 * Bank class has 5 methods i.e. deposit, withdraw, check balance, pay bill and
 * transfer
 */
class Bank {
	DecimalFormat df = new DecimalFormat("#.##"); // specifying formatting number to 2 decimal places
	double[] bank_Accounts;
	Scanner b_input = new Scanner(System.in); // declaring and assigning object of the scanner class for Account class
	double balance = Math.random() * 10000; // generating random balance
	double deposit_Amount, withdraw_Amount, bill_Amount, transfer_Amount, transfer_Accountnumber;

	public void defaultMethod(double[] accounts) // declaring default method
	{

		bank_Accounts = new double[accounts.length]; // defining size of bank account
		// creating array with the length of number of accounts in the bank dynamically
		for (int i = 0; i <= accounts.length - 1; i++) {
			this.bank_Accounts[i] = accounts[i];
		}
		System.out.println("Accounts in Bank:"); // displaying the accounts
		for (int i = 0; i <= accounts.length - 1; i++) {
			System.out.println(df.format(bank_Accounts[i]));
			;
		}
	}

	public void deposit() // declaring deposit method
	{
		System.out.println("Available Balance in Your Account:" + df.format(balance));
		System.out.println("Enter Amount for Deposit:");
		deposit_Amount = b_input.nextDouble();
		balance = balance + deposit_Amount; // formula for depositing into account
		System.out.println("Deposit Sucessful");
		System.out.println("Available Balance in Your Account:" + df.format(balance));
	}

	public void withdraw() // declaring withdraw method
	{
		System.out.println("Available Balance in Your Account:" + df.format(balance));
		System.out.println("Enter Amount for Withdraw:"); // prompting user for withdraw amount
		// checking that withdraw amount is more than balance
		do {
			withdraw_Amount = b_input.nextDouble();
			if (withdraw_Amount > balance) {
				System.out.println("Withdraw Amount cannot be more then Balance!");
				System.out.println("Enter Amount for Withdraw:");
			}
		} while (withdraw_Amount > balance);

		balance = balance - withdraw_Amount; // formula for withdraw amount
		System.out.println("Withdraw Sucessful");
		System.out.println("Available Balance in Your Account:" + df.format(balance));
	}

	public void checkBalance() // declaring checkBalance method
	{
		System.out.println("Available Balance in Your Account:" + df.format(balance));
	}

	public void payBill() // declaring payBill method
	{
		System.out.println("Available Balance in Your Account:" + df.format(balance));
		System.out.println("Enter the Amount you want to Pay:"); // prompt user for amount to pay
		bill_Amount = b_input.nextDouble();
		// checking for balance of account being sufficient for the bill
		if (bill_Amount > balance) {
			System.out.println("Insufficient Balance!");
		} else {
			balance = balance - bill_Amount; // formula for deducting bill amount from balance
			System.out.println("Bill was paid successfully");
			System.out.println("Available Balance in Your Account:" + df.format(balance));
		}
	}

	public void transfer(double acc_Number) // declaring transfer method
	{
		System.out.println("Available Balance in Your Account(" + df.format(acc_Number) + "):" + df.format(balance));
		System.out.println("Choose an Account in which the transfer is to be done:");
		byte j = 1;
		// displaying the accounts in the bank you can transfer to
		for (int i = 0; i <= bank_Accounts.length - 1; i++) {
			if (bank_Accounts[i] != acc_Number) {
				System.out.println(+(j) + ":" + df.format(bank_Accounts[i]));
				j++;
			}
		}

		int number_of_preference = bank_Accounts.length - 1; // show the remaining bank accounts that weren't chosen by
																// user
		System.out.println("Enter Your Preference(1 to " + number_of_preference + "):"); // prompt user for their choice
																							// of account
		byte preference;

		// checking if user option is valid
		do {
			preference = b_input.nextByte();
			if (preference < 1 || preference > number_of_preference) {
				System.out.println("Invalid Option");
				System.out.println("Enter Your Preference(1 to " + number_of_preference + "):");
			}
		} while (preference < 1 || preference > number_of_preference);

		System.out.println("Enter the Amount you want to Transfer:"); // prompt user input
		transfer_Amount = b_input.nextDouble();
		// checking if sufficient funds are able to be transfered
		if (transfer_Amount > balance) {
			System.out.println("Insufficient Balance!");
		} else {
			balance = balance - transfer_Amount; // formula for deducting amount from balance
			System.out.println("Transfer Successful");
			System.out.println("Available Balance in Your Account:" + df.format(balance));
		}
	}
}

/*
 * Main class where user selects their bank, account and other options, the
 * other classes and their methods are called here
 */

public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		double[] scotia_BankAccounts = { 123456, 225615, 302651, 165413, 216513 }; // declaring an array of the accounts
																					// in Scotia Bank
		double[] montreal_BankAccounts = { 567891, 567892, 567893 }; // declaring an array of the accounts in the Bank
																		// of Montreal

		System.out.println("Enter your Bank Number(123: Bank of Nova Scotia OR 456: Bank of Montreal):");
		int bank_number;
		// checking that user input one of these banks
		do {
			bank_number = input.nextInt();
			if (bank_number != 123 && bank_number != 456)
				System.out
						.println("Please Enter Valid Bank Number(123: Bank of Nova Scotia OR 456: Bank of Montreal):");
		} while (bank_number != 123 && bank_number != 456);

		System.out.println("Do you know your account Number:Y or N");
		char knowAccount;
		// checking that user input yes or no for knowing their account number
		do {
			knowAccount = input.next().charAt(0);
			if (knowAccount != 'Y' && knowAccount != 'N' && knowAccount != 'y' && knowAccount != 'n')
				System.out.println("Please Enter only Y or N:");
		} while (knowAccount != 'Y' && knowAccount != 'N' && knowAccount != 'y' && knowAccount != 'n');

		// if user knows their account number
		if (knowAccount == 'Y' || knowAccount == 'y') {
			Account a = new Account();

			// showing accounts in the Bank of Nova Scotia
			if (bank_number == 123) {
				System.out.println("Welcome to Bank Of Nova Scotia");
				System.out.println("Account Number Currently Available::");
				// displaying the bank accounts in the Bank of Nova Scotia
				for (int i = 0; i <= scotia_BankAccounts.length - 1; i++) {
					System.out.println(df.format(scotia_BankAccounts[i]));
				}
				System.out.println("Enter Your Account Number:"); // prompting user for their account number
				double account_number;

				// outer breaks the loop if an account number matches an account in the Nova
				// Scotia Bank array
				outer: do {
					account_number = input.nextDouble();
					// checking if account number is found in the array of Nova Scotia Bank accounts
					for (int i = 0; i <= scotia_BankAccounts.length - 1; i++) {
						if (account_number == scotia_BankAccounts[i]) {
							break outer;
						}
					}
					System.out.println("Please Enter valid your Account Number:");
				} while (account_number > 0);

				// showing user the options for their account
				System.out.println("Choose an Option");
				System.out.println("1 : Deposit");
				System.out.println("2 : Withdraw");
				System.out.println("3 : Check Balance");
				System.out.println("Enter Your Preference(1, 2 OR 3):"); // prompting user for their preference
				byte preference;

				// checking that user input a proper choice
				do {
					preference = input.nextByte();
					if (preference <= 0 || preference >= 4) {
						System.out.println("Invalid Option");
						System.out.println("Enter Your Preference(1, 2 OR 3):");
					}
				} while (preference <= 0 || preference >= 4);

				// matching user's choice to the appropriate method
				if (preference == 1) {
					a.deposit();
				} else if (preference == 2) {
					a.withdraw();
				} else if (preference == 3) {
					a.checkBalance();
				}
			} else {
				System.out.println("Welcome to Bank Of Montreal");
				System.out.println("Account Number Currently Available::");
				// checking the bank accounts in the Bank of Montreal, also displays them
				for (int i = 0; i <= montreal_BankAccounts.length - 1; i++) {
					System.out.println(df.format(montreal_BankAccounts[i]));
				}
				System.out.println("Enter Your Account Number:"); // prompts user for account number
				double account_number;

				// outer breaks the loop
				outer: do {
					account_number = input.nextDouble();
					// checking if account number by user is in the Bank of Montreal
					for (int i = 0; i <= montreal_BankAccounts.length - 1; i++) {
						if (account_number == montreal_BankAccounts[i]) {
							break outer;
						}
					}
					System.out.println("Please Enter valid your Account Number:");
				} while (account_number > 0);

				// displaying options to user
				System.out.println("Choose an Option");
				System.out.println("1 : Deposit");
				System.out.println("2 : Withdraw");
				System.out.println("3 : Check Balance");
				System.out.println("Enter Your Preference(1, 2 OR 3):"); // prompt user to select from options given
				byte preference;

				// checking if the preference mentioned by the user is correct or not
				do {
					preference = input.nextByte();
					if (preference <= 0 || preference >= 4) {
						System.out.println("Invalid Option");
						System.out.println("Enter Your Preference(1, 2 OR 3):");
					}
				} while (preference <= 0 || preference >= 4);

				// calling method according to preference chosen by user
				if (preference == 1) {
					a.deposit();
				} else if (preference == 2) {
					a.withdraw();
				} else if (preference == 3) {
					a.checkBalance();
				}
			}
		}

		// if user does not know their account number
		if (knowAccount == 'N' || knowAccount == 'n') {
			Bank b = new Bank(); // declaring and assigning object for bank class

			// if user selected Bank of Nova Scotia
			if (bank_number == 123) {
				System.out.println("Welcome to Bank of Nova Scotia");
				b.defaultMethod(scotia_BankAccounts); // will show all the accounts in the Bank of Nova Scotia

				System.out.println("Please Choose your Account Number:");
				byte j = 1;
				// displaying the accounts in the Bank of Nova Scotia to user with user choice
				// infront
				for (int i = 0; i <= scotia_BankAccounts.length - 1; i++) {
					System.out.println(+(j) + ":" + df.format(scotia_BankAccounts[i]));
					j++;
				}
				int number_of_preference = scotia_BankAccounts.length;
				System.out.println("Enter Your Preference(1 to " + number_of_preference + "):"); // prompting user
																									// choice
				double account_number = 0;
				byte preference;

				// checking if the preference from user is valid or not
				do {
					preference = input.nextByte();
					if (preference < 1 || preference > number_of_preference) {
						System.out.println("Invalid Option");
						System.out.println("Enter Your Preference(1 to " + number_of_preference + "):");
					}
				} while (preference < 1 || preference > number_of_preference);

				account_number = scotia_BankAccounts[preference - 1];

				// displaying list of options to the user
				System.out.println("Choose an Option");
				System.out.println("1 : Deposit");
				System.out.println("2 : Withdraw");
				System.out.println("3 : Check Balance");
				System.out.println("4 : Pay Bill");
				System.out.println("5 : Transfer Money");
				System.out.println("Enter Your Preference(1, 2, 3, 4 OR 5):"); // prompting user to select preference
				byte preference_action;

				// checking if preference of user is valid
				do {
					preference_action = input.nextByte();
					if (preference_action <= 0 || preference_action >= 6) {
						System.out.println("Invalid Option");
						System.out.println("Enter Your Preference(1, 2, 3, 4 OR 5):");
					}
				} while (preference_action <= 0 || preference_action >= 6);

				// calling method for each selected preference
				if (preference_action == 1) {
					b.deposit();
				} else if (preference_action == 2) {
					b.withdraw();
				} else if (preference_action == 3) {
					b.checkBalance();
				} else if (preference_action == 4) {
					b.payBill();
				} else {
					b.transfer(account_number);
				}

			} else {
				// bank selected is Bank of Montreal
				System.out.println("Welcome to Bank of Montreal");
				b.defaultMethod(montreal_BankAccounts);

				System.out.println("Please Choose your Account Number:"); // asks user to select their account number
																			// from options
				byte j = 1;
				// displaying Bank of Montreal Accounts to user
				for (int i = 0; i <= montreal_BankAccounts.length - 1; i++) {
					System.out.println(+(j) + ":" + df.format(montreal_BankAccounts[i]));
					j++;
				}
				int number_of_preference = montreal_BankAccounts.length;
				System.out.println("Enter Your Preference(1 to " + number_of_preference + "):"); // prompting user for
																									// their account
																									// preference
				double account_number = 0;
				byte preference;

				// checking if preference is valid
				do {
					preference = input.nextByte();
					if (preference < 1 || preference > number_of_preference) {
						System.out.println("Invalid Option");
						System.out.println("Enter Your Preference(1 to " + number_of_preference + "):");
					}
				} while (preference < 1 || preference > number_of_preference);

				account_number = montreal_BankAccounts[preference - 1]; // selecting appropriate account from Montreal
																		// Bank account's array

				// displaying options to user
				System.out.println("Choose an Option");
				System.out.println("1 : Deposit");
				System.out.println("2 : Withdraw");
				System.out.println("3 : Check Balance");
				System.out.println("4 : Pay Bill");
				System.out.println("5 : Transfer Money");
				System.out.println("Enter Your Preference(1, 2, 3, 4 OR 5):"); // prompting user to select preference
				byte preference_action;
				// checking if preference is valid
				do {
					preference_action = input.nextByte();
					if (preference_action <= 0 || preference_action >= 6) {
						System.out.println("Invalid Option");
						System.out.println("Enter Your Preference(1, 2, 3, 4 OR 5):");
					}
				} while (preference_action <= 0 || preference_action >= 6);

				// calling method for the preference that was selected by user
				if (preference_action == 1) {
					b.deposit();
				} else if (preference_action == 2) {
					b.withdraw();
				} else if (preference_action == 3) {
					b.checkBalance();
				} else if (preference_action == 4) {
					b.payBill();
				} else {
					b.transfer(account_number);
				}
			}
		}
		input.close(); // closing input scanner
	}

}
