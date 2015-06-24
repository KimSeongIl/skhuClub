<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일정 입력</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
*{

	font-family: 'Jeju Gothic', sans-serif;
}
</style>
</head>
<body>
	<%
		String start = (String) request.getAttribute("start");
		String end = (String) request.getAttribute("end");
	%>
	<div style="width:50%;margin:auto;" >
	
	<form method="post" class="form-inline">
		<input type="hidden" name="start" value="<%=start%>">
		<input type="hidden" name="end" value="<%=end%>"><br>
		&nbsp;제목: <input type="text" name="tit" class="form-control"><br>
		<br> &nbsp;색 : <select name='color1' class="form-control">
			<option>red</option>
			<option>blue</option>
			<option>green</option>
			<option>orange</option>
			<option>sky</option>
			<option>purple</option>
		</select> 
		<br>
		<div align="center">
		<input type="button" class="btn btn-primary" value="확인"
			onclick="window.opener.select(this.form);self.close()">
		</div>
	</form>
	
	</div>


</body>
</html>