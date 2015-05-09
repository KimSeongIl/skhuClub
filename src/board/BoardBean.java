package board;

import java.sql.*;
import java.util.ArrayList;

import calendar.CalendarData;
import conn.Conn;
import java.util.*;



public class BoardBean {
	private static BoardBean instance=new BoardBean();

	public static BoardBean getInstance(){
		return instance;
	}
	private BoardBean(){

	}
	public int getBoardCount(){
		int count=0;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) from board")){
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					count=rs.getInt(1);
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public List boardMain(String category,int start,int end){
		List boardList=null;
		BoardData board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select bid,name,btitle,bdate,inquiry from board b join member m on m.id=b.uid where category=? order by bid desc limit ?,?");){

			pstmt.setString(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			try( ResultSet rs=pstmt.executeQuery(); ){
				if(rs.next()){
					boardList=new ArrayList();
					do{
						board = new BoardData();
						board.setBId(rs.getInt("bid"));
						board.setUName(rs.getString("name"));
						board.setBTitle(rs.getString("btitle"));

						board.setBDate(rs.getTimestamp("bdate"));
						board.setInquiry(rs.getInt("inquiry"));
						
						boardList.add(board);

					}while(rs.next());
				}
			}catch(Exception ee){}
		}catch(Exception e){
			e.printStackTrace();
		}

		return boardList;
	}
	public void insertBoard(String category,String bTitle,String bContent,String uId){

		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into board(uid,btitle,bContent,category) values(?,?,?,?)");){

			pstmt.setString(1, uId);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, category);
			pstmt.executeUpdate();


		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public BoardData viewBoard(String bId){

		BoardData board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select bid,uid,btitle,bcontent,bdate,files,name,category from board b join member m on b.uid=m.id where bid=?");){

			pstmt.setString(1, bId);

			try( ResultSet rs=pstmt.executeQuery(); ){
				if(rs.next()){


					board = new BoardData();
					board.setBId(rs.getInt("bid"));
					board.setUId(rs.getString("uid"));
					board.setBTitle(rs.getString("btitle"));
					board.setBContent(rs.getString("bcontent"));
					board.setBDate(rs.getTimestamp("bdate"));
					board.setFiles(rs.getString("files"));
					board.setUName(rs.getString("name"));
					board.setCategory(rs.getString("category"));



				}
			}catch(Exception ee){}
		}catch(Exception e){
			e.printStackTrace();
		}

		return board;
	}

	public void updateBoard(String bid,String bTitle,String bContent){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update board set btitle=?, bcontent=? where bid=?");){

			pstmt.setString(1, bTitle);
			pstmt.setString(2, bContent);
			pstmt.setString(3, bid);
			pstmt.executeUpdate();


		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void deleteBoard(String bid){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from board where bid=?");){

			pstmt.setString(1, bid);
			pstmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
