<%@page import="member.MemberData" %>
<div id="article">
	<div id="myPageNav">
	</div>
	
	<%
		MemberData member=(MemberData)request.getAttribute("member");
	%>
	<form id="modifyForm" action="" method="post">
	아이디: <input type="text" value="<%=member.getId() %>" class="form-control" readonly><br>
	비밀번호: <input type="password" name="mpw" value="<%=member.getPw() %>" class="form-control" readonly><br>
	<span id="mpw2"></span>
	이름: <input type="text" name="mname" value="<%=member.getName() %>" class="form-control" readonly><br>
	학번: <input type="text" value="<%=member.getSNum() %>" class="form-control" readonly><br>
	핸드폰: <input type="text" name="mphone" value="<%=member.getPhone() %>" class="form-control" readonly><br>
	이메일: <input type="text" name="memail" value="<%=member.getEmail() %>" class="form-control" readonly><br>
	권한: <input type="text" value="<%=member.getAuthority() %>" class="form-control" readonly><br>
	
	<input id="modifyBtn" type="button" value="정보수정" class="btn btn-default-sm" onclick="memberModify()">
	<span id="mreset"></span>
	</form>
</div>