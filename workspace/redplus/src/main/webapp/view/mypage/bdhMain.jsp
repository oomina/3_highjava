<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
  <!-- BootStrap-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  
  
  <title>RedPlus</title>
<%@ include file="/view/layout/bdh/bdhCommon_top.jsp" %>

    <section class="main_contents">
      <!--다들 여기에 작성해주세요-->
<%--       <img src="<%=request.getContextPath() %>/images/moonjin.png" width="800px"> --%>
	  <!-- 여기는 건들지 마세요!!!!! -->
      <!-- 작성칸 끝 -->
	</section>
<%@ include file="/view/layout/common/common_bottom.jsp" %>

</body>
</html>