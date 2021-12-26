import java.util.Random; //importing random class

public class ReturnRandomNumberMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b = 2, c = 3, d = 4, e = 5, f = 6, g = 7, h = 8, i = 9, j = 10; // declaring and assigning values to variables
		int randonNumber = getRandom(a, b, c, d, e, f, g, h, i, j); // calling method and passing actual parameter
		System.out.println("The Returned Random Number is " + randonNumber); // printing returned random number

	}

	public static int getRandom(int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8,
			int num9, int num10) { // declaration of method and its formal parameter

		Random r = new Random(); // creating object for random class
		int[] arr = { num1, num2, num3, num4, num5, num6, num7, num8, num9, num10 }; // declaring an array and storing
																						// the values in it

		int random = arr[r.nextInt(arr.length)]; // getting random number from array
		return random; // returning random
	}

}
