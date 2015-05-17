<style>
	#myPageNav ul li{
		float:left;
		
	}
	
</style>
<script>
	function addClub(){
		var clubLeft=($(window).width()-$('#addClubDiv').outerWidth())/2;
		var clubTop=($(window).height()-$('#addClubDiv').outerHeight())/2;
		$('#addClubDiv').css({'left':clubLeft,'top':clubTop,'display':'block'});
		wrapMask();
		$('input[name=clubName]').focus();
	}
	function clubClose(){
		$('#layered,#addClubDiv').css('display','none');
	}
	function addClubSubmit(){
		var clubName=$('input[name=clubName]').val();
		if(clubName.trim().length>=10){
			alert('10자 이내로 입력하세요');
		}
		else{
			$.post('addClub.aj',{clubName:clubName},function(data){
				var result=data.trim();
				if(result==1){
					alert('추가되었습니다');
					
					
					clubClose();
					
				}
				else if(result==2){
					alert('실패했습니다');
				}
			});
		}
	}
	
</script>
<div id="myPageNav">
<% String uauth=(String)session.getAttribute("auth"); 
	
	if(uauth.equals("관리자")){
%>
	<ul>
		<li onclick="location.href='myPage.do'">정보수정</li>
		<li onclick="addClub()">동아리 추가</li>
	</ul>
	<br>
	<br>
	<br>
<%} %>

</div>

<div id="addClubDiv">
		<div id="clubClose" onclick="clubClose()">
			<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div><br><br>
	<input type="text" class="form-control" name="clubName" placeholder="이름 입력"><br>
	<input type="button" value="추가" class="btn btn-default-sm" onclick="addClubSubmit()">
</div>