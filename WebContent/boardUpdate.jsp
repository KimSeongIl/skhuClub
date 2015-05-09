<%
	String category=(String)request.getAttribute("category");
	out.println("<script>alert('완료되었습니다!')</script>");
	out.println("<script>location.href='board.do?category="+category+"'</script>");
%>