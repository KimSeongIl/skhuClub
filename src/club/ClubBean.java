package club;

import conn.Conn;


import java.sql.*;
import java.util.*;

public class ClubBean {

	private static ClubBean instance=new ClubBean();

	public static ClubBean getInstance(){
		return instance;
	}

	private ClubBean(){

	}
	public void insertClubExplain(ClubData cl){
		
		String homepage=cl.getHomePage();
		String clubexplain=cl.getClubExplain();
		String clubevent=cl.getClubEvent();
		
		
		try(
			Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into club(homepage,clubexplain,clubevent) values(?,?,?)");
				){
			pstmt.setString(1, homepage);
			pstmt.setString(2,clubexplain);
			pstmt.setString(3,clubevent);
			pstmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	public int addClub(String name){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into club(name) values (?);");){
			pstmt.setString(1, name);
			pstmt.executeUpdate();

			return 1;
		}catch(Exception e){
			return 2;
		}
	}

	public List clubList(){
		List clubList=null;
		ClubData cd=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select name from club");){
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					clubList=new ArrayList();
					do{
						cd=new ClubData();
						cd.setName(rs.getString("name"));
						clubList.add(cd);

					}while(rs.next());
				}

			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return clubList;
	}
	
}