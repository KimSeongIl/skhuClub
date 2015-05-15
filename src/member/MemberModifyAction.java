package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class MemberModifyAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("uid");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
	
		MemberData md=new MemberData();
		md.setId(id);
		md.setPw(pw);
		md.setName(name);
		md.setPhone(phone);
		md.setEmail(email);
		
		MemberBean member=MemberBean.getInstance();
		member.modifyMember(md);
		
		
		return null;
		
	}
}
