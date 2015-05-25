package club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class InsertClubExplainAction implements CommandAction{
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

	request.setCharacterEncoding("utf-8");
	
	String name=request.getParameter("name");
	String homepage=request.getParameter("homepage");
	String clubexplain=request.getParameter("clubexplain").replaceAll("\n", "<br>");
	String clubevent=request.getParameter("clubevent").replaceAll("\n","<br>");
	
	ClubData cl=new ClubData();
	
	cl.setName(name);
	cl.setHomePage(homepage);
	cl.setClubExplain(clubexplain);
	cl.setClubEvent(clubevent);
	
	ClubBean dbCl=ClubBean.getInstance();
	
	dbCl.updateClubExplain(cl);
	
	return "Main.jsp";
	
	
	
	
	
	
	
	
}
}
