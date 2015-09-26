package club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class ClubInsertAction implements CommandAction{

public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		String clubName=request.getParameter("clubName");
		
		ClubBean bean=ClubBean.getInstance();
		int result=bean.addClub(clubName);
		
		request.setAttribute("result", result);
		
		return "addClubResult.jsp";
		
	}
}
