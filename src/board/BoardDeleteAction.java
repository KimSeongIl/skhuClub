package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;

public class BoardDeleteAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		String bid=request.getParameter("bid");
		String category=request.getParameter("category");
		BoardBean board=BoardBean.getInstance();
		
		board.deleteBoard(bid);
		request.setAttribute("category",category);
		
		return "boardDelete.jsp";
	}
}
