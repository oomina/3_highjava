<%@page import="kr.or.redplus.vo.ClientVO"%>

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
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/mypage/bloodinfo.css">
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
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
    <div id="wrapper"> <!-- 이너 래퍼(Asdie+Section)-->
  <!-- Asdie메뉴 -->
 <%@ include file="/view/layout/common/inc_info_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
     	  <div id="pl-title">
		      <h1>혈액이란?</h1>
	      </div>
         <div id="pl-info">
			<div id="info-img">
				<img alt="" src="<%=request.getContextPath() %>/images/layout/책.png" id="book">
			</div>
			<div id="info-text">
				<div>
					<span id="sTitle">혈액이란?</span><br><br>
					- 혈액이란 혈관을 통해 흐르고 있는 체액으로 각종 세포에 산소와 영양분를 공급하고 노폐물을 회수합니다.<br>
				  	혈액은 액체성분인 혈장과 세포성분인 적혈구, 백혈구, 혈소판으로 구성되어 체중의 7~8%를 차지합니다.
				</div>
			</div>
		</div>
		<div id="info-content">
		<br>
			<h1>혈액의 구성</h1><br>
			<h2>적혈구(Red Blood Cells)</h2>
			<p>
				- 참고치: 400~500만개/μL <br>
				- 산소운반<br>
				- 적혈구 한 개당 3백만개 정도의 헤모글로빈 가짐<br>
				- 산소와 결합된 헤모글로빈은 옥시헤모글로빈(Oxyhemoglobin)이라고 하며 밝은 붉은 색을 띰<br>
				- 이산화탄소와 결합하면 카바미노헤모글로빈(Carbaminohemoglobin)로 변하고 검붉은 색 나타냄<br><br><br>
			</p>
			<h2>적혈구(Red Blood Cells)</h2>
			<p>
				- 참고치: 4,000~10,000개/μL <br>
				- 면역시스템을 이루는 세포로 박테리아, 바이러스 등이 침입하면 백혈구 수가 증가되어 신체를 방어함<br>
				- 백혈구에는 호중구(neutrophil), 호염구(basophil,) 호산구(eosinophil), 단구(monocyte) 및 대식세포(macrophage) 등이 있다.<br><br><br>
			</p>
			<h2>혈소판(platelets)</h2>
			<p>
				- 참고치: 15~40만개/μL <br>
				- 손상된 혈관벽에 붙어서혈액응고를 일으켜 피를 멎게 하는 기능과 감염이나 염증이 있을 때 면역작용을 함.<br><br><br>
			</p>
			<h2>혈장(plasma)</h2>
			<p>
				- 혈액의 반 이상 차지 <br>
				- 생명 유지에 꼭 필요한 전해질, 영양분, 비타민, 호르몬, 효소 그리고 항체 및 혈액응고 인자 등 중요한 단백 성분이 들어있음<br>
			</p>
			
		</div>
		     
        
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>