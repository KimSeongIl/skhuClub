package comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import action.CommandAction;
import java.util.*;


public class CommentWriteAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		int bid=Integer.parseInt(request.getParameter("bid"));
		HttpSession session=request.getSession();
		String uid=(String)session.getAttribute("id");
		String bdcontent=request.getParameter("bdcontent").replaceAll("\n", "<br>");
		CommentBean comment=CommentBean.getInstance();
		comment.insertComment(bid, uid, bdcontent);
		List commentList=comment.commentList(bid);
		
		
		request.setAttribute("comment", commentList);
		request.setAttribute("bid", bid);
		return "commentView.jsp";
	}
}
