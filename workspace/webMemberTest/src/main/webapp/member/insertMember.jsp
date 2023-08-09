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
	
	$('#save').on('click', function() {
		password1 = $('#mempass1').val();
		password2 = $('#mempass2').val();
		
		if(password1 != password2) {
			alert("비밀번호가 일치하지 않습니다");
			return false;
		}
	})
	
	$('#idcheck').on('click', function() {
		idvalue = $('#memid').val().trim();
		
		$.ajax({
			url : "<%= request.getContextPath() %>/idCheck.do",
			type : "post",
			data : { "id" : idvalue },
			success : function(res) {
				alert(res.flag);					
			},
			error : function(xhr) {
				alert("상태 : " + xhr.status);
			},
			dataType : "json"
		})
	})
})
</script>
</head>
<body>
	<form action="<%= request.getContextPath()%>/insertMember.do" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>회원ID</td>
				<td><input type="text" name="memid" id="memid"><input type="button" id="idcheck" value="중복확인"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="mempass1" id="mempass1"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="mempass2" id="mempass2"></td>
			</tr>
			<tr>
				<td>회원이름</td>
				<td><input type="text" name="memname"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="memtel"></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><input type="text" name="memaddr"></td>
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