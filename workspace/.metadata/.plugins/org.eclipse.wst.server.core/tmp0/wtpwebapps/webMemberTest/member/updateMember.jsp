<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#memlist').on('click', function() {
		location.href = "<%= request.getContextPath() %>/memberList.do";
	})
}
</script>
</head>
<body>
<%
	MemberVO vo = (MemberVO) request.getAttribute("member");
%>
	<form action="<%= request.getContextPath()%>/updateMember.do?memid=<%=vo.getMem_id()%>" method="post" enctype="multipart/form-data">
	<h3>회원 정보 수정 폼</h3>
	<table border="1">
		<tr>
			<td colspan="2"><img src="<%= request.getContextPath() %>/imageView.do?memphoto=<%=vo.getMem_photo()%>"></td>
		</tr>
		<tr>
			<td>회원ID</td>
			<td><%= vo.getMem_id() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mempass" value="<%= vo.getMem_pass() %>"></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><input type="text" name="memname" value="<%= vo.getMem_name() %>"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="memtel" value="<%= vo.getMem_tel() %>"></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><input type="text" name="memaddr" value="<%= vo.getMem_addr() %>"></td>
		</tr>
		<tr>
			<td>프로필 사진</td>
			<td><input type="file" name="memphoto"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="저장" id="save">
				<input type="reset" value="취소" id="cancel">
				<input type="button" value="회원목록" id="memlist">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>