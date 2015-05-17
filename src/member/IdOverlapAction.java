package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class IdOverlapAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		String uid=request.getParameter("uid");
		MemberBean member=MemberBean.getInstance();
		int check=member.overlapCheck(uid);
		
		request.setAttribute("check", check);
		
		return "overlapId.jsp";
	}
}
