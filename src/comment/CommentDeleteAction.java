package comment;

import java.io.PrintWriter;
import java.util.List;
import action.CommandAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommentDeleteAction implements CommandAction{
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		
		int bdid=Integer.parseInt(request.getParameter("bdid"));
		int bid=Integer.parseInt(request.getParameter("bid"));
		
		CommentBean comment=CommentBean.getInstance();
		comment.deleteComment(bdid);
		List commentList=comment.commentList(bid);
		
		request.setAttribute("comment", commentList);
		request.setAttribute("bid", bid);
		return "commentView.jsp";
	}
}
