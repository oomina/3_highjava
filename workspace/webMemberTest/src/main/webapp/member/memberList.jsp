<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#btn').on('click', function() {
		location.href="<%=request.getContextPath()%>/member/insertMember.jsp";
	})
})
</script>
</head>
<body>
<%
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
%>
<h3>회원 목록 보기</h3>
<table border="1">
	<thead>
		<tr><td colspan="5"><input type="button" id="btn" value="회원추가"></td></tr>
		<tr><th>ID</th><th>비밀번호</th><th>이 름</th><th>전 화</th><th>주 소</th></tr>
</thead>
<tbody>
<%
	if(list == null || list.size() == 0) {
%>
		<tr><td colspan="5">등록된 회원이 하나도 없습니다</td></tr>
<%
	} else {
		for(MemberVO vo : list) {
%>
		<tr>
			<td><a href="<%=request.getContextPath()%>/memberdetail.do?memid=<%=vo.getMem_id()%>"><%=vo.getMem_id()%></a></td>
			<td><%=vo.getMem_pass() %></td>
			<td><%=vo.getMem_name() %></td>
			<td><%=vo.getMem_tel() %></td>
			<td><%=vo.getMem_addr() %></td>
		</tr>
<%
		}
	}
%>
</tbody>
</table>
</body>
</html>