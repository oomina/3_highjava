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
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/res_css/bdhRes4.css">
<style type="text/css">
	
</style>
<script>			
		$(function(){
			$.setStepStyle(3);
			$('#disagree').on('click',function(){
				alert('약관에 동의하셔야 예약신청이 가능합니다.')
				$(this).prop('checked',false)
			})
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
			<h3>개인정보입력</h3>
			<div id="resInfo">				
				<div class="infoText" id="infoText">
					<p class="infoTitle">개인정보를 확인해주세요.</p>
					<ul>
						<li class="infoContent">
							이름 : ${infoVo.client_name }
						</li>
						<li class="infoContent">
							전화번호 : ${infoVo.client_tel }
						</li>
						<li class="infoContent">
							생년월일 : ${infoVo.mem_regno1 }
						</li>
					</ul>
				</div>
			</div>
			<h3>개인정보 수집 및 이용에 대한 안내</h3>
			<div id="info">
				<div id="infoText2">
					<p class="title">개인정보 수집 및 이용에 대한 안내</p>
					<p class="title">◇ 수집 및 이용 목적</p>
					<ul>
						<li class="infoContent">헌혈예약 및 예약 관련 상담</li>
					</ul>
					<p class="title">◇ 수집 및 이용 항목</p>
					<ul>
						<li class="infoContent">(필수) 이름, 주민등록번호(외국인등록번호), 휴대전화번호</li>
						<li class="infoContent">혈액관리법 시행령 제10조의 2에 따라 헌혈예약 시 헌혈경력 및 검사결과 조회를 위해 주민등록번호를 처리하고 있습니다.</li>
					</ul>
					<p class="title">◇ 이용 및 보유 기간</p>
					<ul>
						<li class="infoContent" id="impact">헌혈예약 후 5년</li>
					</ul>
					<p class="title">◇ 동의거부 권리 및 불이익</p>
					<ul>
						<li class="infoContent">정보주체는 개인정보 수집에 동의하지 않을 권리가 있으며, 필수항목을 입력하지 않으시는 경우 헌혈예약이 불가합니다.</li>
					</ul>
					<div id="chkAgree">	
						<input type="checkbox" class="agree">동의합니다 <input type="checkbox" id="disagree">동의하지 않습니다.				
					</div>
				</div>
			</div>
			
		</article>
		<div id="btnwrap">
			<input type="button" value="이 전" class="btn" id="preBtn" onclick="location.href='/BdhRes3.do'">
			<form action="/submitRes.do" method="post">
				<input type="hidden" name ="resType" value="${bVo.res_type}">
				<input type="hidden" name ="memId" value="${bVo.mem_id}">
				<input type="hidden" name ="bdhId" value="${bVo.bdh_id}">
				<input type="hidden" name ="dayCode" value="${bVo.day_code}">
				<input type="hidden" name ="timeCode" value="${bVo.time_code}">
				<input type="hidden" name ="userName" value="${infoVo.client_name}">
				<input type="hidden" name ="dtType" value="${bVo.dt_type}">
				<input type="submit" value="제 출" class="btn" id="nextBtn">
			</form>
		</div>
	</div>
</body>
</html>