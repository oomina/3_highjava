<%@page import="kr.or.redplus.vo.ClientVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
   <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/donation_css/donAccept.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  	$(function(){
  		code = "<table id='reqTb' border='1'><tr><td>작성날짜</td><td>요청자ID</td><td>제목</td><td>지역</td><td>상세보기</td></tr>"
  		$.ajax({
  			url : "<%=request.getContextPath()%>/DonationAccept.do",
  			type : "post",
  			data: {"memId":"${memId}"},
  			success : function(res){
  				$.each(res,function(i,v){
  					if(res.length == 0){
  	  					code += "<tr><td colspan=5>헌혈증 요청이 존재하지 않습니다</td>"
  	  				}else{
  	  			   		code += "<tr id='conTb'><td>"+v.dr_date+"</td><td>"+v.mem_id+"</td><td>"+v.dr_title+"</td><td>"+v.dr_loc+"</td><td><input type='button' value='상세보기' id='dBtn' class='btn btn-primary' data-bs-toggle='modal' data-bs-target='#myModal' data-dr-date='"+v.dr_date+"' data-mem-id='"+v.mem_id+"' data-dr-title='"+v.dr_title+"' data-dr-loc='"+v.dr_loc+"' data-dr-content='"+v.dr_content+"'></td></tr>";
  	  				}
  				})
  				code += "</table>";
  				$('#reqList').html(code);
  				$('#reqTb tr').eq(0).css({'font-weight':'bold','background':' #dad8d9',"height":"30px",'vertical-align': 'middle'});
  				
  			},
  			error : function(xhr){
  				alert('status : '+xhr.status);
  			},
  			dataType : 'json'
  		})
  		$(document).on('click','#dBtn',function(){
  			 drDate = $(this).data("dr-date");
  		 	 reqId = $(this).data("mem-id");
  		 	 drTitle = $(this).data("dr-title");
  		 	 drLoc = $(this).data("dr-loc");
  		 	 drContent = $(this).data("dr-content");
  		 	 $('#mDate').text(drDate);
  		 	 $('#mId').text(reqId);
  		 	 $('#mTitle').text(drTitle);
  		 	 $('#mLoc').text(drLoc);
  		 	 $('#mContent').text(drContent);
  		 
  		 	 $.ajax({
  		 		 url : "<%=request.getContextPath()%>/BdCardList.do",
  		 		 type : "post",
  		 		 dataType:'json',
  		 		 success: function(res){
  		 			 code = "<table id='resListBtn'><tr><td>발급날짜</td><td>헌혈증코드</td><td>소유자</td><td>헌혈종류</td><td>발급지</td><td>생년월일</td><td>성별</td><td>기부하기</td></tr>";
  		 			 $.each(res,function(i,v){
  		 				 code += "<tr><td class='dTd'>"+v.bd_date+"</td><td class='dTd'>"+v.bd_code+"</td><td class='dTd'>"+v.card_owner+"</td><td class='dTd'>"+v.bd_type+"</td><td class='dTd'>"+v.blood_location+"</td><td class='dTd'>"+v.bd_regno1+"</td><td class='dTd'>"+v.bd_gender+"</td><td class='dTd'><input type='button' id='donBtn' value='기부하기'></td></tr>";
  		 			 })
  		 			code +="</table>";
  	  		 		 $('#resList').html(code);
  	  		 		 $('#resListBtn tr').eq(0).css({'background':'#dad8d9','font-weight':'bold','height':'40px'});
  	  		 		 $('#resListBtn tr td').eq(1).css('width','160px');
  		 		 },
  		 		 error : function(xhr){
  		 			 alert('status : '+xhr.status);
  		 		 }
  		 		 
  		 	 })
  		 	 $(document).on('click','#donBtn',function(){
  		 		 bdCode = $(this).closest('tr').find('td:eq(1)').text(); // 헌혈증 코드
  		 		if(confirm("헌혈증 기부를 하시겠습니까?")){
  		 		 $.ajax({
  		 			 url : "<%=request.getContextPath()%>/DonationEnd.do",
  		 			 type : "post",
  		 			 data : {
  		 				 "memId":'${memId}',
  		 				 "bdCode":bdCode,
  		 				 "reqId":reqId
  		 			 },
  		 			 success:function(res){
  		 				alert("기부가 완료되었습니다.");
  	  					location.reload();
  		 			 },
  		 			 error: function(xhr){
  		 				 alert('status : '+xhr.status);
  		 			 }
  		 			 
  		 		 })		 
	 		  }
  		 		
  		 	 })
  		 	
  		})
  		//resDate = $(this).closest('tr').find('td:eq(0)').text();
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
 <%@ include file="/view/layout/mem/inc_donation_aside.jsp" %>      
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
      	<div id="pl-title">
	      	<h1>헌혈증 기부</h1>
	      	<p>　· 다른사용자의 헌혈증 기부요청글을 조회하고 자신이 보유한 전자헌혈증을 기부할 수 있습니다.</p>
      	</div>
	  	<div id="info-text">
	  		<p>
	  			<span>${memName}</span>님 기부에 참여해주셔서 진심으로 감사드립니다 <br><br>
	  			현재 보유하신 헌혈증 개수는 <span id="cnt">${cnt}</span>개 입니다.
	  		</p>
	  	</div>
  		<div id="reqinfo">
  			<p>현재 기부요청 명단</p>
  		</div>
  		<div id="reqList">
  		</div>
     <div class="modal" id="myModal">
  	<div class="modal-dialog modal-xl">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">기부요청 상세보기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div>
        	<table id="modalTb">
        		<tr>
        			<td class="mT">작성날짜</td>
        			<td id="mDate"></td>
        		</tr>
        		<tr>
        			<td class="mT">요청자ID</td>
        			<td id="mId"></td>
        		</tr>
        		<tr>
        			<td class="mT">제목</td>
        			<td id="mTitle"></td>
        		</tr>
        		<tr>
        			<td class="mT">지역</td>
        			<td id="mLoc"></td>
        		</tr>
        		<tr id="modal-content">
        			<td class="mT">내용</td>
        			<td id="mContent"></td>
        		</tr>
        	</table>
        </div>
        <div id='cardList'>
        	<p>현재 보유중인 현혈증</p>
        	<div id='resList'>
        		
        	</div>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>