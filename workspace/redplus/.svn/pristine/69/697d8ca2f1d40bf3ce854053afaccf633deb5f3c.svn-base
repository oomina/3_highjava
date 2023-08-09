<%@page import="kr.or.redplus.vo.ClientVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_jhs/bdInfo.css" />
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  
  </script>

</style>
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
 <%@ include file="/view/layout/common/inc_info_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">

	<div id="pl-title">
		<h1>헌혈과정</h1>
	</div>
	<div class ="midContainer">
		<p class="mainTitle">
			헌혈기록카드 작성
		</p>
		<p class="mainSide">
			헌혈 전에 필수 헌혈관련 안내문을 읽고 헌혈기록카드(전자문진)를 작성합니다.
		</p>
	</div>
	
	<div class ="midContainer">
		<p class="mainTitle">
			헌혈상담
		</p>
		<p class="sideTitle">
			신분증 확인
		</p>
		<p class="side">
			헌혈 전에 필수 헌혈관련 안내문을 읽고 헌혈기록카드(전자문진)를 작성합니다.
		</p>
		<p class="sideTitle">
			헌혈경력조회
		</p>
		<p class="side">
			혈액정보관리시스템(BIMS)을 통해 과거헌혈경력과 그 검사결과를 조회합니다.
		</p>
		<p class="sideTitle">
			헌혈 전 검사
		</p>
		<p class="sideTitle2">
			1. 몸무게, 혈압, 맥박, 체온 측정
		</p>
		<p class="side">
			몸무게는 남자 50kg 및 여자 45kg 미만, 혈압은 수축기 혈압 90mmHg 미만 또는 180mmHg 이상, 이완기 혈압 100mmHg 이상,
			맥박은 1분간 50회 미만이나 100회 초과, 체온 37.5°C 초과 시 헌혈이 제한됩니다.
		</p>
		<p class="sideTitle2">
			2. 혈액형 검사 (초회 헌혈자에 한함)
		</p>
		<p class="side">
			채혈현장에서는 A,B,O,AB형에 대한 혈구형 검사만 실시하고, 헌혈 후에 검사센터에서 혈구형, 혈청형 등 
			자세한 검사를 실시합니다.
		</p>
		<p class="sideTitle2">
			3. 빈혈검사
		</p>
		<p class="side">
			혈색소 수치가 성분헌혈은 12.0 g/dL 이상인 경우, 전혈 헌혈은 12.5 g/dL 이상인 경우 헌혈이 가능합니다.
		</p>
		<p class="sideTitle2">	
			4. 혈소판 수 측정
		</p>
		<p class="side">
			혈소판 수가 15만 개/μL 이상일 경우 혈소판성분헌혈이 가능합니다.
		</p>
		<p class="sideTitle2">
			5. 문진
		</p>
		<p class="side">
			문진은 헌혈자의 헌혈관련증상 발생을 예방하고 수혈자의 건강을 보호하기 위해 시행하며, 
			문진간호사는 헌혈자가 작성한 헌혈기록카드를 확인하여 헌혈 적격여부를 판정합니다.
		</p>	
	</div>
	
	<div class ="midContainer">
		<p class="mainTitle">
			헌혈
		</p>
		<p class="mainSide"">
			헌혈자는 헌혈 종류를 자유롭게 선택할 수 있으며, <br>
			문진간호사가 당일 혈액제제 수급상황에 따라 필요한 헌혈 종류를 안내드릴 수 있습니다.
		</p>
		<p class="sideTitle2">
			전혈헌혈
		</p>
		<p class="side">
			혈액의 모든 성분을 채혈하는 것입니다.
		</p>
		<p class="sideTitle2">
			성분헌혈
		</p>
		<p class="side">
			성분채혈기를 통해 혈소판, 혈장 성분을 헌혈한다.
		</p>		
	</div>
	
	<div class ="midContainer">
		<p class="mainTitle">
			휴식 및 헌혈증서 수령
		</p>
		<p class="mainSide"">
			헌혈 후 휴식공간이 준비되어 있으며 음료와 다과를 제공해 드립니다.
		</p>
	</div>
	
	<div class ="midContainer">
		<p class="mainTitle">
			헌혈혈액 검사결과 조회
		</p>
		<p class="mainSide">
			혈액관리본부 홈페이지 및 헌혈앱 레드커넥트에서 본인확인 후(휴대폰 인증, 아이핀 인증) 검사결과를 확인할 수 있습니다.
		</p>
	</div>
	
	<div class ="midContainer">
		<p class="mainTitle">
			헌혈 재참여
		</p>
		<p class="mainSide"">
			전혈을 하였을 경우 8주 후, 성분헌혈을 하였을 경우 2주 후 같은 요일부터 다음 헌혈이 가능합니다. 단, 과거 1년 이내에 전혈헌혈 횟수가 5회이면 전혈헌혈이 제한되며, <br>
			과거 1년 이내에 성분헌혈 횟수가 24회일 경우 혈소판성분헌혈, 혈소판혈장성분헌혈이 제한됩니다.
		</p>
	</div>

      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>