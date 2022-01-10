public class DaysInAYear {  //declaration of class

	public static void main(String[] args) {  //declaration of main method
		// TODO Auto-generated method stub
		System.out.println("Year     Number of Days");  
		System.out.println();
		for(int i=2005;i<=2021;i++)  //for loop from year 2005 to 2021
		{
			int year=i;  
			int days=numberOfDaysInAYear(year);  //calling method and passing actual parameter
			System.out.println(year+"        "+days);  //printing year and number of days it has 
		}
	}
	public static int numberOfDaysInAYear(int year)  //declaration of method and its formal parameter
	{
		int day;
		//nested if condition to check whether the year is leap year or not
		if (year % 4 == 0) {  
			// if the year is century
		    if (year % 100 == 0) {
		    	// if year is divided by 400
		        // then it is a leap year
		        if (year % 400 == 0)
		          day=366;  //if leap year then it has 366 days
		        else
		          day=365;  //if regular year then it has 365 days
		        }
		    // if the year is not century
		    else
		        day=366;  //if leap year then it has 366 days
		    }
		else
			day=365;  //if regular year then it has 365 days
		return day;  //returning days a particular year has
	}
	
}
