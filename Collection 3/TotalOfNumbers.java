import java.util.Scanner;

public class TotalOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter String of all number for which total is to be calculated:");
		String str=input.nextLine();
		int total=0;
		String s="";
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)!=' ')
			{
				s=s+Character.toString(str.charAt(i));
			}
			if(str.charAt(i)==' ' || i==str.length()-1)
			{
				int j=Integer.parseInt(s);
				total=total+j;
				s="";
			}
		}
		System.out.println("Total of all the Number:"+total);
		input.close();

	}

}
