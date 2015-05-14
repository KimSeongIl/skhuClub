package board;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

import action.CommandAction;

public class FileDownloadAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		String fileName=request.getParameter("fileName");
		String path=request.getRealPath("/assets/uploads/");
		request.setAttribute("fileName",fileName);
		request.setAttribute("path", path);
		
		return "fileDownload.jsp";
		
	}
}
