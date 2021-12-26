import java.util.Scanner; //importing Scanner class 

public class ZellerCongurenceAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); // creating object for scanner class
		System.out.println("Enter Year:"); // prompt the user to enter year
		int year = input.nextInt();
		System.out.println("Enter Month:"); // prompt the user to enter month
		int m_month = input.nextInt();
		System.out.println("Enter Day of the Month:"); // prompt the user to enter day
		int q_day = input.nextInt();

		int j_century = (int) year / 100; // formula to obtain century value
		int k_year = year % 100; // formula to obtain year value

		int h_dayoftheweek;

		if (m_month == 1) // condition to check if entered value for month is 1
		{
			m_month = 13; // assigning value 13 for January due to assumption in this formula
			k_year = k_year - 1; // decreasing the value of year by 1 due to assumption in this formula

			h_dayoftheweek = (q_day + (int) ((26 * (m_month + 1)) / 10) + k_year + (int) (k_year / 4)
					+ (int) (j_century / 4) + (5 * j_century)) % 7; // formula for zeller's congruence algorithm

			switch (h_dayoftheweek) // switch case to print day of the week
			{
			case 1:
				System.out.println("Day of the Week is Sunday");
				break;
			case 2:
				System.out.println("Day of the Week is Monday");
				break;
			case 3:
				System.out.println("Day of the Week is Tuesday");
				break;
			case 4:
				System.out.println("Day of the Week is Wednesday");
				break;
			case 5:
				System.out.println("Day of the Week is Thrusday");
				break;
			case 6:
				System.out.println("Day of the Week is Friday");
				break;
			default:
				System.out.println("Day of the Week is Saturday");
				break;
			}
		} else if (m_month == 2) // condition to check if entered value for month is 2
		{
			m_month = 14; // assigning value 14 for January due to assumption in this formula
			k_year = k_year - 1; // decreasing the value of year by 1 due to assumption in this formula

			h_dayoftheweek = (q_day + (int) ((26 * (m_month + 1)) / 10) + k_year + (int) (k_year / 4)
					+ (int) (j_century / 4) + (5 * j_century)) % 7; // formula for zeller's congruence algorithm

			switch (h_dayoftheweek) // switch case to print day of the week
			{
			case 1:
				System.out.println("Day of the Week is Sunday");
				break;
			case 2:
				System.out.println("Day of the Week is Monday");
				break;
			case 3:
				System.out.println("Day of the Week is Tuesday");
				break;
			case 4:
				System.out.println("Day of the Week is Wednesday");
				break;
			case 5:
				System.out.println("Day of the Week is Thrusday");
				break;
			case 6:
				System.out.println("Day of the Week is Friday");
				break;
			default:
				System.out.println("Day of the Week is Saturday");
				break;
			}
		} else {
			h_dayoftheweek = (q_day + (int) ((26 * (m_month + 1)) / 10) + k_year + (int) (k_year / 4)
					+ (int) (j_century / 4) + (5 * j_century)) % 7; // formula for zeller's congruence algorithm

			switch (h_dayoftheweek) // switch case to print day of the week
			{
			case 1:
				System.out.println("Day of the Week is Sunday");
				break;
			case 2:
				System.out.println("Day of the Week is Monday");
				break;
			case 3:
				System.out.println("Day of the Week is Tuesday");
				break;
			case 4:
				System.out.println("Day of the Week is Wednesday");
				break;
			case 5:
				System.out.println("Day of the Week is Thrusday");
				break;
			case 6:
				System.out.println("Day of the Week is Friday");
				break;
			default:
				System.out.println("Day of the Week is Saturday");
				break;
			}
		}
		input.close();
	}

}
