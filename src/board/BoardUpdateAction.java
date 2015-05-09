package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;

public class BoardUpdateAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		String bid=request.getParameter("bid");
		BoardBean board=BoardBean.getInstance();
		BoardData bd=new BoardData();
		bd=board.viewBoard(bid);
		request.setAttribute("board", bd);
		
		return "boardWrite.jsp";
	}
}
