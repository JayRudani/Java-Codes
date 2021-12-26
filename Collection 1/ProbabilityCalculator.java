public class ProbabilityCalculator {

	public static void main(String[] args) {

		final double squareHeight = 2; // declaring the length of each side of square
		int odd = 0; // for calculating each time a dart fall in the odd region
		for (int i = 0; i <= 1000000; i++) { // dart is thrown 1000000 times

			double x = Math.random() * (squareHeight) - 1; // generating a random point x in the square
			double y = Math.random() * (squareHeight) - 1; // generating a random point y in the sqaure

			if (x < 0) // if the dart falls in the region where value of x is negative
			{
				odd++; // hit in the odd region
			} else if (x > 0 && y > 0 && x < 1 && y < 1) // conforming the dart was thrown in the 1st part of square
			{
				double x1 = 1, x2 = 0, y1 = 0, y2 = 1; // declaring variables to calculate slope
				double z = (y2 - y1) * x + (x1 - x2) * y + (x2 * y1 - x1 * y2); // formula to known if the point is
																				// above or below the line
				if (z < 0) // if value of z<0 then the dart is the lower region of the line
				{
					odd++; // hit in the odd region
				}

			}
		}
		System.out.println("The total no of hits:" + odd); // printing the no of hits
		double probability = odd / 1000000d; // formula for calculating probability
		System.out.println("The probability of dart falling in the odd region in the square is:" + probability); // printing the probability of hit

	}

}
