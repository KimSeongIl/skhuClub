package action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardBean;

public class BoardInsertAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		String category=request.getParameter("category");
		String bTitle=request.getParameter("btitle");
		String bContent=request.getParameter("bcontent");
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		BoardBean board=BoardBean.getInstance();
		board.insertBoard(category,bTitle,bContent,id);
		
		request.setAttribute("category", category);
		
		return "boardInsert.jsp";
		
		
	}
}
