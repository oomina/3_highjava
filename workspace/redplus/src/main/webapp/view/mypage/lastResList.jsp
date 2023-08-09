<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.redplus.vo.bdhres.BdhResVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BdhResVO> lastVo = (List<BdhResVO>)request.getAttribute("lastVo");
	Gson gson = new Gson();
	String result = gson.toJson(lastVo);
	out.print(result);
	out.flush();
%>