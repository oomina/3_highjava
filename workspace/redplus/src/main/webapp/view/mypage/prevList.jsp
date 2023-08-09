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
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/mypage/resList.css">

  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  	$(function(){
  		$.ajax({
  			url : "<%=request.getContextPath()%>/ResList.do",
  			type : "post",
  			data : {
  				"bdhId":'${vo2.bdh_id}',
  				"clientId":'${vo2.client_id}',
  				"memId":'${vo2.mem_id}'
  			},
  			success: function(res){
  				  code="<table id='bdTb'><tr><td>헌혈일자</td><td>헌혈종류</td><td>헌혈원</td><td>헌혈의집</td></tr>";
  				  if(res.length === 0 ){
  					code +="<tr ><td id='noExist' colspan=4 style='height:30px;'>헌혈내역이 존재하지 않습니다</td></tr>"
  				  }else{
  				  	$.each(res,function(i,v){
 	  					 code+="<tr><td >"+v.day_code+"</td><td>"+v.res_type+"</td><td>"+v.bb_name+"</td><td>"+v.bdh_name+"</td></tr>"  					  
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
    <div id="wrapper"> <!-- 이너 래퍼(Asdie+Section)-->
  <!-- Asdie메뉴 -->
 <%@ include file="/view/layout/mem/inc_mypage_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
      	<div id="pl-title">
	      	<h1>일반헌혈이력 조회</h1>
	        <p>　· 지난 헌혈기록을 조회하고 총 헌혈 횟수와 최근 헌혈일, 헌혈종류에 따라 다음 헌혈가능일자를 계산하여 보여줍니다.</p>
      	</div>
        <!--다들 여기에 컨텐츠 작성해주세요-->
        <p id="infoText">
        	<span>${vo2.client_name}님!</span> 사랑의 헌혈에 참여해 주셔서 감사합니다. 앞으로도 지속적인 관심과 참여 부탁드립니다.
        </p>
		<div id="pl-info">
			<p class="piTitle">현혈횟수 총<span>${cntBd}</span>회</p><br>
			<p class="piTitle">다음 헌혈 가능일자는<span>${nextResDate}</span>이후에 가능합니다</p>
		</div>
		<div id="lastRes">
			<div id="notice">
				<ul>
					<li>
						헌혈 혈액검사결과(특검결과는 제외)에 따른 다음 헌혈가능일자입니다.<br><br>
					</li>
					
					<li>
						혈액검사결과, 연간 채혈량 제한, 기타 사유로 헌혈예약 및 헌혈참여가 제한될 수 있으며 필요시 특별검사를 실시할 수 있습니다.<br><br>
					</li>
					<li>
						전혈헌혈을 한 경우 다음 헌혈은 8주 후부터, 성분(혈장,혈소판)헌혈을 한 경우 다음 헌혈은 2주 후 같은 요일부터 가능합니다.<br><br>
					</li>
					<li>
						단, 전혈헌혈은 연 5회까지로 제한되며, 성분헌혈(혈장, 혈소판)이 연24회인 경우 혈소판헌혈은 불가능합니다.<br>
						제한사항에 해당하시면 다음 헌혈 가능일이 연기될 수 있습니다.<br><br>
					</li>
					<li>
						적십자 외 기관에서 헌혈하신 경우, 헌혈가능일이 변동될 수 있습니다.<br><br>
					</li>
				</ul>
			</div>
			<p id="lastTitle">지난 헌혈기록 </p>
			<div id="resList">
				
			</div>
		</div>     
        
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>