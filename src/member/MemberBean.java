package member;

import club.ClubData;
import conn.Conn;

import java.sql.*;
import java.util.*;


public class MemberBean {

	private static MemberBean instance=new MemberBean();
	
	public static MemberBean getInstance(){
		return instance;
	}
	private MemberBean(){
		
	}
	
	public List memberList(){
		List list=new ArrayList<MemberData>();
		MemberData md=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select id,studentNum,name,phone,email,authority from member");){
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					do{
						md=new MemberData();
						md.setId(rs.getString("id"));
						md.setSNum(rs.getInt("studentNum"));
						md.setName(rs.getString("name"));
						md.setPhone(rs.getString("phone"));
						md.setEmail(rs.getString("email"));
						md.setAuthority(rs.getString("authority"));
						list.add(md);

					}while(rs.next());
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void memberAuthModify(String clubName,String uid){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update member set authority=null where authority=?");
				){
			pstmt.setString(1, clubName);
			pstmt.executeUpdate();
			PreparedStatement pstmt2=conn.prepareStatement("update member set authority=? where id=?");
			pstmt2.setString(1, clubName);
			pstmt2.setString(2, uid);
			pstmt2.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
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
	

	
	public void insertMember(MemberData mem){
		
		String id=mem.getId();
		String password=mem.getPw();
		int studentNum=mem.getSNum();
		String name=mem.getName();
		String phone=mem.getPhone();
		String email=mem.getEmail();
		
		try(
			//디비 연결 
			Connection conn=Conn.getConnection();
			PreparedStatement pstmt=conn.prepareStatement("insert into member(id,password,studentNum,name,phone,email) values(?,?,?,?,?,?)");
				//쿼리문 실행	
				//디비 인젝션을 방지 
		){
			pstmt.setString(1, id);
			pstmt.setString(2,password);
			pstmt.setInt(3, studentNum);
			pstmt.setString(4, name);
			pstmt.setString(5, phone);
			pstmt.setString(6,email);
			pstmt.executeUpdate();//executeUpdate()는 insert delete update 명령문을 이용할때 사용 
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	
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

	public int overlapCheck(String id){
		int check=0;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from member where id=?");){
			
			pstmt.setString(1, id);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					check=1;
				}
				else{
					check=2;
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return check;
	}
	
	public void memberDelete(String uid){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from member where id=?");){
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
