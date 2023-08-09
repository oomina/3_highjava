<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="kr.or.redplus.vo.ClientVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
<style type="text/css">

.rwd-table {
  margin: auto;
  min-width: 650px;
  max-width: 100%;
  border-collapse: collapse;
  
}

.rwd-table tr:first-child {
  border-top: none;
  background: #f13d43;
  font-weight: 800;
  color: #fff;
}

.rwd-table tr {
  border-top: 1px solid #ddd;
  border-bottom: 1px solid #ddd;
  background-color: #fec9cb;
}

.rwd-table tr:nth-child(odd):not(:first-child) {
  background-color: #feeced;
}

.rwd-table th {
  display: none;
}

.rwd-table td {
  display: block;
}

.rwd-table td:first-child {
  margin-top: .5em;
}

.rwd-table td:last-child {
  margin-bottom: .5em;
}

.rwd-table td:before {
  content: attr(data-th) ": ";
  font-weight: bold;
  width: 120px;
  display: inline-block;
  color: #000;
}

.rwd-table th,
.rwd-table td {
  text-align: center;
}

.rwd-table {
  color: #000;
  border-radius: .4em;
  overflow: hidden;
}

.rwd-table tr {
  border-color: #bfbfbf;
}

.rwd-table th,
.rwd-table td {
  padding: .5em 1em;
}
@media screen and (max-width: 601px) {
  .rwd-table tr:nth-child(2) {
    border-top: none;
  }
}
@media screen and (min-width: 600px) {
  .rwd-table tr:hover:not(:first-child) {
    background-color: #d8e7f3;
  }
  .rwd-table td:before {
    display: none;
  }
  .rwd-table th,
  .rwd-table td {
    display: table-cell;
    padding: .25em .5em;
  }
  .rwd-table th:first-child,
  .rwd-table td:first-child {
    padding-left: 0;
  }
  .rwd-table th:last-child,
  .rwd-table td:last-child {
    padding-right: 0;
  }
  .rwd-table th,
  .rwd-table td {
    padding: 1em !important;
  }
}


/* THE END OF THE IMPORTANT STUFF */

/* Basic Styling */
.tlb_container {
  display: block;
  text-align: center;
  width:650px;
  margin: auto;
  position: relative;
}

@-webkit-keyframes leftRight {
  0%    { -webkit-transform: translateX(0)}
  25%   { -webkit-transform: translateX(-10px)}
  75%   { -webkit-transform: translateX(10px)}
  100%  { -webkit-transform: translateX(0)}
}
@keyframes leftRight {
  0%    { transform: translateX(0)}
  25%   { transform: translateX(-10px)}
  75%   { transform: translateX(10px)}
  100%  { transform: translateX(0)}
}


/* 페이지 CSS */
#pl-title{
	width:100%;
	padding-bottom:30px;
	border-bottom:2px solid #d9534f;
	margin-bottom: 50px;
}
#pl-title h1{
	font-size: 1.5em;
	font-weight: bold;
}

.btn {
    background: #f42e3d;
    position: absolute;
    right: 0;
    color: white;
    width: 180px;
    height: 40px;
    box-shadow: 0 0 10px 0 rgba(0,0,0,0.5);
    border: none;
    font-size: 1.2em;
    border-radius: 5px;
}
</style>

  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  
  $(document).on('click', '.delreq', function(){
	  vidx = $(this).attr('idx');
	  
	  if (confirm(vidx + '번 요청글을 삭제 하시겠습니까?')) {
    
	  
	  $.ajax({
		  url: `/hos/dirDonDelete.do`,
		  data: { "dd_code" : vidx },
		  type: 'post',
		  dataType: 'text',
		  success: function(res) {
			  alert(res);
			  location.reload();
			
		  },
			error: function(xhr) {
					alert("요청실패" + xhr.status + " " + xhr.statusText);
			}
		  
	  })
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
 <%@ include file="/view/layout/hos/inc_hosreq_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
      



<div id="pl-title">
  <h1>기존 지정헌혈 요청 리스트</h1>
  <p>　· 요청글 작성하기 버튼을 눌러 요청할 수 있고, '진행중' 버튼을 눌러 삭제할 수 있습니다.</p>
</div>



<div class="tlb_container">
<button type="button" class="btn" onclick="location.href='/hos/ddwrite.do'">요청글 작성하기</button>
<br><br>
  <table class="rwd-table">
    <tbody>
      <tr>
        <th>No</th>
        <th>마감날짜</th>
        <th>요청코드</th>
        <th>혈액형</th>
        <th>종류</th>
        <th>진행상황</th>
      </tr>
      <c:forEach var="n" items="${list}" varStatus="status">
     
      <tr>
        <td data-th="Supplier Code">
        ${status.count}	
        </td>
        <td data-th="Supplier Name">
        ${n.dd_date}
        </td>
        <td data-th="Invoice Number">
        ${n.dd_code}
        </td>
        <td data-th="Invoice Date">
        ${n.dd_blood_type}
        </td>
        <td data-th="Due Date">
        ${n.dd_bd_type}
        </td>
        <td data-th="Net Amount">
        <c:if test="${n.dd_accept=='1'}">
        <button>매칭완료</button>
        </c:if>
        <c:if test="${n.dd_accept=='0'}">
        <button class="delreq" idx="${n.dd_code}">진행중</button>
        </c:if>
        </td>
      </tr>
      </c:forEach>

    </tbody>
  </table>
</div>

        
      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>