import java.util.Scanner;

public class SubtractionTest {

	public static void main(String[] args) {
		int quecount = 0, rightans = 0; // declaring a variable for no of question which is 5 and to calculate the no of
										// right answer
		Scanner input = new Scanner(System.in);
		while (quecount < 5) {
			int number1 = (int) (Math.random() * 10); // generating a random no Number1
			int number2 = (int) (Math.random() * 10); // generating a random no number2

			if (number1 < number2) { // if the value of number2 is greater then number 1 then swap the value of both
										// the number
				int temp = number1;
				number1 = number2;
				number2 = temp;
			}
			System.out.println("What's the answer of " + number1 + "-" + number2 + "?"); // printing the question

			int answer = input.nextInt(); // getting answer from the user
			if (answer == (number1 - number2)) { // checking the answer
				rightans++; // increments on every right answer
			}
			quecount++;
		}
		System.out.println("Your final score is " + rightans + "/" + quecount); // printing the final score
		input.close();
	}

}
