<%
String uid=(String)session.getAttribute("id");
if(uid==null){
	out.println("<script>alert('로그인 해주세요!')</script>");
	out.println("<script>location.href='main.do'</script>");
}
%>
<%@page import="java.util.*" %>
<%@page import="apply.ApplyData" %>
<div style="width:100%;padding-left:100px;">
<ul>
	<li style="float:left;margin-right:50px;"><a href="myPage.do">정보수정</a></li>
	<%String auth=(String)session.getAttribute("auth");
	  if(auth==null){%>
	<li style="float:left;"><a href="#">지원서 관리</a></li>
	<%}else{ %>
	<li style="float:left;"><a href="applicationManagement.do">지원서 관리</a></li>
	<%} %>
</ul>
</div>
<br>
<div id="article">
<center>
	<h1>지 원 서   관 리</h1>
	<table border width="100%">
		<tr>
			<th>동아리명</th>
			<th>학과</th>
			<th>학년</th>
			<th>소개</th>
			
			<th style="width:10%;"></th>
		</tr>
<%List<ApplyData> list=(ArrayList<ApplyData>)request.getAttribute("list");
 for(int i=0;i<list.size();i++){
	 out.println("<tr>");
 	out.println("<td>"+list.get(i).getClubName()+"</td>");
 	out.println("<td>"+list.get(i).getDepartment()+"</td>");
 	out.println("<td>"+list.get(i).getGrade()+"</td>");
 	out.println("<td>"+list.get(i).getIntroduction()+"</td>");
 	out.println("<td style='width:10%;text-align:center;' name="+list.get(i).getUid()+" clubname="+list.get(i).getClubName()+"><input type='button' class='btn btn-primary btn-sm applyModify' value='수정'>&nbsp;&nbsp;<input type='button' class='btn btn-default btn-sm applyDelete' value='삭제'></td>");
 	out.println("</tr>");
 }%>
 	</table>
 </center>
</div>