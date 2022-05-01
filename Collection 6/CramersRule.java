/* Write a program explaining about cramers rule to find values of X and Y*/
public class CramersRule {

	public static void main(String[] args) {
		System.out.println("The equations are 3.4x+50.2y=44.5 and 2.1x+.55y=5.9"); // given equation

		float a = 3.4f, b = 50.2f, c = 2.1f, d = .55f, e = 44.5f, f = 5.9f; // values assigned to the variables as per
																			// cramer's rule

		float x = (((e * d) - (b * f)) / ((a * d) - (b * c))), y = (((a * f) - (e * c)) / ((a * d) - (b * c))); // equation
																												// to
																												// find
																												// values
																												// of x
																												// and y
																												// as
																												// per
																												// cramer's
																												// rule

		System.out.println("The value of x:" + x); // value of x
		System.out.println("The value of y:" + y); // value of y

	}

}
