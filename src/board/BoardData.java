package board;

import java.sql.Timestamp;

public class BoardData {
	private int bId;
	private String uId;
	private String uName;
	private String bTitle;
	private String bContent;
	private Timestamp bDate;
	private String files;
	private int inquiry;
	private String category;
	
	public void setBId(int bId){
		this.bId=bId;
	}
	public int getBId(){
		return bId;
	}
	public void setUId(String uId){
		this.uId=uId;
	}
	public String getUId(){
		return uId;
	}
	public void setUName(String uName){
		this.uName=uName;
	}
	public String getUName(){
		return uName;
	}
	public void setBTitle(String bTitle){
		this.bTitle=bTitle;
	}
	public String getBTitle(){
		return bTitle;
	}
	public void setBContent(String bContent){
		this.bContent=bContent;
	}
	public String getBContent(){
		return bContent;
	}
	public void setBDate(Timestamp bDate){
		this.bDate=bDate;
	}
	public Timestamp getBDate(){
		return bDate;
	}
	public void setFiles(String files){
		this.files=files;
	}
	public String getFiles(){
		return files;
	}
	public void setInquiry(int inquiry){
		this.inquiry=inquiry;
	}
	public int getInquiry(){
		return inquiry;
	}
	public void setCategory(String category){
		this.category=category;
	}
	public String getCategory(){
		return category;
	}
}
