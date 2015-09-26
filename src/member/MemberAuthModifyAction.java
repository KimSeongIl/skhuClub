package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class MemberAuthModifyAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response )throws Throwable{
		request.setCharacterEncoding("UTF-8");
		String clubName=request.getParameter("clubName");
		String uid=request.getParameter("uid");
		MemberBean bean=MemberBean.getInstance();
		bean.memberAuthModify(clubName, uid);
		return null;
	}
}
