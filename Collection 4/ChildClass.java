class ParentClass {
	
	public void parentPrint()
	{
		System.out.println("This is going to be my parent class");
	}
}

public class ChildClass extends ParentClass{
	
	public void childPrint()
	{
		System.out.println("This is a child class that is being created");
	}
	public static void main(String[] args) {
		
		ParentClass p = new ParentClass();
		p.parentPrint();
		
		ChildClass c = new ChildClass();
		c.childPrint();
		
		c.parentPrint();
	}
}

