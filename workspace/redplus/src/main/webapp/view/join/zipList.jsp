<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.redplus.vo.JoinZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<JoinZipVO> list = (List<JoinZipVO>)request.getAttribute("listvalue");
	
	Gson gson = new Gson();
	String result = gson.toJson(list);
	
	out.print(result);
	out.flush();
%>