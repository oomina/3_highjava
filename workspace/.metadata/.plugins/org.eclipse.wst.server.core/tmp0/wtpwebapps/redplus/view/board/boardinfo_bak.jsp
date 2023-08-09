<%@page import="kr.or.redplus.vo.ClientVO"%>
<%@page import="kr.or.redplus.vo.ReplyVO"%>
<%@page import="kr.or.redplus.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RedPlus</title>

<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
<script src="<%= request.getContextPath() %>/js/jquery.serializejson.min.js" type="text/javascript"></script>
<!-- js -->
<script src="<%= request.getContextPath() %>/js/js_lsj.js" type="text/javascript"></script>
<!-- BootStrap-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<%
	ClientVO clientVo = (ClientVO)session.getAttribute("login");
	BoardVO boardVo = (BoardVO)request.getAttribute("boardVo");
	ReplyVO replyVo = (ReplyVO)request.getAttribute("ReplyVO");
%>

<script type="text/javascript">
mypath = `<%=request.getContextPath()%>`
currentPage = 1;
console.log(mypath);

$(function(){	
	var boardCode = $('#boardCode').val();
	$.replyPageServer(1, boardCode);
	
<%-- 	if(<%=clientVo%> == null){
        alert("로그인이 필요합니다.")
        location.href = "<%=request.getContextPath()%>/view/board/board.jsp";
	} --%>
	// 댓글 보기 텍스트 클릭
	/* $('#replyList').on('click', function () {
		var boardCode = $('#boardCode').val();
		$.replyPageServer(1, boardCode);
	}) */
	
	// 다음 클릭
	$(document).on('click', '#next', function() {
		currentPage = parseInt($('.pageno').last().text().trim()) + 1
		$.replyPageServer(1, boardCode);
	})
	
	// 이전 클릭
	$(document).on('click', '#prev', function() {
		currentPage = parseInt($('.pageno').first().text().trim()) + -1
		$.replyPageServer(1, boardCode);
	})
	
	// 페이지번호 클릭
	$(document).on('click', '.pageno', function() {
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
	})
	
	// 게시글 삭제 클릭
	$("#btnDelete").on("click", function() {
		if(confirm("정말 삭제하시겠습니까?") == true){
			location.href = "<%=request.getContextPath()%>/boardDelete.do?board_code=${boardVo.board_code}";
			alert("삭제되었습니다.");
		} else {
			return;
		}
	})
	
	$(document).on('click', '.action', function(){
		// 이름 찾기
		vaction = $(this).attr('name');
		vidx = $(this).attr('idx');
		
		if(vaction == "modify"){
			alert(vidx + "번 글 수정")
			
			vmodify = this;
			
		} else if(vaction == "delete"){
			
			//alert(vidx + "번 글 삭제");
			if(confirm("정말 삭제하시겠습니까?") == true){
				location.href = "<%=request.getContextPath()%>/replyDelete.do?board_code=${boardVo.board_code}";
				alert("삭제되었습니다.");
			} else {
				return;
			}
		}
	})
	
})

</script>
</head>
<body>

<%@ include file="/view/layout/common/common_top.jsp" %>

	<section class="main_contents">  <!-- 섹션시작 -->
		<form name="boardForm" id="boardForm">
		<input type="hidden" id="boardCode" value="<%=boardVo.getBoard_code() %>">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<tr>
					<td>글 번호</td>
					<td style="text-align: left" id="board_code" name="board_code"><%=boardVo.getBoard_code() %></td>
					<td>조회수</td>
					<td style="text-align: left" id="view_cnt" name="view_cnt"><%=boardVo.getView_cnt() %></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td style="text-align: left" id="write_date" name="write_date"><%=boardVo.getWrite_date() %></td>
					<td>수정일</td>
					<td style="text-align: left" id="modify_date" name="modify_date"><%=boardVo.getModify_date() %></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="3" style="text-align: left" id="client_id" name="client_id"><%=boardVo.getClient_id() %></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="3" style="text-align: left" id="board_title" name="board_title"><%=boardVo.getBoard_title() %></td>
				</tr>
				<tr>
					<td>Comments</td>
					<td colspan="3">
						<textarea class="form-control" rows="10" id="board_content" name="board_content" readonly="readonly"><%=boardVo.getBoard_content() %></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="4" style="text-align:right;">
						<button type="button" class="btn btn-primary" id="btnList">목록</button>
						<button type="button" class="btn btn-outline-primary" id="btnUpdate">수정</button>
						<button type="button" class="btn btn-outline-danger" id="btnDelete">삭제</button>
					</td>
				</tr>
			</table>
		</form>
		
		<br><br>
		<div>
			<p>Comments</p>
		</div>
		<hr>
		
		<form method="post"
		action="<%=request.getContextPath()%>/replyWrite.do" >
			<div class="form-group">
				<div class="input-group">
					<!-- 글코드, 게시글 -->
					<input type="hidden" value="${boardVo.board_code}" name="board_code"> 
					<input type="hidden" value="${boardVo.client_id}" name="client_id">
					<textarea class="form-control" placeholder="내용을 입력하세요." name="reply_content"></textarea>
					<button type="submit" class="btn btn-primary" id="btnReplyWrite">등록</button>
				</div>
			</div>
		</form>
		
		<br><br>
		<u id="replyList">댓글보기</u>
		<hr>
		<div id="replyResult"></div>
		<br><br>
		<div id="replyPageList"></div>
		
	</section>  <!-- 섹션 끝 -->
	
<%@ include file="/view/layout/common/common_bottom.jsp" %>
</body>
</html>