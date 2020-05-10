
public class PostAUnionCharge {
	public static void postUnionCharge(double amt) {
		for(Integer key : EmployeeData.empList.keySet()) {
			Employee e =  EmployeeData.empList.get(key);
			e.unionDeduction(amt);
		}
	}
}
