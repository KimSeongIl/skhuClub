<div id="article">
<%@page import="java.net.*" %>
<%@page import="club.ClubData" %>

<% 
String getClub=request.getParameter("club");
String club=URLDecoder.decode(getClub,"UTF-8");
	



//  디비에서 정보를 가져오기 위해 

ClubData viewClub=(ClubData)request.getAttribute("viewClub");
String homepage="";
String clubExplain="";
String clubEvent="";
String image="";
String member="";
String phone="";
if(viewClub!=null){
homepage="<a href=//"+viewClub.getHomePage()+" target='_blank'>"+viewClub.getHomePage()+"</a>";//링크르 걸어주기위해서 ( //를 해줘야 상대경로 안가짐  )
clubExplain=viewClub.getClubExplain();
clubEvent=viewClub.getClubEvent();
image=viewClub.getImage();
member=viewClub.getMember();
phone=viewClub.getPhone();

if(viewClub.getHomePage()==null){
	homepage="";
}
if(clubExplain==null){
	clubExplain="";
}
if(clubEvent==null){
	clubEvent="";
}
if(image==null){
	image="";
}
if(member==null){
	member="";
}
if(phone==null){
	phone="";
}
}
%>


    


 


    <!-- Intro Section -->
    <section id="intro" class="intro-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                 <h1><%=club %></h1>
                 <div style="margin:auto;max-width:900px;">
                <div  style="width:170px;height:177px; border:3px solid #E3E3E3;border-radius:5px;float:left;text-align:center;padding:10px;">
                    <img src="<%=image %>" width="90%" height="90%" >
               </div>
               <div style="float:left;margin-left:50px;">
                    
                    <br><br><br>
                    	현회장:&nbsp;<%=member %><br><br>
                    	연락처:&nbsp;<%=phone %><br><br>
                    
                   		 홈페이지:&nbsp;<%=homepage %>
                    
                </div>
                </div>
                </div>
            </div>
        </div>
        
    </section>
<br><br>	
    <!-- About Section -->
    <section id="about" >
<nav class="navbar navbar-default">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
     
      <a class="navbar-brand" href="#"><%=club %></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div  id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li style="background-color:white;"><a href="#about" style="color:#337AB7 !important;">동아리 소개<span class="sr-only">(current)</span></a></li>
        <li ><a href="#services">활동 및 행사</a></li>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    
                    
                    <%=clubExplain %>
                  
                    
                </div>
            </div>
        </div>
    </section>

    <!-- Services Section -->
    <section id="services" class="services-section">
<nav class="navbar navbar-default">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
     
      <a class="navbar-brand" href="#"><%=club %></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#about">동아리 소개</a></li>
        <li style="background-color:white;"><a href="#services" style="color:#337AB7 !important;">활동 및 행사<span class="sr-only">(current)</span></a></li>
          
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    
                    <%=clubEvent %>
                </div>
            </div>
           
        </div>
    </section>





    
</nav>
        
      
    </section>
  <%if(session.getAttribute("auth")==null){ %> 
  <div style="text-align:right"><a href="application.do?club=<%=getClub %>" class="btn btn-primary" >지원하기</a></div>
<%}else{ %>
	<div style="text-align:right"><a href="clubExplain.do?club=<%=getClub %>" class="btn btn-primary" >올리기</a></div>
<%} %>

</div>
