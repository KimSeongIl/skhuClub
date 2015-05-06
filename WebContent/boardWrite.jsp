<%
	String uid=(String)session.getAttribute("id");
	if(uid==null){
		out.println("<script>alert('로그인 해주세요!')</script>");
		out.println("<script>location.href='main.do'</script>");
	}
%>
	<div id="article">
		
		<form action="boardInsert.do" method="post">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" placeholder="제목을 입력하세요" name="btitle"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="bcontent"></textarea>
				</tr>
			</table>
			<input type="hidden" name="category" value="notice">
			<input type="submit" class="btn btn-default-sm" value="쓰기">
			&nbsp;<input type="button"  class="btn btn-default-sm" value="돌아가기" onclick="history.back()">
		</form>
	</div>

	
