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
				PreparedStatement pstmt=conn.prepareStatement("select name,image from club");){
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					clubList=new ArrayList();
					do{
						cd=new ClubData();
						cd.setName(rs.getString("name"));
						cd.setImage(rs.getString("image"));
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

	public void updateClubExplain(ClubData cl){

		String name=cl.getName();
		String homepage=cl.getHomePage();
		String clubexplain=cl.getClubExplain();
		String clubevent=cl.getClubEvent();
		String image=cl.getImage();
		System.out.println(name);
		System.out.println(homepage);
		System.out.println(clubevent);
		System.out.println(image);
		


		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update club set homepage=?,clubexplain=?,clubevent=?,image=? where name=?");
				){

			pstmt.setString(1, homepage);
			pstmt.setString(2,clubexplain);
			pstmt.setString(3,clubevent);
			pstmt.setString(4,image);
			pstmt.setString(5,name);
			pstmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public ClubData viewClub(String name){
		ClubData club=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select c.name,m.name,phone,homepage,clubexplain,clubevent,image from club c left outer join member m on c.name=m.authority where c.name=? ");){

			pstmt.setString(1, name);

			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					club=new ClubData();
					club.setName(rs.getString("c.name"));
					club.setHomePage(rs.getString("homepage"));
					club.setClubExplain(rs.getString("clubexplain"));
					club.setClubEvent(rs.getString("clubevent"));
					club.setImage(rs.getString("image"));
					club.setMember(rs.getString("m.name"));
					club.setPhone(rs.getString("phone"));

				}
			}catch(Exception ee){}
		}catch(Exception e){
			e.printStackTrace();
		}

		return club;
	}


}