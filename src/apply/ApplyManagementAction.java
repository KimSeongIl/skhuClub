package apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class ApplyManagementAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		HttpSession session=request.getSession();
		ApplyData data=new ApplyData();
		data.setUid((String)session.getAttribute("id"));
		ApplyBean bean=ApplyBean.getInstance();
		List<ApplyData> list=bean.getApplyById(data);
		request.setAttribute("list", list);
		
		return "applyManagement.jsp";
	}
}
