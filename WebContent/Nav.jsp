
<nav class="navbar navbar-default" role="navigation" >

	<!-- Brand and toggle get grouped for better mobile display -->
	<div style="margin:auto;max-width:768px;">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>

		</button>
		<a class="navbar-brand" href="main.do">성공회대 동아리</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse" >
		<ul class="nav navbar-nav">

			
			<li><a href="board.do?category=notice">공지사항</a></li>	
			<li><a href="schedule.do">동아리 일정</a></li>
			


				

			<li class="dropdown"><a href="clubList.do"">동아리</a>
			<li><a href="board.do?category=free">자유게시판</a></li>	
		</ul>

		
			
			
		
	</div>
	<div id="log">
<%
	String name=(String)session.getAttribute("name");

	if(name==null){
%>
	<span id="login" class="btn btn-default btn-sm">로그인</span>&nbsp;&nbsp;

	<span id="signUp" onclick="location.href='signUp.do'" class="btn btn-default btn-sm">회원가입</span>

<%  }else{
%>
	<%=name%>님 환영합니다 &nbsp;
	<span id="myPage"><a href="myPage.do" class="btn btn-default btn-sm">마이페이지</a></span>&nbsp;&nbsp;
	<span id="logout"><a href="logout.do" class="btn btn-default btn-sm">로그아웃</a></span>
<%
}
%>
</div>
	<!-- /.navbar-collapse -->
	</div>
</nav>

<br>
<div class="wrap">
