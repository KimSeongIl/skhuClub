package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		
		
		return "logoutPro.jsp";
	}
}
