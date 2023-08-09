<%@page import="kr.or.redplus.vo.ClientVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript">mypath = '<%=request.getContextPath()%>
	'
</script>
<!-- Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!-- BootStrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script src="<%=request.getContextPath() %>/js/js_jhs/login.js"></script>
<script src="<%=request.getContextPath() %>/js/main.js"></script>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_jhs/login.css" />
<style type="text/css">
a {
  text-decoration: none;
}
</style>
<script type="text/javascript">

	$(function(){
		$.loginerror();
	})
</script>
</head>
<body>
    <div id="main">
	 	<header>
            <div id="head-img" style="text-align: center;">
            	<a href="javascript:goToMenu('home')">
                <img src="<%=request.getContextPath() %>/images/eqimg/redplus.png" id="logo">
                </a>
            </div>

            <div id="info-text">
                <p>
                    <span>헌혈,</span>생명이 소중함을 나눌 수 있는<br>
                    가장 아름다운 <span>선물</span>입니다.
                </p>
            </div>
        </header>
    	 <article>
	 		<form method="post" action="<%=request.getContextPath()%>/login.do">
				<label for="id" class="Text">ID</label> 
				<br>
				<input type="text" class="input_login" placeholder="Enter id" name="id">
				<br>
				<label for="pass" class="Text">PASSWORD</label>
				<br> 
				<input type="password" class="input_login" placeholder="Enter password" name="pass">
				<br>
				<input type="submit" id="login_button"  value="LOGIN">
			</form>
		</article>
			<div id="find_index">
				<a href="javascript:goToMenu('findid')">아이디 찾기</a> <a href="javascript:goToMenu('findps')">비밀번호 찾기</a> <a href="javascript:goToMenu('join')">회원가입</a>
			</div>
	</div>

</body>
</html>