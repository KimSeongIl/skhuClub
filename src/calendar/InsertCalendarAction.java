package calendar;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import action.CommandAction;



public class InsertCalendarAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		String title=request.getParameter("title");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String color=request.getParameter("color");
		
		CalendarData cal=new CalendarData(title,start,end,color);
		
		CalendarBean dbPro=CalendarBean.getInstance();
		dbPro.insertCalendar(cal);
		
		
		
		
		return null;
	}
}
