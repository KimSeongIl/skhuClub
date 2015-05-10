<%@page import="java.util.*"%>
<%@page import="board.BoardData"%>
<%@page import="comment.CommentData" %>



<div id="article">

	<table border id="board">
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<%
				String category = (String) request.getParameter("category");
				List boardList = (List) request.getAttribute("boardList");
				List commentCount=(List)request.getAttribute("commentCount");
				int count=0;
				if (boardList != null) {
					
					for (int i = 0; i < boardList.size(); i++) {
						BoardData board = (BoardData) boardList.get(i);
						CommentData cd=null;
						if(commentCount!=null){
							cd=(CommentData)commentCount.get(i);
						}

						out.println("<tr>");
						out.println("<td>" + board.getBId() + "</td>");
						if(cd!=null && cd.getBdcount()!=0){
							out.println("<td><a href='boardView.do?bid="
									+ board.getBId() + "'>" + board.getBTitle()
									+" ["+cd.getBdcount()+"]"+ "</a></td>");
						}
						else{
							out.println("<td><a href='boardView.do?bid="
									+ board.getBId() + "'>" + board.getBTitle()
									+ "</a></td>");
						}
						
						out.println("<td>" + board.getUName() + "</td>");
						out.println("<td>" + board.getBDate() + "</td>");
						out.println("<td>" + board.getInquiry() + "</td>");
						out.println("</tr>");
					}
				}
			%>
		
	</table>
	<br>
	<div id="paging">
		<%
			List paging = (List) request.getAttribute("paging");

			for (int i = 0; i < paging.size(); i++) {
				out.print(paging.get(i));
			}
		%>
	</div>
	<select id="searchSelect">
		<option>제목+내용</option>
		<option>작성자</option>
	</select>

	<script>
		$(document).ready(function(){
			$('#boardSearchValue').keyup(function(){
				if(event.keyCode=='13'){
					boardSearch('<%=category%>')
				}
			})
		})
		
	</script>
	<input type="search" id="boardSearchValue">
	 <input id="boardSearch" type="button" value="검색" class="btn btn-default-sm" onclick="boardSearch('<%=category%>')"> 
	 <input type="button" class="btn btn-default-sm" value="글쓰기" onclick="location.href='boardWrite.do'">
</div>


