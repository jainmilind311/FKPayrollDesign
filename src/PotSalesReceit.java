
public class PotSalesReceit {
	public static void postSalesReceit(int id, double sales) {
		
		if(! EmployeeData.empList.containsKey(id)) {
			System.out.println("Employee Does not exists!");
			return;
		}
		Employee e = EmployeeData.empList.get(id);
		if(e instanceof CommEmp) {
			((CommEmp) e).setSales(sales);
		}else {
			System.out.println("The id does not correspond to Commission Employee");
		}
		
	}
}
