<%@page import="kr.or.redplus.vo.ClientVO"%>
<%@page import="kr.or.redplus.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<% ClientVO vo = (ClientVO)session.getAttribute("login"); %>
  <!-- !!!Head인클루드 끝 !!! -->
  

  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
	$(document).ready(function(){
		$('#board_title').on('input', function () {
			var current_length = $(this).val().length;
			var max_length = $(this).attr('maxlength');
			
			$('#board_title_counter').text(current_length + '/' + max_length);
		})
		
		
		$('#board_title, #board_content').on('input', function () {
			
			if ($('#board_title').val() == '' || $('#board_content').val() == '') {
				$("#btnSubmit").prop("disabled", true);
			} else {
				$("#btnSubmit").prop("disabled", false);
			}
		})
	})
	
    $(function() {
    	// 게시글 목록 클릭
    	$("#btnList").on("click", function() {
    		if(confirm("게시글을 작성 중 입니다. 게시글 목록으로 이동하시겠습니까?") == true){
				location.href = "<%=request.getContextPath()%>/view/board/board.jsp";
			} else {
				return;
			}
		})
		
    })
    
    
  </script>
</head>
<body>

  <!--!!!TOP인클루드 시작 !!!-->
 <%@ include file="/view/layout/common/inc_common_top.jsp" %>
  <!-- Top인클루드 종료부분!!!!-->
      
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">
        <!--다들 여기에 컨텐츠 작성해주세요-->
        <h1>게시글 작성</h1>
        <form id="boardForm" method="post" 
          action="<%=request.getContextPath()%>/boardWrite.do">
        <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
        <tbody>
          <tr>
              <!-- 로그인한 회원  -->
              <td>작성자</td>
              <td style="text-align:left;"><input type="text" name="client_id" id="client_id" readonly="readonly" value="<%=vo.getClient_id()%>"></td>
          </tr>
          <tr>
              <td>제목</td>
              <td style="text-align:left;"><input type="text" name="board_title" id="board_title" maxlength="20"><span id="board_title_counter"></span></td>
          </tr>
          <tr>
              <td>Comments</td>
              <td>
                  <textarea class="form-control" rows="10" name="board_content" id="board_content"></textarea>
              </td>
          </tr>
          <tr>
              <td colspan="2" style="text-align:right;">
                  <button type="submit" class="btn btn-primary" disabled="true" id="btnSubmit">등록하기</button>
                  <input type="button" class="btn btn-secondary action" name="btnList" id="btnList" value="목록으로">
              </td>
          </tr>
        </tbody>
        </table>
        
        </form>
        
      </section> <!-- 작성칸 끝 -->
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_bottom.jsp" %>