function signCheck(){
	
//	아이디 입력여부 검사
	if(document.s.id.value=="")
	{
		alert("아이디를 입력하지 않았습니다.")
		document.s.id.focus()
		return
	}
//	아이디 유효성 검사 (영문소문자, 숫자만 허용)
	for (i=0;i<document.s.id.value.length ;i++ )
	{
		ch=document.s.id.value.charAt(i)
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
		document.s.id.select()
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
		document.s.password.select()
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

}