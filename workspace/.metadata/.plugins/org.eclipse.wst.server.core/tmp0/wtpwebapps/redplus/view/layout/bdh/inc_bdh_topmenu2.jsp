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
          <div class="item__name"><a href="javascript:goToMenu('bdh_res_man')">헌혈의집 업무</a></div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                    <li>
                    <a href="javascript:goToMenu('bdh_res_man')"><h4>헌혈예약 관리</h4></a>
                    <ul>
                        <li>해당 헌혈의집으로 일반회원이<br><u>예약한 내역을 조회</u>합니다.</li>
                    </ul>
                    </li>
                    <li>
                    <a href="javascript:goToMenu('bdh_stock')"><h4>혈액재고관리</h4></a>
                    <ul>
                        <li>새로 입고된 <u>혈액재고를 등록</u>하고,<br><u>보유한 혈액을 조회</u>합니다.</li>
                        <li></li>

                    </ul>
                    </li>
                    <li>
                    <a href="javascript:goToMenu('bdh_card_ins')"><h4>헌혈증 발급</h4></a>
                    <ul>
                        <li>헌혈한 이용자에게 <br><u>종이or전자 헌혈증</u>을 발급합니다.</li>
                        <li></li>
                    </ul>
                    </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <p>레드플러스에서 헌혈 예약을 할 수 있습니다.</p>

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