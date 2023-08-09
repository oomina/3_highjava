<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
<%
MemberVO vo = (MemberVO) request.getAttribute("member");
%>
$(function(){
	$('#memlist').on('click', function(){
		location.href="<%=request.getContextPath()%>/memberList.do";
	})
	
	$('#update').on('click', function(){
		location.href="<%=request.getContextPath()%>/memberdetail.do?update=true&memid=<%=vo.getMem_id()%>";
	})
	
	$('#delete').on('click', function(){
		idvalue = "<%=vo.getMem_id()%>";
		$.ajax({
			url : "<%=request.getContextPath()%>/deleteMember.do",
			type : "post",
			data : { "memid" : idvalue },
			success : function(res) {
				alert(res.flag);
			},
			error : function(xhr) {
				alert("상태 : " + xhr.status);
			},
			dataType : "json"
		}) 
		location.href="<%=request.getContextPath()%>/memberList.do";
	})
})
</script>
</head>
<body>

	<h3>회원 정보 상세보기</h3>
	<table border="1">
		<tr>
			<td colspan="2"><img src="<%=request.getContextPath()%>/imageView.do?memphoto=<%=vo.getMem_photo()%>"></td>
		</tr>
		<tr>
			<td>회원ID</td>
			<td><%= vo.getMem_id() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= vo.getMem_pass() %></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><%= vo.getMem_name() %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%= vo.getMem_tel() %></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><%= vo.getMem_addr() %></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="수정" id="update" onclick="location.href='<%=request.getContextPath() %>/updateMember.do?memId=<%=vo.getMem_id()%>'">
			<input type="button" value="삭제" id="delete" onclick="location.href='<%=request.getContextPath() %>/deleteMember.do?memId=<%=vo.getMem_id()%>'">
			<input type="button" value="회원목록" id="memlist" onclick="location.href='<%=request.getContextPath()%>/memberList.do'">
			</td>
		</tr>
	</table>
</body>
</html>