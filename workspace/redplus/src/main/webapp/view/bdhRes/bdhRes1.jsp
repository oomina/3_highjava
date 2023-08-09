<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/js/js_kmw.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/res_css/rescommon.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/res_css/bdhRes1.css">

	<script>
		// 이 함수는 나중에 js로 빼야함	
		$(function(){
			$.setStepStyle(0);
		})
	</script>
</head>
<body>
	<div id="container">
		<header>
			<div id="text">
				<p>헌혈의집 예약</p>
			</div>
			<div id="stepBox">
				<div class="step">
					<span>STEP1</span><br>
					<p>유의사항</p>
				</div>
				<div class="step">
					<span>STEP2</span><br>
					<p>헌혈의집 선택</p>
				</div>
				<div class="step">
					<span>STEP3</span><br>
					<p>날짜 및 시간 선택</p>
				</div>
				<div class="step">
					<span>STEP4</span><br>
					<p>개인정보입력 및 확인</p>
				</div>
			</div>
		</header>
		<article>
			<div id="resInfo">
				<div id="resimg">
					<img src='<%=request.getContextPath()%>/images/resimg/달력.jpg'>
				</div>
				
				<div class="infoText" id="infoText">
					<p class="infoTitle">헌혈예약이란?</p>
					<ul>
						<li class="infoContent">
							헌혈하기 전에 홈페이지, 모바일, CRM센터 또는 혈액원 직원을 통해 헌혈장소, 날짜, 시간 및<br> 
							헌혈종류를 미리 예약하고 헌혈의 참여하는 것을 말합니다. 
						</li>
					</ul>
				</div>
			</div>
			<!-- 이쪽에 헌혈 유의사항 이미지 넣기!! -->
			<div class="infoText" id="infoText2">
					<p class="infoTitle">헌혈예약 장점</p>
					<ul>
						<li class="infoContent">
							원하는 장소, 날짜, 시간에 헌혈참여가 가능합니다. 
						</li>
						<li class="infoContent">
							헌혈의집에서의 대기시간을 줄일 수 있습니다.
						</li>
					</ul>
				</div>
				<div class="infoText" id="infoText">
					<p class="infoTitle">유의사항</p>
					<ul>
						<li class="infoContent">
							<p>예약 및 취소 시</p>
							<ul>
								<li>
									6개월 이내 헌혈의집으로 예약할 수 있으며, 당일 예약은 불가합니다.
								</li>
								<li>
									최근 헌혈혈액검사결과에 따라 예약이 제한될 수 있습니다. (예약 후 헌혈혈액검사결과 이상 판정 시 예약이 자동 취소되며 안내문자가 발송됩니다.)
								</li>
								<li>
									문자메시지로 예약현황을 안내해 드립니다. (예약 직후, 예약일 3일 전, 예약 당일)
								</li>
								<li>
									예약안내 문자를 받지 못하신 경우에는 예약현황을 확인해 주십시오.
								</li>
								<li>
									헌혈의집 사정으로 예약일정이 변경 또는 취소될 수 있으며, 예약일 이전에 헌혈 참여 시 예약이력은 자동 취소됩니다.
								</li>
							</ul>
						</li>
					</ul>
					<ul>
						<li class="infoContent">
							<p>예약 후 방문 시</p>
							<ul>
								<li>
									예약시간 경과 시 예약이 취소되니 시간을 꼭 지켜주십시오.
								</li>
								<li>
									헌혈장소 도착 시 예약헌혈자임을 직원에게 말씀해 주십시오.
								</li>
								<li>
									당일 상황에 따라 헌혈 대기시간이 지연될 수 있습니다.
								</li>
								<li>
									긴급헌혈 또는 혈액재고 등에 따라 헌혈종류 변경을 요청드릴 경우 양해와 협조 부탁드립니다.
								</li>
								<li>
									전자문진에 미리 참여 후 방문하시는 경우 헌혈시간이 단축될 수 있습니다. (전자문진 참여 후 3일간 유효)
								</li>
							</ul>
						</li>
					</ul>
				</div>
				
		</article>
		<div id="btnwrap">
			<input type="button" value="홈으로가기" class="btn" id="preBtn" onclick="location.href='/index.do'">
			<input type="button" value="다 음" class="btn" id="nextBtn" onclick="location.href='/BdhRes2.do'">
		</div>
	</div>
</body>
</html>