<%@page import="kr.or.redplus.vo.ClientVO"%>
<%@page import="kr.or.redplus.vo.ReplyVO"%>
<%@page import="kr.or.redplus.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript">mypath = '<%=request.getContextPath()%>'</script>
<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
<script src="<%= request.getContextPath() %>/js/jquery.serializejson.min.js" type="text/javascript"></script>
<!-- js -->
<script src="<%= request.getContextPath() %>/js/js_lsj.js" type="text/javascript"></script>
<!-- BootStrap-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<title>RedPlus</title>



<!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
<%@ include file="/view/layout/common/inc_common_head.jsp"%>
<script type="text/javascript">
mypath = `<%=request.getContextPath()%>`
currentPage = 1;

var replyAuthorId = $('.replyAuthorId').text();
console.log(replyAuthorId)

console.log("접속한 id는" + '${login.client_id}')

function goBack() {
		window.history.back();
}

$(document).ready(function(){
	if ('${login.client_id}' == replyAuthorId) {
		$(".reply_code").prop("disabled", false);
	} else {
		$(".reply_code").prop("disabled", true);
	}
	
	$('#content').on('input', function () {
		if ($('#content').val() == '') {
			$("#msend").prop("disabled", true);
		} else {
			$("#msend").prop("disabled", false);
		}
	})
	
	$('#reply_content').on('input', function () {
		if ($('#reply_content').val() == '') {
			$("#btnReplyWrite").prop("disabled", true);
		} else {
			$("#btnReplyWrite").prop("disabled", false);
		}
	})
	
	
	
	
})

$(function(){	
	var boardCode = $('#boardCode').val();
	$.replyListServer(boardCode);
	
	if('${login.client_id}' == null) {
		alert("로그인이 필요합니다.");
	}
	
	console.log("접속한 id는" + '${login.client_id}' + "작성자 id는" + '${boardVo.client_id}');
	
    // a1과 b1이 같은 경우에만 버튼 생성 및 추가
    if ('${login.client_id}' == '${boardVo.client_id}') {
        // id가 "btnUpdate"인 버튼 생성
        var updateBtn = $("<button/>", {
            type: "button",
            class: "btn btn-outline-primary",
            id: "btnUpdate",
            text: "수정"
        });

        // id가 "btnDelete"인 버튼 생성
        var deleteBtn = $("<button/>", {
            type: "button",
            class: "btn btn-outline-danger",
            id: "btnDelete",
            text: "삭제"
        });

        // id가 "btnList"인 버튼 뒤에 생성된 버튼들 추가
        $("#btnList").after(updateBtn, deleteBtn);
    } // 
	
	// 다음 클릭
	$(document).on('click', '#replyNext', function() {
		currentPage = parseInt($('.pageNo').last().text().trim()) + 1
		$.replyPageServer(1, boardCode);
	})
	
	// 이전 클릭
	$(document).on('click', '#replyPrev', function() {
		currentPage = parseInt($('.pageNo').first().text().trim()) + -1
		$.replyPageServer(1, boardCode);
	})
	
	// 페이지번호 클릭
	$(document).on('click', '.pageNo', function() {
		currentPage = $(this).text().trim();
		$.replyPageServer(1, boardCode);
	})
	
	// 게시글 목록 클릭
	$("#btnList").on("click", function() {
		location.href = "<%=request.getContextPath()%>/view/board/board.jsp";
	})
	
	// 게시글 수정 클릭
	$("#btnUpdate").on("click", function() {
		location.href = "<%=request.getContextPath()%>/boardUpdate.do?board_code=${boardVo.board_code}";
	})//
	
	// 게시글 삭제 클릭
	$("#btnDelete").on("click", function() {
		if(confirm("정말 삭제하시겠습니까?") == true){
			location.href = "<%=request.getContextPath()%>/boardDelete.do?board_code=${boardVo.board_code}";
			alert("삭제되었습니다.");
		} else {
			return;
		}
	})// 
	
	$(document).on('click', '.action', function(){
		// 이름 찾기
		vaction = $(this).attr('name');
		vidx = $(this).attr('idx');
		
		// 댓글 수정
		if(vaction == "modify"){
// 			alert(vidx + "번 글 수정");
			vmodify = this;
			
			// 수정할 본문의 내용 가져오기
// 			ddType = $(this).closest('tr').find('td:eq(3)').text();
			replyVal =  $(this).closest('.input-group').find('#rcont').val();
			
			// modal창에 출력하기
			$('#mform #content').val(replyVal);
			$('#mform #reply_code').val(vidx);
			$('#mModal').modal('show');
			
		// 댓글 삭제
		} else if(vaction == "delete"){
			if(confirm("정말 삭제하시겠습니까?") == true){
				$.replyDeleteServer();
				location.reload();
			} else {
				return;
			}
		}
	})//
	
	$('#msend').on('click', function () {
		fdata = $('#mform').serializeJSON();
		console.log(fdata);
		
		$.replyUpdateServer();
		
		vmc = $('#mform #rcont').val();
		
		$('#mModal').modal('hide');
		
		location.reload();
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
	BoardVO boardVo = (BoardVO)request.getAttribute("boardVo");
	ReplyVO replyVo = (ReplyVO)request.getAttribute("ReplyVO");
	
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
	<form name="boardForm" id="boardForm">
		<input type="hidden" id="boardCode" value="${boardVo.board_code}">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<tr>
					<td>글 번호</td>
					<td style="text-align: left" id="board_code" name="board_code">${boardVo.board_code}</td>
					<td>조회수</td>
					<td style="text-align: left" id="view_cnt" name="view_cnt">${boardVo.view_cnt}</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td style="text-align: left" id="write_date" name="write_date">${boardVo.write_date}</td>
					<td>수정일</td>
					<td style="text-align: left" id="modify_date" name="modify_date">${boardVo.modify_date}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="3" style="text-align: left" id="client_id" name="client_id">${boardVo.client_id}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="3" style="text-align: left" id="board_title" name="board_title">${boardVo.board_title}</td>
				</tr>
				<tr>
					<td>Comments</td>
					<td colspan="3">
						<textarea class="form-control" rows="10" id="board_content" name="board_content" readonly="readonly">${boardVo.board_content}</textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="4" style="text-align:right;">
						<button type="button" class="btn btn-primary" id="btnList">목록</button>
						<button type="button" class="btn btn-primary" onclick="goBack()">이전으로</button>
					</td>
				</tr>
			</table>
		</form>
		
		<br><br>
		<div>
			<p>Comments</p>
		</div>
		<hr>
		
		<!-- 댓글 작성 폼 -->
		<form method="post"
		action="<%=request.getContextPath()%>/replyWrite.do?replyClient_id=${login.client_id}" >
			<div class="form-group">
				<div class="input-group">
					<!-- 글코드, 댓글작성자(로그인한 아이디코드), 댓글 내용 -->
					<input type="hidden" value="${boardVo.board_code}" name="board_code" id="board_code">
					<input type="hidden" value="${login.client_id}" name="replyClient_id" id="replyClient_id">
					<textarea class="form-control" placeholder="내용을 입력하세요." id="reply_content" name="reply_content" ></textarea>
					<button type="submit" class="btn btn-primary" id="btnReplyWrite" disabled="true">등록</button>
				</div>
			</div>
		</form>
		
		<br><br>
		<u id="replyList">댓글보기</u>
		<hr>
		
		<div id="replyResult"></div>
		
		<!-- 댓글 수정 창 -->
		<!-- The Modal -->
		<div class="modal" id="mModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		     <div class="modal-header">
		        <h4 class="modal-title">댓글 수정하기</h4>
		        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
		 	 </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <form name="mform" id="mform" >
		        	<input type="hidden" id="reply_code" name="reply_code">
					<label>내용</label><br>
			        <textarea rows="5" cols="50" id="content" name="content"></textarea>
		        </form>
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
				<input type="button" class="btn btn-outline-primary" value="확인" id="msend" disabled="true" >
		        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
		      </div>
		
		    </div>
		  </div>
    </div>
  </div>
</div>

      </section> <!-- 작성칸 끝 -->
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>