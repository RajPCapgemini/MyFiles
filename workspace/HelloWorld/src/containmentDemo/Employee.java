package containmentDemo;

public class Employee {
	private int eId;
	private String eName;
	private MyDate eDoj;
//	private double eSalary;
	protected double eSalary;
	public Employee() {
		
	}
	public Employee(int eId,String eName,MyDate eDoj,double eSalary) {
		this.eId=eId;
		this.eName=eName;
		this.eDoj=eDoj;
		this.eSalary=eSalary;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public MyDate geteDoj() {
		return eDoj;
	}
	public void seteDoj(MyDate eDoj) {
		this.eDoj = eDoj;
	}
	public double geteSalary() {
		return eSalary;
	}
	public void seteSalary(double eSalary) {
		this.eSalary = eSalary;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eDoj=" + eDoj + ", eSalary=" + eSalary + "]";
	}
	
	public double computeSalary() {
		return eSalary;
	}
	
}
