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

  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
<script>
	$(function() {
		if('${msg}' != null && '${msg}' != ""){
			alert('${msg}');
		}
		
		$("#send").on('click',function(){
			if($('#pwd').val() == ""){
				alert("비밀번호를 입력하세요");
				return false;
			}
			
			form = document.memberInfoForm;
			form.submit();
		})
	})
	
	function MemberInfoUpdatePage(){
		form = document.memberInfoForm; 
	}
</script>
<style type="text/css">
section .m-content form {
  display: flex;
  flex-direction: column;
  align-items: center;
}
section .m-content form div .btn_warp {
  display: flex;
  justify-content: center;
}
section .m-content form div .btn_warp button{
 margin: 5px;
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
	<div id="pl-title">
		<h1>회원정보 수정</h1>
	</div>
	<div class="m-content">
		<form name="memberInfoForm" action="<%=request.getContextPath()%>/memberInfoUpdatePage.do" method="post" onsubmit="return false;">
			<div id="checkForm">
				<h5>회원정보 수정을 위해 현재 사용중인 비밀번호를 입력해주세요&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5><br>
				<div class="form-group">
					<label for="pwd"></label>
					<input type="password" class="form-control" id="pwd" name="client_pass" placeholder="비밀번호를 입력하세요" required>
				</div><br>
				<div class="btn_warp">
				<button type="button" id="send" class="btn btn-danger" onclick="javascript:MemberInfoUpdatePage();">확인</button>
				<button type="button" id="cancel" class="btn btn-danger" onclick="window.history.back()">돌아가기</button>
				</div>
			</div>
		</form>
	</div>
</section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>