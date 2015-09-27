package club;



import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class InsertClubExplainAction implements CommandAction{
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

	request.setCharacterEncoding("utf-8");
	
	

	String uploads=request.getServletContext().getRealPath("/assets/uploads");
	System.out.println(uploads);
	int sizeLimit= 1024*1024*15;
	
	
	MultipartRequest multi = new MultipartRequest(request,uploads, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
	
	
	 
	 
	String fileName = multi.getFilesystemName("clubImage");
	String m_fileFullPath = "/assets/uploads/"+ fileName; 
	System.out.println(m_fileFullPath);
	
      
	
 	String name=multi.getParameter("name");
 	String homepage=multi.getParameter("homepage");
 	String clubexplain=multi.getParameter("clubexplain").replaceAll("\n", "<br>");
 	String clubevent=multi.getParameter("clubevent").replaceAll("\n","<br>");
 	System.out.println(name);
 	System.out.println(homepage);
 	System.out.println(clubexplain);
 	System.out.println(clubevent);
	
	ClubData cl=new ClubData();
	
	cl.setName(name);
	cl.setHomePage(homepage);
	cl.setClubExplain(clubexplain);
	cl.setClubEvent(clubevent);
	cl.setImage(m_fileFullPath);
	
	ClubBean dbCl=ClubBean.getInstance();
	
	dbCl.updateClubExplain(cl);
	
	return "Main.jsp";
	
	
	
	
	
	
	
	
}
}
