<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head></head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
  <!-- BootStrap-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath() %>/js/js_jhs/bdhManage.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_jhs/bdhManage.css" />
<%  
   LocalDate today_ = LocalDate.now();
   String year = String.valueOf(today_.getYear());
   String month = String.format("%02d",today_.getMonthValue());
   String day = String.format("%02d", today_.getDayOfMonth());
   String today = year+"/"+month+"/"+day;
%>
<script type="text/javascript">
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
  <title>RedPlus</title>
<%@ include file="/view/layout/bdh/bdhCommon_top.jsp" %>

 

    <section class="main_contents">  <!-- 섹션시작 -->
      <div id="bdhManageMain">
         <div id="dayChoice">
            <input id='dateId' type="date"> 
         </div>
         <div id="resList">
         </div>
      </div>
   </section>  <!-- 섹션 끝 -->


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
<%@ include file="/view/layout/common/common_bottom.jsp" %>
</body>
</html>