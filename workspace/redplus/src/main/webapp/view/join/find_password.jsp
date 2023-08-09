<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>

<html lang="ko">
<head></head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript">

</script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" />

<!--브라우저 스타일 초기화-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
<!--Google Fonts - 나눔고딕-->
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet" />

<!-- Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!-- BootStrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="../js/js_omn.js" type="text/javascript"></script>
<link rel="stylesheet" href="../css/css_omn.css">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$('#uid').on('keyup', function() {
			idvalue = $(this).val().trim();
			idreg = /^(?=.*[a-z])(?=.*[0-9]).{6,20}$/;
			
			regcheck(idreg, idvalue, this);
			
		})
		
		$('#uname').on('keyup', function() {
			namevalue = $(this).val().trim();
			namereg = /^[가-힣]{2,10}$/;
			
			regcheck(namereg, namevalue, this);
			
		})
		
		$('#memRegno1').on('keyup', function() {
			hpvalue = $(this).val().trim();
			hpreg = /^[0-9]{6}$/;
			
			regcheck(hpreg, hpvalue, this);
		})
		
		$('#memRegno2').on('keyup', function() {
			hpvalue = $(this).val().trim();
			hpreg = /^[0-9]{7}$/;
			
			regcheck(hpreg, hpvalue, this);
		})
		
		regcheck = function(reg, value, ele) {
			if(!(reg.test(value))) {
				$(ele).css('border', '2px solid red');
			} else {
				$(ele).css('border', '2px solid skyblue');
			}
		}
		
		$("#send").on('click',function(){
			if($('#uid').val() == ""){
				alert("아이디를 입력해주세요");
				return false;
			} else if($('#uname').val() == ""){
				alert("이름을 입력하세요");
				return false;
			} else if($('#memRegno1').val() == ""){
				alert("주민등록번호 앞자리를 입력해주세요");
				return false;
			} else if($('#memRegno2').val() == ""){
				alert("주민등록번호 뒷자리를 입력해주세요");
				return false;
			}
			
			idvalue = $('#uid').val().trim();
			unamevalue = $('#uname').val().trim();
			memRegno1value = $('#memRegno1').val().trim();
			memRegno2value = $('#memRegno2').val().trim();
			
			param =
				{
					mem_id : idvalue
					,client_name : unamevalue
					,mem_regno1 : memRegno1value
					,mem_regno2 : memRegno2value
				}
			$.ajax({
				url : '<%=request.getContextPath()%>/findPassword.do',
				data : param,
				type : 'post',
				success : function(data) {
					if(data.pwd == null || data.pwd == ""){
						alert("회원정보가 일치하지 않습니다.");
					} else if ($("#pwd").css("display") == "none"){
						$("#pwd").show();
						$("#pwd").text("임시 비밀번호는 " + data.pwd + "입니다");
						$("#send").css("display", "none");
					}
				},
				error : function(xhr) {
					alert("상태 : " + xhr.status)
				},
				dataType : 'json'
			})
		})
	})
</script>
<style>
.pwdbtn {
	text-align : center;
}
.pwdbtn1 {
	display : inline-block;
}
#pwd {
	padding : 2em 2em; 
	margin : 2em 10px; 
	font-weight : bold; 
	color : #565656; 
	background : #E4FCFF; 
	box-shadow : 0px 0px 0px 10px #E4FCFF; 
	border : dashed 2px #1DC1D6; 
	border-radius : 8px;
}
</style>
<div class="container"><br>
	<h2>비밀번호 찾기</h2>
	<h5>정보를 입력해주세요</h5><br>
	<form class="needs-validation">
		<div class="form-group">
			<label for="uid">아이디</label>
			<input type="text" class="form-control" id="uid" name="mem_id" required>
		</div><br>
		<div class="form-group">
			<label for="uname">이름</label>
			<input type="text" class="form-control" id="uname" name="mem_name" required>
		</div><br>
		<div class="row g-2">
			<div class="col-sm-6">
				<label for="memRegno1">주민등록번호</label>
				<input type="text" class="form-control" id="memRegno1" name="mem_regno1" required>
			</div>
			<div class="col-sm">
				<label for="memRegno2"></label>
				<input type="password" class="form-control" id="memRegno2" name="mem_regno2" required>
			</div>
		</div><br><br>
		<div class="pwdbtn">
			<button type="button" id="send" class="btn btn-primary pwdbtn1">비밀번호 찾기</button>
			<button type="button" id="login" class="btn btn-primary pwdbtn1" onclick="location.href='/login.do'">로그인하러 가기</button>
		</div>
	</form><br>
	<div id="pwd" style="display : none;"></div>
</div>
</body>
</html>