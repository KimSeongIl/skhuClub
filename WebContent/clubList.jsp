<%@page import="java.util.*" %>
<%@page import="club.ClubData" %>
<%@page import="java.net.*" %>
<%
	List clubList=(List)request.getAttribute("clubList");
	if(clubList!=null){
		for(int i=0;i<clubList.size();i++){
			if(i!=0 && i%3==0){
				out.println("<br>");
			}
			ClubData cd=(ClubData)clubList.get(i);
			String name=cd.getName();
			String encodingName=URLEncoder.encode(name);
			out.println("<a href='introduce.do?name="+encodingName+"'>"+name+"</a>&nbsp;&nbsp;");
		}
	}
	
	out.println("<br>");
	out.println("<input type='button' value='닫기' onclick='clubListClose()' class='btn btn-default-sm'>");
%>