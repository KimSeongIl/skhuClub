package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;

public class BoardUpdateAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		int bid=Integer.parseInt(request.getParameter("bid"));
		String category=request.getParameter("category");
		BoardBean board=BoardBean.getInstance();
		BoardData bd=new BoardData();
		bd=board.viewBoard(bid);
		request.setAttribute("board", bd);
		request.setAttribute("category", category);
		return "boardWrite.jsp";
	}
}
