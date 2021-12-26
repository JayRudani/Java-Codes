import java.text.DecimalFormat; //importing DecimalFormat class
import java.util.Scanner; //importing Scanner class 

public class AmortizationSchedulefortheLoan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); // creating object for Scanner class
		DecimalFormat df = new DecimalFormat("#.##"); // creating object for DecimalFormat class

		System.out.println("Enter Loan Amount:"); // Prompt the user to enter the loan amount
		double l_Amount = input.nextDouble();
		System.out.println("Enter Number of Years:"); // Prompt the user to enter the number of years
		int noOfYears = input.nextInt();
		int noOfMonth = noOfYears * 12; // calculating no of month from years
		System.out.println("Enter Annual Interest Rate:"); // Prompt the user to enter the Annual interest rate
		double annual_InterestRate = input.nextDouble();

		double monthly_InterestRate = annual_InterestRate / 1200; // formula to calculate monthly interest rate

		double monthly_Payment = ((l_Amount * monthly_InterestRate * (Math.pow(1 + monthly_InterestRate, noOfMonth)))
				/ ((Math.pow(1 + monthly_InterestRate, noOfMonth)) - 1)); // Calculate monthly payment
		System.out.println();

		System.out.printf("Monthly Payment: %.2f\n", monthly_Payment); // printing monthly payment
		double total_Payment = (monthly_Payment * 12) * noOfYears; // formula to calculate total payment

		System.out.printf("Total Payment: %.2f\n", total_Payment); // printing total payment

		double balance = l_Amount; // assigning loan amount to balance
		double principal, interest; // declaring principal and interest
		System.out.println();
		System.out.println("Payment#        Interest        Principal       Balance");

		for (int i = 1; i <= noOfYears * 12; i++) { // for loop for calculating and printing amortization table
			interest = monthly_InterestRate * balance; // calculating interest
			principal = monthly_Payment - interest; // calculating principal
			balance = balance - principal; // calculating balance

			String formatted_Interest = df.format(interest); // formating so that only 2 digit are printed after decimal
																// point
			String formatted_Principal = df.format(principal); // formating so that only 2 digit are printed after
																// decimal point
			String formatted_Balance = df.format(balance); // formating so that only 2 digit are printed after decimal
															// point

			System.out.println(
					i + "\t\t" + formatted_Interest + "\t\t" + formatted_Principal + "\t\t" + formatted_Balance);
		}
		input.close();
	}

}
