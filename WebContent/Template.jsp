<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성공회대 동아리 커뮤니티</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
*{

	font-family: 'Jeju Gothic', sans-serif;
}

ul{
	list-style:none;
}
a{
	
	text-decoration:none;
}
a:visited{
	color:black;
}

.navbar-inverse {
	max-width: 100%;
	margin: auto;
}

.wrap {
	max-width: 800px;
	background:white;
	border-radius:10px;
	margin: auto;
}

@media ( min-width :768px) {
	#notice, #free {
		float: left;
		width: 400px;
		height: 300px;
		margin: auto;
		
	}
	#article{
		min-height:300px;
		margin:auto;
	}
	#footer{
		margin:auto;
	}
	
	#footerList{
		margin:auto;
		max-width:768px;
	}
	
	#footer li{
		
		
		width:250px;
		float:left;
		display:block;
		
	}
	
}

@media ( max-width :767px) {
	#notice, #free {
		max-width: 700px;
		height: 300px;
		margin: auto;
		border: 1px solid black;
	}
	#article{
		
		margin:auto;
	}
	
}

#footer {
	text-align:center;
	
	
	height: 100px;
	border-top: 1px solid black;
	text-align:center;
	margin: auto;
	margin-top: 10px;
}
#footer li:hover{
	background:black;
	
}

#header {
	border-bottom: 1px solid black;
}

#log {
	position: absolute;
	
	right: 80px;
	top: 10px;
}

.dropdown-menu {
	background: #222222 !important;
}

.dropdown-menu>li>a {
	color: white !important;
}

.dropdown-menu>li>a:hover {
	background: #909090 !important;
	color: black !important;
}
#layered{
	position:absolute;
	left:0;
	top:0;
	background:#000;
	z-index:1000;
	opacity:0.7;
	
	display:none;
}
#loginDiv,#addClubDiv{
	position:absolute;
	left:0;
	top:0;
	width:250px;
	height:250px;
	text-align:center;
	z-index:1001;
	display:none;
	padding-top:10px;
	background:#EBEBEB;
	border-radius:10px;
}
#loginClose{
	margin-right:10px;
}
#board{
	margin:auto;
	width:400px;
	
}
#clubList{
	
	border:1px solid black;
	display:none;
	max-width:800px;
	margin:auto;
	margin-top:0;
}

#commentList{
	width:550px;
	margin:auto;
}
#board{
	width:500px;
	text-align:center;
}
#board th{
	text-align:center;
}
#board td:nth-child(2){
	width:200px;
}
#paging{
	text-align:center;
	margin:auto;
}

#boardTable{
	margin:auto;
	width:600px;
	min-height:300px;
}
#boardTable th{
	width:100px;
}
#boardTable td{
	max-width:500px;
	
}
.fc-sun{color:red;}
.fc-sat {color:#007dc3}
</style>
<link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">

<script src="//code.jquery.com/jquery.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/js/HuskyEZCreator.js" charset="utf-8"></script>

<script src="assets/js/skhuClub.js"></script>

</head>
<body style="background-color:#EEEEEE;">
	<div id="layered" ></div>
	<div id="loginDiv">
		<div id="loginClose">
			<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div><br><br>
		<form class="form-inline" action="login.do" method="post">
			<input id="loginId" type="text" class="form-control" placeholder="ID" name="id"><br><br>
			<input type="password" class="form-control" placeholder="PW" name="pw"><br><br>
			<input type="submit" value="로그인" class="btn btn-default">
		</form>
	</div>
	
	<jsp:include page="Nav.jsp" flush="false" />
	<%String article=(String)request.getAttribute("article"); %>
	<jsp:include page="<%=article %>" flush="false" />
	<jsp:include page="Footer.jsp" flush="false" />

</body>
</html>