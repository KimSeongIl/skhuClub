package member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.ClubBean;
import action.CommandAction;

public class MemberManagementAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response )throws Throwable{
	
		MemberBean bean=MemberBean.getInstance();
		List list=bean.memberList();
		ClubBean club=ClubBean.getInstance();
		List clubList=club.clubList();
		request.setAttribute("list", list);
		request.setAttribute("clubList", clubList);
		return "memberManagement.jsp";
	}
}
