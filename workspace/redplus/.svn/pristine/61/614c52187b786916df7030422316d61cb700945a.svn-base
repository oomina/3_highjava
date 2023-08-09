<%@page import="kr.or.redplus.vo.ClientVO"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- BDH CSS -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_jhs/bdhManage.css" />
  
  <!-- Jquery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
  <!-- BootStrap-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <%  
	LocalDate today_ = LocalDate.now();
	String year = String.valueOf(today_.getYear());
	String month = String.format("%02d",today_.getMonthValue());
	String day = String.format("%02d", today_.getDayOfMonth());
	String today = year+"/"+month+"/"+day;
%>
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  $(function(){
		
		$('#dateId').on('change', function(){
		  day = $('#dateId').val();	
		  $.ResList(day);
		})
		
		if($('#dateId').val()==''){
		  day = '<%=today%>'
	      $.ResList(day)
		}
		
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
 <%@ include file="/view/layout/bdh/inc_bdh_work_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
		<div id="bdhManageMain">
			<div id="dayChoice">
				<input id='dateId' type="date"> 
			</div>
			<div id="resList">
			</div>
		</div>
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
 <!-- Modal Div -->
 <div class="modal" id="DetilaListModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">예약상세조회</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body" id="detailList">  				
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
    <!-- Bottom인클루드 시작부분!!!! -->

 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>