	$(document).ready(
			function() {
				
				$('.applicationDelete').click(function(){
					if(confirm('정말 삭제하시겠습니까?')){
						uid=$(this).parent().attr('name');
						
						$.post('applicationDelete.aj',{uid:uid},function(data){
							if(data==1){
								alert('삭제되었습니다.');
								location.href="applicationManagement.do";
							}else{
								alert('오류가 발생했습니다.');
							}
							
						})
					}
					
				})
				
				$('.applyDelete').click(function(){
					if(confirm('정말 삭제하시겠습니까?')){
						uid=$(this).parent().attr('name');
						clubName=$(this).parent().attr('clubname');
						
						$.post('applyDelete.aj',{uid:uid,clubName:clubName},function(data){
							if(data==1){
								alert('삭제되었습니다.');
								location.href="applyManagement.do";
							}else{
								alert('오류가 발생했습니다.');
							}
						})
					}
				})
			
				
				$('#footer li').hover(function(){
					$(this).children('a').css('color','#337AB7');
				},function(){
					$(this).children('a').css('color','white');
				})

				
				$('div.navbar-ex1-collapse ul li').hover(function(){
					//var idx = $(this).index();
					if ($(window).width() >= 768) {
						$(this).find('a').attr({'aria-expanded' : 'true'});
						$(this).addClass('open');
					}
				},function(){
					if ($(window).width() >= 768) {
						$(this).find('a').attr({'aria-expanded' : 'flase'});
						$(this).removeClass('open');
					}
				});
				
				

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
		
		$('#mpw2').append("비번확인: <input type='password' name='passwordCheck' class='form-control'><br><br>");
		$('#mreset').append("<input type='button' value='취소' class='btn btn-default' onclick='modifyReset()'>");
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
	
	function applyDetail(getThis){
		var getName,getGrade,getPhone,getDepartment,getIntroduction,getClubName;
		getName=getThis.parent().parent().find('.getName').html();
		getGrade=getThis.parent().parent().find('.getGrade').html();
		getPhone=getThis.attr('phone');
		getDepartment=getThis.parent().parent().find('.getDepartment').html();
		getIntroduction=getThis.attr('intro');
		getClubName=getThis.parent().parent().find('.getClubName').html();

		
		$('[name=getName]').val(getName);
		$('[name=getGrade]').val(getGrade);
		$('[name=getDepartment]').val(getDepartment);
		$('[name=getPhone]').val(getPhone);
		$('[name=getIntroduction]').val(getIntroduction);
		
		$('[name=getClubName]').val(getClubName);
		
		
		
	}
	
	function applyManagementPop(){
		
		
		$('[name=getGrade]').attr("readonly",false);
		$('[name=getIntroduction]').attr("readonly",false);
		$('[name=getDepartment]').attr("readonly",false);
		$('[name=getClubName]').attr("readonly",false);
		
		
		$('[name=applyModify]').css({"display":"none"});
		$('[name=applySave]').css({"display":"inline-block"});
		$('[name=applyCancel]').css({"display":"inline-block"});
		
	}
	//apply 지원자
	function applyManagementSave(){
	var getClubName,getIntroduction,getDepartment,getGrade;
		
		getClubName=$('[name=getClubName]').val();
		getGrade=$('[name=getGrade]').val();
		getDepartment=$('[name=getDepartment]').val();
		getIntroduction=$('[name=getIntroduction]').val();
		alert(getClubName+"/"+getGrade+"/"+getDepartment+"/"+getIntroduction);
		
		$('[name=applySave]').click(function(){
			$.ajax({
				type:"POST",
				url:"applyUpdate.aj",
				data:{clubName:getClubName,
				grade:getGrade,
				department:getDepartment,
				introduction:getIntroduction
				},
				dataType:"json",
				success:function(json){
					console.log("success updateApply !!");
				},
				error: function(){
					alert("지원서 정보 수정 실패!");
				}
				
			});
		});
		
		
		
		
		
		
	}
	
	
	function applyManagementCancel(){
		
		$('[name=getGrade]').attr("readonly",true);
		$('[name=getIntroduction]').attr("readonly",true);
		$('[name=getClubName]').attr("readonly",true);
		$('[name=getDepartment]').attr("readonly",true);
		
		$('[name=applyModify]').css({"display":"inline-block"});
		$('[name=applySave]').css({"display":"none"});
		$('[name=applyCancel]').css({"display":"none"});
	}
	
	
		
	
	