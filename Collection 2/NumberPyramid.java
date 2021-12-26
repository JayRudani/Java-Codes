import java.util.Scanner;

public class NumberPyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of rows:"); // prompt the user to enter height of pyramid
		int noOfRows = input.nextInt();

		for (int i = 1; i <= noOfRows; i++) { // for loop for no of rows

			for (int j = 1; j <= (noOfRows - i); j++) // for loop for printing spaces 4 at a time
			{
				System.out.print(" ");
			}

			for (int j = 0; j < i; j++) { // for loop for incrementing number from 0 to i-1
				System.out.printf("%4d", (int) Math.pow(2, j));
			}

			for (int j = i - 2; j >= 0; j--) { // for loop for decrementing number from i-2 to 0
				System.out.printf("%4d", (int) Math.pow(2, j));
			}
			System.out.println();

		}
		input.close();
	}
}
