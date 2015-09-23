package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.MemberData;
import logon.LogonBean;
import action.UserService;

public class LoginProAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable{
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String p=UserService.encryptPasswd(pw);
		
		HttpSession session = request.getSession();
		
		LogonBean dbPro=LogonBean.getInstance();
		MemberData check=dbPro.userCheck(id, p);
		
		request.setAttribute("check", check);
		
		
		return "loginPro.jsp";
	}
}
