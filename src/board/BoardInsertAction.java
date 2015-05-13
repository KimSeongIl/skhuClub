package board;

import java.util.Enumeration;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.CommandAction;

public class BoardInsertAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		String category="";
		String bTitle="";
		String bContent="";
		String fileName=null;
		String uploads=request.getRealPath("/assets/uploads");
		
		try{
		MultipartRequest multi=new MultipartRequest(request,uploads,5*1024*1024,"UTF-8",new DefaultFileRenamePolicy());
		Enumeration params=multi.getFileNames();
		
		
		 String formName=(String)params.nextElement(); // 자료가 많을 경우엔 while 문을 사용
	     fileName=multi.getFilesystemName(formName); 
			
			
		
		category=multi.getParameter("category");
		bTitle=multi.getParameter("btitle");

		bContent=multi.getParameter("bcontent").replaceAll("\n", "<br>");
		}catch(Exception e){
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		
		



		BoardBean board=BoardBean.getInstance();
		board.insertBoard(category,bTitle,bContent,id,fileName);
		
		request.setAttribute("category", category);
		
		return "boardInsert.jsp";
		
		
	}
}
