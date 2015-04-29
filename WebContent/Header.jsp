
<div id="header">
	<span><img width="200px" height="100px"
		src="assets/image/sin.jpg"></span>

</div>

<div id="log">
<%
	String name=(String)session.getAttribute("name");

	if(name==null){
%>
	<span id="login">로그인</span>
	<span id="signIn">회원가입</span>
<%  }else{
%>
	<%=name%>님 환영합니다 <br>
	<span id="logout"><a href="logout.do">로그아웃</a></span>
<%
}
%>
</div>