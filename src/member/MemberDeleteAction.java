package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class MemberDeleteAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response )throws Throwable{
		String uid=request.getParameter("uid");
		MemberBean bean=MemberBean.getInstance();
		bean.memberDelete(uid);
		return null;
	}
}
