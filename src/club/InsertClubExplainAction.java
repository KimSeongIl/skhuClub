package club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class InsertClubExplainAction implements CommandAction{
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

	request.setCharacterEncoding("utf-8");
	
	String homepage=request.getParameter("homepage");
	String clubexplain=request.getParameter("clubexplain");
	String clubevent=request.getParameter("clubevent");
	
	ClubData cl=new ClubData();
	
	
	cl.setHomePage(homepage);
	cl.setClubExplain(clubexplain);
	cl.setClubEvent(clubevent);
	
	ClubBean dbCl=ClubBean.getInstance();
	
	dbCl.insertClubExplain(cl);
	
	return "Main.jsp";
	
	
	
	
	
	
	
	
}
}
