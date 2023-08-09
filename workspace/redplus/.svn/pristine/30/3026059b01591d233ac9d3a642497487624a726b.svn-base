<%@page import="java.time.LocalDate"%>
<%@page import="kr.or.redplus.vo.ClientVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
LocalDate today_ = LocalDate.now();
String year = String.valueOf(today_.getYear());
String month = String.format("%02d",today_.getMonthValue());
String day = String.format("%02d", today_.getDayOfMonth());
String today = year+"/"+month+"/"+day;
%>
<html lang="ko">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
   <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_hkt/h_bloodStock.css" />
<script src="<%=request.getContextPath() %>/js/js_hkt/h_bloodStock.js"></script>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>

 
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
		<div id="wrapper">
			<!-- 이너 래퍼(Asdie+Section)-->
			<!-- Asdie메뉴 -->
			<%@ include file="/view/layout/hos/inc_hosstock_aside.jsp"%>
			<!-- Asdie메뉴 끝 ..-->


			<!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
			<section class="main_contents">
				<div id="stockMainContainer">
					<h2>${login.client_name} 혈액 재고</h2>

					<div id="choiceList">
						<label for="dateId">입고날짜 :&nbsp;</label><input id='dateId' type="date"> <label for="type">헌혈유형 : </label>
						<select name="type" id="blood-dt-type">
							<option selected  value="">전체선택</option>
							<option>전혈</option>
							<option>혈장</option>
							<option>혈소판</option>
						</select> <label for="bType">혈액형 : </label> <select name="bType" id="blood-type">
							<option selected value="">전체선택</option>
							<option>A</option>
							<option>B</option>
							<option>O</option>
							<option>AB</option>
						</select> 
					</div>
					<div id="stockList"></div>
				
				</div>
		



		</section>
		<!-- 작성칸 끝 -->


</div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>