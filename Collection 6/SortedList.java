/* This program take 3 input from the user in the form of values and arrange them in ascending order */
package Lab04;

import java.util.Scanner; //importing  scanner class

public class SortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); // creating object for scanner class
		System.out.println("Enter 3 values that is to be sorted:");
		System.out.println("Enter Number 1:");
		int n1 = input.nextInt(); // Taking 1st input in the form of value from the user
		System.out.println("Enter Number 2:");
		int n2 = input.nextInt(); // Taking 2nd input in the form of value from the user
		System.out.println("Enter Number 3:");
		int n3 = input.nextInt(); // Taking 3rd input in the form of value from the user
		displaySortedNumbers(n1, n2, n3); // calling the method and passing the actual parameter
		input.close();

	}

	public static void displaySortedNumbers(int num1, int num2, int num3) { // the declaration of the method and the
																			// formal parameter
		System.out.println("The sorted List:");
		/*
		 * There are total six possibilities of arranging the numbers in ascending
		 * order. The code below check each of the six possibilities and print answer
		 * according to it.
		 */
		if (num1 > num2) { // checking num1 is greater then num2
			if (num1 > num3) { // checking num1 is greater then num3
				if (num2 > num3) { // checking num2 is greater then num3
					/* Printing possibility 1 */
					System.out.println(num3);
					System.out.println(num2);
					System.out.println(num1);
				} else { // else num2 is greater then num3
					/* Printing possibility 2 */
					System.out.println(num2);
					System.out.println(num3);
					System.out.println(num1);
				}
			} else { // else num3 is greater then num1
				/* Printing possibility 3 */
				System.out.println(num2);
				System.out.println(num1);
				System.out.println(num3);
			}
		} else if (num2 > num1) { // checking num2 is greater then num1
			if (num2 > num3) { // checking num2 is greater then num3
				if (num1 > num3) { // checking num1 is greater then num3
					/* Printing possibility 4 */
					System.out.println(num3);
					System.out.println(num1);
					System.out.println(num2);
				} else { // else num3 is greater then num1
					/* Printing possibility 5 */
					System.out.println(num1);
					System.out.println(num3);
					System.out.println(num2);
				}
			} else { // else num3 is greater then num2
				/* Printing possibility 6 */
				System.out.println(num1);
				System.out.println(num2);
				System.out.println(num3);
			}
		}
	}
}
