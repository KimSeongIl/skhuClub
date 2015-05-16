	$(document).ready(
			function() {
				
				
				$('.dropdown,.dropdown-menu').hover(
						function() {

							if ($(window).width() >= 768) {
								$(this).addClass('open').trigger(
										'shown.bs.dropdown', relatedTarget)
								return false;
							}

						},
						function() {
							if ($(window).width() >= 768) {
								$(this).removeClass('open').trigger(
										'hidden.bs.dropdown', relatedTarget)
								return false;
							}
						})

				$('#login').click(function(){
					var loginLeft=($(window).width()-$('#loginDiv').outerWidth())/2;
					var loginTop=($(window).height()-$('#loginDiv').outerHeight())/2;
					$('#loginDiv').css({'left':loginLeft,'top':loginTop,'display':'block'});
					wrapMask();
					$('#loginId').focus();
				})
				$("#loginClose").click(function(){
					$('#layered,#loginDiv').css('display','none');
					
				})
				
				window.onresize=function(){
					
					var maskWidth=$(document).width();
					var maskHeight=$(document).height();
					
					$('#layered').css({'width':maskWidth,'height':maskHeight});
					
					var loginLeft=($(window).width()-$('#loginDiv').outerWidth())/2;
					var loginTop=($(window).height()-$('#loginDiv').outerHeight())/2;
					$('#loginDiv').css({'left':loginLeft,'top':loginTop});
					
					
				}
				
				$('#clubList').load('clubList.aj');
			})
	function wrapMask(){
		
		var maskWidth=$(document).width();
		var maskHeight=$(document).height();
		
		$('#layered').css({'width':maskWidth,'height':maskHeight,'display':'block'});
		
	}
	function boardSearch(category){
		var bsv=$('#boardSearchValue').val().trim();
		if($('#searchSelect').val()=='제목+내용'){
			ss=1;
		}
		else{
			ss=2;
		}
		
		if(bsv==''){
			alert('한글자 이상 입력하세요!')
		}
		else{
			location.href="boardSearch.do?category="+category+"&search="+ss+"&value="+bsv;
		}
	}
	
	function commentWrite(bid){
		var commentContent=$('#commentContent').val();
		$.post('commentWrite.aj',{bid:bid,bdcontent:commentContent},function(data){
			
			$('#comment').html(data);
			
			$('#commentContent').val('');
		})
	}
	
	function commentDelete(bdid,bid){
		if(confirm('삭제하시겠습니까?')){
			$.post('commentDelete.aj',{bdid:bdid,bid:bid},function(data){
				$('#comment').html(data);
			})
		}
	}
	function fileDownload(){
		
		$('#downloadForm').submit();
		
	}
	function memberModify(){
		$('input[name=password],input[name=name],input[name=phone],input[name=email]').removeAttr("readonly");
		
		$('#mpw2').append("비밀번호확인: <input type='password' name='passwordCheck' class='form-control'><br>");
		$('#mreset').append("<input type='button' value='취소' class='btn btn-default-sm' onclick='modifyReset()'>");
		$('input[name=password]').focus();
		$('#modifyBtn').removeAttr('onclick');
		$('#modifyBtn').attr('onclick','memberSubmit(this.form)');
	}
	
	
	function modifyReset(){
		
		$('#mpw2').html('');
		
		$("form").each(function() {  
		   if(this.id == "modifyForm") 
			   this.reset();  
		});  

		
		$('input[name=password],input[name=name],input[name=phone],input[name=email]').attr("readonly",true);
		$('#modifyBtn').removeAttr('onclick');
		$('#modifyBtn').attr('onclick','memberModify()');
		
		$('#mreset').html('');
		
		
	}
	
	function clubList(){
		$('#clubList').css('display','block');
	}
	function clubListClose(){
		$('#clubList').css('display','none');
	}
		
	
	