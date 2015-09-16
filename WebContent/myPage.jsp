<%
String uid=(String)session.getAttribute("id");
if(uid==null){
	out.println("<script>alert('로그인 해주세요!')</script>");
	out.println("<script>location.href='main.do'</script>");
}
%>
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
<script src="assets/js/signUp.js"></script>
<%@page import="member.MemberData" %>

<div id="article">
	
	
	<%
		MemberData member=(MemberData)request.getAttribute("member");
	%>
	<center>
	
	
	
	<h2>정 보 수 정</h2><br><br><br><br>
	<div style="max-width:300px;">
	<form id="modifyForm"  method="post" class="form-inline" >
	&nbsp;&nbsp;&nbsp;아이디: <input type="text" name="uid" value="<%=member.getId() %>" class="form-control" readonly><br><br>
	비밀번호: <input type="password" name="password" value="<%=member.getPw() %>" class="form-control" readonly><br><br>
	<span id="mpw2"></span>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이름: <input type="text" name="name" value="<%=member.getName() %>" class="form-control" readonly><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;학번: <input type="text" value="<%=member.getSNum() %>" class="form-control" readonly><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;핸드폰: <input type="text" name="phone" value="<%=member.getPhone() %>" class="form-control" readonly><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;이메일: <input type="text" name="email" value="<%=member.getEmail() %>" class="form-control" readonly><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;권한: <input type="text" value="<%=member.getAuthority() %>" class="form-control" readonly><br><br>
	
	<input id="modifyBtn" type="button" value="정보수정" class="btn btn-primary" onclick="memberModify()">
	<span id="mreset"></span>
	</form>
	</div>
	</center>
</div>