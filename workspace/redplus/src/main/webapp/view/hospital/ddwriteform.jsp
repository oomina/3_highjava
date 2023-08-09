<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="kr.or.redplus.vo.ClientVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>

  <!-- !!!Head인클루드 끝 !!! -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_hkt/h_hoswritereq.css" />

  <title>RedPlus</title>

  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>

$(function() { 
  
	  /* 신청내역을 확인하는 내용 */
	  $('form button').click(function() {
	  var hosId = $('form input[name="hos_id"]').val();
	  var ddDate = $('form input[name="dd_date"]').val();
	  var ddBloodType = $('form input[name="dd_blood_type"]:checked').val();
	  var ddBdType = $('form input[name="dd_bd_type"]:checked').val();

	  var confirmMsg = '요청 의료기관 ID : ' + hosId + '\n';
	  confirmMsg += '신청 날짜 : ' + ddDate + '\n';
	  confirmMsg += '요청 혈액형 : ' + ddBloodType + '\n';
	  confirmMsg += '헌혈 구분 : ' + ddBdType + '\n';

	  if (confirm(confirmMsg + '위의 내용이 맞습니까?')) {
	    $('form').submit();
	  }
	});
	  

	  var today = new Date(); // 현재 날짜와 시간 정보를 가진 Date 객체 생성
	  var year = today.getFullYear(); // 현재 연도 가져오기
	  var month = today.getMonth() + 1; // 현재 월 가져오기 (0부터 시작하므로 1을 더해줌)
	  var day = today.getDate(); // 현재 일 가져오기

	  // 월과 일이 10보다 작으면 앞에 0을 붙여서 두 자리로 만듦
	  month = month < 10 ? '0' + month : month;
	  day = day < 10 ? '0' + day : day;

	  // 날짜 정보를 YYYY-MM-DD 형태의 문자열로 만듦
	  var dateStr = year + '-' + month + '-' + day;

	  // input 요소의 value 속성에 날짜 정보를 넣어줌
	  document.getElementById('dateform').value = dateStr;  
	  

	  
  });
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
 <%@ include file="/view/layout/hos/inc_hosreq_aside.jsp" %>      
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
      




  <div class="writeform">
 <%--  
   <form action="/hos/ddwrite.do" method="post" >
   <fieldset>
   <legend>지정헌혈 요청 신청서 작성</legend>
   	<label for="hos_id">요청 의료기관 ID : </label>
   	<input type="text" name="hos_id" value="${login.client_id}" readonly> <br>
   	<label for="dd_date">마감 날짜 : </label>
   	<input type="date" name="dd_date"  id="dateform"> <br>
   	<label for="dd_blood_type">요청 혈액형 : </label>
   	<input type="radio" name="dd_blood_type" value="A" checked>
   	<label for="A" name="dd_blood_type">A</label>
   	<input type="radio" name="dd_blood_type" value="B">
   	<label for="B" name="dd_blood_type">B</label>
   	<input type="radio" name="dd_blood_type" value="O">
   	<label for="O" name="dd_blood_type">O</label>
   	<input type="radio" name="dd_blood_type" value="AB">
   	<label for="AB" name="dd_blood_type">AB</label><br>
   	<label for="dd_bd_type">헌혈 구분 : </label>
   	<input type="radio" name="dd_bd_type" value="전혈" checked>
   	<label for="dd_bd_type" name="전혈">전혈</label>
   	<input type="radio" name="dd_bd_type" value="혈소판">
   	<label for="dd_bd_type" name="혈소판">혈소판</label>
   	<input type="radio" name="dd_bd_type" value="혈장">
   	<label for="dd_bd_type" name="혈장">혈장</label><br>
   	<button type="button">지정헌혈 요청하기</button>
   	
   	</fieldset>
   	
   
   </form>	 --%>
   
   <form action="/hos/ddwrite.do" method="post" >
   		<div id="checkForm">
			<h1>지정헌혈 요청 신청서 작성</h1>
   	<label for="hos_id">요청 의료기관 ID : </label>
   	<input type="text" name="hos_id" value="${login.client_id}" readonly> <br>
   	<label for="dd_date">마감 날짜 : </label>
   	<input type="date" name="dd_date"  id="dateform"> <br>
   	<label for="dd_blood_type">요청 혈액형 : </label>
   	<input type="radio" name="dd_blood_type" value="A" checked>
   	<label for="A" name="dd_blood_type">A</label>
   	<input type="radio" name="dd_blood_type" value="B">
   	<label for="B" name="dd_blood_type">B</label>
   	<input type="radio" name="dd_blood_type" value="O">
   	<label for="O" name="dd_blood_type">O</label>
   	<input type="radio" name="dd_blood_type" value="AB">
   	<label for="AB" name="dd_blood_type">AB</label><br>
   	<label for="dd_bd_type">헌혈 구분 : </label>
   	<input type="radio" name="dd_bd_type" value="전혈" checked>
   	<label for="dd_bd_type" name="전혈">전혈</label>
   	<input type="radio" name="dd_bd_type" value="혈소판">
   	<label for="dd_bd_type" name="혈소판">혈소판</label>
   	<input type="radio" name="dd_bd_type" value="혈장">
   	<label for="dd_bd_type" name="혈장">혈장</label><br>
   	
   	<button type="button">지정헌혈 요청하기</button>
   	</div>
	</form>
  
  </div>



        
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>