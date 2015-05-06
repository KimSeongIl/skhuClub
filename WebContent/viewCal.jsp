<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="calendar.CalendarData"%>
<%
	List cal = (List) request.getAttribute("cal");
	if (cal != null) {
		for (int i = 0; i < cal.size(); i++) {
			CalendarData cd = (CalendarData) cal.get(i);
			out.print(cd.getId() + "<br>");
			out.print(cd.getTitle() + "<br>");
			out.print(cd.getStart() + "<br>");
			out.print(cd.getEnd() + "<br>");
			out.print(cd.getColor() + "<br>");
		}
	}
	
%>

	
