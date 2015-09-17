<%
if(session.getAttribute("id")==null){
	out.println("<script>alert('로그인 해주세요!')</script>");
	out.println("<script>history.back()</script>");
}
String club=request.getParameter("club");%>
<%@ page import="java.util.*" %>
<%@ page import="apply.ApplyData" %>
	<script src=""></script>
	<div id="article">
	<center>
	<h1>지 원 서 관 리</h1>
	<table>
	
	<tr>
	<th>작성자</th>
	<th>##</th>
	<th>작성일</th>
	<th>##</th>
    
    <%List<ApplyData> list=(ArrayList<ApplyData>)request.getAttribute("list");
 for(int i=0;i<list.size();i++){
	out.println("<tr>");
 	out.println("<td>"+list.get(i).getIntroduction()+"</td>");
 	out.println("</tr>");
 }%>
	
	
	</table>
	</center>
	</div>