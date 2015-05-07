package calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class DeleteCalendarAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("id").trim());
		
		
		
		CalendarData cal=new CalendarData();
		cal.setId(id);
		
		
		CalendarBean dbPro=CalendarBean.getInstance();
		dbPro.deleteCalendar(cal);
		
		
		
		
		return null;
	}
}
