package board;

import java.sql.*;



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
	public int getSearchCount(String category,String value){
		int count=0;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) from board where category=? and (btitle like ? or bcontent like ? ) ")){
			
			pstmt.setString(1, category);
			pstmt.setString(2, "%"+value+"%");
			pstmt.setString(3, "%"+value+"%");
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
	public int getSearchNameCount(String category,String value){
		int count=0;
		
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) from board b join member m on b.uid=m.id where category=? and name like ?")){
			
			pstmt.setString(1, category);
			pstmt.setString(2, "%"+value+"%");
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
	public List boardSearch(String category,String value,int start,int end){
		List boardList=null;
		BoardData board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select bid,name,btitle,bdate,inquiry from board b join member m on m.id=b.uid where category=? and (btitle like ? or bcontent like ?)order by bid desc limit ?,?");){

			pstmt.setString(1, category);
			pstmt.setString(2, "%"+value+"%");
			pstmt.setString(3,"%"+value+"%");
			pstmt.setInt(4, start);
			pstmt.setInt(5, end);

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
	public List boardSearchName(String category,String value,int start,int end){
		List boardList=null;
		BoardData board=null;
		System.out.println(value);
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select bid,name,btitle,bdate,inquiry from board b join member m on m.id=b.uid where category=? and name like ? order by bid desc limit ?,?");){

			pstmt.setString(1, category);
			pstmt.setString(2, "%"+value+"%");
			
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);

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
	public void insertBoard(String category,String bTitle,String bContent,String uId,String fileName){

		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into board(uid,btitle,bContent,category,files) values(?,?,?,?,?)");){
 
			pstmt.setString(1, uId);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, category);
			pstmt.setString(5, fileName);
			pstmt.executeUpdate();


		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void increaseInquiry(int bId){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update board set inquiry=inquiry+1 where bid=?")){
			
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public BoardData viewBoard(int bId){

		BoardData board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select bid,uid,btitle,bcontent,bdate,files,name,category,inquiry from board b join member m on b.uid=m.id where bid=?");){

			pstmt.setInt(1, bId);

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
