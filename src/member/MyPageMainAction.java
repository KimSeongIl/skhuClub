package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class MyPageMainAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		MemberBean member=MemberBean.getInstance();
		MemberData md=member.getMemberData(id);
		
		request.setAttribute("member",md);
		
		return "myPage.jsp";
	}
}
