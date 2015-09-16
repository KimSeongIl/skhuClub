package apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class ApplicationDeleteAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		String uid=(String)request.getParameter("uid");
		
		ApplyData data=new ApplyData();
		HttpSession session=request.getSession();
		data.setUid(uid);
		data.setClubName((String)session.getAttribute("auth"));
		ApplyBean bean=ApplyBean.getInstance();
		int result=bean.deleteApplication(data);
		request.setAttribute("result", result);
		return "applyDelete.jsp";
	}
}

