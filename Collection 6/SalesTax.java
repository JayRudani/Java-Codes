import java.util.Scanner;

import java.text.DecimalFormat;

public class SalesTax {

	public static void main(String[] args) {

		System.out.println("The sales tax is 2%");
		Scanner input = new Scanner(System.in);
		final int salestax = 2;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		System.out.println("Enter the no of items you have purchased:");
		int items = input.nextInt();
		
		System.out.println("Enter the price of the item:");
		float price = input.nextFloat();
		
		float tax = price * (salestax / 100f);
		System.out.println("The sales tax incurred on 1 items:" +numberFormat.format(tax));
		
		float totaltax = tax * items;
		System.out.println("The total tax for " + items + " is " + numberFormat.format(totaltax));
		
		input.close();

	}

}
