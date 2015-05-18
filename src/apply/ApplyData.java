package apply;

public class ApplyData {

	private String uid;
	private String grade;
	private String department;
	private String self_instroduction;
	private String club;
	
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
	public void setSelf_instroduction(String self_instroduction){
		this.self_instroduction=self_instroduction;
	}
	
	public String getGrade(){
		return grade;
	}
	
	public String getDepartment(){
		return department;
	}
	public String getSelf_instroduction(){
		return self_instroduction;
	}
	public void setClub(String club){
		this.club=club;
	}
	public String getClub(){
		return club;
	}
	
	
	
}
