package calendar;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class SelectCalendarAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		
		
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		
		
		return "select.jsp";
		
		
	}
}
