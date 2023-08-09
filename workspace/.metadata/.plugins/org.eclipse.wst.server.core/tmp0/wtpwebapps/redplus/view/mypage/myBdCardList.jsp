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
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/mypage/cardList.css">
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  	$(function(){
  		$.ajax({
  			url:"<%=request.getContextPath()%>/MyBdCardList.do",
  			type :"post",
  			data : {"memId":"${memId}"},
  			dataType : "json",
  			success : function(res){
  				code = "<table id='listTb'><tr><td>발급날짜</td><td>헌혈증코드</td><td>소유자</td><td>헌혈종류</td><td>혈액위치</td><td>생년월일</td><td>성별</td></tr>";
  				$.each(res,function(i,v){
  					if(res.length == 0){
  						code += "<tr><td colspan=7>보유하신 헌혈증이 존재하지 않습니다</td></tr>";
  					}else{
  						code += "<tr><td class='dTd'>"+v.bd_date+"</td><td class='dTd'>"+v.bd_code+"</td><td class='dTd'>"+v.card_owner+"</td><td class='dTd'>"+v.bd_type+"</td><td class='dTd'>"+v.blood_location+"</td><td class='dTd'>"+v.bd_regno1+"</td><td class='dTd'>"+v.bd_gender+"</td></tr>";
  					}
  				})
  				
  				code +="</table>";
  				$('#cardList').html(code);
  				$('#listTb tr').eq(0).css({'background':'#dad8d9','font-weight':'bold','height':'40px'});
  				$('#listTb tr td').eq(1).css('width','160px');
  			},
  			error : function(xhr){
  				alert('status : '+xhr.status);
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
 <%@ include file="/view/layout/mem/inc_mypage_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
      	<div id="pl-title">
	      	<h1>나의 보유헌혈증</h1>
	      	<p>　· 회원이 보유한 헌혈증을 조회하고 자신이 헌혈한 혈액의 위치를 추적 할 수 있습니다.</p>
      	</div>
	  	<div id="info-text">
	  		<p>
	  			<span>${memName}</span>님 환영합니다! <br><br>
	  			현재 보유하신 헌혈증 개수는 <span id="cnt">${cnt}</span>개 입니다.
	  		</p>
	  	</div>
  		<div id="reqinfo">
  			<p>현재 보유헌혈증 목록</p>
  		</div>
  		<div id="cardList">
  		
  		</div>
        
		    
        
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>