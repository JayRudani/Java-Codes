/* Create a dictionary of words, as a String array. Initialize you array in your main
 * method (i.e. hard code). Make this array size 20 (with 20 words) – add any words
 * you wish (preferably greater than 5 characters per word – to make things
 * interesting)*/

package Lab09;

import java.util.Scanner; //importing Scanner class

public class HangmanGame {

	public static void main(String[] args) { // declaration of main class
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); // declaring object of scanner class

		String name[] = { "banana", "fruit", "exotic", "apple", "pineapple", "aeroplane", "plant", "build", "compile",
				"python", "kotlin", "eclipse", "netbeans", "google", "microsoft", "amazon", "flipkart", "alibaba",
				"humber", "javascript" }; // declaration of array of string consisting of 20 different words

		String randomName = name[(int) (Math.random() * 20)]; // selecting a random word
		int nameLength = randomName.length(); // calculating length of selected word
//		System.out.println(randomName);

		char choosedName[] = randomName.toCharArray(); // converting the random word into char array
		char[] uniqueCharacter = new char[nameLength]; // an array to store unique character in choosedName array
		char[] wordFound = new char[nameLength]; // array for showing correct guessed word

		int index_uniqueCharacter = 0;
		int hit = 0;

		for (int i = 0; i < choosedName.length; i++) // for loop for finding unique character in the choosedName
		{
			int flag = 0;
			for (int j = 0; j < i; j++) {
				if (choosedName[i] == choosedName[j]) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				uniqueCharacter[index_uniqueCharacter] = choosedName[i];
				index_uniqueCharacter++;
			}
		}

		for (int i = 0; i < wordFound.length; i++) // for loop for filling character in wordFound array
		{
			wordFound[i] = '-';
			System.out.print(wordFound[i]);
		}

		do { // do while loop for guessing game
			byte printMessage = 0;
			byte doublehit = 0;

			System.out.println("\nGuess a Character:");
			char ch = input.next().charAt(0); // getting input from user

			for (int i = 0; i < choosedName.length; i++) // for loop to check if the word has already exist or it a new
															// one
			{
				if (ch == wordFound[i]) {
					doublehit++;
					if (doublehit < 2) {
						System.out.println("Character already exist");
					}
					printMessage++;
				} else {
					if (ch == choosedName[i]) {
						wordFound[i] = ch;
						doublehit++;
						if (doublehit < 2) {
							System.out.println("Correct Guess!");
							hit++;
						}
						printMessage++;
					}
				}
			}

			for (int i = 0; i < wordFound.length; i++) // for loop for showing wordFound Array
			{
				System.out.print(wordFound[i]);
			}
			if (printMessage == 0) // printing message for wrong input
			{
				System.out.println("Wrong guess!");
			}
		} while (hit != index_uniqueCharacter); // executing do-while loop till all letters are guessed

		System.out.println("\nCongratulations!! You found the word");
		input.close();

	}

}
