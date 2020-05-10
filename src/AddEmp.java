


import java.util.Scanner;


public class AddEmp {

	public static HourlyEmp addHourlyEmp() {

		Scanner inp = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = inp.nextLine();
		System.out.println("Enter Address: ");
		String address = inp.nextLine();
		System.out.println("Part of union? Press 1 for Yes and 0 for no ");
		int no = inp.nextInt();
		boolean union = false;
		double unionCharge = 0;
		if (no == 1) {
			union = true;
			System.out.println("Union charge");
			unionCharge = inp.nextDouble();
		}else if(no!=0){
			System.out.println("Invalid input. Not registered in Union");
		}
		System.out.println("Method of payment?Enter 1/2/3 \n 1. Mail \n 2. Hold \n 3. Deposit");
		String mop;
		int no1 = inp.nextInt();
		switch (no1) {
		case 1:
			mop = "mail";
			break;
		case 2:
			mop = "hold";
			break;
		default:
			mop = "deposit";
			break;
		}
		System.out.println("Salary: ");
		double hSalary = inp.nextDouble();
		HourlyEmp emp = new HourlyEmp(name, address, union, mop, unionCharge, hSalary);
		return emp;

	}

	public static SalariedEmp addSalaried() {

		Scanner inp = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = inp.nextLine();
		System.out.println("Enter Address: ");
		String address = inp.nextLine();
		System.out.println("Part of union? Press 1 for Yes and 0 for no ");
		int no = inp.nextInt();
		boolean union = false;
		double unionCharge = 0;
		if (no == 1) {
			union = true;
			System.out.println("Union charge");
			unionCharge = inp.nextDouble();
		}else if(no!=0){
			System.out.println("Invalid input. Not registered in Union");
		}
		System.out.println("Method of payment?Enter 1/2/3 \n 1. Mail \n 2. Hold \n 3. Deposit");
		String mop;
		int no1 = inp.nextInt();
		switch (no1) {
		case 1:
			mop = "mail";
			break;
		case 2:
			mop = "hold";
			break;
		default:
			mop = "deposit";
			break;
		}
		System.out.println("Salary: ");
		double mSalary = inp.nextDouble();
		SalariedEmp emp = new SalariedEmp(name, address, union, mop, unionCharge, mSalary);
		return emp;

	}

	public static CommEmp addCommEmp() {

		Scanner inp = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = inp.nextLine();
		System.out.println("Enter Address: ");
		String address = inp.nextLine();
		System.out.println("Part of union? Press 1 for Yes and 0 for no ");
		int no = inp.nextInt();
		boolean union = false;
		double unionCharge = 0;
		if (no == 1) {
			union = true;
			System.out.println("Union charge");
			unionCharge = inp.nextDouble();
		}else if(no!=0){
			System.out.println("Invalid input. Not registered in Union");
		}
		System.out.println("Method of payment?Enter 1/2/3 \n 1. Mail \n 2. Hold \n 3. Deposit");
		String mop;
		int no1 = inp.nextInt();
		switch (no1) {
		case 1:
			mop = "mail";
			break;
		case 2:
			mop = "hold";
			break;
		default:
			mop = "deposit";
			break;
		}
		System.out.println("Salary: ");
		double mSalary = inp.nextDouble();
		System.out.println("Commission Rate (How many %): ");
		double commRate = inp.nextDouble();
		CommEmp emp = new CommEmp(name, address, union, mop, unionCharge, mSalary, commRate);
		return emp;

	}

	public static int addEmp(int typeOfEmp)  {

		Employee e;
		
		if(typeOfEmp == 1) {
			e = addHourlyEmp();
			System.out.println("Hourly Employee Created");
		}else if(typeOfEmp == 2) {
			e = addSalaried();
			System.out.println("Salaried Employee Created");
		}else {
			e = addCommEmp();
			System.out.println("Commissioned Employee Created");
		}
		
		int sizeOfMap = EmployeeData.empList.size();
		EmployeeData.empList.put(sizeOfMap+1, e);
		
		return typeOfEmp;
		
		

		
	}

}
