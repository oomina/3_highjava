<%@page import="kr.or.redplus.vo.ClientVO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
  <!-- BootStrap-->
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js" integrity="sha512-IQLehpLoVS4fNzl7IfH8Iowfm5+RiMGtHykgZJl9AWMgqx0AmJ6cRWcB+GaGVtIsnC4voMfm8f2vwtY+6oPjpQ==" crossorigin="anonymous"></script>
    <script defer src="<%=request.getContextPath()%>/js/main.js"></script>


  <!-- !!!head 인클루드 시작!!! -->
<%-- <%@ include file="/view/layout/common/inc_common_head.jsp" %> --%>

 <!--<link rel="shortcut icon" href="favicon.ico" />-->
  <link rel="icon" href="<%=request.getContextPath()%>/images/favicon/favicon.ico" />
  <link rel="icon" href="<%=request.getContextPath()%>/images/favicon/favicon.png" />
  <!--Google Fonts - 나눔고딕-->
  <link rel="preconnect" href="https://fonts.gstatic.com" />
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet" />

  <!-- !!!Head인클루드 끝 !!! -->



  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>

  </script>
  
  <style type="text/css">
body > section.bdgraph > div > ul{
	display: flex;
}
body > section.bdgraph > div > ul > li{
	position: relative;
	width: 50%;
	margin: 10px;
	padding: 20px;
	border: 5px solid #f4515e;
	border-radius: 10px;
}
body > section.bdgraph > div > ul > li > h4{
	font-size: 20px;
	font-weight: 700;
}
body > section.bdgraph > div > ul > li > h1{
	font-size: 12px;
}

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
      
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->

 <%@ include file="/view/layout/common/inc_frontpage.jsp" %>
       <!-- 작성칸 끝 -->
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>