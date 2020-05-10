
public class PostTimeCard {
	public static void postTimeCard(int id, double hours) {
		if(! EmployeeData.empList.containsKey(id)) {
			System.out.println("Employee Does not exists!");
			return;
		}
		Employee e = EmployeeData.empList.get(id);
		if(e instanceof HourlyEmp) {
			((HourlyEmp) e).setTimeHour(hours);
		}else {
			System.out.println("The id does not correspond to Hourly Employee");
		}
	}
}
