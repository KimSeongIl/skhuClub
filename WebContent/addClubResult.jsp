	<%
		int result=(int)request.getAttribute("result");
		if(result==1){
			out.println("<script>alert('추가되었습니다.');");
			out.println("location.href='main.do';</script>");
			
		}
		else{
			out.println("<script>alert('오류가 발생했습니다.');</script>");
		}
	%>
