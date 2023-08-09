<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="kr.or.redplus.vo.MemberVO"%>
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

  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
     <% 
	MemberVO mvo = (MemberVO)request.getAttribute("mvo");
 	String name = (String)request.getAttribute("name");
 	List<String> days = (List<String>)request.getAttribute("day");

// 	LocalDate today_ = LocalDate.now();
// 	String year = String.valueOf(today_.getYear());
// 	String month = String.format("%02d",today_.getMonthValue());
// 	String day = String.format("%02d", today_.getDayOfMonth());
// 	String today = year+"/"+month+"/"+day;
	String gender = ""; // 성별을 저장할 변수
	char num = mvo.getMem_regno2().charAt(0);
	if(num == '1'|| num == '3'){
		gender = "남";
	}else{
		gender = "여";
	}
	
 %>
  <script>
	$(function(){
		$.RadioCheck();
	})
  </script>
  <script src="<%=request.getContextPath() %>/js/js_jhs/bdCardLssued.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_jhs/bdCardLssued.css" />
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
 <%@ include file="/view/layout/common/inc_dummy_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
      
        <!--다들 여기에 컨텐츠 작성해주세요-->
			<form method="post" action="<%=request.getContextPath()%>/bdCardInput.do" >
	  	<div id = "BCLForm">
	  		<input type="hidden" name="memId" value='<%=mvo.getMem_id()%>'>
	  		<input type="hidden" name="bdhName" value='<%=cliVo.getClient_name()%>'>
	  		<input type="hidden" name="bdhId" value='<%=cliVo.getClient_id()%>'>
      		<h1>헌혈증 발급</h1>
      		<hr>
	  		<h3>이름</h3>
	  		<input type="text" value='<%=name%>' name="name"  readonly="readonly">
	  		<br>
	  		<h3>발급날짜</h3>
	  		<select id="dayList" name='day'>
	  		  <% for (String day : days) { %>
    			<option value="<%=day%>"><%=day%></option>
  			  <% } %>
	  		</select>
	  		<h3>성별</h3>
	  		<input type="text" value='<%=gender%>' name="gender" readonly="readonly">
	  		<h3>생년월일</h3>
	  		<input type="text" value='<%=mvo.getMem_regno1()%>' name="br" readonly="readonly">
	  		<h3>혈액형</h3>
	  		<input type="text" value='<%=mvo.getMem_blood_type()%>' name="bloodBType" readonly="readonly">
	  		
	  		
	  		<h3>헌혈 종류</h3>
	  		<div class="selectType">
			<input type="radio" name='bloodType' id="selectType1" value="전혈"><label for="selectType1">전혈</label> 
			<input type="radio" name='bloodType' id="selectType2" value="혈소판"><label for="selectType2">혈소판</label> 
			<input type="radio" name='bloodType' id="selectType3" value="혈장"><label for="selectType3">혈장</label> 
			</div>
			
			<h3>발급 형태</h3>
  			<div class="selectType">
			<input type="radio" name='bloodForm' id="selectForm1" value="종이"><label for="selectForm1">종이</label> 
			<input type="radio" name='bloodForm' id="selectForm2" value="전자"><label for="selectForm2">전자</label>  
			</div>


    		<input type="submit" value="발급">
  		</div>	
	  	</form>     
        
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>/html>