package calendar;

import java.sql.Timestamp;

public class CalendarBean {

	private int id;
	private String title;
	private Timestamp start;
	private Timestamp end;
	private String color;
	
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setStart(Timestamp start){
		this.start=start;
	}
	public Timestamp getStart(){
		return start;
	}
	public void setEnd(Timestamp end){
		this.end=end;
	}
	public Timestamp getEnd(){
		return end;
	}
	
	public void setColor(String color){
		this.color=color;
	}
	public String getColor(){
		return color;
	}
}
