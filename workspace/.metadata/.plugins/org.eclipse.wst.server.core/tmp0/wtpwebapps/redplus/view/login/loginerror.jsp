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
  
  
  <title>로그인 에러</title>

    <section class="main_contents">  <!-- 섹션시작 -->
      <!--다들 여기부터 작성해주세요-->
	<script type="text/javascript">
	alert("로그인/비밀번호가 틀렸습니다.");
	window.location.href = "/view/login/login.jsp";
	</script>
	
      <!-- 작성칸 끝 -->
	</section>  <!-- 섹션 끝 -->


</body>
</html>