<% 
	if(session.getAttribute("id")==null){
		out.println("<script>alert('로그인 해주세요!')</script>");
		out.println("<script>history.back()</script>");
	}
	String club=request.getParameter("club"); %>
	<script src=""></script>

	

	<div id="article">
	<b>동아리 지원서</b><br>
	<hr>


	<form action="insertApplication.do" name="appicationForm" id="applicationForm" method="post">

    학년<br>
	<input type="text" class="form-control" placeholder="학년을 입려해주세요" name="grade"><br>
	학과<br>
	<input type="text" class="form-control" placeholder="학과를 입력해주세요" name="department"><br>
	자기소개<br>
	<textarea class="form-control" placeholder="300자이내로 작성해주세요" name="self_instroduction"></textarea>
	<input type="hidden" name="club" value="<%=club %>">
	<hr>
	


<div style="text-align:center"><input type="submit" class="btn btn-primary" value="지원하기" >&nbsp;<a class="btn btn-info" onclick="history.back()">돌아가기</a></div>
	
	</form>
	</div>
	
	

