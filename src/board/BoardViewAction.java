package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import comment.CommentBean;

public class BoardViewAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		int bid=Integer.parseInt(request.getParameter("bid"));
		BoardBean board=BoardBean.getInstance();
		BoardData bd=new BoardData();
		bd=board.viewBoard(bid);
		board.increaseInquiry(bid);
		
		CommentBean comment=CommentBean.getInstance();
		List commentList=comment.commentList(bid);
		
		request.setAttribute("board", bd);
		request.setAttribute("comment", commentList);
		
		return "boardView.jsp";
	}
}
