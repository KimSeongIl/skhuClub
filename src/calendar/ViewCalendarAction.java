package calendar;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;
import java.util.*;

public class ViewCalendarAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		
		
		CalendarBean dbPro=CalendarBean.getInstance();
		List cal=dbPro.viewCalendar();
		
		request.setAttribute("cal", cal);
		
		
		return "viewCal.jsp";
		
		
	}
}
