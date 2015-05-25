<%@page import="board.BoardData" %>
<%@page import="comment.CommentData" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<style>
	textarea:focus{
		height:100px;
		
	}
</style>
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

	<table border id="boardTable">
		<tr>
			<th>제목</th>
			<td><%=btitle %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=name %></td>
		</tr>
		<tr>
		<th>파일</th>
		<td><a onclick="fileDownload()"><%=files%></a></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><div style="overflow:auto;"><%=bcontent %></div></td>
		</tr>
	</table>
	<br>
	<% if(uid.equals(suid)){ %>
	
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
	
	
	<div style="clear:both;"></div>
	<% } %>
	
	<%if(suid!=null){ %>
	<div id="commentWrite" align="center">
		<textarea style="width:450px; float:left;margin-left:100px;" id="commentContent" class="form-control"></textarea> 
		<input style="float:left;margin-left:10px;"type="button" value="쓰기" class="btn btn-primary btn-sm" onclick="commentWrite('<%=bid%>')">
	</div>
	<div style="clear:both;"></div>
	<%} %>
	<br><br>	
	<div id="comment">
		
		<%
			List commentList=(List)request.getAttribute("comment");
			if(commentList!=null){
				out.println("<table id='commentList'>");
				for(int i=0;i<commentList.size();i++){
					CommentData cd=(CommentData)commentList.get(i);
					String colspan="colspan='2'";
					String delete="";
					if(cd.getUid().equals(suid)){
						int bdid=cd.getBdid();
						colspan="";
						delete="<td><button class='btn btn-default btn-sm' onclick='commentDelete("+bdid+","+bid+")'>삭제</button></td>";
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
	<br>
	<div align="center">
	<input type="button" class="btn btn-default" value="돌아가기" onclick="history.back()">
	</div>
</div>