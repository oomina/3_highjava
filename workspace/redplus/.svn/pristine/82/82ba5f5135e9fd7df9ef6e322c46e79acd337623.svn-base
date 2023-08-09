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
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw/res_css/bdhRes3.css">
<script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js"></script>
 <link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css" rel="stylesheet" />


<style type="text/css">
	#calender{
		width: 90%;
		margin: 0px auto;
		display: flex;
		flex-direction: column;
	}
	.calendar{
		width: 90%;
	}
	#selectDay{
		display: flex;
		justify-content: space-between;
	}
	#resBtn{
		width: 80px;
		height: 60px;
		background: #d9534f;
		border: none;
		color:white;
		border-radius: 20px;
		font-weight: bold;
	}
	#resTb{
		margin-top: 30px;
		width: 100%;
		table-layout: fixed;
		text-align: center;
		border-top:2px solid black;
	}
	#viewResInfo{
		margin-top: 40px;
		margin-bottom: 20px;
		border-radius: 15px;
		box-shadow: 0 0 10px 0 rgba(0,0,0,0.5);
		width: 100%;
		height: 100px;
		text-align: center;
	}
	#viewResInfo p{
		color: #d9534f;
		font-weight: bold;
		font-size: 1.2em;
		margin-top: 40px;
	}
	#ableBtn{
		background:#d9534f;
		border: none;
		width: 70px;
		height: 30px;
		border-radius: 15px;
		color: white;
		font-weight: bold;
	}
</style>
<script>
		
		$(function(){
			$.setStepStyle(2);
			$('#dateVal').datepicker({ header: true, modal: true, footer: true });
			
			$('#resBtn').on('click',function(){
				var dateStr = $('#dateVal').val();
				var dateArray = dateStr.split("/");
				var year = dateArray[2];
				var month = ("0" + dateArray[0]).slice(-2);
				var day = ("0" + dateArray[1]).slice(-2);
				var formattedDate = year + "/" + month + "/" + day;
				date = $('#resDate').val(formattedDate);
				$.ajax({
					url : "<%=request.getContextPath()%>/ResChoice.do",
					type : "post",
					data :{
						type : "<%=request.getAttribute("type")%>",
						bdhName : "<%=request.getAttribute("bdhName")%>",
						date : formattedDate
					},
					success : function(res){
						$('#nextBtn').css('display','block');
						code="<table id='resTb'><tr><td>예약날짜</td><td>시간</td><td>예약가능인원</td><td>현재예약인원</td><td>헌혈종류</td><td>선택</td></tr>";
						if(res.length == 0){
							alert('예약 날짜를 선택해주세요');
						}
						
						$.each(res,function(i,v){
							code+="<tr style='background:#fbf8f3'><td>"+v.day_code+"</td><td>"+v.time_code+"시</td><td>"+v.max_user+
									"명</td><td>"+v.cnt_user+"명</td><td>"+v.dt_type+"</td>";
							//3명이상이면 버튼 생성 제한
							if(v.cnt_user<3){
								code+="<td><input type='button' value='선 택' id='ableBtn'></td></tr>";
							}else{
								code+="<td style='font-weight:bold'>예약초과</td></tr>";
							}
						})
						code += "</table>"
						$('#printResInfo').html(code);
						$('#resTb tr:eq(0)').css({'background-color':'#f6f6f6','text-align':'center','font-weight':'bold'});
					},
					error : function(xhr){
						alert('status : '+xhr.status);
					},
					dataType : 'json'
				})
				$(document).on('click','#ableBtn',function(){
					$('#viewResInfo').css('display','block');
					resDate = $(this).closest('tr').find('td:eq(0)').text();
					resTime = $(this).closest('tr').find('td:eq(1)').text();
					$('#resTime').val(resTime);
					divideDate = resDate.split("/");
					dYear = divideDate[0];
					dMonth = ("0"+divideDate[1]).slice(-2);
					dDay = ("0"+divideDate[2]).slice(-2);
					res = "예약날짜는 "+dYear+"년 "+dMonth+"월 "+dDay+"일 예약시간은"+resTime+"입니다";
					$('#viewResInfo p').text(res);
				})
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
		<form action="/BdhRes4.do" method="post">
		<article>
			<div id="resInfo">
				<div id="resimg">
					<img src='<%=request.getContextPath()%>/images/resimg/달력.jpg'>
				</div>				
				<div class="infoText" id="infoText">
					<p class="infoTitle"><span>${bdhName}</span>가 선택되었습니다</p>
					<ul>
						<li class="infoContent">
							주소 : ${addr }
						</li>
						<li class="infoContent">
							전화번호 : ${tel }
						</li>
						<li class="infoContent">
							헌혈종류 : ${type }
						</li>
					</ul>
				</div>
			</div>
			<div class="infoText" id="infoText">
					<p class="infoTitle">예약날짜를 선택해주세요</p>
					<ul>
						<li class="infoContent">
							오늘날짜 이후 2개월 이내로 선택이 가능합니다.
						</li>
						<li class="infoContent">
							헌혈가능나이 및 다음 헌혈가일자에 따라 선택 가능한 예약날짜와 헌혈종류를 안내해 드립니다.
						</li>
					</ul>
				</div>
		</article>
		<div id= "calendar">
			<div id="selectDay">
				<p class="calendar" style="font-weight: bold;">예약날짜선택 <input type="text" id="dateVal"></p>
				<input type="hidden" name = "resDate" id="resDate">
				<input type="hidden" name = "resTime" id="resTime">
				<input type="hidden" name = "resType" id="resType" value="${type }">
				<input type="hidden" name = "bdhName" id="bdhName" value="${bdhName}">
				<input type="button" value="예약선택" id="resBtn">
			</div>
			<div id="printResInfo">
			
			</div>
			<div id="viewResInfo" style="display: none">
				<p></p>
			</div>
		</div>
		<div id="btnwrap">
			<input type="button" value="이 전" class="btn" id="preBtn" onclick="location.href='/BdhRes2.do'">
			<input type="submit" value="다 음" class="btn" id="nextBtn" style="display: none">
		</div>
	</form>
	</div>
</body>
</html>