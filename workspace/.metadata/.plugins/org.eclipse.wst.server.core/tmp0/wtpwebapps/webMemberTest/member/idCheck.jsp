<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String) request.getAttribute("userid");
if(id != null) {
%>
	{
		"flag" : "사용 불가능한 id입니다."
	}
<% } else { %>
	{
		"flag" : "사용 가능한 id입니다."
	}	
<%
}
%>