package member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.UserService;//디비 암호화 
import action.CommandAction;

public class InsertMemberAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response )throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		String uid=request.getParameter("uid");
		String p=request.getParameter("password");
		String password=UserService.encryptPasswd(p);
		int studentNum=Integer.parseInt(request.getParameter("studentNum"));
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
	   
		
		MemberData mem=new MemberData();
		
		mem.setId(uid);
		mem.setPw(password);
		mem.setSNum(studentNum);
		mem.setName(name);
		mem.setPhone(phone);
		mem.setEmail(email);
		
		
		
		
		MemberBean dbMem=MemberBean.getInstance();
		
		dbMem.insertMember(mem);
	
		
		
		return "Main.jsp";
	}

}
