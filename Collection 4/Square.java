import java.util.Scanner;

class Rectangle { // declaration of Rectangle class

	private float length;  //declaration of length variable of type float
	private float breath;  //declaration of breath variable of type float
	
	public Rectangle(float length,float breath)  //declaration of constructor of Rectangle class with formal parameter
	{
		this.length=length;
		this.breath=breath;
	}
	
	public float calculateAreaofRectangle()  //declaration of calculateAreaofRectangle method
	{
		return (length*breath);
	}
	
	public float calculatePerimeterofRectangle()  //declaration of calculatePerimeterofRectangle method
	{
		return (2*(length+breath));
	}
}

public class Square extends Rectangle { // declaration of Square class which inherit Rectangle class

	private float side; // declaration of side variable of type float

	public Square(float side) // declaration of constructor of Square class with formal parameter
	{
		super(side, side); // calling constructor of Rectangle class
		this.side = side;
	}

	public float calculateAreaofSquare() // declaration of calculateAreaofSquare method
	{
		return (side * side);
	}

	public float calculatePerimeterofSquare() // declaration of calculatePerimeterofSquare method
	{
		return (4 * side);
	}

	public static void main(String[] args) { // declaration of main method
		// TODO Auto-generated method stub
		Square s = new Square(10); // declaration of object of Square class and calling constructor of Square class
									// with actual parameter
		System.out.println("Perimeter Of Square:" + s.calculatePerimeterofSquare());
		System.out.println("Area Of Square:" + s.calculateAreaofSquare());
		System.out.println("Perimeter Of Rectangle:" + s.calculatePerimeterofRectangle());
		System.out.println("Area Of Rectangle:" + s.calculateAreaofRectangle());

		Square s1[] = new Square[10]; // declaration of array of object of Square class
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < s1.length; i++) {
			System.out.println("\nEnter value of side for Square " + (i + 1) + ":");
			int side = input.nextInt();
			s1[i] = new Square(side); // calling constructor of Square class
			System.out.println("Area Of Square:" + s1[i].calculateAreaofSquare());
		}

		input.close();
	}

}
