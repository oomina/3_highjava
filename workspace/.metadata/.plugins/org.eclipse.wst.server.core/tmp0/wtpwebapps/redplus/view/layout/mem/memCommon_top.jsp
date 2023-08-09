<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <header>
    <div class="inner">

      <a href="<%= request.getContextPath() %>/index.do" class="logo">
        <img src="<%= request.getContextPath() %>/images/layout/redplus_logo.png" alt="REDPLUS" />
      </a>
        

      <div class="sub-menu">
        <ul class="menu">
          <li>
            <a>${login.client_name}님 안녕하세요!</a>
          </li>
          <li>
            <a href="javascript:goToMenu('logout')">LOGOUT</a>
          </li>
        </ul>
        
      </div>

      <ul class="main-menu">
        <li class="item">
          <div class="item__name"><a href="javascript:goToMenu('mem_mypage_main')">마이페이지</a></div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                    <li>
                    <a href="javascript:goToMenu('mem_mp_mycard')"><h4>보유헌혈증</h4></a>
                    <ul>
                        <li>보유 헌혈증을 조회하고 헌혈한<br><u>혈액의 위치</u>를 확인합니다. </li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                    </li>
                    <li>
                    <a href="javascript:goToMenu('mem_mp_prev_dona')"><h4>헌혈이력 조회</h4></a>
                    <ul>
                        <li>과거현혈기록 조회,<br><u>다음 헌혈가능일자</u>를 확인합니다.</li>
                        <li></li>
                        <li></li>
                        <li></li>

                    </ul>
                    </li>
										<li>
											<a href="javascript:goToMenu('mem_mp_res_bd')"><h4>헌혈예약 내역</h4></a>
											<ul>
													<li><a href="javascript:goToMenu('mem_mp_res_bd')">- 일반헌혈 예약내역</a></li>
													<li><a href="javascript:goToMenu('mem_mp_res_direct')">- 지정헌혈 예약내역</a></li>
													<li></li>
													<li></li>
	
											</ul>
											</li>
                    <li>
                    <a href="javascript:goToMenu('mem_mp_myarticle')"><h4>내가 쓴글 조회</h4></a>
                    <ul>
                        <li>회원이 자신이 작성한<br>게시글을 조회합니다.</li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                    </li>
                    <li>
                    <a href="javascript:goToMenu('mem_mp_modify')"><h4>회원정보 수정</h4></a>
                    <ul>
                        <li>회원이 자신의 개인정보를<br>수정할수 있습니다.</li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                    </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <p>사랑의 헌혈로 생명을 나누어 주세요.</p>

              </div>
            </div>
          </div>
        </li>
        <li class="item">
          <div class="item__name">헌혈예약</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">

                <li>
                  <a href="javascript:goToMenu('mem_res1')"><h4>헌혈의집 예약</h4></a>
                  <ul>
                  	<li>회원은 <u>전국 헌혈의집</u>을<br>선택해 날짜와 시간을 지정하여<br>헌혈예약을 할 수 있습니다.</li>
                  </ul>
                </li>
                <li>
                  <a href="javascript:goToMenu('mem_res2')"><h4>지정헌혈 예약</h4></a>
                  <ul>
                   <li>회원은 <u>전국 의료기관</u>에서 긴급으로<br>요청한 지정헌혈을 예약할 수 있습니다.<br>(의료기관이 요청한 지정헌혈예약)</li>
                  </ul>
                </li>
                <li>
                  <a href="javascript:goToMenu('mem_eq')"><h4>전자문진</h4></a>
                  <ul>
                  	<li>빠른 헌혈과 신속한 업무처리를 위해<br><u>헌혈의집 헌혈예약 이전</u>에<br>전자문진을 진행합니다.</li>
                  </ul>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <p>ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ레드플러스에선 헌혈을 쉽고 빠르게 예약을 할 수 있습니다.</p>
              </div>
            </div>
          </div>
        </li>
        <li class="item">
          <div class="item__name"><a href="javascript:goToMenu('mem_don_list')">헌혈증기부</a></div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">

                <li>
                  <a href="javascript:goToMenu('mem_don_req')"><h4>기부요청</h4></a>
                  <ul>
                   <li>헌혈증이 긴급하게 필요한 회원은<br>다른 회원들에게 게시글을 올려서<br><u>전자헌혈증을 기부요청</u>할 수 있습니다.</li>
                  </ul>
                </li>
                <li>
                  <a href="javascript:goToMenu('mem_don_list')"><h4>기부하기</h4></a>
                  <ul>
                  	<li>회원은 자신이 보유한 전자헌혈증을<br> <u>다른회원에게 기부</u>할 수 있습니다.</li>
                  </ul>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <p>ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ잠들어 있는 헌혈증으로 용기와 희망을 나눠요!</p>
              </div>
            </div>
          </div>
        </li>
        <li class="item">
          <div class="item__name"><a href="javascript:goToMenu('board')">커뮤니티</a></div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
           
                <li>
                  <a href="javascript:goToMenu('board')"><h4>플러스게시판</h4></a>
                  <ul>
                  	<li>레드플러스의 회원들의 자유게시판 입니다.</li>
                  </ul>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <p>ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ건강한 헌혈은 행복 愛너지, 안전한 수혈은 희망 愛너지</p>
              </div>
            </div>
          </div>
        </li>
        <li class="item">
          <div class="item__name"><a href="javascript:goToMenu('mem_binfo1')">헌혈정보</a></div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <a href="javascript:goToMenu('mem_binfo1')"><h4>헌혈의 필요성</h4></a>
                  <ul>
                    <li>회원들에게 올바른 헌혈정보를 전달합니다.</li>
                  </ul>
                </li>
                <li>
                  <a href="javascript:goToMenu('mem_binfo2')"><h4>혈액이란</h4></a>
                  <ul>
                  </ul>
                </li>
                <li>
                  <a href="javascript:goToMenu('mem_binfo3')"><h4>헌혈과정</h4></a>
                  <ul>
                  </ul>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <p>ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ헌혈, 내 건강으로 또 한 명을 살리는 행복</p>
              </div>
            </div>
          </div>
        </li>
      </ul>

    </div>


  </header>