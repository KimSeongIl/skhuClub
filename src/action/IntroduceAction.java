package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntroduceAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		return "introduce.jsp";
	}
}
