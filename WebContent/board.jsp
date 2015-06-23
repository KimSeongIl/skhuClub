<%@page import="java.util.*"%>
<%@page import="board.BoardData"%>
<%@page import="comment.CommentData" %>



<div id="article">
	<div style="min-height:500px;"><br>
	<table id="board" class="table table-hover">
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
				if(category.equals("notice")){
					out.println("<h2 align='center'>공 지 사 항</h2><br>");
				}
				else if(category.equals("free")){
					out.println("<h2 align='center'>자 유 게 시 판</h2><br>");
				}
				if (boardList != null) {
					
					for (int i = 0; i < boardList.size(); i++) {
						BoardData board = (BoardData) boardList.get(i);
						CommentData cd=null;
						if(commentCount!=null){
							cd=(CommentData)commentCount.get(i);
						}
						String day=board.getBDate().getYear()+1900+"-"+(board.getBDate().getMonth()+1)+"-"+board.getBDate().getDate();
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
						out.println("<td>" + day + "</td>");
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
	</div><br>
	<center>
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
	 <input id="boardSearch" type="button" value="검색" class="btn btn-default btn-sm" onclick="boardSearch('<%=category%>')"> 
	 <input type="button" class="btn btn-default btn-sm" value="글쓰기" onclick="location.href='boardWrite.do?category=<%=category%>'">
	<br><br>
	</center>
	</div>
</div>


