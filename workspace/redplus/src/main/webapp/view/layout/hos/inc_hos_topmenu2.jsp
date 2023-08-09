<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <header>
    <div class="inner">

      <a href="javascript:goToMenu('home')" class="logo">
        <img src="<%=request.getContextPath()%>/images/layout/redplus_logo.png" alt="REDPLUS" />
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
          <div class="item__name"><a href="javascript:goToMenu('hos_bld_req')">요청업무</a></div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                    <li>
                    <a href="javascript:goToMenu('hos_bld_req')"><h4>혈액공급 요청</h4></a>
                    <ul>
                        <li>의료기관은 지역(관할)혈액원에<br><u>혈액이송을 요청</u>합니다.</li>
                    </ul>
                    </li>
                    <li>
                    <a href="javascript:goToMenu('hos_dd_req')"><h4>지정헌혈 요청</h4></a>
                    <ul>
                        <li>의료기관은 일반회원들에게<br><u>긴급 지정헌혈</u>을 요청합니다.</li>
                        <li></li>
                        <li></li>

                    </ul>
                    </li>

              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <p>ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ헌혈에서 수혈까지 안전하고 건강하게!</p>

              </div>
            </div>
          </div>
        </li>
        <li class="item">
          <div class="item__name"><a href="javascript:goToMenu('hos_stock')">혈액 재고관리</a></div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">

                <li>
                  <a href="javascript:goToMenu('hos_stock')"><h4>보유 혈액재고</h4></a>
                  	<ul>
                  		<li>의료기관은 해당기관 보유혈액을 확인하고<br><u>사용처리</u> 할 수 있습니다.</li>
                  	</ul>
                </li>
                <li>     </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <p>ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ헌혈봉사자들이 기부한 마음만큼 소중하게 관리해요!</p>
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
                  	<li>레드플러스의 자유게시판 입니다.</li>
                  </ul>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <p>ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ헌혈문화, 함께 나눠요!</p>
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