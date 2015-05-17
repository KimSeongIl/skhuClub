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
	  String grade=app.getGrade();
	  String department=app.getDepartment();
	  String self_instroduction=app.getSelf_instroduction();
	  String club=app.getClub();
	  
	  try(
			  //디비연결
			  Connection conn=Conn.getConnection();
			  PreparedStatement pstmt=conn.prepareStatement("insert into apply(uid,grade,department,acontent,club) values(?,?,?,?,?)");
			  //쿼리문 실행
			  //디비 인젝션을 방지 
			  
		 ){
		  pstmt.setString(1, uid);
		  pstmt.setString(2, grade);
		  pstmt.setString(3, department);
		  pstmt.setString(4,self_instroduction);
		  pstmt.setString(5, club);
		  pstmt.executeUpdate();
		  
		  
		  
	  }catch (Exception e){
		  e.printStackTrace();
		  
	  }
	  
	  
		
	}
	
	
	
	
	
}
