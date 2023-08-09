<%@page import="kr.or.redplus.vo.ClientVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript">mypath = '<%=request.getContextPath()%>'</script>
<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!-- BootStrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- !!!head 인클루드 시작!!! -->
<% ClientVO vo = (ClientVO)session.getAttribute("login"); %>
<!-- !!!Head인클루드 끝 !!! -->

<title>RedPlus</title>
<!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
<%@ include file="/view/layout/common/inc_common_head.jsp"%>
<script>
mypath = `<%=request.getContextPath()%>`
currentPage = 1;
console.log("접속한 id는" + '${login.client_id}')

$(function() {
	$.listPageServer(1);
	
	// 글쓰기 클릭
	$('#btnWrite').on("click", function () {
		location.href = "<%=request.getContextPath()%>/boardWrite.do";
	})
	
	// 다음 클릭
	$(document).on('click', '#next', function() {
		currentPage = parseInt($('.pageno').last().text().trim()) + 1
		$.listPageServer(currentPage);
	})
	
	// 이전 클릭
	$(document).on('click', '#prev', function() {
		currentPage = parseInt($('.pageno').first().text().trim()) + -1
		$.listPageServer(currentPage);
	})
	
	// 페이지번호 클릭
	$(document).on('click', '.pageno', function() {
		currentPage = $(this).text().trim();
		$.listPageServer(currentPage);
	})
	
	// 검색 클릭
	$('#search').on('click', function(){
		$.listPageServer(1);
	})
	
	// 조회수 증가
	$(document).on('click', '.action', function () {
		// 이름 찾기
		vaction = $(this).attr('name');
		vidx = $(this).attr('idx');
		
		vmodify = this;
		
		if (vaction == "updateView") {
			$.updateViewServer(this);
		}
	})
	
})
</script>

<style type="text/css">
#pageList {
	margin-left: 10%;
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
 		case 1:%> <%@ include file="/view/layout/mem/inc_memcom_topmenu2.jsp" %> <% ; break;
 		case 2:%> <%@ include file="/view/layout/bdh/inc_bdh_topmenu2.jsp" %> <% ; break;
 		case 3:%> <%@ include file="/view/layout/hos/inc_hos_topmenu2.jsp" %> <% ; break;
 		default : %> <%@ include file="/view/layout/common/inc_common_topmenu.jsp" %> <% ; break;
 		} 
 }
%>
  <!-- TopMENU인클루드 종료부분!!!!-->
  
  <div id="container"> <!-- 컨테이너 래퍼 -->
    <div id="wrapper"> <!-- 이너 래퍼(Asdie+Section)-->
  <!-- Asdie메뉴 -->
 <%@ include file="/view/layout/common/inc_board_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
	<!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
	<section class="main_contents">
		<!--다들 여기에 컨텐츠 작성해주세요-->

		<!-- 검색 -->
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#mynavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="mynavbar">
					<ul class="navbar-nav me-auto">
						<!-- <li class="nav-item"><a class="nav-link"
							href="javascript:void(0)">공지사항<s/a></li> -->
						<li class="nav-item"><a class="nav-link"
							href="/view/board/board.jsp">게시판</a></li>
					</ul>

					<form class="d-flex">
						<select class="form-select" id="stype">
							<option value="">전체</option>
							<option value="board_title">제목</option>
							<option value="client_id">작성자</option>
							<option value="board_content">내용</option>
						</select> <input class="form-control me-2" type="text" id="sword" placeholder="Search">
						<button class="btn btn-primary" id="search" type="button">Search</button>
					</form>
					<button type="button" class="btn btn-outline-primary" id="btnWrite">글쓰기</button>
				</div>
			</div>
		</nav>
		<div id="result"></div>
		<br> <br>
		<div id="pageList"></div>

      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>