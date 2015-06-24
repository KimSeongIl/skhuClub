<%@page import="board.BoardData" %>
<%@page import="comment.CommentData" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>

<%  

	BoardData board=(BoardData)request.getAttribute("board");
	int bid=board.getBId();
	String uid=board.getUId();
	String name=board.getUName();
	String btitle=board.getBTitle();
	String bcontent=board.getBContent();
	String files=board.getFiles();
	String category=board.getCategory();
	String suid=(String)session.getAttribute("id");
	
	if(files==null){
		files="";
	}
	else{
		out.println("<form id='downloadForm' action='fileDownload.aj' method='post'>");
		out.println("<input type='hidden' value='"+files+"' name='fileName'>");
		out.println("</form>");
	}

%>
<div id="article">

	<table id="boardTable">
		<tr>
			<th>제목</th>
			<th><%=btitle %></th>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=name %></td>
		</tr>
		
		<tr>
			<th>파일</th>
			<td><a onclick="fileDownload()" style="cursor:hand;cursor:pointer;text-decoration:underline;"><%=files%></a></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><div style="overflow:auto;"><%=bcontent %></div></td>
		</tr>
	</table>
	<br>
	<% if(uid.equals(suid)){ %>
	<div style="margin:auto;width:80%;">
	<form action="boardDelete.do" method="post" style="float:right;">
		<input type="hidden" name="bid" value="<%=bid %>">
		<input type="hidden" name="category" value="<%=category %>">
		<input type="submit" class="btn btn-default" value="삭제" onclick="if(!confirm('정말 삭제하시겠습니까?')){return false;}">
	</form>
	
	<form action="boardUpdate.do" method="post" style="float:right;margin-right:10px;">
		<input type="hidden" name="bid" value="<%=bid %>">
		<input type="hidden" name="category" value="<%=category %>">
		<input type="submit" class="btn btn-primary" value="수정" ">
	</form>
	</div>
	
	<div style="clear:both;"></div><br>
	<% } %>
	
	
		
	<div id="comment">
		
		<%
			List commentList=(List)request.getAttribute("comment");
			out.println("<table id='commentList'>");
			if(commentList!=null){
				
				for(int i=0;i<commentList.size();i++){
					CommentData cd=(CommentData)commentList.get(i);
					String colspan="colspan='2'";
					String delete="";
					if(cd.getUid().equals(suid)){
						int bdid=cd.getBdid();
						colspan="";
						delete="<td><span style='cursor:hand;cursor:pointer;' onclick='commentDelete("+bdid+","+bid+")'>X</span></td>";
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
				
				
			}
			if(suid!=null){
				out.println("<tr><td><textarea id='commentContent' class='form-control'></textarea></td><td><input type='button' class='btn btn-primary btn-sm' value='쓰기' onclick='commentWrite("+bid+")'></td></tr>");
			}
			out.println("</table>");
		%>
	
		
	</div>
	<br>
	
	<br>
	<div align="center">
	<input type="button" class="btn btn-default" value="돌아가기" onclick="history.back()">
	</div>
</div>