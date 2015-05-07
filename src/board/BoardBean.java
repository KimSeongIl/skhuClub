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
	public List boardMain(String category){
		List boardList=null;
		BoardData board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select bid,name,btitle,bdate,inquiry from board b join member m on m.id=b.uid where category=?");){
				
				pstmt.setString(1, category);
				
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
			PreparedStatement pstmt=conn.prepareStatement("select * from board where bid=?");){
			
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
						board.setInquiry(rs.getInt("inquiry"));
						board.setCategory(rs.getString("category"));
						
						
					
				}
			}catch(Exception ee){}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return board;
	}
}
