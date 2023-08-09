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
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/mypage/curList.css">

  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  	$(function(){
  		$.ajax({
  			url : "<%=request.getContextPath()%>/CurList.do",
  			type : "post",
  			data : {
  				"bdhId":'${vo2.bdh_id}',
  				"clientId":'${vo2.client_id}',
  				"memId":'${vo2.mem_id}'
  			},
  			success: function(res){
  				  code="<table id='bdTb'><tr><td>헌혈일자</td><td>헌혈종류</td><td>혈액원</td><td>헌혈의집</td><td>예약취소</td></tr>";
  				  if(res.length === 0 ){
  					code +="<tr ><td id='noExist' colspan=5 style='height:30px;'>헌혈내역이 존재하지 않습니다</td></tr>"
  				  }else{
  				  	$.each(res,function(i,v){
 	  					 code+="<tr><td >"+v.day_code+"</td><td>"+v.res_type+"</td><td>"+v.bb_name+"</td><td>"+v.bdh_name
 	  					 		+"</td><td><input type='button' value='예약취소' id='delBtn'></td></tr>"  					  
  				  	})					  
  				  }
  				  code+="</table>"
   				  $('#resList').html(code);
  				$('#bdTb tr:eq(0)').css({'background-color':'#f6f6f6','text-align':'center','font-weight':'bold'});
  				
  			},
  			error: function(xhr){
  				alert("status : "+xhr.status);
  			},
  			dataType : 'json'
  		})
  		$(document).on('click','#delBtn',function(){
  			resDate = $(this).closest('tr').find('td:eq(0)').text();
  			if(confirm(resDate+'예약을 취소하시겠습니까?')){
  				$.ajax({
  	  				url : "<%=request.getContextPath()%>/DelRes.do",
  	  				type : "post",
  	  				data : {
  	  					"resDate":resDate,
						"memId":"${vo2.mem_id}"		  	  					
  	  				},
  	  				success: function(res){
  	  				 	alert("예약이 취소 되었습니다");
  	  					location.reload();
  	  				},
  	  				error : function(xhr){
  	  					alert('status : '+xhr.status);
  	  				}
  	  			})
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
 		case 0:%> <%@ include file="/view/layout/admin/inc_admin_topmenu.jsp" %> <%  ; break;
 		case 1:%> <%@ include file="/view/layout/mem/inc_memcom_topmenu.jsp" %> <%  ; break;
 		case 2:%> <%@ include file="/view/layout/bdh/inc_bdh_topmenu.jsp" %> <%  ; break;
 		case 3:%> <%@ include file="/view/layout/hos/inc_hos_topmenu.jsp" %> <%  ; break;
 		default : %> <%@ include file="/view/layout/common/inc_common_topmenu.jsp" %> <%  ; break;
 		} 
 }
%>
  <!-- TopMENU인클루드 종료부분!!!!-->
  
  <div id="container"> <!-- 컨테이너 래퍼 -->
		<div id="wrapper">
			<!-- 이너 래퍼(Asdie+Section)-->
			<!-- Asdie메뉴 -->
			<%@ include file="/view/layout/mem/inc_mypage_aside.jsp"%>
			<!-- Asdie메뉴 끝 ..-->


			<!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
			<section class="main_contents">
				<div id="pl-title">
					<h1>일반헌혈 예약현황</h1>
					<p>　· 회원의 헌혈의집(일반헌혈) 예약 내역을 조회합니다.</p>
				</div>
				<!--다들 여기에 컨텐츠 작성해주세요-->
				<p id="infoText">
					<span>${vo2.client_name}님!</span> 사랑의 헌혈에 참여해 주셔서 감사합니다. 앞으로도 지속적인
					관심과 참여 부탁드립니다.
				</p>
				<div id="pl-info">
					<p class="piTitle">
						현혈횟수 총<span>${cntBd}</span>회
					</p>
					<br>
					<p class="piTitle">
						다음 헌혈 가능일자는<span>${nextResDate}</span>이후에 가능합니다
					</p>
				</div>

				<p id="lastTitle">헌혈예약현황</p>
				<div id="resList"></div>

		</section>
		<!-- 작성칸 끝 -->


	</div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>