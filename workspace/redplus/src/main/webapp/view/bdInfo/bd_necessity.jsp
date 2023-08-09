<%@page import="kr.or.redplus.vo.ClientVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript">mypath = '<%= request.getContextPath() %>'</script>
  <!-- Jquery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 

  <!-- !!!head 인클루드 시작!!! -->
<%@ include file="/view/layout/common/inc_common_head.jsp" %>
  <!-- !!!Head인클루드 끝 !!! -->


  <title>RedPlus</title>
  <!-- 페이지 자바스크립트는 아래 하단에 사용하세요(왠만하면 js자기폴더 외부스크립트 추천, script태그 여기보다 위에 생성하면 에러발생) -->
  <script>
  
  </script>
<style type="text/css">
.main_contents ul {
	list-style: disc;
}
article {
	width : 90%;
	margin : 0px auto;
	margin-top : 20px;
	display : flex;
	flex-direction : column;
}
#infoText {
	margin :auto 0px;
}
#infoText2 {
	margin : 0;
}
.infoTitle {
	font-size : 1.3em;
	font-weight : bold;
}
.infoContent {
	color : gray;
}
.infoContent p {
	color : red;
	font-size : 1.1em;
	font-weight : bold;
	display: table-cell;
	vertical-align : middle;
}
#u1 {
	list-style : url("/images/bdInfo/q.png");
}
</style>
</head>
<body>
  <!--!!!TOPMENU 인클루드 시작 !!!-->
 <%
	ClientVO cliVo = (ClientVO)session.getAttribute("login");
 if(cliVo==null) { %> <%@ include file="/view/layout/common/inc_common_topmenu.jsp" %> <% } 
 if(cliVo!=null) {
	 int auth = cliVo.getAuth_code();
	
		switch(auth) {
 		case 0:%> <%@ include file="/view/layout/admin/inc_admin_topmenu.jsp" %> <% ; break;
 		case 1:%> <%@ include file="/view/layout/mem/inc_memcom_topmenu.jsp" %> <% ; break;
 		case 2:%> <%@ include file="/view/layout/bdh/inc_bdh_topmenu.jsp" %> <% ; break;
 		case 3:%> <%@ include file="/view/layout/hos/inc_hos_topmenu.jsp" %> <% ; break;
 		default : %> <%@ include file="/view/layout/common/inc_common_topmenu.jsp" %> <% ; break;
 		} 
 }
%>
  <!-- TopMENU인클루드 종료부분!!!!-->
  
  <div id="container"> <!-- 컨테이너 래퍼 -->
    <div id="wrapper"> <!-- 이너 래퍼(Asdie+Section)-->
  <!-- Asdie메뉴 -->
 <%@ include file="/view/layout/common/inc_info_aside.jsp" %>   
  <!-- Asdie메뉴 끝 ..-->   
  
  
      <!-- 아래부터 메인 컨텐츠(section.main_contents) 공간 -->
      <section class="main_contents">

	<div id="pl-title">
		<h1>헌혈의 필요성</h1>
	</div>
	<div class="infoText" id="infoText2">
		<p class="infoTitle">헌혈의 필요성</p>
		<article>
			<ul>
				<li class="infoContent">혈액은 수혈이 필요한 환자의 생명을 구하는 유일한 수단으로 아직까지 대체할 물질이 없고 인공적으로 만들 수도 없습니다.</li>
				<li class="infoContent">생명을 사고 팔 수 없다는 인류 공통의 윤리에 기반하여 세계 각국은 혈액의 상업적 유통을 법으로 규제하고 있습니다.</li>
				<li class="infoContent">혈액은 장기간 보관이 불가능하기 때문에 적정 혈액보유량을 유지하기 위해서는 지속적이고 꾸준한 헌혈이 필요합니다.</li>
				<li class="infoContent">우리나라는 수혈용 혈액은 자급자족하고 있지만, 의약품 제조를 위한 분획용 혈액은 외국으로부터 일부 수입하고 있습니다.</li>
				<li class="infoContent">우리는 언제든 수혈받을 상황에 처할 수 있습니다. 건강할 때 헌혈하는 것은 자신과 사랑하는 가족, 더 나아가 우리 모두를 위한 사랑의 실천입니다.</li>
			</ul>
		</article>
	</div><br><br>
	<div class="infoText" id="infoText2">
		<p class="infoTitle">헌혈에 대한 오해와 진실</p>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>헌혈증서를 구입할 수 있다?</p><br>
					<div>헌혈증서는 혈액관리법 제3조(혈액매매행위등의 금지)에 의해 매매가 금지되어 있습니다.혈액관리법에서는 "누구든지 금전,재산상의 이익 기타 대가적 급부를 주거나 주기로 하고 타인의 혈액(제14조의 규정에 의한 헌혈증서를 포함한다)을 제공하거나 이를 약속하여서는 아니된다"고 규정하고 있어 헌혈증서를 사고 파는 것은 위법 행위이며 관련법규에 의하여 처벌받을 수 있습니다. 헌혈증서가 필요하신 분께서는 전국 적십자사 혈액원에 문의하시면 기증증서를 소정의 절차를 거쳐 받으실 수 있습니다. 자세한 사항은 해당지역 혈액원에 문의하시기 바랍니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>헌혈을 하면 건강에 나쁘다?</p><br>
					<div>우리 몸에 있는 혈액량은 남자는 체중의 8%, 여자는 7% 정도입니다. 예를 들어 체중이 60Kg인 남자의 혈액량은 약 4,800mL이고, 50Kg인 여자는 3,500mL 정도입니다. 전체 혈액량의 15%는 비상시를 대비해 여유로 가지고 있는 것으로, 헌혈 후 충분한 휴식을 취하면 건강에 아무런 지장을 주지 않습니다. 우리 몸은 신체 내·외부의 변화에 대한 조절능력이 있으므로 헌혈 후 1~2일 정도면 일상생활에 지장이 없을 정도로 혈액순환이 회복됩니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>헌혈을 통해 에이즈 등 질병에 감염될 수 있다?</p><br>
					<div>헌혈에 사용하는 바늘, 혈액백 등 모든 의료기기는 무균처리된 일회용 제품으로 한번 사용 후 모두 폐기하기 때문에 헌혈로 인해 에이즈 등 질병에 감염될 위험은 전혀 없습니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>헌혈을 하면 살이 빠진다던데...다이어트에도 좋나요?</p><br>
					<div>헌혈을 하면 헌혈량 만큼의 혈액이 체외로 빠져나와 일시적으로 체중이 감소하지만 조직에 있던 체액이곧바로 혈관 내로 이동하고 음식 및 수분 섭취 등으로 보충되기 때문에 다이어트와는 무관합니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>헌혈을 많이 하면 혈관이 좁아진다고 하는데?</p><br>
					<div>혈관은 외부로부터 바늘이 들어오면 순간적으로 수축할 수 있지만 곧 본래의 상태로 회복되므로 헌혈을 많이 한다고해서 혈관이 좁아지지는 않습니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>헌혈을 하면 빈혈에 걸리지 않나요?</p><br>
					<div>헌혈자 건강 보호를 위해 헌혈 전 혈색소(헤모글로빈)를 측정하여 빈혈 여부를 사전에 확인합니다. 또한 빈혈 예방을 위해 헌혈간격과 헌혈가능횟수 기준을 정해 과도한 헌혈참여를 예방하고 있으므로 헌혈로 인해 빈혈에 걸리지는 않습니다. 다만, 잦은 헌혈로 인해 체내 철분함량이 감소하는 것을 방지하기 위해 철분함량이 높은 식습관을 권장합니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>전에 헌혈을 하려다가 못하였는데 헌혈이 가능한가요?</p><br>
					<div>헌혈 부적격 사유로 인해 일시적으로 헌혈에 참여하지 못한 경우라도 일정기간 경과 후 다시 헌혈에 참여하실 수 있습니다. 헌혈 부적격 사유 중 가장 높은 비율을 차지하는 항목은 낮은 혈색소 수치인데 이 경우 헌혈 재참여를 위해서는 철분함량이 높은 식습관을 유지하는 것이 중요합니다. 기타 질병 또는 약복용과 관련된 부적격은 사유별로 배제기간이 다르므로 헌혈의집이나 각 혈액원에 문의하시기 바랍니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>나의 헌혈기록이나 검사결과에 대한 비밀보장이 어렵다는데...?</p><br>
					<div>헌혈자의 모든 헌혈기록과 검사결과는 비밀이 보장되며, 본인 이외의 타인들에게 공개되지 않도록 법적으로 규정하고 있습니다. 개인정보보호를 위해 독립된 문진공간에서 문진이 진행되며 문진항목에 대한 답변 또한 비밀이 유지됩니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>에이즈 검사도 하나요? 왜 검사를 통보해주지 않나요?</p><br>
					<div>헌혈한 혈액은 혈액형검사, B형간염 항원검사, C형간염 항체검사, ALT검사, 매독항체검사, HIV검사를 실시하나 에이즈 검사를 목적으로 헌혈에 참여하는 것을 막기 위해서 에이즈(HIV) 검사결과는 통보해 주지 않습니다. 현재 각 구청 보건소에서는 개인의 비밀을 보장하면서 에이즈 검사를 실시하고 있으니 참고바랍니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>에이즈에 대해 더 자세히 알고 싶을 땐 어디로 문의하면 되나요?</p><br>
					<div>에이즈 검사를 목적으로 헌혈에 참여하는 것을 막기 위해서 관련 법령에 따라 헌혈선별검사 중 에이즈 검사결과는 헌혈자에게 통보하지 않습니다. 질병진단을 위한 에이즈 검사는 각 구청 보건소로, 에이즈 관련 상담은 한국에이즈퇴치연맹, 대한에이즈예방협회, 질병관리청으로 문의하시기 바랍니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>에이즈 감염혈액이 수혈되었다고 하는데...?</p><br>
					<div>헌혈 혈액에 대해서는 B형간염 바이러스(HBV), C형간염 바이러스(HCV), 후천성면역결핍증(에이즈) 바이러스(HIV) 등 수혈로 전파될 수 있는 병원체에 대한 검사를 시행하고 있습니다. 바이러스에 감염된 후 감염여부를 검사로 확인할 수 없는 기간을 윈도우기(window period)라고 합니다. 
					의학기술의 발달로 윈도우기를 많이 단축시켰지만 아직까지 HIV의 윈도우기는 4.5일 정도이므로 수혈로 인한 감염을 100% 막을 수는 없습니다. 따라서 문진시 과거력이나 위험행위 등에 대해 정확하게 답변하는 것이 중요합니다.<br>
					대한적십자사사에서는 수혈용 혈액의 안전성을 보증하기 위해서 혈청검사와 더불어 바이러스의 핵산을 직접 검출하는 핵산증폭검사를 적용하고 있으며 2003년 이후 단 한건의 에이즈 수혈감염 사례도 발생하지 않았습니다.</div>
				</li>
			</ul>
		</article><br>
		<article>
			<ul id="u1">
				<li class="infoContent">
					<p>적십자사에서 피 장사를 한다...?</p><br>
					<div>대한적십자사 혈액관리에 사용되는 재원은 혈액수가에만 의존하고 있으며, 국민들이 지로 형태로 납부하는 적십자회비는 혈액관리업무에 사용되지 않습니다. 혈액수가는 혈액관리를 위해 필수적인 인건비, 의료품비, 기념품비, 헌혈의 집 임대비 등 운영비와 홍보비 등에 사용되며, 우리나라의 혈액수가는 일본, 미국 등 주요 OECD 국가의 1/4 수준입니다.</div>
				</li>
			</ul>
		</article><br>
	</div>

      </section> <!-- 작성칸 끝 -->
      
      
     </div>
   </div>
    <!-- Bottom인클루드 시작부분!!!! -->
 <%@ include file="/view/layout/common/inc_common_footer.jsp" %>