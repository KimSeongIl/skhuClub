<%@page import="java.util.*"%>
<%@page import="club.ClubData"%>
<%@page import="java.net.*"%>
<style>
#club_list{
	max-width:700px;
	border-collapse:separate;
	border-spacing:50px;
}
#club_list td{
	width:250px;
	height:150px;
	border-radius:5px;
	
	border:1px solid black;
	text-align:center;
}

</style>

<div id="article">
	<center>
	<table id="club_list" ">
		<%
			List clubList = (List) request.getAttribute("clubList");
			if (clubList != null) {
				for (int i = 0; i < clubList.size(); i++) {
					if (i % 2 == 0) {

						out.println("<tr>");
					}
					ClubData cd = (ClubData) clubList.get(i);
					String name = cd.getName();
					String encodingName = URLEncoder.encode(name);
					out.println("<td><a href='introduce.do?club="
							+ encodingName + "'>" + name + "</a></td>");
					if (i!=0 && i % 2 == 1) {

						out.println("</tr>");
					}
				}
			}

			out.println("<br>");
			
		%>
	</table>
	</center>
</div>