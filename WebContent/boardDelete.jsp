<%
	String category=(String)request.getAttribute("category");
	out.println("<script>alert('삭제되었습니다!')</script>");
	out.println("<script>location.href='board.do?category="+category+"'</script>");
%>