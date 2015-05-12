<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성공회대 동아리 커뮤니티</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
.navbar-inverse {
	max-width: 800px;
	margin: auto;
}

.wrap {
	max-width: 800px;
	background-color: white;
	margin: auto;
}

#mainImage {
	max-width: 700px;
	height: 300px;
	margin: auto;
	border: 1px solid black;
	background-image: url("assets/image/mainvisual1.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

@media ( min-width :768px) {
	#notice, #free {
		float: left;
		width: 400px;
		height: 300px;
		margin: auto;
		border: 1px solid black;
	}
}

@media ( max-width :767px) {
	#notice, #free {
		max-width: 700px;
		height: 300px;
		margin: auto;
		border: 1px solid black;
	}
}

#footer {
	max-width: 800px;
	height: 100px;
	border: 1px solid black;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
	box-shadow: 0px 5px 10px #ccc;
	margin: auto;
	margin-top: 10px;
}

#header {
	border-bottom: 1px solid black;
}

#log {
	position: absolute;
	border: 1px solid black;
	right: 50px;
	top: 30px;
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
#loginDiv{
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
.fc-sun{color:red;}
.fc-sat {color:#007dc3}
</style>
<link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">

<script src="//code.jquery.com/jquery.js"></script>
<script src="assets/js/bootstrap.js"></script>





<script>
	$(document).ready(
			function() {
				
				
				$('.dropdown,.dropdown-menu').hover(
						function() {

							if ($(window).width() >= 768) {
								$(this).addClass('open').trigger(
										'shown.bs.dropdown', relatedTarget)
								return false;
							}

						},
						function() {
							if ($(window).width() >= 768) {
								$(this).removeClass('open').trigger(
										'hidden.bs.dropdown', relatedTarget)
								return false;
							}
						})

				$('#login').click(function(){
					var loginLeft=($(window).width()-$('#loginDiv').outerWidth())/2;
					var loginTop=($(window).height()-$('#loginDiv').outerHeight())/2;
					$('#loginDiv').css({'left':loginLeft,'top':loginTop,'display':'block'});
					wrapMask();
					$('#loginId').focus();
				})
				$("#loginClose").click(function(){
					$('#layered,#loginDiv').css('display','none');
					
				})
				
				window.onresize=function(){
					
					var maskWidth=$(document).width();
					var maskHeight=$(document).height();
					
					$('#layered').css({'width':maskWidth,'height':maskHeight});
					
					var loginLeft=($(window).width()-$('#loginDiv').outerWidth())/2;
					var loginTop=($(window).height()-$('#loginDiv').outerHeight())/2;
					$('#loginDiv').css({'left':loginLeft,'top':loginTop});
					
					
				}
				
				
			})
	function wrapMask(){
		
		var maskWidth=$(document).width();
		var maskHeight=$(document).height();
		
		$('#layered').css({'width':maskWidth,'height':maskHeight,'display':'block'});
		
	}
	function boardSearch(category){
		var bsv=$('#boardSearchValue').val().trim();
		if($('#searchSelect').val()=='제목+내용'){
			ss=1;
		}
		else{
			ss=2;
		}
		
		if(bsv==''){
			alert('한글자 이상 입력하세요!')
		}
		else{
			location.href="boardSearch.do?category="+category+"&search="+ss+"&value="+bsv;
		}
	}
	
	function commentWrite(bid){
		var commentContent=$('#commentContent').val();
		$.post('commentWrite.aj',{bid:bid,bdcontent:commentContent},function(data){
			
			$('#comment').html(data);
			
			$('#commentContent').val('');
		})
	}
	
	function commentDelete(bdid,bid){
		if(confirm('삭제하시겠습니까?')){
			$.post('commentDelete.aj',{bdid:bdid,bid:bid},function(data){
				$('#comment').html(data);
			})
		}
	}
	function fileDownload(){
		
		$('#downloadForm').submit();
		
	}
	
</script>

</head>
<body>
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
	<jsp:include page="Header.jsp" flush="false" />
	<jsp:include page="Nav.jsp" flush="false" />
	<%String article=(String)request.getAttribute("article"); %>
	<jsp:include page="<%=article %>" flush="false" />
	<jsp:include page="Footer.jsp" flush="false" />

</body>
</html>