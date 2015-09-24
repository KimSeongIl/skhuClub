package club;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class AddClubAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		
		
		return "addClub.jsp";
		
	}
}
