package club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;
import java.util.*;

public class ClubListAction implements CommandAction{
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		ClubBean club=ClubBean.getInstance();
		List clubList=club.clubList();
		
				request.setAttribute("clubList", clubList);
		
		return "clubList.jsp";
		
	}
}
