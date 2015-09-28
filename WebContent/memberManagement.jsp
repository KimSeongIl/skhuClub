
<%@page import="java.util.*" %>
<%@page import="member.MemberData" %>
<%@page import="club.ClubData" %>
<% List list=(ArrayList<MemberData>)request.getAttribute("list"); 
   List clubList=(ArrayList<ClubData>)request.getAttribute("clubList");%>
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
		<li style="float:left;margin-right:50px;"><a href="addClub.do">동아리 추가</a></li>
		<li style="float:left;"><a href="memberManagement.do">회원 관리</a>
		<%} %>
</ul>
</div>
<br>
<div id="article">
	<center>
	<h1>회 원 관 리</h1><br><hr>
	</center>
	<table class="table">
		<tr>
			<th>아이디</th>
			<th>학번</th>
			<th>이름</th>
			<th>폰번호</th>
			<th>이메일</th>
			<th>권한</th>
			<th></th>
			<th></th>
		</tr>
		<% 
			for(int i=0;i<list.size();i++){
				MemberData md=(MemberData)list.get(i);
				if(!"관리자".equals(md.getAuthority())){
					out.println("<tr>");
					out.println("<td>"+md.getId()+"</td>");
					out.println("<td>"+md.getSNum()+"</td>");
					out.println("<td>"+md.getName()+"</td>");
					out.println("<td>"+md.getPhone()+"</td>");
					out.println("<td>"+md.getEmail()+"</td>");
					out.println("<td><span class='modifyContent'></span><span class='memberAuth'>"+md.getAuthority()+"</span>&nbsp;&nbsp;</td>");
					out.println("<td><span class='modifyContent'></span><input type='button' class='btn btn-primary btn-sm memberAuthModify' value='수정'><span class='memberAuthForm'><input type='button' class='btn btn-primary btn-sm memberAuthSubmit' uid="+md.getId()+" value='수정'>&nbsp;<input type='button' class='btn btn-default btn-sm modifyCancel' value='취소'></span></td>");
					out.println("<td><input type='button' class='btn btn-default btn-sm memberDelete' uid="+md.getId()+" value='삭제'</td>");
					out.println("</tr>");
				}
			}
		%>
	</table>
</div>
<div id="modifyContentSelect">
	<select>
		<%
			for(int i=0;i<clubList.size();i++){
				ClubData cd=(ClubData)clubList.get(i);
				out.println("<option>"+cd.getName()+"</option>");
			}
		%>
	</select>
</div>
<script>
	$(document).ready(function(){
		$('.modifyContentSelect').hide();
		$('.memberAuthForm').hide();
		$('.memberAuthModify').click(function(){
			$(this).parent().find('.memberAuth').hide();
			$(this).parent().find('.modifyContent').html($('#modifyContentSelect').html());
			$(this).parent().find('.memberAuthForm').show();
			$(this).hide();
			
		})
		$('.modifyCancel').click(function(){
			$(this).parent().parent().find('.memberAuthModify').show();
			$(this).parent().hide();
			$(this).parent().parent().find('.modifyContent').hide();
			$(this).parent().parent().find('.memberAuth').show();
		})
		$('.memberAuthSubmit').click(function(){
			var clubName=$(this).parent().parent().find('.modifyContent select').val();
			var uid=$(this).attr('uid');
			
			$.post('memberAuthModify.aj',{clubName:clubName,uid:uid},function(data){
				alert('수정되었습니다');
				location.href='memberManagement.do';
			})
		})
		$('.memberDelete').click(function(){
			if(confirm('삭제하시겠습니까?')){
				var uid=$(this).attr('uid');
				$.post('memberDelete.aj',{uid:uid},function(data){
					alert('삭제되었습니다.');
					location.href='memberManagement.do';
				})
			}
		})
	})
</script>