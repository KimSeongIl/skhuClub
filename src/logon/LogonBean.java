package logon;

import java.sql.*;
import member.MemberBean;
import conn.Conn;

public class LogonBean {

	private static LogonBean instance=new LogonBean();
	
	public static LogonBean getInstance(){
		return instance;
	}
	private LogonBean(){
		
	}
	
	
	
	public MemberBean userCheck(String id,String pw) throws Exception{
		
		MemberBean bean = null;
	
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from member where id=? and password=?");
			){
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			try( ResultSet rs=pstmt.executeQuery(); ){
				if(rs.next()){
					bean = new MemberBean();
					bean.setId(rs.getString("id"));
					bean.setName(rs.getString("name"));
					bean.setAuthority(rs.getString("authority"));
				}
			}catch(Exception ee){}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean;
	}
}
