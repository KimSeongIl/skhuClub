<%@page import="java.util.*"%>
<%@page import="comment.CommentData"%>
<%
			String suid=(String)session.getAttribute("id");
			int bid=(int)request.getAttribute("bid");
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