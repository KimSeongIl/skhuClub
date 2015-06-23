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
	color:black;
	text-decoration:none;
}




.wrap {
	position:relative;
	max-width: 800px;
	
	
	margin: auto;
}

@media ( min-width :768px) {
	.wrap{
		max-width:60% !important;
	}
	#notice, #free {
		float: left;
		width: 400px;
		height: 300px;
		margin: auto;
		
	}
	#article{
		min-height:600px;
		margin:auto;
	}
	#footer{
		margin:auto;
	}
	
	#footerList{
		margin:auto;
		max-width:768px;
	}
	
	#footerList>li{
		
		
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
		min-height:350px;
		margin:auto;
	}
	
}

#footer {
	text-align:center;
	
	background-color:#337AB7;
	
	
	text-align:center;
	margin: auto;
	margin-top:30px;
	padding-bottom:5px;
}
#footerList>li>a{
	color:white;
}
#footerList>li:hover{
	background-color:white;
	
}

#header {
	border-bottom: 1px solid black;
}

#log {
	position: absolute;
	
	right: 100px;
	top: 15px;
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
	margin:auto;
	width:100%;
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

.navbar-default{
	
	background-color:#337AB7 !important;
	color:white !important;
	min-height:70px;
}
.navbar-header{
	
	
}
.icon-bar{
	background-color:white !important;
}
.navbar-default .navbar-brand{
	color:white !important;
	
    height:60px;
	
}
.navbar-nav{
	
}
.navbar-default .navbar-nav > li {
	
	padding-top:0px;
	
}
.navbar-default .navbar-nav > li>a{
	
	color:white !important;
	height:60px;
	
}
.navbar-default .navbar-nav > li>a:hover{
	background-color:white !important;
	color:#337AB7 !important;
}


.fc-sun{color:red;}
.fc-sat {color:#007dc3}
</style>
<link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">

<script src="assets/js/jquery-1.9.1.min.js"></script>
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