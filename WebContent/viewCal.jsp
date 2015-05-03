<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" %>
<%
	List cal=(List)request.getAttribute("cal");
	out.print(cal);
%>
