﻿<%@page import="board.BoardData" %>
<%
	String uid=(String)session.getAttribute("id");
	if(uid==null){
		out.println("<script>alert('로그인 해주세요!')</script>");
		out.println("<script>location.href='main.do'</script>");
	}
	BoardData board=(BoardData)request.getAttribute("board");
	String btitle="";
	String bcontent="";
	int bid=0;
	if(board!=null){
		bid=board.getBId();
		btitle=board.getBTitle();
		bcontent=board.getBContent();
	}
%>
	<div id="article">
		<%if (board==null){ %>
		<form action="boardInsert.do" method="post" enctype="multipart/form-data">
		<%}else{ %>
		<form action="boardUpdateSuccess.do?bid=<%=bid %>" method="post">
		<%} %>
			<table border style="width:700px;">
				<tr>
					<th>제목</th>
					<td><input type="text" placeholder="제목을 입력하세요" name="btitle" value="<%=btitle%>"></td>
				</tr>
				<tr>
					<th>파일</th>
					<td><input type="file" name="uploadFile"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="bcontent" id="ir1" rows="10" cols="100" style="width:100%; height:300px; display:none;"><%=bcontent %></textarea>
				</tr>
			</table>
			<input type="hidden" name="category" value="notice">
			<input type="submit" class="btn btn-default-sm" value="쓰기" onclick="if($('input[name=btitle]').val().trim()==''){
				alert('제목을 입력하세요');
			return false;
		}else{submitContents(this)}">
			&nbsp;<input type="button"  class="btn btn-default-sm" value="돌아가기" onclick="history.back()">
		</form>
	</div>
	<script type="text/javascript">
var oEditors = [];

// 추가 글꼴 목록
//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "ir1",
	sSkinURI: "SmartEditor2Skin.html",	
	htParams : {
		bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
		fOnBeforeUnload : function(){
			//alert("완료!");
		}
	}, //boolean
	fOnAppLoad : function(){
		//예제 코드
		//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
	},
	fCreator: "createSEditor2"
});
function submitContents(elClickedObj) {

	oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
	
	// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
	
	try {
		elClickedObj.form.submit();
	} catch(e) {}
}

</script>

	
