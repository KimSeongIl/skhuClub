package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;

public class BoardUpdateSuccessAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		String bid=request.getParameter("bid");
		String bTitle=request.getParameter("btitle");
		String bContent=request.getParameter("bcontent");
		BoardBean board=BoardBean.getInstance();
		board.updateBoard(bid, bTitle, bContent);
		String category=request.getParameter("category");
		request.setAttribute("category", category);
		return "boardUpdate.jsp";
	}
}
