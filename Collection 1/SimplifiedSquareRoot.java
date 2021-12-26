import java.util.Scanner;

public class SimplifiedSquareRoot {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // taking input from the user

		System.out.println("Enter a positive integer:");
		double number = input.nextDouble();
		int flag = 0; // declaring a flag

		if (number == 0 || number == 1) // checking if the entered number is 0 or 1
		{
			System.out.println("sqrt(" + number + ") is " + number);
		} else // checking if the number is prime or not
		{
			int m = (int) number / 2;
			for (int j = 2; j <= m; j++) {
				if (number % j == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) // if the number is prime then its square root is number itself
			{
				System.out.println("sqrt(" + number + ") is sqrt(" + number + ")");
			}
		}

		if (flag == 1) // if the number is not prime
		{
			int k = 0;
			for (int i = 0; i < number; i++) {
				int j = i * i;
				if (number % j == 0) {
					k = j; // here k will be the number whose square root exist
				}
			}
			int a = (int) number / k;
			if (k == 1) // for the number which is not prime but its square root is number itself
			{
				System.out.println("sqrt(" + number + ") is sqrt(" + a + ")");
			} else if (a == 1) // for the number whose square root exist
			{
				for (double i = number; i > 1; i--) {
					if (number / i == i) {
						System.out.println("sqrt(" + number + ") is " + i);
						break;
					}
				}
			} else // for the number whose partial square root exist
			{
				for (double i = number; i > 1; i--) {
					if (number % (i * i) == 0) {
						double b = number / (i * i);
						System.out.println("sqrt(" + number + ") is " + i + "*sqrt(" + b + ")");
						break;
					}
				}
			}
		}
		input.close();
	}
}
