<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.or.redplus.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// controller에서 저장한 데이터 꺼내기
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("myListValue");
	
	Gson gson = new Gson();
	
	String result = gson.toJson(list);
	
	out.print(result);
	out.flush();
%>