class Member {

	private String name;
	private int age;
	private String phoneNumber;
	private String address;
	private double salary;

	public Member(String name, int age, String phoneNumber, String address, double salary) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.salary = salary;
	}

	public void printSalary() {
		System.out.println("The salary " + salary);
	}

	public String Detail() {
		return ("Name:" + name + "\nAge:" + age + "\nPhone Number:" + phoneNumber + "\nAddress:" + address);

	}
}

class Employee extends Member {

	private String specialization;
	private String department;

	public Employee(String name, int age, String phoneNumber, String address, double salary, String specialization,
			String department) {
		super(name, age, phoneNumber, address, salary);
		this.specialization = specialization;
		this.department = department;
	}

	public String Detail() {
		return (super.Detail() + "\nSpecialization:" + specialization + "\nDepartment:" + department);
	}
}

public class Manager extends Member {

	private String specialization;
	private String department;

	public Manager(String name, int age, String phoneNumber, String address, double salary, String specialization,
			String department) {
		super(name, age, phoneNumber, address, salary);
		this.specialization = specialization;
		this.department = department;
	}

	public String Detail() {
		return (super.Detail() + "\nSpecialization:" + specialization + "\nDepartment:" + department);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager m = new Manager("Jay",22,"1651651651","Ahmedabad-India",50000,"Java","IT");
		System.out.println("Detail of Manager");
		System.out.println(m.Detail());
		
		Employee e = new Employee("Krishna",20,"1651612312","Ahmedabad-India",25000,"Java","IT");
		System.out.println("\nDetail of Employee");
		System.out.println(e.Detail());
	}

}
