
public class Initialise {
	public static void initialise() {
		HourlyEmp he1 = new HourlyEmp("Ram Singh", "Delhi", true, "mail", 1500.0, 500.0);
		SalariedEmp se1 = new SalariedEmp("Gabbar Singh", "Bangalore", false, "deposit", 0, 1500000);
		CommEmp ce1 = new CommEmp("Rekha", "Assam", true, "hold", 1000.0, 200000, 20);
		HourlyEmp he2 = new HourlyEmp("Rohit Sharma", "Mumbai", false, "deposit", 0, 780.0);
		SalariedEmp se2 = new SalariedEmp("Sheela Giure", "Bangalore", false, "deposit", 0, 1500000);
		CommEmp ce2 = new CommEmp("Suhas", "Indore", true, "deposit", 1000.0, 800000, 15);
		
		EmployeeData.empList.put(1, he1);
		EmployeeData.empList.put(2, ce1);
		EmployeeData.empList.put(3, se1);
		EmployeeData.empList.put(4, ce2);
		EmployeeData.empList.put(5, he2);
		EmployeeData.empList.put(6, se2);
	}
}
