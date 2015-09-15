package apply;

public class ApplyData {

	private String uid;
	private String grade;
	private String department;
	private String instroduction;
	private String clubname;
	
	public void setUid(String uid){
		this.uid=uid;
	}
	public String getUid(){
		return uid;
	}
	public void setGrade(String grade){
		this.grade=grade;
		
	}
	public void setDepartment(String department){
		this.department=department;
	}
	public void setInstroduction(String instroduction){
		this.instroduction=instroduction;
	}
	
	public String getGrade(){
		return grade;
	}
	
	public String getDepartment(){
		return department;
	}
	public String getInstroduction(){
		return instroduction;
	}
	public void setClubName(String clubname){
		this.clubname=clubname;
	}
	public String getClubName(){
		return clubname;
	}
	
	
	
}
