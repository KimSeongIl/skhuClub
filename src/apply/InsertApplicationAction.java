package apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class InsertApplicationAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("utf-8");
		
		String grade=request.getParameter("grade");
		String department=request.getParameter("department");
		String instroduction=request.getParameter("instroduction");
		HttpSession session=request.getSession();
		String uid=(String)session.getAttribute("id");
		String clubname=request.getParameter("club");
		
		ApplyData app=new ApplyData();
		
		app.setUid(uid);
		app.setGrade(grade);
		app.setDepartment(department);
		app.setIntroduction(instroduction);
		app.setClubName(clubname);
		ApplyBean dbApp=ApplyBean.getInstance();
		
		dbApp.insertApply(app);
		
		
		return "Main.jsp";
	}
}
