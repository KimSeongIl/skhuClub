package apply;

import java.sql.Timestamp;

public class ApplyData {

	private String uid;
	private String name;
	private String phone;
	private String grade;
	private String department;
	private String introduction;
	private String clubname;
	private Timestamp applyDate;
	
	public void setUid(String uid){
		this.uid=uid;
	}
	public String getUid(){
		return uid;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setGrade(String grade){
		this.grade=grade;
		
	}
	public void setDepartment(String department){
		this.department=department;
	}
	public void setIntroduction(String introduction){
		this.introduction=introduction;
	}
	
	public String getGrade(){
		return grade;
	}
	
	public String getDepartment(){
		return department;
	}
	public String getIntroduction(){
		return introduction;
	}
	public void setClubName(String clubname){
		this.clubname=clubname;
	}
	public String getClubName(){
		return clubname;
	}
	public void setApplyDate(Timestamp ApplyDate){
		this.applyDate=applyDate;
	}
	public Timestamp getApplyDate(){
		return applyDate;
	}
	
	
	
}
