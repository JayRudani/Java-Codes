public class AverageSpeed {

	public static void main(String[] args) {
		float totalmile = 24; // total mile
		float totalkilometer = totalmile * 1.6f; // total mile converted to kilometer

		System.out.println("Total time taken to run " + totalkilometer + "km is 1 Hour 40 Min 35 Sec"); // printing
																										// total
																										// kilometer the
																										// runner has
																										// covered in
																										// 1hr 40min
																										// 35sec

		float totalseconds = (1 * 60 * 60) + (40 * 60) + 35; // calculating total seconds taken by runner to completed
																// the run
		System.out.println("Total seconds taken to run " + totalkilometer + "km is " + totalseconds); // printing the
																										// total second
																										// taken by the
																										// runner

		float totalhour = totalseconds / 3600f; // calculating time taken by runner to complete the run in hour
		System.out.println("Total Hours taken to run " + totalkilometer + "km is " + totalhour); // printing total time
																									// taken in hours by
																									// runner

		float timetakenfor1km = totalhour / totalkilometer; // calculating total time taken to complete 1km run in hour
		System.out.println("Total hours taken to run 1km is " + timetakenfor1km); // printing total time taken to
																					// complete 1km run in hour

		float averagespeed = 1f / timetakenfor1km; // calculating the average speed of the runner in km/hr
		System.out.println("Average Speed of runner in km/hr:" + averagespeed); // printing the average speed of the
																				// runner

	}

}
