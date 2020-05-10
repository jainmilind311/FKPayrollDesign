

import java.util.Calendar;

class Employee implements pay{

	protected String name;
	protected String address;
	protected boolean union;
	protected String mop;
	protected double unionCharge = 0;
	
	public Employee(String name, String address, boolean union, String mop, double unionCharge) {
		super();
		this.name = name;
		this.address = address;
		this.union = union;
		this.mop = mop;
		this.unionCharge = unionCharge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isUnion() {
		return union;
	}

	public void setUnion(boolean union) {
		this.union = union;
		if (this.union == false) {
			this.unionCharge = 0;
		}
	}

	public String getMop() {
		return mop;
	}

	public void setMop(String mop) {
		this.mop = mop;
	}

	@Override
	public boolean isPayDay(Calendar calendar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double calcPay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void unionDeduction(double amt) {
		// TODO Auto-generated method stub
		
	}

}

class HourlyEmp extends Employee {
	private double hSalary;
	private double balance;
	private double hours;
	
	

	@Override
	public String toString() {
		return "HourlyEmp [hSalary=" + hSalary + ", balance=" + balance + ", hours=" + hours + ", name=" + name
				+ ", address=" + address + ", union=" + union + ", mop=" + mop + ", unionCharge=" + unionCharge + "]";
	}

	public HourlyEmp(String name, String address, boolean union, String mop, double unionCharge, double hSalary) {
		super(name, address, union, mop, unionCharge);
		this.balance = 0.0;
		this.hours = 0.0;
		this.hSalary = hSalary;
	}

	public boolean isPayDay(Calendar calendar) {
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
			return true;
		return false;
	}

	@Override
	public double calcPay() {
		double temp = balance;
		balance = 0.0;
		return temp-unionCharge;
	}

	public void setTimeHour(double hours2) {
		this.hours = hours2;
		if (hours2 > 8.0) {
			balance += hours2 * hSalary * 1.5;

		} else {
			balance += hours2 * hSalary;
		}
		this.hours = 0;
	}

	@Override
	public void unionDeduction(double amt) {
		if(union) {
			unionCharge+=amt;
		}
		
	}
}

class SalariedEmp extends Employee{

	private double mSalary;
	private double balance;

	public SalariedEmp(String name, String address, boolean union, String mop, double unionCharge, double msalary) {
		super(name, address, union, mop, unionCharge);
		this.mSalary = msalary;
		this.balance = 0;
	}

	@Override
	public boolean isPayDay(Calendar calendar) {
		

		Calendar cal = Calendar.getInstance();
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
			lastDay--;
		case Calendar.SATURDAY:
			lastDay--;
		}
		return calendar.get(Calendar.DAY_OF_MONTH) == lastDay;

	}

	@Override
	public double calcPay() {
		double temp = unionCharge;
		unionCharge = 0;
		return mSalary-temp;
	}

	@Override
	public void unionDeduction(double amt) {
		if(union) {
			unionCharge+=amt;
		}
	}
	
	
}

class CommEmp extends Employee {

	private double mSalary;
	private double commRate;
	private double sales;
	private double balance;
	private boolean toPaySale = false;
	
	public CommEmp(String name, String address, boolean union, String mop, double unionCharge, double msalary, double commRate) {
		super(name, address, union, mop, unionCharge);
		this.mSalary = msalary;
		this.commRate = commRate;
		this.sales = 0.0;
	}

	@Override
	public boolean isPayDay(Calendar calendar) {
		
		Calendar cal = Calendar.getInstance();
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
			lastDay--;
		case Calendar.SATURDAY:
			lastDay--;
		}
		boolean endDay = false;
		boolean secFriday = false;
		if(calendar.get(Calendar.DAY_OF_MONTH) == lastDay) {
			endDay = true;
		}
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
			if(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 2) {
				secFriday = true;
				toPaySale = true;
			}
		}
		return (endDay||secFriday);
	}
	public void setSales(double sales) {
		this.sales += sales;
		balance+= sales*(commRate/100.0);
		
	}
	@Override
	public double calcPay() {
		if(toPaySale) {
			toPaySale = false;
			double temp = balance;
			balance = 0.0;
			sales = 0;
			temp-=unionCharge;
			unionCharge = 0;
			return temp;
		}else {
			double temp = unionCharge;
			unionCharge = 0;
			return mSalary-temp;
		}

	}

	@Override
	public void unionDeduction(double amt) {
		
		if(union) {
			unionCharge+=amt;
		}
	}
	
	
}

