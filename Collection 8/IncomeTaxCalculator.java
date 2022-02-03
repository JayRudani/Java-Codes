import java.util.Scanner;

class IncomeTax {

	Scanner input = new Scanner(System.in);

	// declaring of variables and arrays
	private int filing_status;
	private double taxable_income;
	private double income_tax;
	private double amount_from;
	private double amount_to;
	private double[] rates_2001;
	private double[] rates_2009;
	private double[] interval_single_2001;
	private double[] interval_marriedFilingJointly_2001;
	private double[] interval_marriedFilingSeperately_2001;
	private double[] interval_headOfHouseHold_2001;
	private double[] interval_single_2009;
	private double[] interval_marriedFilingJointly_2009;
	private double[] interval_marriedFilingSeperately_2009;
	private double[] interval_headOfHouseHold_2009;

	// no arg constructor
	public IncomeTax() {

	}

	// constructor with arguments for choice 1
	public IncomeTax(int filing_status, double taxable_income, double[] rates_2001, double[] rates_2009,
			double[] interval_single_2001, double[] interval_marriedFilingJointly_2001,
			double[] interval_marriedFilingSeperately_2001, double[] interval_headOfHouseHold_2001,
			double[] interval_single_2009, double[] interval_marriedFilingJointly_2009,
			double[] interval_marriedFilingSeperately_2009, double[] interval_headOfHouseHold_2009) {

		this.filing_status = filing_status;
		this.taxable_income = taxable_income;
		this.rates_2001 = rates_2001;
		this.rates_2009 = rates_2009;
		this.interval_single_2001 = interval_single_2001;
		this.interval_marriedFilingJointly_2001 = interval_marriedFilingJointly_2001;
		this.interval_marriedFilingSeperately_2001 = interval_marriedFilingSeperately_2001;
		this.interval_headOfHouseHold_2001 = interval_headOfHouseHold_2001;
		this.interval_single_2009 = interval_single_2009;
		this.interval_marriedFilingJointly_2009 = interval_marriedFilingJointly_2009;
		this.interval_marriedFilingSeperately_2009 = interval_marriedFilingSeperately_2009;
		this.interval_headOfHouseHold_2009 = interval_headOfHouseHold_2009;
	}

	// constructor with arguments for choice 2
	public IncomeTax(double[] rates_2001, double[] rates_2009, double[] interval_single_2001,
			double[] interval_marriedFilingJointly_2001, double[] interval_marriedFilingSeperately_2001,
			double[] interval_headOfHouseHold_2001, double[] interval_single_2009,
			double[] interval_marriedFilingJointly_2009, double[] interval_marriedFilingSeperately_2009,
			double[] interval_headOfHouseHold_2009) {

		this.rates_2001 = rates_2001;
		this.rates_2009 = rates_2009;
		this.interval_single_2001 = interval_single_2001;
		this.interval_marriedFilingJointly_2001 = interval_marriedFilingJointly_2001;
		this.interval_marriedFilingSeperately_2001 = interval_marriedFilingSeperately_2001;
		this.interval_headOfHouseHold_2001 = interval_headOfHouseHold_2001;
		this.interval_single_2009 = interval_single_2009;
		this.interval_marriedFilingJointly_2009 = interval_marriedFilingJointly_2009;
		this.interval_marriedFilingSeperately_2009 = interval_marriedFilingSeperately_2009;
		this.interval_headOfHouseHold_2009 = interval_headOfHouseHold_2009;
	}

	// method getting user's filing status
	public int getFilingStatus() {

		System.out.println();
		System.out.println("Select your filling status:");
		System.out.println("0. Single");
		System.out.println("1. Married Filing Jointly or Qualifying Widow(er)");
		System.out.println("2. Married Filing");
		System.out.println("3. Head of House Hold");
		System.out.println();
		System.out.printf("Enter the filing status:");

		// checking for valid option from menu from user
		do {
			filing_status = input.nextByte();
			if (filing_status < 0 || filing_status > 3) {
				System.out.printf("Please Enter a valid option(0, 1, 2 or 3):");
			}
		} while (filing_status < 0 || filing_status > 3);

		return filing_status;
	}

	// method for setting filing status of user
	public void setFilingStatus(int filing_status) {
		this.filing_status = filing_status;
	}

	// method for getting user's Income Tax
	public double getTaxableIncome() {
		System.out.println();
		System.out.printf("Enter the Taxable Income: $");
		double taxable_income = input.nextDouble();
		return taxable_income;
	}

	// method for setting Income Tax of user
	public void setTaxableIncome(double taxable_income) {
		this.taxable_income = taxable_income;
	}

	// method for getting Income Tax for the specific filing status
	public double getIncomeTax() {

		// single filing status calculation
		if (filing_status == 0) {

			for (int i = 0; i < interval_single_2009.length; i++) {
				if (i == interval_single_2009.length - 1) {
					double value = 108216;
					income_tax = ((taxable_income - interval_single_2009[i]) * (rates_2009[i] / 100)) + value;
					break;
				}
				// check if value is between each array value then assign the value of added tax
				else if (taxable_income > interval_single_2009[i] && taxable_income <= interval_single_2009[i + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (i == 1) {
						value = 835;
					}
					if (i == 2) {
						value = 4675;
					}
					if (i == 3) {
						value = 16750;
					}
					if (i == 4) {
						value = 41754;
					}

					// calculate the income tax with that tax interval and rate and the value
					// ex (10000 - 8350) * 15% + 8350
					income_tax = ((taxable_income - interval_single_2009[i]) * (rates_2009[i] / 100)) + value;
					break;
				}
			}
		}
		// joint or widow(er) filing status calculation
		else if (filing_status == 1) {
			for (int i = 0; i < interval_marriedFilingJointly_2009.length; i++) {
				if (i == interval_marriedFilingJointly_2009.length - 1) {
					double value = 100894.5;
					income_tax = ((taxable_income - interval_marriedFilingJointly_2009[i]) * (rates_2009[i] / 100))
							+ value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_marriedFilingJointly_2009[i]
						&& taxable_income <= interval_marriedFilingJointly_2009[i + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (i == 1) {
						value = 1670;
					}
					if (i == 2) {
						value = 9350;
					}
					if (i == 3) {
						value = 26637.5;
					}
					if (i == 4) {
						value = 46741.5;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_marriedFilingJointly_2009[i]) * (rates_2009[i] / 100))
							+ value;
					break;
				}
			}
		}
		// married separately filing status calculation
		else if (filing_status == 2) {
			for (int i = 0; i < interval_marriedFilingSeperately_2009.length; i++) {
				if (i == interval_marriedFilingSeperately_2009.length - 1) {
					double value = 50447.25;
					income_tax = ((taxable_income - interval_marriedFilingSeperately_2009[i]) * (rates_2009[i] / 100))
							+ value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_marriedFilingSeperately_2009[i]
						&& taxable_income <= interval_marriedFilingSeperately_2009[i + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (i == 1) {
						value = 835;
					}
					if (i == 2) {
						value = 4675;
					}
					if (i == 3) {
						value = 13318.75;
					}
					if (i == 4) {
						value = 23370.75;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_marriedFilingSeperately_2009[i]) * (rates_2009[i] / 100))
							+ value;
					break;
				}
			}
		}
		// head of household filing status calculation
		else if (filing_status == 3) {
			for (int i = 0; i < interval_headOfHouseHold_2009.length; i++) {
				if (i == interval_headOfHouseHold_2009.length - 1) {
					double value = 104892.5;
					income_tax = ((taxable_income - interval_headOfHouseHold_2009[i]) * (rates_2009[i] / 100)) + value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_headOfHouseHold_2009[i]
						&& taxable_income <= interval_headOfHouseHold_2009[i + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (i == 1) {
						value = 1195;
					}
					if (i == 2) {
						value = 6227.5;
					}
					if (i == 3) {
						value = 24215;
					}
					if (i == 4) {
						value = 44585;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_headOfHouseHold_2009[i]) * (rates_2009[i] / 100)) + value;
					break;
				}
			}
		}

		// returning income_tax value after calculations
		return income_tax;
	}

	// method to set the amount from and to in option 2 of menu
	public void setAmount() {
		System.out.println();
		System.out.printf("Enter the amount From: $");
		amount_from = input.nextDouble();
		System.out.printf("Enter the amount To: $");
		amount_to = input.nextDouble();
	}

	// method to display the 2009 tax table for the setAmount that is specified by
	// user
	// at increments of 1000
	public void getTaxTable_2009() {
		System.out.println();
		System.out.println();
		System.out.println("2009 tax tables for taxable income from $" + amount_from + " to $" + amount_to);
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Taxable    Single    Married Joint     Married     Head of");
		System.out.println("Income               or Qualifying     Seperate    a House");
		System.out.println("                     Widow(er)                            ");
		System.out.println("-------------------------------------------------------------------------");
		// while amount_to is higher, keep displaying a new line of data for each filing
		// status
		for (double i = amount_from; i <= amount_to; i += 1000) {
			taxable_income = i;
			System.out.print(i + "    ");
			for (int j = 0; j < interval_single_2009.length; j++) {
				// calculating the values in tax table for single filing status
				if (j == interval_single_2009.length - 1) {
					double value = 108216;
					income_tax = ((taxable_income - interval_single_2009[j]) * (rates_2009[j] / 100)) + value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_single_2009[j] && taxable_income <= interval_single_2009[j + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (j == 1) {
						value = 835;
					}
					if (j == 2) {
						value = 4675;
					}
					if (j == 3) {
						value = 16750;
					}
					if (j == 4) {
						value = 41754;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_single_2009[j]) * (rates_2009[j] / 100)) + value;
					break;
				}
			}
			System.out.print(income_tax + "      ");

			// calculating the values in tax table for joint and widow(er) filing status
			for (int j = 0; j < interval_marriedFilingJointly_2009.length; j++) {
				if (j == interval_marriedFilingJointly_2009.length - 1) {
					double value = 100894.5;
					income_tax = ((taxable_income - interval_marriedFilingJointly_2009[j]) * (rates_2009[j] / 100))
							+ value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_marriedFilingJointly_2009[j]
						&& taxable_income <= interval_marriedFilingJointly_2009[j + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (j == 1) {
						value = 1670;
					}
					if (j == 2) {
						value = 9350;
					}
					if (j == 3) {
						value = 26637.5;
					}
					if (j == 4) {
						value = 46741.5;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_marriedFilingJointly_2009[j]) * (rates_2009[j] / 100))
							+ value;
					break;
				}
			}
			System.out.print(income_tax + "         ");

			// calculating the values in tax table for married separately filing status
			for (int j = 0; j < interval_marriedFilingSeperately_2009.length; j++) {
				if (j == interval_marriedFilingJointly_2009.length - 1) {
					double value = 50447.25;
					income_tax = ((taxable_income - interval_marriedFilingSeperately_2009[j]) * (rates_2009[j] / 100))
							+ value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_marriedFilingSeperately_2009[j]
						&& taxable_income <= interval_marriedFilingSeperately_2009[j + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (j == 1) {
						value = 835;
					}
					if (j == 2) {
						value = 4675;
					}
					if (j == 3) {
						value = 13318.75;
					}
					if (j == 4) {
						value = 23370.75;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_marriedFilingSeperately_2009[j]) * (rates_2009[j] / 100))
							+ value;
					break;
				}
			}
			System.out.print(income_tax + "       ");

			// calculating the values in tax table for head of household filing status
			for (int j = 0; j < interval_headOfHouseHold_2009.length; j++) {
				if (j == interval_headOfHouseHold_2009.length - 1) {
					double value = 104892.5;
					income_tax = ((taxable_income - interval_headOfHouseHold_2009[j]) * (rates_2009[j] / 100)) + value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_headOfHouseHold_2009[j]
						&& taxable_income <= interval_headOfHouseHold_2009[j + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (j == 1) {
						value = 1195;
					}
					if (j == 2) {
						value = 6227.5;
					}
					if (j == 3) {
						value = 24215;
					}
					if (j == 4) {
						value = 44585;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_headOfHouseHold_2009[j]) * (rates_2009[j] / 100)) + value;
					break;
				}
			}
			System.out.print(income_tax);
			System.out.println();
		}
	}

	// method to display the 2001 tax table for the setAmount that is specified by
	// user
	// at increments of 1000
	public void getTaxTable_2001() {
		System.out.println();
		System.out.println("2001 tax tables for taxable income from $" + amount_from + " to $" + amount_to);
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Taxable    Single    Married Joint     Married     Head of");
		System.out.println("Income               or Qualifying     Seperate    a House");
		System.out.println("                     Widow(er)                            ");
		System.out.println("-------------------------------------------------------------------------");
		for (double i = amount_from; i <= amount_to; i += 1000) {
			taxable_income = i;
			System.out.print(i + "    ");
			// calculating the values in tax table for single filing status
			for (int j = 0; j < interval_single_2001.length; j++) {
				if (j == interval_single_2001.length - 1) {
					double value = 93374;
					income_tax = ((taxable_income - interval_single_2001[j]) * (rates_2001[j] / 100)) + value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_single_2001[j] && taxable_income <= interval_single_2001[j + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (j == 1) {
						value = 4057.5;
					}
					if (j == 2) {
						value = 14645;
					}
					if (j == 3) {
						value = 36361;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_single_2001[j]) * (rates_2001[j] / 100)) + value;
					break;
				}
			}
			System.out.print(income_tax + "      ");

			// calculating the values in tax table for jointly and widow(er) filing status
			for (int j = 0; j < interval_marriedFilingJointly_2001.length; j++) {
				if (j == interval_marriedFilingJointly_2001.length - 1) {
					double value = 88306.75;
					income_tax = ((taxable_income - interval_marriedFilingJointly_2001[j]) * (rates_2001[j] / 100))
							+ value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_marriedFilingJointly_2001[j]
						&& taxable_income <= interval_marriedFilingJointly_2001[j + 1]) {
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					double value = 0;
					if (j == 1) {
						value = 6780;
					}
					if (j == 2) {
						value = 24393.75;
					}
					if (j == 3) {
						value = 41855;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_marriedFilingJointly_2001[j]) * (rates_2001[j] / 100))
							+ value;
					break;
				}
			}
			System.out.print(income_tax + "         ");

			// calculating the values in tax table for married separately filing status
			for (int j = 0; j < interval_marriedFilingSeperately_2001.length; j++) {
				if (j == interval_marriedFilingJointly_2001.length - 1) {
					double value = 44153.375;
					income_tax = ((taxable_income - interval_marriedFilingSeperately_2001[j]) * (rates_2001[j] / 100))
							+ value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_marriedFilingSeperately_2001[j]
						&& taxable_income <= interval_marriedFilingSeperately_2001[j + 1]) {
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					double value = 0;
					if (j == 1) {
						value = 3390;
					}
					if (j == 2) {
						value = 12196.875;
					}
					if (j == 3) {
						value = 20927.5;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_marriedFilingSeperately_2001[j]) * (rates_2001[j] / 100))
							+ value;
					break;
				}
			}
			System.out.print(income_tax + "       ");

			// calculating the values in tax table for head of household filing status
			for (int j = 0; j < interval_headOfHouseHold_2001.length; j++) {
				if (j == interval_headOfHouseHold_2001.length - 1) {
					double value = 90636;
					income_tax = ((taxable_income - interval_headOfHouseHold_2001[j]) * (rates_2001[j] / 100)) + value;
					break;
				}
				// which interval the taxable income is between
				else if (taxable_income > interval_headOfHouseHold_2001[j]
						&& taxable_income <= interval_headOfHouseHold_2001[j + 1]) {
					double value = 0;
					// assigning value to value variable depending on where tax variable lies
					// and adding that value to the income tax
					if (j == 1) {
						value = 5437.5;
					}
					if (j == 2) {
						value = 21222.5;
					}
					if (j == 3) {
						value = 38912.5;
					}

					// calculate the income tax with that tax interval and rate and the value
					income_tax = ((taxable_income - interval_headOfHouseHold_2001[j]) * (rates_2001[j] / 100)) + value;
					break;
				}
			}
			System.out.print(income_tax);
			System.out.println();
		}
	}
}

public class IncomeTaxCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		// declaration of array values for rates, and intervals for each type of filing
		// status for 2001 and 2009
		double rates_2001[] = { 15, 27.5, 30.5, 35.5, 39.1 };
		double rates_2009[] = { 10, 15, 25, 28, 33, 35 };
		double interval_single_2001[] = { 0, 27050, 65550, 136750, 297350 };
		double interval_marriedFilingJointly_2001[] = { 0, 45200, 109250, 166500, 297350 };
		double interval_marriedFilingSeperately_2001[] = { 0, 22600, 54625, 83250, 148675 };
		double interval_headOfHouseHold_2001[] = { 0, 36250, 93650, 151650, 297350 };
		double interval_single_2009[] = { 0, 8350, 33950, 82250, 171550, 372950 };
		double interval_marriedFilingJointly_2009[] = { 0, 16700, 67900, 137050, 208850, 372950 };
		double interval_marriedFilingSeperately_2009[] = { 0, 8350, 33950, 68525, 104425, 186475 };
		double interval_headOfHouseHold_2009[] = { 0, 11950, 45500, 117450, 190200, 372950 };

		byte choice;
		// options menu displayed to user
		do {
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Select an option from the menu:");
			System.out.println("1. Compute personal income Tax");
			System.out.println("2. Print the Tax tables for taxable income");
			System.out.println("3. Exit");
			System.out.println();
			System.out.printf("Enter your choice:");

			// continues to ask for an option with an error message while 1, 2, or 3 are not
			// entered by user
			do {
				choice = input.nextByte();
				if (choice < 1 || choice > 3) {
					System.out.println("Please Enter a valid option(1, 2 or 3):");
				}
			} while (choice < 1 || choice > 3);

			// if user enters 1, show user filing options to select from
			// and ask for their Taxable Income amount, then displays Income Tax amount
			if (choice == 1) {

				IncomeTax it = new IncomeTax();

				int filing_status = it.getFilingStatus();
				double taxable_income = it.getTaxableIncome();

				IncomeTax it1 = new IncomeTax(filing_status, taxable_income, rates_2001, rates_2009,
						interval_single_2001, interval_marriedFilingJointly_2001, interval_marriedFilingSeperately_2001,
						interval_headOfHouseHold_2001, interval_single_2009, interval_marriedFilingJointly_2009,
						interval_marriedFilingSeperately_2009, interval_headOfHouseHold_2009);
				it1.setFilingStatus(filing_status);

				it1.setTaxableIncome(taxable_income);

				double income_tax = it1.getIncomeTax();
				System.out.println();
				System.out.println("Tax is: $" + income_tax);
			}

			// if user enters 2, shows tax tables for 2001 and 2009 between the 2 values
			// user enters
			if (choice == 2) {

				IncomeTax it1 = new IncomeTax(rates_2001, rates_2009, interval_single_2001,
						interval_marriedFilingJointly_2001, interval_marriedFilingSeperately_2001,
						interval_headOfHouseHold_2001, interval_single_2009, interval_marriedFilingJointly_2009,
						interval_marriedFilingSeperately_2009, interval_headOfHouseHold_2009);

				it1.setAmount();
				it1.getTaxTable_2001();
				it1.getTaxTable_2009();

			}

			// if user enters 3, output a Goodbye message
			if (choice == 3) {
				System.out.println();
				System.out.println("Goodbye!!!");
			}
		} while (choice != 3);
		input.close();

	}

}
