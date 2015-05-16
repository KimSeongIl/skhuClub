package club;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class AddClubAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("clubName");
		ClubBean club=ClubBean.getInstance();
		int num=club.addClub(name);
		
		request.setAttribute("result", num);
		
		return "addClubResult.jsp";
		
	}
}
