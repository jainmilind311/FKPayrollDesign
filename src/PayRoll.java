import java.util.Calendar;
import java.util.Scanner;

public class PayRoll {
	public static void runApp() {
		Calendar calendar = Calendar.getInstance();
		String[] arr = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		while(true) {
			
			System.out.println("Date: " + calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/"
					+ calendar.get(Calendar.YEAR)+ " | Day: "+ arr[calendar.get(Calendar.DAY_OF_WEEK)-1]+ "\n");
			System.out.println("_________Enter the operation you want to perform: _________\n");
			System.out.println("# Add Employee                            - Press 1");
			System.out.println("# Delete Employee                         - Press 2");
			System.out.println("# Post a Time Card                        - Press 3");
			System.out.println("# Post a Sales Receipt                    - Press 4");
			System.out.println("# Post a Service charge for union members - Press 5");
			System.out.println("# Run the payroll                         - Press 6");
			System.out.println("# View All Employees                      - Press 7");
			System.out.println("# Advance next day                        - Press 8");
			System.out.println("Press 0 for exit");
			System.out.println("__________________________________________\n");
			System.out.print("Enter the choice: ");
			Scanner inp = new Scanner(System.in);
			int response = 0;
			if (inp.hasNextInt()) {
				response = inp.nextInt();
				if (response > 8) {
					System.out.println("Invalid response");
					continue;
				}
			} else {
				System.out.println("Invalid response!");
				continue;
			}
			
			if(response==1) {
				System.out.println("Enter the type of Employee");
				System.out.println("1. Hourly\n 2. Salaried \n 3. Commissioned");
				int res = 0;
				if (inp.hasNextInt()) {
					res = inp.nextInt();
					if (res > 3||res<1) {
						System.out.println("Invalid response");
						continue;
					}
				} else {
					System.out.println("Invalid response!");
					continue;
				}
				
				
				System.out.println("Added with id: "+ AddEmp.addEmp(res));
			}else if(response == 2) {
				System.out.println("Enetr Employee id");
				int res = 0;
				if (inp.hasNextInt()) {
					res = inp.nextInt();
				} else {
					System.out.println("Invalid response!");
					continue;
				}
				DeleteEmp.delEmp(res);
			}else if(response == 3){
				System.out.println("Enetr employee id");
				int res = 0;
				if (inp.hasNextInt()) {
					res = inp.nextInt();
				} else {
					System.out.println("Invalid response!");
					continue;
				}
				double hours = 0;
				System.out.println("Enter hours");
				if (inp.hasNextDouble()) {
					hours = inp.nextDouble();
				} else {
					System.out.println("Invalid response!");
					continue;
				}
				PostTimeCard.postTimeCard(res, hours);
			}else if(response == 4) {
				System.out.println("_________Sales Recipt: _________\n");
				System.out.println("Enter the id");
				int res = 0;
				if (inp.hasNextInt()) {
					res = inp.nextInt();
				} else {
					System.out.println("Invalid response!");
					continue;
				}
				double sales = 0;
				System.out.println("Enter Sales amount");
				if (inp.hasNextDouble()) {
					sales = inp.nextDouble();
				} else {
					System.out.println("Invalid response!");
					continue;
				}
				PotSalesReceit.postSalesReceit(res, sales);
				
			}else if(response == 5) {
				System.out.println("_________Post a Service Charge for union members:  _________\n");
				System.out.println("Enter the id");
				int res = 0;
				if (inp.hasNextInt()) {
					res = inp.nextInt();
				} else {
					System.out.println("Invalid response!");
					continue;
				}
				double amt = 0;
				System.out.println("Enter Service Charge amount");
				if (inp.hasNextDouble()) {
					amt = inp.nextDouble();
				} else {
					System.out.println("Invalid response!");
					continue;
				}
				PotSalesReceit.postSalesReceit(res, amt);
			}else if(response == 6) {
				PayCalculation.statement(calendar);
				System.out.println("The data is generated. Please check the generated PayData.txt file");
			}else if(response == 7){
				ViewAll.viewEmp();
			}else if(response == 8){
				System.out.println("Advancing next day.....");
			}else {
				System.out.println("Thank You.");
				break;
			}
			
			calendar.add(Calendar.DATE, 1);
			
		}
		
		
	}
}
