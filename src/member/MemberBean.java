package member;

import conn.Conn;
import java.sql.*;

public class MemberBean {

	private static MemberBean instance=new MemberBean();
	
	public static MemberBean getInstance(){
		return instance;
	}
	private MemberBean(){
		
	}
	
	public MemberData getUserData(String id){
		MemberData md=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from member where id=?");){
			
			pstmt.setString(1, id);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					md=new MemberData();
					md.setId(rs.getString("id"));
					md.setName(rs.getString("name"));
					md.setPw(rs.getString("password"));
					md.setPhone(rs.getString("phone"));
					md.setSNum(rs.getInt("studentNum"));
					md.setEmail(rs.getString("email"));
					String authority=rs.getString("authority");
					if(authority==null){
						md.setAuthority("");	
					}
					else{
						md.setAuthority(authority);
					}
					
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return md;
	}
}
