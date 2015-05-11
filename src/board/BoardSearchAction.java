package board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;

public class BoardSearchAction implements CommandAction{
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		String category=request.getParameter("category");
		int pnum=1;
		if(request.getParameter("pnum")!=null){
			pnum=Integer.parseInt(request.getParameter("pnum"));
		}
		int ss=Integer.parseInt(request.getParameter("search"));
		String value=request.getParameter("value");
		
		
		
		
		
		BoardBean board=BoardBean.getInstance();
		final int VIEW=10;
		final int PAGEVIEW=5;
		int start=(pnum-1)*VIEW;
		int end=VIEW;
		double count=0;
		List boardList = null;
		if(ss==1){
			count=board.getSearchCount(category,value);
			boardList=board.boardSearch(category,value,start,end);
		}
		else if(ss==2){
			System.out.println(1);
			count=board.getSearchNameCount(category, value);
			
			boardList=board.boardSearchName(category, value, start, end);
			System.out.println(2);
		}
		
		if(count==0){
			count=1;
		}
		
		double temp=Math.ceil(count/VIEW);
		int page=(int)temp;
		double pnumTemp=pnum;
		temp=Math.ceil(pnumTemp/PAGEVIEW);
		temp=temp-1;
		
		int pre=(int)temp*5;
		int next=((int)temp+1)*5;
		
		List paging=new ArrayList();
		
		paging.add("<a href=boardSearch.do?category="+category+"&search="+ss+"&value="+value+">처음</a> &nbsp;");
		if(temp>=1){
			paging.add("<a href=boardSearch.do?category="+category+"&search="+ss+"&value="+value+"&pnum="+pre+">이전</a> &nbsp;");
		}
		for(int i=pre;i<next;i++){
			if(i==page){
				break;
			}
			if((i+1)==pnum)
				paging.add((i+1)+" &nbsp;");
			else
				paging.add("<a href=boardSearch.do?category="+category+"&search="+ss+"&value="+value+"&pnum="+(i+1)+">"+(i+1)+"</a> &nbsp;");
		}
		if(next<page){
			paging.add("<a href=boardSearch.do?category="+category+"&search="+ss+"&value="+value+"&pnum="+(next+1)+">다음</a> &nbsp;");
		}
		
		paging.add("<a href=boardSearch.do?category="+category+"&search="+ss+"&value="+value+"&pnum="+page+">마지막</a> &nbsp;");
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("count", count);
		request.setAttribute("paging", paging);
		
		return "board.jsp";
	}
}
