<%@page import="java.net.*" %>
<% String club=URLDecoder.decode(request.getParameter("club"),"UTF-8"); %>
<div id="article">

<form action="insertClubExplain.do" method="post">

<%=club %>
홈페이지 사이트<br>
<input type="text" class="form-control" placeholder="동아리 홈페이지 url을 적어주세요" name="homepage"><br> 
동아리 소개<br>
<textarea class="form-control" placeholder="동아리 소개란" name="clubexplain"></textarea><br>

행사 및 이벤트<br>
<textarea class="form-control" placeholder="동아리 소개란" name="clubevent"></textarea><br>
<input type="hidden" value="<%=club %>" name="name">
<div style="text-align:right"><input type="submit" value="저장하기" class="btn btn-primary"></div>

</form>

</div>


