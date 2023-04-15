package containmentDemo;

public class SalesPerson extends Employee{
	private double sales;
	private double commission;
	public SalesPerson() {
		super();
		
	}
	public SalesPerson(int eId,String eName,MyDate eDoj,double eSalary,double sales,double commission) {
		super(eId,eName,eDoj,eSalary);
		this.sales=sales;
		this.commission=commission;
	}
	@Override
	public String toString() {
		return super.toString()+"SalesPerson [sales=" + sales + ", commission=" + commission + "]";
	}
	public double ComputeSalary() {
		return eSalary+ sales*commission;
	}
	
}
