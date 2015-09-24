<%
String uid=(String)session.getAttribute("id");
if(uid==null){
	out.println("<script>alert('로그인 해주세요!')</script>");
	out.println("<script>location.href='main.do'</script>");
}
%>
<%@page import="java.util.*" %>
<%@page import="apply.ApplyData" %>
<div style="width:100%;padding-left:100px;">
<ul>
	<li style="float:left;margin-right:50px;"><a href="myPage.do">정보수정</a></li>
	<%String auth=(String)session.getAttribute("auth");
	  if(auth==null){%>
	<li style="float:left;margin-right:50px;"><a href="#">지원서 관리</a></li>
	<%}else{ %>
	<li style="float:left;margin-right:50px;"><a href="applicationManagement.do">지원서 관리</a></li>
	<%} 
	  if("관리자".equals(auth)){%>
		<li style="float:left;"><a href="addClub.do">동아리 추가</a></li>
		<%} %>
</ul>
</div>
<br>
<div id="article">
<center>
	<h1>지 원 서   관 리</h1>
	<table width="100%" class="table">
		<tr>
			<th>이름</th>
			<th>학과</th>
			<th>학년</th>
			<th style="width:15%;"></th>
		</tr>
<%List<ApplyData> list=(ArrayList<ApplyData>)request.getAttribute("list");

 for(int i=0;i<list.size();i++){
	out.println("<tr>");
	out.println("<td class='getName'>"+list.get(i).getName()+"</td>");
 	out.println("<td class='getDepartment'>"+list.get(i).getDepartment()+"</td>");
 	out.println("<td class='getGrade'>"+list.get(i).getGrade()+"</td>");%>
 	
 	<% out.println("<td style='width:15%;text-align:center;' name="+list.get(i).getUid()+"><button type='button' phone="+list.get(i).getPhone()+" intro="+list.get(i).getIntroduction()+" class='btn btn-default btn-sm' data-toggle='modal' data-target='#myModal' onclick='applyDetail($(this))' >보기</button>&nbsp;<input type='button' class='btn btn-default btn-sm applicationDelete' value='삭제'></td>");
 	out.println("</tr>");
 }%>
 
 	</table>
 	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title" id="myModalLabel">동아리 지원서</h4>
	      </div>
	      <div class="modal-body">
	      
	       
	       <p style='text-align:left;'>작성자:</p>
	       <input type='text' class='form-control' name='getName'  value="#" readonly><br>
	       <p style='text-align:left;'>학년/학과:</p>
	       <input type='text' class='form-control'  name='getGrade' value="#" readonly><br>
	       <p style='text-align:left;'>전화번호:</p>
	       <input type='text' class='form-control' name='getPhone'  value="#" readonly><br>
	    
	       <p style='text-align:left;'>자기소개:</p>
	       <textarea class='form-control' name='getIntroduction' readonly></textarea>
	       
	       
	      </div>
	      <div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
 	
 	
 		
	

</div>
 	
 </center>
</div>