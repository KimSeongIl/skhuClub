<%@page import="java.util.*" %>
<%@page import="board.BoardData" %>

	
	
	<div id="article">
	
		<table border id="board">
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
		<%
			List boardList=(List)request.getAttribute("boardList");
			if(boardList!=null){
				for(int i=0; i<boardList.size();i++){
					BoardData board=(BoardData)boardList.get(i);
					
					out.println("<tr>");
					out.println("<td>"+board.getBId()+"</td>");
					out.println("<td><a href='boardView.do?bid="+board.getBId()+"'>"+board.getBTitle()+"</a></td>");
					out.println("<td>"+board.getUName()+"</td>");
					out.println("<td>"+board.getBDate()+"</td>");
					out.println("<td>"+board.getInquiry()+"</td>");
					out.println("</tr>");
				}
			}
		%>
		</table>
		
		<input type="button" class="btn btn-default-sm" value="글쓰기" onclick="location.href='boardWrite.do'">
	</div>
	
	
