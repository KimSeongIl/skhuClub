package calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class UpdateCalendarAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("id").trim());
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		
		
		CalendarData cal=new CalendarData();
		cal.setId(id);
		cal.setStart(start);
		cal.setEnd(end);
		
		CalendarBean dbPro=CalendarBean.getInstance();
		dbPro.updateCalendar(cal);
		
		
		
		
		return null;
	}
}
