
	<script src="assets/js/signUp.js"></script>
<div class="wrap">
	

	<div id="article">
	<b>회원가입</b><br>
	<hr>
	<form action="" name="signupForm" id="signupForm" method="post" class="form-inline">
         아이디
    <br>
	<input type="text" class="form-control" placeholder="아이디의 글자수(6~12)" name="uid">
	&nbsp; <input type="button" class="btn btn-default-sm" value="중복확인" onclick="overlapCheck(this.form)"><span id="overlapText"></span>
	<br>
	비밀번호<br>
	<input type="password" class="form-control" placeholder="비밀번호" name="password"><br>
	비밀번호 확인<br>
	<input type="password" class="form-control" placeholder="비밀번호 확인" name="passwordCheck"><br>
	학번<br>
	<input type="number" class="form-control" placeholder="학번" name="studentNum"><br>
	이름<br>
	<input type="text" class="form-control" placeholder="이름" name="name"><br>
	핸드폰 번호<br>
	<input type="number" class="form-control" placeholder="-없이 입력하시오" name="phone"><br>
	이메일<br>
    <input type="text" class="form-control" placeholder="이메일" name="email"><br>
	
	<hr>
	

<button type="button" class="btn btn-primary" id="join" onclick="memberSubmit(this.form)">가입하기</button>
	
	</form>
	</div>
	
	
</div>
