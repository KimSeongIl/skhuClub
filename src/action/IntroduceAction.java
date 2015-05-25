package action;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.ClubBean;
import club.ClubData;

public class IntroduceAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		String name=request.getParameter("club");
		name=URLDecoder.decode(name);
		
		ClubBean club=ClubBean.getInstance();
		ClubData cd=new ClubData();
		cd=club.viewClub(name);
		
		
		request.setAttribute("viewClub", cd);
		
		return "introduce.jsp";
	}
}
