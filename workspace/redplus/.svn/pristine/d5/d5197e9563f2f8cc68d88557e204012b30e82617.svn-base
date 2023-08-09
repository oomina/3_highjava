<%@page import="kr.or.redplus.vo.JoinVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
  <!-- BootStrap-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  $(function() {
		if("${msg}" != null && "${msg}" != ""){
			alert("${msg}");
			goToMenu("home");
		}
		
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
		
		$('#uhp').on('keyup', function() {
			hpvalue = $(this).val().trim();
			hpreg = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
			
			regcheck(hpreg, hpvalue, this);
		})
		
		regcheck = function(reg, value, ele) {
			
			flag = false;
			
			if(!(reg.test(value))) {
				$(ele).css('border', '2px solid red');
				flag = false;
			} else {
				$(ele).css('border', '2px solid skyblue');
				flag = true;
			}
			
			return flag;
		}
		
		$('#zip').on('click', function() {
			dongvalue = $('#dong').val().trim();
			
			if($('#dong').val() == ""){
				alert("찾는 동을 입력하세요");
				return false;
			}
			
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
						
						code += "<tr><td>" + v.zipcode + "</td>";
						code += "<td>" + v.sido + " " +  v.gugun + " " + v.dong + "</td>";
						code += "<td>" + bunji + "</td></tr>";
					})
					code += "</table>";
					
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
			bunji = $('td:eq(2)', this).text();
			
			$('#uzip').val(zip);
			$('#uadd1').val(addr + " " + bunji);
			$('#uadd2').val("");
			
			$('#zipModal').modal('hide');
			$('#dong').val("");
			$('#result1').empty();
		})
		
		$("#send").on('click',function(){
			passvalue = $('#pwd').val().trim();
			passreg = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*?]).{8,20}$/;
			if(regcheck(passreg, passvalue, $('#pwd')) == false){
				alert("비밀번호를 다시 입력해주세요");
				$("#pwd").focus();
				return false;
			}
			
			passvalue = $('#pwd2').val().trim();
			passreg = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*?]).{8,20}$/;
			if(regcheck(passreg, passvalue, $('#pwd2')) == false){
				alert("비밀번호 확인을 다시 입력해주세요");
				$("#pwd2").focus();
				return false;
			}
			
			if($("#pwd").val() != $("#pwd2").val()){
				alert("비밀번호가 일치하지 않습니다! 다시 입력해주세요");
				return false;
			}
			
			hpvalue = $('#uhp').val().trim();
			hpreg = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
			if(regcheck(hpreg, hpvalue, $('#uhp')) == false){
				alert("휴대폰번호를 다시 입력해주세요");
				return false;
			}
		
			if($("#uadd1").val().trim() == ""){
				alert("주소를 입력해주세요");
				return false;
			}
			
			if($("#uadd2").val().trim() == ""){
				alert("상세주소를 입력해주세요");
				return false;
			}
			
			form = document.memberInfoForm;
			form.submit();
			
		})
	})
	
  </script>
  <style type="text/css">
section .m-content{
	display: flex;
	justify-content: center;
}
  
section .m-content form {
  display: flex;
  flex-direction: column;
  width: 500px;

}
section .m-content form .btn_warp {
  display: flex;
  justify-content: center;
}
section .m-content form .btn_warp button{
 margin: 5px;
}
#uzip {
 width: 100px;
}
  
  </style>
</head>
<body>
  <!--!!!TOPMENU 인클루드 시작 !!!-->
 <%@ include file="/view/layout/mem/inc_memcom_topmenu.jsp" %>
  <!-- TopMENU인클루드 종료부분!!!!-->
  
  <div id="container"> <!-- 컨테이너 래퍼 -->
    <div id="wrapper"> <!-- 이너 래퍼(Asdie+Section)-->
  <!-- Asdie메뉴 -->
 <%@ include file="/view/layout/mem/inc_mypage_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
      
        <!--다들 여기에 컨텐츠 작성해주세요-->
    
	
	<div id="pl-title">
		<h1>회원정보 수정</h1>
	</div>
	<div class="m-content"><br>
	<form name="memberInfoForm" action="<%=request.getContextPath()%>/updateMemberInfo.do" method="post">
		<div class="form-group">
			<label for="uid">아이디</label>
			<input type="text" class="form-control" id="uid" name="mem_id" value="${joinVO.mem_id}" readonly="readonly" equired>
		</div><br>
		<div class="form-group">
			<label for="pwd">비밀번호</label> <input type="password" class="form-control" id="pwd" name="mem_pass" placeholder="문자, 숫자, 특수문자 포함 8~20자" required>
		</div><br>
		<div class="form-group">
			<label for="pwd2">비밀번호 확인</label>
			<input type="password" class="form-control" id="pwd2" placeholder="문자, 숫자, 특수문자 포함 8~20자" required>
		</div><br>
		<div class="form-group">
			<label for="uname">이름</label>
			<input type="text" class="form-control" id="uname" name="mem_name" value="${joinVO.client_name}" readonly="readonly" required>
		</div><br>
		<div class="form-group">
			<label for="uhp">휴대폰번호</label>
			<input type="text" class="form-control" id="uhp" name="mem_hp" value="${joinVO.client_tel}" placeholder="010-XXXX-XXXX" required>
		</div><br>
		<div class="row g-2">
			<div class="col-sm-9">
				<label for="uadd1">주소</label>
				<input type="text" class="form-control" id="uadd1" name="mem_add1" value="${joinVO.client_addr}" required>
			</div>
			<div class="col-sm">
				<label for="uzip">&nbsp;</label><br>
				<button type="button" id="uzip" data-toggle="modal" data-target="#zipModal" class="form-control btn btn-danger">주소검색</button>
			</div>
		</div><br>
		<div class="form-group">
			<label for="uadd2">상세주소</label>
			<input type="text" class="form-control" id="uadd2" value="${joinVO.client_detail_addr}" name="mem_add2" required>
		</div><br>
		<div class="btn_warp">
			<button type="button" id="send" class="btn btn-danger">수정</button>
			<button type="button" id="cancel" class="btn btn-danger" onclick="location.href='/index.do'">취소</button>
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
        
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>