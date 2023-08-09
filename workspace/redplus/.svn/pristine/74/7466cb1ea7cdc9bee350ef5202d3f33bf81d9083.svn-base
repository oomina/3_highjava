<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>

<html lang="ko">
<head></head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript">mypath = '<%=request.getContextPath()%>

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
			$('#idspan').text("");
			if(!(idreg.test(idvalue))) {
				$('#idCheck').prop('disabled', true);
			} else {
				$('#idCheck').prop('disabled', false);
			}
			
			regcheck(idreg, idvalue, this);
			
		})
		
		$('#uname').on('keyup', function() {
			namevalue = $(this).val().trim();
			namereg = /^[가-힣]{2,10}$/;
			
			regcheck(namereg, namevalue, this);
			
		})
		
		$('#pwd').on('keyup', function() {
			passvalue = $(this).val().trim();
			passreg = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*?]).{8,20}$/;
			
			regcheck(passreg, passvalue, this);
		})

		$('#pwd2').on('keyup', function() {
			passvalue = $(this).val().trim();
			passreg = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*?]).{8,20}$/;
			
			regcheck(passreg, passvalue, this);
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
		
		$('#uhp').on('keyup', function() {
			hpvalue = $(this).val().trim();
			hpreg = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
			
			regcheck(hpreg, hpvalue, this);
		})
		
		regcheck = function(reg, value, ele) {
			if(!(reg.test(value))) {
				$(ele).css('border', '2px solid red');
				$(ele).addClass('false');
			} else {
				$(ele).css('border', '2px solid skyblue');
				$(ele).removeClass('false');
			}
		}
		
		$("#idCheck").on('click',function(){
			idvalue = $('#uid').val().trim();
			
			if(idvalue.length < 1){
				alert("아이디를 입력하세요");
				return false;
			}
			
			$.ajax({
				url : '<%= request.getContextPath() %>/idCheck.do',
				type : 'get',
				data : { "id" : idvalue },
				success : function(res) {
					console.log(res);
					$('#idspan').html(res.flag).css('color','red');
				},
				error : function(xhr) {
					alert("상태 : " + xhr.status);
				},
				dataType : 'json'
			})
		})
		
		$('#zip').on('click', function() {
			dongvalue = $('#dong').val().trim();
			
			$.ajax({
				url : '<%= request.getContextPath() %>/ZipSearch.do',
				data : { "dong" : dongvalue },
				type : 'post',
				dataType : 'json',
				success : function(res) {
					
					code = "<table>";
					code += "<tr><td>우편번호</td><td>주소</td><td>번지</td></tr>";
					$.each(res, function(i, v) {
						bunji = v.bunji;
						if( typeof bunji == "undefined") bunji = "";
						
						code += `<tr><td>${v.zipcode}</td>`;
						code += `<td>${v.sido} ${v.gugun} ${v.dong}</td>`;
						code += `<td>${bunji}</td></tr>`;
					})
					code += `</table>`;
					
					$('#result1').html(code);
				},
				error : function(xhr) {
					alert("상태 : " + xhr.status);
				}
			})
		})
		
		$(document).on('click', '#result1 tr', function() {
			zip = $('td:eq(0)', this).text();
			addr = $('td:eq(1)', this).text();
			
			$('#uzip').val(zip);
			$('#uadd1').val(addr);
			
			$('#zipModal').modal('hide');
			$('#dong').val("");
			$('#result1').empty();
			
		})
		
		$("#send").on('click',function(){
			if($('#uid').val() == "" || $('#uid').hasClass('false')){
				alert("아이디를 입력해주세요");
				return false;
			} else if($('#idspan').text() != "사용 가능 id입니다") {
				alert("아이디 중복체크를 해주세요");
				return false;
			} else if($('#pwd').val() == "" || $('#pwd').hasClass('false')){
				alert("비밀번호를 입력해주세요");
				return false;
			} else if($('#pwd2').val() == "" || $('#pwd2').hasClass('false')){
				alert("비밀번호 확인을 입력해주세요");
				return false;
			} else if($('#pwd').val() != $('#pwd2').val()){
				alert("비밀번호가 일치하지 않습니다! 다시 입력해주세요");
				return false;
			} else if($('#uname').val() == "" || $('#uname').hasClass('false')){
				alert("이름을 입력해주세요");
				return false;
			} else if($('input:radio[name=bloodType]').is(":checked") == ""){
				alert("혈액형을 선택해주세요");
				return false;
			} else if($('#memRegno1').val() == "" || $('#memRegno1').hasClass('false')){
				alert("주민등록번호 앞자리를 입력해주세요");
				return false;
			} else if($('#memRegno2').val() == "" || $('#memRegno2').hasClass('false')){
				alert("주민등록번호 뒷자리를 입력해주세요");
				return false;
			} else if($('#uhp').val() == "" || $('#uhp').hasClass('false')){
				alert("휴대폰번호를 입력해주세요");
				return false;
			} else if($('#uadd1').val() == "" || $('#uadd1').hasClass('false')){
				alert("주소를 입력해주세요");
				return false;
			} else if($('#uadd2').val() == "" || $('#uadd2').hasClass('false')){
				alert("상세주소를 입력해주세요");
				return false;
			}
			
			idvalue = $('#uid').val().trim();
			pwdvalue = $('#pwd').val().trim();
			unamevalue = $('#uname').val().trim();
			bloodTypevalue = $('input[name=bloodType]:checked').val();
			memRegno1value = $('#memRegno1').val().trim();
			memRegno2value = $('#memRegno2').val().trim();
			uhpvalue = $('#uhp').val().trim();
			uaddvalue = $('#uadd1').val().trim() + "," + $('#uadd2').val().trim();
			
			param =
				{
					mem_id : idvalue
					,client_pass : pwdvalue
					,client_name : unamevalue
					,mem_blood_type : bloodTypevalue
					,mem_regno1 : memRegno1value
					,mem_regno2 : memRegno2value
					,client_tel : uhpvalue
					,client_addr : uaddvalue
				}
			
			$.ajax({
				url : '<%=request.getContextPath()%>/Insert.do',
				data : param,
				type : 'post',
				success : function(res) {
					if(res.flag == "가입성공"){
						alert("가입이 완료되었습니다! \n로그인을 해주세요^_^");
						window.location.href= '<%=request.getContextPath()%>/index.do';
					}else{
						alert("이미 가입된 회원입니다.");
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
.select {
	padding : 15px 0px;
}
.select input[type=radio] {
	display : none;
}
.select input[type=radio]+label {
	display : inline-block;
	cursor : pointer;
	width : 80px;
	height : 30px;
	border : 1px solid lightgray;
	border-radius : 5px;
	line-height : 24px;
	text-align : center;
	font-weight : bold;
	font-size : 13px;
}
.select input[type=radio]+label {
	background-color : #fff;
	color : #333;
}
.select input[type=radio]:checked+label {
	border : none;
	background-color : #dc3545;
	color : #fff;
}
.joinbtn {
	text-align : center;
}
.joinbtn1 {
	display : inline-block;
}
</style>
<div class="container"><br>
	<h2>회원가입</h2>
	<h5>정보를 입력해주세요</h5><br>
	<form class="needs-validation">
		<div class="row g-2">
			<div class="col-sm-10">
				<label for="uid">아이디</label>
				<span id="idspan"></span>
				<input type="text" class="form-control" id="uid" name="mem_id" placeholder="문자, 숫자 포함 6~20자" required>
			</div>
			<div class="col-sm">
				<label for="idCheck"></label>
				<button type="button" id="idCheck" class="form-control btn btn-danger">중복확인</button>
			</div>
		</div><br>
		<div class="form-group">
			<label for="pwd">비밀번호</label>
			<input type="password" class="form-control" id="pwd" name="mem_pass" placeholder="문자, 숫자, 특수문자 포함 8~20자" required>
		</div><br>
		<div class="form-group">
			<label for="pwd2">비밀번호 확인</label>
			<input type="password" class="form-control" id="pwd2" name="mem_pass2" placeholder="문자, 숫자, 특수문자 포함 8~20자" required>
		</div><br>
		<div class="form-group">
			<label for="uname">이름</label>
			<input type="text" class="form-control" id="uname" name="mem_name" required>
		</div><br>
		<div class="select form-group">
			<label for="select">혈액형</label>
			<input type="radio" id="select" name="bloodType" value="A"><label for="select">A</label>
			<input type="radio" id="select2" name="bloodType" value="B"><label for="select2">B</label>
			<input type="radio" id="select3" name="bloodType" value="O"><label for="select3">O</label>
			<input type="radio" id="select4" name="bloodType" value="AB"><label for="select4">AB</label>
		</div><br>
		<div class="row g-2">
			<div class="col-sm-6">
				<label for="memRegno1">주민등록번호</label>
				<input type="text" class="form-control" id="memRegno1" name="mem_regno1" placeholder="주민등록번호 앞자리" required>
			</div>
			<div class="col-sm">
				<label for="memRegno2"></label>
				<input type="password" class="form-control" id="memRegno2" name="mem_regno2" placeholder="주민등록번호 뒷자리" required>
			</div>
		</div><br>
		<div class="form-group">
			<label for="uhp">휴대폰번호</label>
			<input type="text" class="form-control" id="uhp" name="mem_hp" placeholder="010-XXXX-XXXX" required>
		</div><br>
		<div class="row g-2">
			<div class="col-sm-10">
				<label for="uadd1">주소</label>
				<input type="text" class="form-control" id="uadd1" name="mem_add1" readonly="readonly" required>
			</div>
			<div class="col-sm">
				<label for="uzip"></label>
				<button type="button" id="uzip" data-toggle="modal" data-target="#zipModal" class="form-control btn btn-danger">주소검색</button>
			</div>
		</div><br>
		<div class="form-group">
			<label for="uadd1">상세주소</label>
			<input type="text" class="form-control" id="uadd2" name="mem_add2" required>
		</div><br>
		<div class="joinbtn">
			<button type="button" id="send" class="btn btn-danger joinbtn1">회원가입</button>
			<button type="button" id="cancel" class="btn btn-danger joinbtn1" onclick="location.href='/index.do'">취소</button>
		</div>
	</form>
</div>
<!-- The Modal -->
<div class="modal" id="zipModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">우편번호찾기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal body -->
			<div class="modal-body">
				<div class="box">
					<p>찾는 동을 입력하세요</p>
					<input type="text" id="dong">
					<input type="button" value="검색" id="zip"><br><br>
					<div class="result" id="result1"></div>
				</div>
			</div>
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>