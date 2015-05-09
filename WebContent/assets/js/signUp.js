function signCheck(){
//	아이디 입력여부 검사 
	if(document.s.id.value=="")
	{
		alert("아이디를 입력하지 않았습니다.")
		document.s.id.focus()
		return
	}

	//아이디 유효성검사 (영문자랑 숫자만)글자수(6~12)인지 검사


	var idCheck= /^[A-Za-z0-9+]{6,12}$/;


	if(!idCheck.test(document.s.id.value))
	{

		alert("아이디는 영어와 숫자만 입력해주세요.(글자수는 6~12)")
		document.s.id.focus();
		return
	}



	//비밀번호 입력여부 검사
	if(document.s.password.vlaue="")
	{
		alert("비밀번호를 입력하지 않았습니다")
		document.s.password.focus();
		return

	}

	// 비밀번호에 숫자 특수문자 영어로 유효성 검사  비밀번호의 수는 6~12

	var pwCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}$/;



	if(!pwCheck.test(document.s.password.value))
	{


		alert("비밀번호는 영어와 숫자의 조합으로 해주세요.(글자수는 6~12)")
		document.s.password.focus();
		return


	}


	alert("ccc")
	// 비밀번호 일치여부 검사 
	if (document.s.password.value!=document.s.passwordCheck.value)
	{
		alert("비밀번호가 일치하지 않습니다")
		document.s.password.value=""
			document.s.passwordCheck.value=""
				document.s.password.focus()
				return
	}


	//학번 입력여부 검사 

	if(document.s.studentNum.value=="")
	{
		alert("학번을 입력하지 않았습니다.")
		document.s.id.focus()
		return
	}

	//학번에 숫자만 입력가능하도록 검사 

	var studentNumCheck= /^[0-9+]{6,12}$/;


	if(!studentNumCheck.test(document.s.studentNum.value))
	{

		alert("학번은 숫자만 가능합니다")
		document.s.studentNum.focus();
		return

	}
	
	
	//이름입력 여부 검사 
	if(document.s.name.value=="")
	{
		alert("이름을 입력하지 않았습니다.")
		document.s.id.focus()
		return
	}

	for (i=0;i<document.s.name.value.length ;i++ )
	{
		var ch=document.s.name.value.charAt(i)
		if ((ch>='0' && ch<='9') && (ch>='a' && ch<='z'))
		{
			alert ("이름는 소문자, 숫자만 입력불가능합니다.")
			document.s.id.focus()
			
			return
		}
	}
	
	
	
	
	
	//휴대폰번호 입력여부 검사 
	if(document.s.phone.value=="")
	{
		alert("휴대폰 번호를 입력하지 않았습니다.")
		document.s.id.focus()
		return
	}

	//휴대폰 번호 유효성 검사 

	var phoneCheck = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;

	if(!phoneCheck.test(document.s.phone.value))
	{
		alert("전화번호 형식에 맞지 않습니다 ");
		document.s.phone.focus()
		return
	}
//	이메일 입력 여부 검사
	if(document.s.email.value=="")
	{
		alert("이메일을 입력하지 않았습니다.")
		document.s.id.focus()
		return
	}

	//이메일 형식에 맞는지 검사 
	var emailCheck= /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;


	if(!emailCheck.test(document.s.email.value))
	{

		alert("이메일 형식에 맞지 않습니다 ")
		document.s.email.focus();
		return

	}

	alert("회원가입을 축하드립니다")






















	/*	아이디 입력여부 검사
	if(document.s.id.value=="")
	{
		alert("아이디를 입력하지 않았습니다.")
		document.s.id.focus()
		return
	}
//	아이디 유효성 검사 (영문소문자, 숫자만 허용)
	for (i=0;i<document.s.id.value.length ;i++ )
	{
		var ch=document.s.id.value.charAt(i)
		if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z'))
		{
			alert ("아이디는 소문자, 숫자만 입력가능합니다.")
			document.s.id.focus()
			document.s.id.select()
			return
		}
	}
//	아이디에 공백 사용하지 않기
	if (document.s.id.value.indexOf(" ")>=0)
	{
		alert("아이디에 공백을 사용할 수 없습니다.")
		document.s.id.focus()
		document.s.id.select()
		return
	}
//	아이디 길이 체크 (6~12자)
	if (document.s.id.value.length<6 || document.s.id.value.length>12)
	{
		alert ("아이디를 6~12자까지 입력해주세요.")
		document.s.id.focus()
		//document.s.id.select()
		return
	}
//	비밀번호 입력여부 체크
	if(document.s.password.value=="")
	{
		alert("비밀번호를 입력하지 않았습니다.")
		document.s.password.focus()
		return
	}
//	비밀번호 길이 체크(4~8자 까지 허용)
	if (document.s.password.value.length<4 || document.s.password.value.length>8)
	{
		alert ("비밀번호를 4~8자까지 입력해주세요.")
		document.s.password.focus()
		//document.s.password.select()
		return
	}

//	비밀번호와 비밀번호 확인 일치여부 체크
	if (document.s.password.value!=document.s.passwordCheck.value)
	{
		alert("비밀번호가 일치하지 않습니다")
		document.s.password.value=""
			document.s.passwordCheck.value=""
				document.s.password.focus()
				return
	}


	//학번에 숫자말고 다른 문자를 입력하였는 검사


		alert(isNaN(document.s.studentNum.value))*/








}