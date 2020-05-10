
public class ViewAll {
	public static void viewEmp() {
		for(Integer key : EmployeeData.empList.keySet()) {
			Employee e = EmployeeData.empList.get(key);
			System.out.println("id: "+ key + " Name: " + e.name);
		}
	}
}
