<%@page import="board.BoardData" %>
<%
	String uid=(String)session.getAttribute("id");
	if(uid==null){
		out.println("<script>alert('로그인 해주세요!')</script>");
		out.println("<script>location.href='main.do'</script>");
	}
	BoardData board=(BoardData)request.getAttribute("board");
	String btitle="";
	String bcontent="";
	int bid=0;
	if(board!=null){
		bid=board.getBId();
		btitle=board.getBTitle();
		bcontent=board.getBContent();
	}
%>
	<div id="article">
		<%if (board==null){ %>
		<form action="boardInsert.do" method="post">
		<%}else{ %>
		<form action="boardUpdateSuccess.do?bid=<%=bid %>" method="post">
		<%} %>
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" placeholder="제목을 입력하세요" name="btitle" value="<%=btitle%>"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="bcontent"><%=bcontent %></textarea>
				</tr>
			</table>
			<input type="hidden" name="category" value="notice">
			<input type="submit" class="btn btn-default-sm" value="쓰기">
			&nbsp;<input type="button"  class="btn btn-default-sm" value="돌아가기" onclick="history.back()">
		</form>
	</div>

	
