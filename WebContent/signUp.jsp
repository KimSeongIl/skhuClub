﻿
	<script src="assets/js/signUp.js"></script>

	

	<div id="article" style="padding-left:50px;">
	<br>
	<b>회원가입</b><br>
	<hr>

	<form action="insertMember.do" name="signupForm" id="signupForm" method="post" class="form-inline">
         &nbsp;&nbsp;&nbsp;아이디
    
	<input type="text" class="form-control" placeholder="아이디의 글자수(6~12)" name="uid">
	&nbsp; <input type="button" class="btn btn-default btn-sm" value="중복확인" onclick="overlapCheck(this.form)"><span id="overlapText"></span>
	<br><br>

	비밀번호
	<input type="password" class="form-control" placeholder="비밀번호" name="password"><br><br>
	비번확인
	<input type="password" class="form-control" placeholder="비밀번호 확인" name="passwordCheck"><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;학번
	<input type="number" class="form-control" placeholder="학번" name="studentNum"><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이름
	<input type="text" class="form-control" placeholder="이름" name="name"><br><br>
	&nbsp;&nbsp;&nbsp;핸드폰
	<input type="number" class="form-control" placeholder="-없이 입력하시오" name="phone"><br><br>
	&nbsp;&nbsp;&nbsp;이메일
    <input type="text" class="form-control" placeholder="이메일" name="email"><br>
	
	<hr>
	

<input type="submit" class="btn btn-primary" id="join" onclick="if(!memberSubmit(this.form)){return false;}" value="가입하기"/>
	<br><br>
	</form>
	</div>
	
	

