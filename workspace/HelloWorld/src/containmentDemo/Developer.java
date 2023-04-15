package containmentDemo;

public class Developer extends Employee{
	private int projectId;
	private int experience;
	Developer(){
		super();
	}
	public Developer(int eId,String eName,MyDate eDoj,double eSalary,int projectId,int experience) {
		super(eId,eName,eDoj,eSalary);
		this.projectId=projectId;
		this.experience=experience;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return super.toString()+"Developer [projectId=" + projectId + ", experience=" + experience + "]";
	}
	
}
