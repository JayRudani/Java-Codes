import java.util.Scanner;

class Customer {

	Scanner input = new Scanner(System.in);

	// declaring variables and arrays
	int id;
	String phone;
	String name;
	String email;
	String postal;
	int customer_id[];
	String customer_phone[];
	String customer_name[];
	String customer_email[];
	String customer_postal[];

	// no arg constructor
	public Customer() {

	}

	// constructor for initializing array
	public Customer(int customer_id[], String customer_name[], String customer_phone[], String customer_email[],
			String customer_postal[]) {

		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
		this.customer_email = customer_email;
		this.customer_postal = customer_postal;

	}

	// method generating customer id making sure it is unique
	public int generateID() {

		int i;
		for (i = 1; i <= customer_id.length; i++) {
			if (customer_id[i] == 0) {
				break;
			}
		}

		return i;
	}

	// method for getting the customer's name
	public String getName() {

		System.out.printf("Enter customer's name: ");
		name = input.next();
		return name;
	}

	// method for getting customer's phone number
	public String getPhone() {

		System.out.printf("Enter customer phone number: ");
		do {
			phone = input.next();
			if (phone.length() != 10)
				System.out.println("Enter your 10-digit phone number:");
		} while (phone.length() != 10);
		return phone;
	}

	// method for getting customer's email address
	public String getEmail() {

		System.out.printf("Enter customer email: ");
		email = input.next();
		return email;
	}

	// method for getting customer's postal code
	public String getPostal() {

		System.out.printf("Enter customer postal code: ");
		postal = input.next();
		return postal;
	}

	// method to get customer whose information is to be modified
	public int getCustomer() {

		System.out.println("Select a customer to modify it's detail:");
		int count = 0;
		for (int i = 0; i < customer_id.length; i++) {
			if (customer_id[i] != 0) {
				System.out.println(customer_id[i] + ":" + customer_name[i]);
				count++;
			}
		}
		System.out.println("Enter your choice:");
		byte choice;

		do {
			choice = input.nextByte();
			if (choice < 1 || choice > count)
				System.out.println("Please enter a valid choice:");
		} while (choice < 1 || choice > count);

		return choice;
	}

	// method to list all the customer
	public void listcustomer() {

		System.out.println("List of all the customer:\n");
		for (int i = 0; i < customer_id.length; i++) {

			if (customer_id[i] != 0) {
				System.out.println("Customer ID:" + customer_id[i]);
				System.out.println("Customer Name:" + customer_name[i]);
				System.out.println("Customer Phone:" + customer_phone[i]);
				System.out.println("Customer Email:" + customer_email[i]);
				System.out.println("Customer Postal:" + customer_postal[i]);
				System.out.println("-------------------------------------------------");
			}
		}
	}

}

public class CustomerManagementApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		// declaring arrays
		int customer_id[] = new int[5];
		String customer_phone[] = new String[5];
		String customer_name[] = new String[5];
		String customer_email[] = new String[5];
		String customer_postal[] = new String[5];

		// entering default values
		customer_id[0] = 1;
		customer_name[0] = "Jay";
		customer_phone[0] = "1325103211";
		customer_email[0] = "jay@gmail.com";
		customer_postal[0] = "NY02JH";

		customer_id[1] = 2;
		customer_name[1] = "Nic";
		customer_phone[1] = "1265168921";
		customer_email[1] = "nic@gmail.com";
		customer_postal[1] = "NF05HD";
		
		byte count=2;
		byte choice;
		do {
			if (count==customer_id.length)
				break;

			System.out.println("-------------------------------------------------");
			System.out.println("Choose an Action:");
			System.out.println("1.Add new customer");
			System.out.println("2.Find and Modify existing customer:");
			System.out.println("3.List all the customer:");
			System.out.println("4.Exit");
			System.out.println("Enter your choice(1,2,3,4):");

			do {
				choice = input.nextByte();
				if(choice==1)
					count++;
				if (choice < 1 || choice > 4)
					System.out.println("Please enter a valid choice(1,2,3,4):");
			} while (choice < 1 || choice > 4);

			// if user wants to add new customer
			if (choice == 1) {

				Customer c1 = new Customer(customer_id, customer_name, customer_phone, customer_email, customer_postal);

				int id = c1.generateID();
				String name = c1.getName();
				String phone = c1.getPhone();
				String email = c1.getEmail();
				String postal = c1.getPostal();

				customer_id[id] = id + 1;
				customer_name[id] = name;
				customer_phone[id] = phone;
				customer_email[id] = email;
				customer_postal[id] = postal;
				System.out.println("Data Added Successfully!!!");

			}
			// if user wants to modify existing customer
			else if (choice == 2) {

				Customer c1 = new Customer(customer_id, customer_name, customer_phone, customer_email, customer_postal);

				int selected_customer = c1.getCustomer();

				System.out.println("What do you want to change?");
				System.out.println("1.Name");
				System.out.println("2.Phone");
				System.out.println("3.Email");
				System.out.println("4.Postal Code");
				System.out.println("5.Every Detail");
				System.out.println("Enter your choice:");

				byte change_choice;
				do {
					change_choice = input.nextByte();
					if (change_choice < 1 || change_choice > 5)
						System.out.println("Please enter a valid choice(1,2,3,4,5):");
				} while (change_choice < 1 || change_choice > 5);

				if (change_choice == 1) {

					String name = c1.getName();
					System.out.println(name);
					customer_name[selected_customer - 1] = name;

				} else if (change_choice == 2) {

					String phone = c1.getPhone();
					customer_phone[selected_customer - 1] = phone;

				} else if (change_choice == 3) {

					String email = c1.getEmail();
					customer_phone[selected_customer - 1] = email;

				} else if (change_choice == 4) {

					String postal = c1.getPostal();
					customer_phone[selected_customer - 1] = postal;

				} else if (change_choice == 5) {

					String name = c1.getName();
					String phone = c1.getPhone();
					String email = c1.getEmail();
					String postal = c1.getPostal();
					customer_phone[selected_customer - 1] = name;
					customer_phone[selected_customer - 1] = phone;
					customer_phone[selected_customer - 1] = email;
					customer_phone[selected_customer - 1] = postal;
				}

			}
			// if user wants to print list of all the customer
			else if (choice == 3) {

				Customer c1 = new Customer(customer_id, customer_name, customer_phone, customer_email, customer_postal);
				c1.listcustomer();
			}

		} while (choice != 4);

		System.out.println("List of all the customer:\n");
		for (int i = 0; i < customer_id.length; i++) {

			System.out.println("Customer ID:" + customer_id[i]);
			System.out.println("Customer Name:" + customer_name[i]);
			System.out.println("Customer Phone:" + customer_phone[i]);
			System.out.println("Customer Email:" + customer_email[i]);
			System.out.println("Customer Postal:" + customer_postal[i]);
			System.out.println("-------------------------------------------------");
		}

		System.out.println("Goodbye!!!");

		input.close();
	}

}
