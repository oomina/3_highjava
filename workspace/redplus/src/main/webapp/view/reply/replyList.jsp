<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.redplus.vo.ClientVO"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.or.redplus.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//controller에서 저장한 데이터 꺼내기
/*
	List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("replyList");
	int startP = (Integer)request.getAttribute("startPage");
	int endP = (Integer)request.getAttribute("endPage");
	int totalP = (Integer)request.getAttribute("totalPage");
	
	JsonObject obj = new JsonObject();
	obj.addProperty("sp", startP);
	obj.addProperty("ep", endP);
	obj.addProperty("tp", totalP);
	
	Gson gson = new Gson();
	JsonElement result = gson.toJsonTree(list);
	
	obj.add("replies", result);
	
	out.print(obj);
	out.flush();
*/
// ClientVO vo = (ClientVO)session.getAttribute("login");
// DdListVO dvo = new DdListVO();
// Gson gson = new Gson();
// String name, countStr;
// int count = service.getDdCount(vo.getClient_id());
// dvo = service.getDdList(vo.getClient_id());
 
// name = gson.toJson(vo.getClient_name());
//   countStr = gson.toJson(count);
//   Map<String, Object> data = new HashMap<>();

//   if(dvo!=null) {
//      data.put("info", dvo);
// }else {
//    data.put("info", '0');
// }

//  data.put("name", name);
//  data.put("count", countStr);    

 
//  String result = gson.toJson(data);
 
// response.getWriter().write(result);
// response.flushBuffer();   	


	List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("replyList");
	ClientVO vo = (ClientVO)session.getAttribute("login");
	
	JsonObject   obj = new JsonObject();
	if(vo!=null){
		obj.addProperty("login", vo.getClient_id());	
	}else{
		obj.addProperty("login", '0');
	}
	
	
	
	
	Gson gson = new Gson();
	JsonElement   jsonlist  = gson.toJsonTree(list);
	
	
	obj.add("reply", jsonlist);
	
	out.print(obj);
	out.flush();
	
	//String reply, login;
	
	/* reply = gson.toJson(list);
	login = gson.toJson(vo.getClient_id());
	
	Map<String, Object> data = new HashMap<>();
	
	data.put("reply", reply);
	data.put("login", login);
	
	String result = gson.toJson(data);
	 */
	//response.getWriter().write(result);
	//response.flushBuffer();  
%>