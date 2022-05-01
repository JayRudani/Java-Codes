import java.util.Scanner;

public class TemperatureConverter {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the temperature in Fahrenheit:");
		float fahrenheit = input.nextFloat();
		float celcius = (fahrenheit - 32f) * (5f / 9f);
		System.out.println("The equivalent temperature in Celcius:" + celcius);
		input.close();

	}

}
