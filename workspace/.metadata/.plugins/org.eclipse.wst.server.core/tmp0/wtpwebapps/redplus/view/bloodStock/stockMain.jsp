<%@page import="java.time.LocalDate"%>
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
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->
 <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_jhs/bloodStock.css" />


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
   
<%  
   LocalDate today_ = LocalDate.now();
   String year = String.valueOf(today_.getYear());
   String month = String.format("%02d",today_.getMonthValue());
   String day = String.format("%02d", today_.getDayOfMonth());
   String today = year+"/"+month+"/"+day;
%>
 
  <script>
	$(function(){
		day = $('#dateId').val();
		type = $('#type').val(); 
		bType = $('#bType').val();  
		possession = $('#possession').val();  
		
		if($('#dateId').val()==''){
			day = '<%=today%>'
			day = day.replaceAll("/","-");
		    $('#dateId').val(day);
		    $.StockList(day, type, bType, possession);
		}
		
		$('#dateId').on('change', function(){
			day = $('#dateId').val();  
			day = day.replaceAll("/","-");
			$.StockList(day, type, bType, possession);
		})
	
		$('#type').on('change', function(){
			type = $('#type').val();  
			$.StockList(day, type, bType, possession);
		})
		
		$('#bType').on('change', function(){
			bType = $('#bType').val();  
			$.StockList(day, type, bType, possession);
		})
		
		$('#possession').on('change', function(){
			possession = $('#possession').val();  
			$.StockList(day, type, bType, possession);
		})
		
		$.selectNoStockList();
		
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
		<div id="wrapper">
			<!-- 이너 래퍼(Asdie+Section)-->
			<!-- Asdie메뉴 -->
			 <%@ include file="/view/layout/bdh/inc_bdh_work_aside.jsp" %> 
			<!-- Asdie메뉴 끝 ..-->

			<script src="<%=request.getContextPath() %>/js/js_jhs/bloodStock.js"></script>
			<!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
			<section class="main_contents">

				<!--다들 여기에 컨텐츠 작성해주세요-->
				<div id="stockMainContainer">
					<h2>${login.client_name} 헌혈의집 혈액재고관리</h2>
					<div id="choiceList">
						<input id='dateId' type="date"> <label for="type">헌혈유형:</label>
						<select name="type" id="type">
							<option selected>전체선택</option>
							<option>전혈</option>
							<option>혈장</option>
							<option>혈소판</option>
						</select> 
						<label for="bType">혈액형:</label> 
						<select name="bType" id="bType">
							<option selected>전체선택</option>
							<option>A</option>
							<option>B</option>
							<option>O</option>
							<option>AB</option>
						</select> 
						<label for="bType">소지여부</label>
						<select name="possession" id="possession">
							<option selected>입고</option>
							<option>출고</option>
						</select>
					</div>
					<div id="stockList"></div>
					<input type="button" id="stockOn" value="재고등록" data-toggle="modal"
						data-target="#stockModal">
				</div>
		
		<div class="modal" id="stockModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">재고등록</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body" id="stockNoList"></div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>


		</section>
		<!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>