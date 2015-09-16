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
	  String instroduction=app.getIntroduction();

	  
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
	public List getApplyAdmin(ApplyData data){
		List list=null;
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select uid,(select name from member where id=uid) name,(select phone from member where id=uid) phone,clubname,grade,department,introduction,applydate from application where clubname=?;");){
				pstmt.setString(1, data.getClubName());
			try(ResultSet rs=pstmt.executeQuery();){
				list=new ArrayList<ApplyData>();
				if(rs.next()){
					do{
						ApplyData app=new ApplyData();
						app.setUid(rs.getString("uid"));
						app.setName(rs.getString("name"));
						app.setPhone(rs.getString("phone"));
						app.setClubName(rs.getString("clubname"));
						app.setGrade(rs.getString("grade"));
						app.setDepartment(rs.getString("department"));
						app.setIntroduction(rs.getString("introduction"));
						app.setApplyDate(rs.getTimestamp("applydate"));
						
						list.add(app);
					}while(rs.next());
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	public int deleteApplication(ApplyData data){
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from application where uid=? and clubname=?");
				
				){
			pstmt.setString(1,data.getUid());
			pstmt.setString(2, data.getClubName());
			
			pstmt.executeUpdate();
			return 1;
		}catch(Exception e){
			return 2;
		}
	}
	
	
	
	
	
}
