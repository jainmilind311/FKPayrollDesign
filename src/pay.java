

import java.util.Calendar;

public interface pay {
	boolean isPayDay(Calendar calendar);
	double calcPay();
	void unionDeduction(double amt);
}
