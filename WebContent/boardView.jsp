<%@page import="board.BoardData" %>
<%@page import="comment.CommentData" %>
<%@page import="java.util.*" %>
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
	
	<%if(suid!=null){ %>
	<div id="commentWrite">
		<textarea id="commentContent"></textarea> 
		<input type="button" value="쓰기" class="btn btn-default-sm" onclick="commentWrite('<%=bid%>')">
	</div>
	<%} %>
		
	<div id="comment">
		
		<%
			List commentList=(List)request.getAttribute("comment");
			if(commentList!=null){
				out.println("<table>");
				for(int i=0;i<commentList.size();i++){
					CommentData cd=(CommentData)commentList.get(i);
					String colspan="colspan='2'";
					String delete="";
					if(cd.getUid().equals(suid)){
						int bdid=cd.getBdid();
						colspan="";
						delete="<td><span onclick='commentDelete("+bdid+","+bid+")'>삭제</span></td>";
					}
					out.println("<tr>");
					out.println("<td "+colspan+">");
					out.print(cd.getName()+" ");
					out.print(cd.getBddate()+"<br>");
					out.println(cd.getBdcontent());
					out.println("</td>");
					out.println(delete);
					out.println("</tr>");
				}
				out.println("</table>");
				
			}
		%>
	
		</table>
	</div>

	<input type="button" class="btn btn-default-sm" value="돌아가기" onclick="history.back()">

</div>