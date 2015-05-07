package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.BoardBean;
import java.util.*;

public class BoardAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		String category=request.getParameter("category");
		BoardBean board=BoardBean.getInstance();
		List boardList=board.boardMain(category);
		request.setAttribute("boardList", boardList);
		
		return "board.jsp";
	}
}
