//Write a java program to generate a random number plate which consist of 3 letter and 3 digit.


public class NumberPlateGenerator {

	public static void main(String[] args) {

		for (int i = 0; i <= 3; i++) { // Initializing for loop and declaring and assigning variable i in it
			double a = Math.random() * 26; // generating a random number and multiply it by 26 and assigning it to
											// variable a
			int b = (int) a + 65; // Adding 65 to the random number as upper-case letter are in between 65 to 90
									// in ASCII table and assigning it to variable b
			char c = (char) b; // converting the number to character
			System.out.print(c); // printing the character
		}
		for (int i = 0; i <= 2; i++) { // Initializing for loop and declaring and assigning variable i in it
			double a = Math.random() * 9; // generating a random number and multiply it by 9 and assigning it to
											// variable a
			int b = (int) a; // casting the variable a from double to integer and storing it into variable b
			System.out.print(b); // printing the integer
		}

	}

}
