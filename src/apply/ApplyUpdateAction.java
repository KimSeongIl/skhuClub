package apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class ApplyUpdateAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String uid=(String)session.getAttribute("id");
		String clubName=(String)request.getParameter("clubName");
		String department=(String)request.getParameter("department");
		String grade=(String)request.getParameter("grade");
		String introduction=(String)request.getParameter("introduction");
		
		System.out.println(grade);
		
		ApplyData data=new ApplyData();
		data.setUid(uid);
		data.setClubName(clubName);
		data.setDepartment(department);
		data.setGrade(grade);
		data.setIntroduction(introduction);
		
		ApplyBean bean=ApplyBean.getInstance();
		bean.modifyApply(data);
		
		return "applyUpdate.jsp";
	}

}
