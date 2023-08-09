<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.or.redplus.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	// controller에서 저장한 데이터 꺼내기
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("listValue");
	int startP = (Integer)request.getAttribute("startPage");
	int endP = (Integer)request.getAttribute("endPage");
	int totalP = (Integer)request.getAttribute("totalPage");
	
	JsonObject obj = new JsonObject();
	obj.addProperty("sp", startP);
	obj.addProperty("ep", endP);
	obj.addProperty("tp", totalP);
	
	Gson gson = new Gson();
	JsonElement result = gson.toJsonTree(list);
	
	obj.add("datas", result);
	
	out.print(obj);
	out.flush();
%>