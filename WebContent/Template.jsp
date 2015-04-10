<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
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

			})
</script>
</head>
<body>
	<jsp:include page="Header.jsp" flush="false" />
	<jsp:include page="Nav.jsp" flush="false" />
	<%String article=(String)request.getAttribute("article"); %>
	<jsp:include page="<%=article %>" flush="false" />
	<jsp:include page="Footer.jsp" flush="false" />

</body>
</html>