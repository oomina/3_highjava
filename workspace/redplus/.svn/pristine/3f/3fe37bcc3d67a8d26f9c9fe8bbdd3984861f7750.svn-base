<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 
    	전자문진 첫페이지입니다.
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/eq_css/eqStart.css">
<%
		String memId = (String)request.getAttribute("memId");
		String memName = (String)request.getAttribute("memName");
%>

<script type="text/javascript">
	alert("<%=memName%>님 환영합니다.")
	$(function(){
		checkCnt = 0;
		$('.checkbox').on('click',function(){
			index = $(this).attr('id');
			var imgSrc = "<img src='<%=request.getContextPath()%>/images/eqimg/전자문진체크" + index + ".png' alt='Image" + index + "'>";
			$('#article').html(imgSrc);
			$('.check').eq(index-1).css('background','pink');
			checkCnt++;
			if(checkCnt == 6){
				$('#btn').css('display','block');
			}
			
		})
	})
</script>

</head>
<body>
	
	<div id="main">
		<div id="header">
			<img src="<%=request.getContextPath()%>/images/eqimg/redplus.png" id="logo">
			<h1>전자문진</h1>
			
		</div>
		<div id="content">
			<div id="infoText">
				<p>
					헌혈금지약물, 헌혈금지약물(태아영향)-요약, 감염병, 말라리아 관련 헌혈제한지역, 
					<br>헌혈관련증상에 대한 안내문을 읽어 보셨습니까?
				</p>
				<p>
					※ 아래 안내문을 모두 클릭하여 읽어 주십시오.
				</p>
			</div>
			
			<div id="checkBox">
				<div class="check">
					<img alt="" src="<%=request.getContextPath()%>/images/eqimg/button_1.png" id="1" class="checkbox">
					<p>헌혈금지약물및<br>예방접종 안내문</p>
				</div>
				<div class="check">
					<img alt="" src="<%=request.getContextPath()%>/images/eqimg/button_1.png" id="2" class="checkbox">
					<p>헌혈금지약물<br>(태아영향) 안내문</p>
				</div>
				<div class="check">
					<img alt="" src="<%=request.getContextPath()%>/images/eqimg/button_1.png" id="3" class="checkbox">
					<p>감염병및vCJD<br>안내문</p>
				</div>
				<div class="check">
					<img alt="" src="<%=request.getContextPath()%>/images/eqimg/button_1.png" id="4" class="checkbox">
					<p>국내 말라리아<br>헌혈 제한지역<br>안내문</p>
				</div>
				<div class="check">
					<img alt="" src="<%=request.getContextPath()%>/images/eqimg/button_1.png" id="5" class="checkbox">
					<p>국외 말라리아<br>헌혈 제한지역<br>안내문</p>
				</div>
				<div class="check">
					<img alt="" src="<%=request.getContextPath()%>/images/eqimg/button_1.png" id="6" class="checkbox">
					<p>헌혈후 생길수<br>있는 증상 안내문</p>
				</div>
			</div>
			<div id=inputBtn>
			
				<input type="button" id="btn" value ="확 인" style="display: none;" onclick="location.href='<%=request.getContextPath()%>/view/eq/eqEnd.jsp?memId=<%=memId%>'">
			</div>
			<div id="article">
				<img src="<%=request.getContextPath()%>/images/eqimg/전자문진체크1.png" alt="Image 1">
			</div>
		</div>
	</div>
</body>
</html>