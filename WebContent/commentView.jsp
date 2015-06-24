<%@page import="java.util.*"%>
<%@page import="comment.CommentData"%>
<%
			String suid=(String)session.getAttribute("id");
			int bid=(int)request.getAttribute("bid");
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