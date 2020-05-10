import java.util.HashMap;
import java.util.Map;
class cluster{
	protected Employee e;
	protected double amt;
	public cluster(Employee e, double amt) {
		this.e = e;
		this.amt = amt;
	}
	@Override
	public String toString() {
		return "e=" + e + ", amt=" + amt + "]";
	}
	
}
public class PayDataase {
	public static Map<Integer, Double> deposit = new HashMap<>();
	public static Map<Integer, Double> hold = new HashMap<>();
	public static Map<Integer, Double> mail = new HashMap<>();
}
