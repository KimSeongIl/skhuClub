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
						cal.setTitle(rs.getString("title"));
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
	public int insertCalendar(CalendarData cal){
		
		String title=cal.getTitle();
		String start=cal.getStart();
		String end=cal.getEnd();
		String color=cal.getColor();
		int number = 0;
		
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("SELECT id from calendar order by id desc limit 1");
				ResultSet rs=pstmt.executeQuery();
				
			){
			
			if(rs.next()){
				number=rs.getInt(1)+1;
			}
			else{
				number=1;
			}
			try(PreparedStatement pstmt2=conn.prepareStatement("insert into calendar values(?,?,?,?,?)");){
				pstmt2.setInt(1,number);
				pstmt2.setString(2, title);
				pstmt2.setString(3, start);
				pstmt2.setString(4,end);
				pstmt2.setString(5, color);
				pstmt2.executeUpdate();
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return number;
	}
	
	public void updateCalendar(CalendarData cal){
		int id=cal.getId();
		String start=cal.getStart();
		String end=cal.getEnd();
		
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update calendar set start=?,end=? where id=?");
			){
			
			pstmt.setString(1, start);
			pstmt.setString(2, end);
			pstmt.setInt(3,id);
			
			pstmt.executeUpdate();
			
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
			pstmt.executeUpdate();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
