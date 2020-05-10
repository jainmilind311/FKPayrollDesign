public class DeleteEmp {
	public static void delEmp(int id) {
		if(EmployeeData.empList.containsKey(id)) {
			EmployeeData.empList.remove(id);
			System.out.println("Deleted!");
		}else {
			System.out.println("Does not exists!");
		}
		
	}

}
