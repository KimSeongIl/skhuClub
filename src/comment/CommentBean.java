package comment;

import java.util.*;
import conn.Conn;
import java.sql.*;

public class CommentBean {

	private static CommentBean instance=new CommentBean();

	public static CommentBean getInstance(){
		return instance;
	}
	private CommentBean(){

	}

	public List commentCount(int start,int end){
		List commentCount=new ArrayList();
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select b.bid,count(bdid) from board_comment c right outer join board b on c.bid=b.bid group by bid order by bid desc limit ?,?");){
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					do{
						CommentData cd=new CommentData();
						cd.setBid(rs.getInt(1));
						cd.setBdcount(rs.getInt(2));
						commentCount.add(cd);
					}while(rs.next());
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return commentCount;
	}
	public List commentList(int bid){
		List comment=new ArrayList();
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select bdid,uid,name,bdcontent,bddate from board_comment b join member m on b.uid=m.id where bid=? order by bddate desc");){
			pstmt.setInt(1, bid);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					do{
						CommentData cd=new CommentData();
						cd.setBdid(rs.getInt("bdid"));
						cd.setUid(rs.getString("uid"));
						cd.setName(rs.getString("name"));
						cd.setBdcontent(rs.getString("bdcontent"));
						cd.setBddate(rs.getTimestamp("bddate"));
						comment.add(cd);
					}while(rs.next());
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return comment;
	}

	public void insertComment(int bid,String uid,String bdcontent){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into board_comment(bid,uid,bdcontent) values(?,?,?)");){
			pstmt.setInt(1, bid);
			pstmt.setString(2, uid);
			pstmt.setString(3, bdcontent);
			pstmt.executeUpdate();


		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteComment(int bdid){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from board_comment where bdid=?");){

			pstmt.setInt(1, bdid);
			pstmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
