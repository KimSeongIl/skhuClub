package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import action.CommandAction;
import comment.CommentBean;

import java.util.*;

public class BoardAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		String category=request.getParameter("category");
		int pnum=1;
		if(request.getParameter("pnum")!=null){
			pnum=Integer.parseInt(request.getParameter("pnum"));
		}
		
		
		
		BoardBean board=BoardBean.getInstance();
		double count=board.getBoardCount(category);
		
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
		CommentBean comment=CommentBean.getInstance();
		List commentCount=comment.commentCount(start,end,category);
		List paging=new ArrayList();
		paging.add("<ul class='pagination'>");
		paging.add("<li><a href=board.do?category="+category+">처음</a></li>");
		if(temp>=1){
			paging.add("<li><a href=board.do?category="+category+"&pnum="+pre+">이전</a></li>");
		}
		for(int i=pre;i<next;i++){
			if(i==page){
				break;
			}
			if((i+1)==pnum)
				paging.add("<li class='active'><a>"+(i+1)+"</a></li>");
			else
				paging.add("<li><a href=board.do?category="+category+"&pnum="+(i+1)+">"+(i+1)+"</a></li>");
		}
		if(next<page){
			paging.add("<li><a href=board.do?category="+category+"&pnum="+(next+1)+">다음</a></li>");
		}
		
		paging.add("<li><a href=board.do?category="+category+"&pnum="+page+">마지막</a></li>");
		paging.add("</ul>");
		request.setAttribute("boardList", boardList);
		request.setAttribute("commentCount", commentCount);
		request.setAttribute("count", count);
		request.setAttribute("paging", paging);
		
		return "board.jsp";
	}
}
