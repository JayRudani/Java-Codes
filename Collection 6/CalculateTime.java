import java.lang.*;

public class CalculateTime {

	public static void main(String[] args) {
		double milliseconds =(int) System.currentTimeMillis();
		System.out.println("Current time of the system in milliseconds:" + milliseconds);

		double totalseconds = (milliseconds / 1000);
		double minute = (totalseconds / 60);
		System.out.println(minute);
		double seconds= ((minute-(int)minute)*60);
		System.out.println("Total no of Seconds:"+totalseconds);
		System.out.println("The Time is "+(int)minute+" minutes and "+(int)seconds+" seconds");
	}

}
