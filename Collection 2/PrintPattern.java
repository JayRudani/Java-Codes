import java.util.Scanner;

public class PrintPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of Rows:"); // prompt the user to enter height of the pyramid
		int noOfRows = input.nextInt();

		for (int i = noOfRows; i > 0; i--) { // for loop for number of rows
			for (int j = 0; j < noOfRows - i; j++) // for loop for printing spaces

			{
				System.out.print(" ");
			}
			for (int j = 0; j < (i * 2) - 1; j++) // for loop for printing star(*)

			{
				System.out.print("*");
			}
			System.out.println();
		}
		input.close();

	}

}
