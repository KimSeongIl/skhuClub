package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

import java.util.*;

public class BoardAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		String category=request.getParameter("category");
		int pnum=1;
		if(request.getParameter("pnum")!=null){
			pnum=Integer.parseInt(request.getParameter("pnum"));
		}
		
		
		
		BoardBean board=BoardBean.getInstance();
		double count=board.getBoardCount();
		if(count==0){
			count=1;
		}
		final int VIEW=10;
		final int PAGEVIEW=5;
		int start=(pnum-1)*VIEW;
		int end=VIEW;
		double temp=Math.ceil(count/VIEW);
		int page=(int)temp;
		double pnumTemp=pnum;
		temp=Math.ceil(pnumTemp/PAGEVIEW);
		temp=temp-1;
		
		int pre=(int)temp*5;
		int next=((int)temp+1)*5;
		List boardList=board.boardMain(category,start,end);
		List paging=new ArrayList();
		
		paging.add("<a href=board.do?category="+category+">처음</a> &nbsp;");
		if(temp>=1){
			paging.add("<a href=board.do?category="+category+"&pnum="+pre+">이전</a> &nbsp;");
		}
		for(int i=pre;i<next;i++){
			if(i==page){
				break;
			}
			if((i+1)==pnum)
				paging.add((i+1)+" &nbsp;");
			else
				paging.add("<a href=board.do?category="+category+"&pnum="+(i+1)+">"+(i+1)+"</a> &nbsp;");
		}
		if(next<page){
			paging.add("<a href=board.do?category="+category+"&pnum="+(next+1)+">다음</a> &nbsp;");
		}
		
		paging.add("<a href=board.do?category="+category+"&pnum="+page+">마지막</a> &nbsp;");
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("count", count);
		request.setAttribute("paging", paging);
		
		return "board.jsp";
	}
}
