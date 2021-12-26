public class DistanceFromtheCenter {

	public static void main(String[] args) {

		final double radius = 5; // declaring the radius of the circle
		double x = (Math.random() * radius); // generating a random point x in the circle
		double y = (Math.random() * radius); // generating a random point y in the circle

		double point1 = Math.sin(x); // determining the point lies in which quadrant and its sin value
		double point1inCircle = point1 * Math.PI; // multiplying with PI so that the point remain inside the circle

		double point2 = Math.cos(y); // determining the point lies in which quadrant and its cos value
		double point2inCircle = point2 * Math.PI; // multiplying with PI so that the point remain inside the circle


		double distance = Math.sqrt(Math.pow(point1inCircle, 2) + Math.pow(point2inCircle, 2)); // calculating the distance of the point from the center of the circle
		System.out.println("The Point is (" + point1inCircle + ", " + point2inCircle
				+ ") and its distance to the center is " + distance); // printing the distance of the point

	}

}
