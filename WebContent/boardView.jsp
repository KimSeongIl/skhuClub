<%@page import="board.BoardData" %>
<%  

	BoardData board=(BoardData)request.getAttribute("board");
	int bid=board.getBId();
	String uid=board.getUId();
	String name=board.getUName();
	String btitle=board.getBTitle();
	String bcontent=board.getBContent();
	String category=board.getCategory();
	String suid=(String)session.getAttribute("id");
	
	

%>
<div id="article">

	<table>
		<tr>
			<th>제목</th>
			<td><%=btitle %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=bcontent %></td>
		</tr>
	</table>
	<br>
	<% if(uid.equals(suid)){ %>
	
	<input type="button" class="btn btn-default-sm" value="수정" onclick="location.href='boardUpdate.do?bid=<%=bid%>'">
	<form action="boardDelete.do" method="post">
		<input type="hidden" name="bid" value="<%=bid %>">
		<input type="hidden" name="category" value="<%=category %>">
		<input type="submit" class="btn btn-default-sm" value="삭제" onclick="if(!confirm('정말 삭제하시겠습니까?')){return false;}">
	</form>
	<% } %>

	<input type="button" class="btn btn-default-sm" value="돌아가기" onclick="history.back()">

</div>