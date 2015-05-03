package calendar;

import java.sql.*;
import java.util.*;

import conn.Conn;

public class CalendarBean {
	private static CalendarBean instance=new CalendarBean();
	
	public static CalendarBean getInstance(){
		return instance;
	}
	private CalendarBean(){
		
	}
	
	
	public List viewCalendar(){
		CalendarData cal=null;
		List calList=null;
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from calendar");
			){
			
			
			
			try( ResultSet rs=pstmt.executeQuery(); ){
				if(rs.next()){
					calList=new ArrayList();
					do{
					cal = new CalendarData();
					cal.setId(rs.getInt("id"));
					cal.setTitle(rs.getString("name"));
					cal.setStart(rs.getString("start"));
					cal.setEnd(rs.getString("end"));
					cal.setColor(rs.getString("color"));
					calList.add(cal);
					}while(rs.next());
				}
			}catch(Exception ee){}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return calList;
	}
	public void insertCalendar(CalendarData cal){
		
		String title=cal.getTitle();
		Timestamp start=cal.getStart();
		Timestamp end=cal.getEnd();
		String color=cal.getColor();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into calendar values(?,?,?,?)");
			){
			
			pstmt.setString(1, title);
			pstmt.setTimestamp(2, start);
			pstmt.setTimestamp(3,end);
			pstmt.setString(4, color);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateCalendar(CalendarData cal){
		int id=cal.getId();
		Timestamp start=cal.getStart();
		Timestamp end=cal.getEnd();
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update calendar set start=?,end=? where id=?");
			){
			
			pstmt.setTimestamp(1, start);
			pstmt.setTimestamp(2, end);
			pstmt.setInt(3,id);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteCalendar(CalendarData cal){
		int id=cal.getId();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from calendar where id=?");
			){
			
			
			pstmt.setInt(1,id);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
