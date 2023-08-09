<%@page import="kr.or.redplus.vo.ClientVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/donation_css/donMain.css">
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  	$(function(){
  		$('#reqBtn').on('click',function(){
  			if($('#title').val().trim()=='' || $('#content').val().trim()==''){
  				alert('요청 형식을 모두 입력해주세요.');
  				return false;
  			}
  		})
  	})
  </script>
</head>
<body>
  <!--!!!TOPMENU 인클루드 시작 !!!-->
 <%
	ClientVO cliVo = (ClientVO)session.getAttribute("login");
 if(cliVo==null) { %> <%@ include file="/view/layout/common/inc_common_topmenu.jsp" %> <% } 
 if(cliVo!=null) {
	 int auth = cliVo.getAuth_code();
	
		switch(auth) {
 		case 0:%> <%@ include file="/view/layout/admin/inc_admin_topmenu.jsp" %> <% ; break;
 		case 1:%> <%@ include file="/view/layout/mem/inc_memcom_topmenu.jsp" %> <% ; break;
 		case 2:%> <%@ include file="/view/layout/bdh/inc_bdh_topmenu.jsp" %> <% ; break;
 		case 3:%> <%@ include file="/view/layout/hos/inc_hos_topmenu.jsp" %> <% ; break;
 		default : %> <%@ include file="/view/layout/common/inc_common_topmenu.jsp" %> <% ; break;
 		} 
 }
%>
  <!-- TopMENU인클루드 종료부분!!!!-->
  
  <div id="container"> <!-- 컨테이너 래퍼 -->
    <div id="wrapper"> <!-- 이너 래퍼(Asdie+Section)-->
  <!-- Asdie메뉴 -->
 <%@ include file="/view/layout/mem/inc_donation_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
      	<div id="pl-title">
	      	<h1>헌혈증 기부 요청</h1>
	      	<p>　· 일반회원은 다른회원에게 전자헌혈증 기부요청하는 게시할 수 있습니다.</p>
      	</div>
      <form action="/DonationReq.do" method="post">
		<div id="don-main">
			<div class="req" id="inputId">
				<div id="" class="info">
					<p>아이디</p>
				</div>
				<div id="" class="content">
					<input type="text" value="${memId }" readonly="readonly" name="id" id="id">
				</div>
			</div>
			<div class="req" id="inputId">
				<div id="" class="info">
					<p>제목</p>
				</div>
				<div id="" class="content">
					<input type="text" name="title" id="title">
				</div>
			</div>
			<div class="req" id="inputId">
				<div id="" class="info">
					<p>지역</p>
				</div>
				<div id="" class="content">
					<select name="location">
							<option>서울</option>
							<option>부산</option>
							<option>경기</option>
							<option>인천</option>
							<option>강원</option>
							<option>충북</option>
							<option>대전세종충남</option>
							<option>전북</option>
							<option>광주전남</option>
							<option>대구경북</option>
							<option>경남</option>
							<option>제주</option>
							<option>울산</option>
						</select>
				</div>
			</div>
			<div class="req" >
				<div id="reqest"  class="info">
					<div id="rqText">
						<p>요청사항</p>
					</div>
				</div>
				<div class="content">
					<textarea cols="75" rows="10" name="content" id="content"></textarea>
				</div>
			</div>
			<div id="btnBox">
				<input type="submit" id="reqBtn" value="요청하기">
			</div>
			<div id="reqinfo-text">
				<p>헌혈 요청시 수령받은 헌혈증은 마이페이지에서 확인하실 수 있습니다</p>
			</div>
		</div>
		
		</form>
	      
        
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>