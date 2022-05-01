import java.util.Scanner;

class Time{
	
	Scanner input = new Scanner(System.in);
	
	double hour,minute,second;
	
	public Time()
	{
		System.out.println("Current Time:"+java.time.LocalTime.now());  
	}
	
	public Time(double e_Seconds)
	{
		hour=e_Seconds/3600000;
		minute=(hour-(int)hour)*60;
		second=(minute-(int)minute)*60;
		System.out.println("Elapsed Time since January 1, 1970:");
		System.out.println(+(int)hour+":"+(int)minute+":"+(int)second);
	}
	
	public int getHour() {
		System.out.println("Enter Number of Hour:");
		int hour=input.nextInt();
		return hour;
	}
	
	public int getMinute() {
		
		System.out.println("Enter Number of Minute:");
		int minute=input.nextInt();
		
		return minute;
	}
	
	public int getSecond() {
		System.out.println("Enter Number of Second:");
		int second=input.nextInt();
		return second;
	}
	
	public Time(int i_hour,int i_minute,int i_second) {
		hour=i_hour;
		minute=i_minute;
		second=i_second;
		if(second>=60)
		{
			int i=(int)second/60;
			minute=minute+i;
			second=(int)second%60;
		}
		if(minute>=60)
		{
			int i=(int)minute/60;
			hour=hour+i;
			minute=(int)minute%60;
		}
		System.out.println("Entered User Time:");
		System.out.println((int)hour+":"+(int)minute+":"+(int)second);
	}
	
	public void setTime(double i_elapsedTime) {
		hour=i_elapsedTime/3600000;
		minute=(hour-(int)hour)*60;
		second=(minute-(int)minute)*60;
		System.out.println("Time="+(int)hour+":"+(int)minute+":"+(int)second);
	}
}

public class MainTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		Time t1=new Time();
		
		double elapsedSeconds=System.currentTimeMillis();
		Time t2=new Time(elapsedSeconds);
		
		int hr=t1.getHour();
		int min=t2.getMinute();
		int sec=t2.getSecond();
		
		Time t3=new Time(hr,min,sec);
		
		System.out.println("Enter the elapsed time in millisecond:");
		double elapsedTime=input.nextDouble();
		t3.setTime(elapsedTime);
		
		input.close();
	}
}
