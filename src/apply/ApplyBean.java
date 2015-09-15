package apply;

import conn.Conn;
import java.sql.*;
import java.util.*;



public class ApplyBean {

	private static ApplyBean instance=new ApplyBean();
	
	public static ApplyBean getInstance(){
		return instance;
	}
	
	private ApplyBean(){ 
		
	}
	
	public void insertApply(ApplyData app){
	  String uid=app.getUid();
	  String clubname=app.getClubName();
	  String grade=app.getGrade();
	  String department=app.getDepartment();
	  String instroduction=app.getInstroduction();

	  
	  try(
			  //디비연결
			  Connection conn=Conn.getConnection();
			  PreparedStatement pstmt=conn.prepareStatement("insert into application(uid,clubname,grade,department,introduction) values(?,?,?,?,?)");
			  //쿼리문 실행
			  //디비 인젝션을 방지 
			  
		 ){
		  pstmt.setString(1, uid);
		  pstmt.setString(2, clubname);
		  pstmt.setString(3, grade);
		  pstmt.setString(4,department);
		  pstmt.setString(5, instroduction);
		  
		  pstmt.executeUpdate();
		  
		  
		  
	  }catch (Exception e){
		  e.printStackTrace();
		  
	  }
	  
	  
		
	}
	
	
	
	
	
}
