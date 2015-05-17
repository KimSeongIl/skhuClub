<style>
	#myPageNav ul li{
		float:left;
		
	}
	
</style>

<div id="myPageNav">
<% String uauth=(String)session.getAttribute("auth"); 
	
	
%>
	<ul>
		<li onclick="location.href='myPage.do'">정보수정</li>
		
	</ul>
	<br>
	<br>
	<br>


</div>

<div id="addClubDiv">
		<div id="clubClose" onclick="clubClose()">
			<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div><br><br>
	<input type="text" class="form-control" name="clubName" placeholder="이름 입력"><br>
	<input type="button" value="추가" class="btn btn-default-sm" onclick="addClubSubmit()">
</div>
