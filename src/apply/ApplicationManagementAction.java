package apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class ApplicationManagementAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		ApplyData data=new ApplyData();
		data.setClubName(auth);
		ApplyBean bean=ApplyBean.getInstance();
		List<ApplyData> list=bean.getApplyAdmin(data);
		request.setAttribute("list",list);
		return "applicationManagement.jsp";
	}
}

