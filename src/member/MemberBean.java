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
	
	public MemberData getMemberData(String id){
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
	
	public void modifyMember(MemberData md){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update member set password=?,name=?,phone=?,email=? where id=?");){
			
			pstmt.setString(1, md.getPw());
			pstmt.setString(2, md.getName());
			pstmt.setString(3, md.getPhone());
			pstmt.setString(4, md.getEmail());
			pstmt.setString(5, md.getId());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
