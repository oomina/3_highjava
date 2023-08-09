<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 전자문진 로그인페이지 입니다 -->
<html>
<head>
	<% 
		String chk = (String)request.getAttribute("chk");
  		if(chk!=null && chk.equals("no")) { %>
       <script>
           alert("존재하지 않는 회원입니다.");
       </script>
	<% }%>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js" ></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/eq_css/questionLogin.css">
    <script>
        $(function (){
                // 버튼을 클릭시 이름 또는 주민번호값을 제대로 입력하지 않았을 경우 경고창띄우기
                $('#start-btn').on('click',function(){
                    if($('#name').val()==""){
                        alert("이름을 입력해주세요.")
                    }else if ($('#regno1').val().length<6 ||$('#regno2').val().length<7){
                        alert("주민번호를 입력해주세요.")
                    }
                })
                
        })
    </script>
</head>
<body>
    <div id= main>
        <header>
            <div id="head-img" style="text-align: center">
                <img src="<%=request.getContextPath() %>/images/eqimg/redplus.png" id="logo" onclick="location.href='/index.do'" >
            </div>

            <div id="info-text">
                <p>
                    <span>헌혈,</span>생명이 소중함을 나눌 수 있는<br>
                    가장 아름다운 <span>선물</span>입니다.
                </p>
            </div>
        </header>
		
        <article>
        	<form action="/EqLogin.do" method="post">
        		<p class="text">성명</p>
            	<input type="text" placeholder="성명" id="name" name="name">
            	<p class="text">주민등록번호</p>
            	<input type="text" placeholder="주민등록번호(앞)" id="regno1" name="regno1" class="input-regno" maxlength="6">
            	<input type="password" placeholder="주민등록번호(뒤)" id="regno2" name="regno2" class="input-regno" maxlength="7">
            	<br><br>
            	<input type="submit" value="전자문진 시작" style="text-align: center" id="start-btn">
        	</form>
            
        </article>
    </div>
</body>
</html>
