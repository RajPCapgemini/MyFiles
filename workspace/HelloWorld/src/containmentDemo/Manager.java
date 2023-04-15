package containmentDemo;

public class Manager extends Employee{
	private double travelallowance;
	private int trips;
	public Manager() {
		
	}
	public Manager(int eId,String eName,MyDate eDoj,double eSalary,double travelallowance, int trips) {
		super(eId,eName,eDoj,eSalary);
		this.travelallowance = travelallowance;
		this.trips = trips;
	}
	public double getTravelallowance() {
		return travelallowance;
	}
	public void setTravelallowance(double travelallowance) {
		this.travelallowance = travelallowance;
	}
	public int getTrips() {
		return trips;
	}
	public void setTrips(int trips) {
		this.trips = trips;
	}
	@Override
	public String toString() {
		return super.toString()+"Manager [travelallowance=" + travelallowance + ", trips=" + trips + "]";
	}
	public double computeSalary() {
		return eSalary+travelallowance;
	}
	
	public double getBonus() {
		System.out.print("Manager getting bonus ");
		return 4000;
	}
	
}
