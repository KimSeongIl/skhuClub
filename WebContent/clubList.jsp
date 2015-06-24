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
	
	padding-top:5px;
	width:250px;
	height:150px;
	border-radius:5px;
	border:3px solid #E3E3E3;
	
	text-align:center;
}
#club_list td{
	font-size:30px;
	
}
#club_list td:hover{
	cursor:pointer;
	cursor:hand;
	opacity:0.5;
	border:3px solid #337AB7;
	
}
</style>

<div id="article">
	
	<center>
	<h2>동 아 리</h2>
	<table id="club_list" >
	<%
		String han=URLEncoder.encode("한비");
		String kkoon=URLEncoder.encode("꾼");
		String mr=URLEncoder.encode("M.R.Crew");
		String iris=URLEncoder.encode("아이리스");
	%>
		<tr>
			<td onclick="location.href='introduce.do?club=<%=mr%>'"><img class="img-rounded" src="assets/image/ex.jpg" width="90%" height="90%"><br>M.R Crew</td>
			<td onclick="location.href='introduce.do?club=<%=kkoon%>'"><img class="img-rounded" src="assets/image/kkoon.jpg" width="90%" height="90%"><br>꾼</td>
			
		</tr>
		<tr>
			<td onclick="location.href='introduce.do?club=<%=han%>'"><img class="img-rounded" src="assets/image/han.jpg" width="90%" height="90%"><br>한비</td>
			<td onclick="location.href='introduce.do?club=<%=iris%>'"><img class="img-rounded" src="assets/image/iris.jpg" width="90%" height="90%"><br>아이리스</td>
		</tr>
		<% /* 
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
			*/
		%>
	</table>
	</center>
</div>