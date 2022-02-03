/*Write a program that reads the integers between 1 and 100 and counts the occurrences of each. Assume the input ends with -1.*/
import java.util.Scanner; //importing Scanner class

public class CountNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in); // declaring scanner class object
		System.out.println("Enter the size of Array:");
		int size = input.nextInt(); // enter the size of Array
		int[] array = new int[size]; // creating an Array of size defined by user
		int[] temp = new int[size]; // creating an temporary Array for counting occurrence of an number
		System.out.println("Enter " + size + " numbers in the array between 1 to 100:");
		int number;
		int visited = -1; // declaring an variable for showing that a particular element has been visited
							// in an Array

		for (int i = 0; i <= array.length - 1; i++) { // a for loop for asking user to enter values into the Array
			number = input.nextInt();
			if (number == -1) // if user enter -1 which suggest user doesn't want to enter further input of
								// values into an Array
				break;
			array[i] = number;
		}

		for (int i = 0; i <= array.length - 1; i++) { // an external for loop for accessing an entire Array
			int count = 1; // initializing count variable with default value 1
			for (int j = i + 1; j <= array.length - 1; j++) { // an internal for loop for comparison of element in an
																// Array
				if (array[i] == array[j]) { // condition for comparing values
					count++;
					temp[j] = visited;
				}
			}
			if (temp[i] != visited) { // condition for assigning count value
				temp[i] = count;
			}
		}

		for (int i = 0; i <= temp.length - 1; i++) { // a for loop for printing the occurrence of an number in the Array
			if (array[i] != 0) {  //condition for not counting value 0
				if (temp[i] != visited) {  
					System.out.println("The Number " + array[i] + " is repeated " + temp[i] + " times");
				}
			}
		}

		input.close();

	}
}
