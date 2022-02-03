/* Write a test program that prompts the user to enter a binary string and displays the corresponding decimal integer value.
 */

package Lab10;

import java.util.Scanner; //importing scanner class

public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); // declaring object for scanner class
		System.out.println("Enter  Binary Number String:");
		String str = input.nextLine(); // getting input from user as String
		int value = binaryToDecimal(str); // calling method and storing the returned value in a variable
		if (value != 0) {
			System.out.println("The decimal value is:" + value);
		}
		input.close();
	}

	public static int binaryToDecimal(String str) {
		int value = 0; // variable for decimal number
		int base = 1; // variable for base value
		int check = 1;

		for (int i = 0; i < str.length(); i++) { // for loop to loop through string
			if (str.charAt(i) == '1' || str.charAt(i) == '0') { // if condition to check that string contains only 1 and
																// 0
				check = 1;
			} else {
				check = 0;
				break;
			}
		}
		if (check == 0) { // if string has other value other than 0 or 1
			System.out.println("Invalid String!!");
		} else { // calculating decimal value if the string is valid
			for (int i = str.length() - 1; i >= 0; i--) { // for loop to loop through string in backward manner
				if (str.charAt(i) == '1') { // checking if there is 1 at the current poistion in the string
					value += base; // calculating decimal value
				}
				base = base * 2; // increasing base i.e. 2, 4 ,8 ...
			}
		}
		return value; // returning decimal value
	}

}
