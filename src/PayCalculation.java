import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class PayCalculation {
	public static void statement(Calendar calendar) {
		for(Integer key : EmployeeData.empList.keySet()) {
			Employee e = EmployeeData.empList.get(key);
			
			if(e.isPayDay(calendar)) {
				
				double amt = e.calcPay();
				String mop = e.mop;
				if(mop == "mail") {
					PayDataase.mail.put(key, amt);
				}else if(mop == "hold") {
					PayDataase.hold.put(key, amt);
				}else {
					PayDataase.deposit.put(key, amt);
				}
			}
		}
		String[] arr = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

		try
		{
		    String filename= "PayData.txt";
		    FileWriter fw = new FileWriter(filename); //the true will append the new data
		    fw.write("Date: " + calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/"
					+ calendar.get(Calendar.YEAR)+ " | Day: "+ arr[calendar.get(Calendar.DAY_OF_WEEK)-1]+ "\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
		try
		{
		    String filename= "PayData.txt";
		    FileWriter fw = new FileWriter(filename, true); //the true will append the new data
		    fw.write("________________________Employee Pay Data_________________________\n\n MAIL METHOD-------------->\n\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		for(Integer key: PayDataase.mail.keySet()) {
			int id = key;
			double amt = PayDataase.mail.get(key);
			try
			{
			    String filename= "PayData.txt";
			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
			    fw.write("Emp id: "+ id+ " Amount: "+ amt+"\n");//appends the string to the file
			    fw.close();
			}
			catch(IOException ioe)
			{
			    System.err.println("IOException: " + ioe.getMessage());
			}
			
		}
		try
		{
		    String filename= "PayData.txt";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("\n\nHOLD METHOD-------------->\n\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		for(Integer key: PayDataase.hold.keySet()) {
			int id = key;
			double amt = PayDataase.hold.get(key);
			try
			{
			    String filename= "PayData.txt";
			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
			    fw.write("Emp id: "+ id+ " Amount: "+ amt+"\n");//appends the string to the file
			    fw.close();
			}
			catch(IOException ioe)
			{
			    System.err.println("IOException: " + ioe.getMessage());
			}
			
		}
		try
		{
		    String filename= "PayData.txt";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("\n\nDEPOSIT METHOD-------------->\n\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		for(Integer key: PayDataase.deposit.keySet()) {
			int id = key;
			double amt = PayDataase.deposit.get(key);
			try
			{
			    String filename= "PayData.txt";
			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
			    fw.write("Emp id: "+ id+ " Amount: "+ amt+"\n");//appends the string to the file
			    fw.close();
			}
			catch(IOException ioe)
			{
			    System.err.println("IOException: " + ioe.getMessage());
			}
			
		}
		
		
		
	}
}
