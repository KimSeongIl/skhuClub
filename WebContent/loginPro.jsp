<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.MemberData"%>
	<%
		MemberData check=(MemberData)request.getAttribute("check");
		if(check!=null){
			String id=check.getId();
			String name=check.getName();
			String auth=check.getAuthority();
			session.setAttribute("id",id);
			session.setAttribute("name",name);
			session.setAttribute("auth",auth);
			
			%>
			<script>location.href="main.do"</script>
			<%
			
		}
		
		else{
			%>
			<script>
				alert("아이디와 비밀번호가 맞지 않습니다!");
				history.back();
			</script>
			<%
		}
	%>
