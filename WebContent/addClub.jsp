﻿<%
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
	<li style="float:left;margin-right:50px;"><a href="#">지원서 관리</a></li>
	<%}else{ %>
	<li style="float:left;margin-right:50px;"><a href="applicationManagement.do">지원서 관리</a></li>
	<%}
	  if("관리자".equals(auth)){%>
		<li style="float:left;"><a href="addClub.do">동아리 추가</a></li>
		<%} %>
</ul>
</div>
<br>
<div id="article">
	<center>
		<h1>동 아 리 추 가</h1><br><hr>
		<div width="400px" >
		<form  action="clubInsert.do" class="form-inline" method="post" >
			<div class="form-group">
    			<label  >동아리 이름</label>&nbsp;
    			<input type="text" class="form-control" name="clubName" placeholder="Name">
  			</div><br><br><br>
  			<button type="submit" class="btn btn-primary">추가</button>
		</form>
		</div>
	</center>
</div>