<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 
	전자문진 마지막 페이지입니다.
 -->
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/eq_css/eqEnd.css">
<script type="text/javascript">
	$(function(){
		isChk = false;
		cntChk = 0;
		$('#chkOk').on('click',function(){
			if($(this).prop('checked')){
				isChk = true;	
				cntChk++;
			}else{
				isChk = false;
				cntChk--;
			}
			if(cntChk > 0){
				isChk = true;
			}
			displayButton();
		})
		
		$('.chkIdx').on('click',function(){
			if($(this).prop('checked')){
				isChk = true;
				alert('헌혈 부적합자입니다.');	
				cntChk++;
			}else{
				isChk = false;
				cntChk--;
			}
			if(cntChk > 0){
				isChk = true;
			}
			displayButton();
		})
		function displayButton(){
			if(isChk == false){
			    $('#btn').css('display','none');
			}else{
				$('#btn').css('display','block');
			}
		}
		
	})
</script>
</head>
<body>
<%
	String memId = (String)request.getParameter("memId");
%>

<div id="main">
		<div id="header">
			<img src="<%=request.getContextPath()%>/images/eqimg/redplus.png" id="logo">
			<h1>전자문진</h1>
			
		</div>
		<div id="content">
			<div id="infoText">
				<h1>CHECK</h1>
				<p>
					아래와 같은 경험을 해당 기간 안에 하신 분 중 일부는 일정기간 동안 헌혈할 수 
					<br>없습니다.<br>
					아래 사항 중 선택해 주십시오.
				</p>
				
			</div>
			<div id="checkBox">
				<div id="chk">
					<input type="checkbox" id="chkOk">
					<div id="chkText">
						<span>해당없음</span>
					</div>
				</div>
			</div>
			<div id="check">
				<input type="checkbox" class='chkIdx'><span> 몸상태 안 좋음</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 발열</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 인후통</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 설사</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 약물복용</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 주사</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 외국여행</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 반복적인 고열, 춥고 떨림, 땀흘림</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 시술(내시경, 조직검사, 레이져시술)</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 수술</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 입원</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 암</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 호흡기질환</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 심장질환</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 당뇨병</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 전립선치료제(두타스테라이드,피나스테라이드)</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 탈모증치료제(피나스테라이드)</span><br><br>
				<input type="checkbox" class='chkIdx'><span> 여드름치료제</span><br><br>
			</div>
			<div id="detail">
				<textarea cols="102" rows="5"></textarea>
			</div>
			<div id=inputBtn>
				<form action="<%=request.getContextPath()%>/EqEnd.do" method="get" >
				  	<input type="hidden" name="memId" value="<%=memId%>">		
					<input type="submit" id="btn" value ="제 출" style="display: none;">
				</form> 
			</div>
			
		</div>
	</div>
</body>
</html>