package InterfaceDemo;

public class Employee implements Comparable{
	private int eId;
	private String eName;
	private double eSalary;
	public Employee(int eId, String eName, double eSalary) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSalary = eSalary;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSalary=" + eSalary + "]";
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Employee) {
			Employee e=(Employee)o;
			if(this.eId>e.eId) return 1;
			else if(this.eId==e.eId) return 0;
			else return -1;
		}
		return 0;
	}
	
}
