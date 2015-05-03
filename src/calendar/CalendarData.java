package calendar;

import java.sql.Timestamp;

public class CalendarData {

	private int id;
	private String title;
	private String start;
	private String end;
	private String color;
	
	public CalendarData(String title,String start,String end,String color){
		this.title=title;
		this.start=start;
		this.end=end;
		this.color=color;
	}
	public CalendarData(){
		
	}
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
	public void setStart(String start){
		this.start=start;
	}
	public Timestamp getStart(){
		return Timestamp.valueOf(start);
	}
	public void setEnd(String end){
		this.end=end;
	}
	public Timestamp getEnd(){
		return Timestamp.valueOf(end);
	}
	
	public void setColor(String color){
		this.color=color;
	}
	public String getColor(){
		return color;
	}
}
