<%@page import="kr.or.redplus.vo.BdhVO"%>
<%@page import="kr.or.redplus.vo.ClientVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<!-- 공통 main CSS -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" />
<!-- 개인 CSS 불러오기 -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_hkt.css" />
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_jhs.css" />
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_kmw.css" />
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_lsj.css" />
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/css_omn.css" />

<!-- 공통 Js -->
  <script src="<%=request.getContextPath() %>/js/main.js""></script>
<!-- 개인 Js -->
  <script src="<%=request.getContextPath() %>/js/js_hkt.js""></script>
  <script src="<%=request.getContextPath() %>/js/js_jhs.js""></script>
  <script src="<%=request.getContextPath() %>/js/js_kmw.js""></script>
  <script src="<%=request.getContextPath() %>/js/js_lsj.js""></script>
  <script src="<%=request.getContextPath() %>/js/js_omn.js""></script>


    <!--브라우저 스타일 초기화-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
  <!--Google Fonts - 나눔고딕-->
  <link rel="preconnect" href="https://fonts.gstatic.com" />
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet" />
  <!--Google Material Icons-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />

  <!--Open Graph-->
  <!--http://ogp.me/-->
  <meta property="og:type" content="website" />
  <meta property="og:site_name" content="RedPlus" />
  <meta property="og:title" content="레드플러스, 사랑을 나눠요!" />
  <meta property="og:description" content="레드플러스와 헌혈 함께해요!." />
  <meta property="og:image" content="#" />
  <meta property="og:url" content="https://ddit.or.kr" />

  <!--Twitter Card-->
  <!--https://developer.twitter.com/en/docs/twitter-for-websites/cards/guides/getting-started-->
  <meta property="twitter:card" content="summary" />
  <meta property="twitter:site" content="RedPlus" />
  <meta property="twitter:title" content="레드플러스, 사랑을 나눠요!" />
  <meta property="twitter:description" content="레드플러스는 헌혈 캠페인을 하고있습니다." />
  <meta property="twitter:image" content="#" />
  <meta property="twitter:url" content="https://ddit.or.kr" />

  <!--파비콘-->
  <!--<link rel="shortcut icon" href="favicon.ico" />-->
  <link rel="icon" href="<%=request.getContextPath() %>/favicon/favicon.png" />
  <!--브라우저 스타일 초기화-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
  <!--Google Fonts - 나눔고딕-->
  <link rel="preconnect" href="https://fonts.gstatic.com" />
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet" />
  <!--Google Material Icons-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />



  <!--GSAP & ScrollToPlugin-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js" integrity="sha512-IQLehpLoVS4fNzl7IfH8Iowfm5+RiMGtHykgZJl9AWMgqx0AmJ6cRWcB+GaGVtIsnC4voMfm8f2vwtY+6oPjpQ==" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/ScrollToPlugin.min.js" integrity="sha512-nTHzMQK7lwWt8nL4KF6DhwLHluv6dVq/hNnj2PBN0xMl2KaMm1PM02csx57mmToPAodHmPsipoERRNn4pG7f+Q==" crossorigin="anonymous"></script>
  <!--Swiper-->
  <link rel="stylesheet" href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css" />
  <script src="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.js"></script>
  <!--ScrollMagic-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/ScrollMagic/2.0.8/ScrollMagic.min.js"></script>
  <!--Lodash-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.20/lodash.min.js" integrity="sha512-90vH1Z83AJY9DmlWa8WkjkV79yfS2n2Oxhsi2dZbIv0nC4E6m5AbH8Nh156kkM7JePmqD6tcZsfad1ueoaovww==" crossorigin="anonymous"></script>


</head>
<body></body>

  <!--HEADER-->
  <header>
    <div class="inner">

      <a href="/" class="logo">
        <img src="<%=request.getContextPath() %>/images/redplus_logo.png" alt="REDPLUS" />
      </a>
     
      <div class="sub-menu">
        <ul class="menu">
          <li>
            <a>${login.client_name}님 안녕하세요!</a>
          </li>
          <li>
            <a href="<%=request.getContextPath()%>/logout.do">LOGOUT</a>
          </li>
        </ul>  
      </div>
      

      <ul class="main-menu">
        <li class="item">
          <div class="item__name"><a href="/view/bdhManage/bdhManageMain.jsp">헌혈예약관리</a></div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <h4>보유헌혈증</h4>
                  <ul>
                    <li>-</li>
                    <li></li>
                    <li></li>
                    <li></li>
                  </ul>
                </li>
                <li>
                  <h4>헌혈이력 조회</h4>
                  <ul>
                    <li>-</li>
                    <li></li>
                    <li></li>
                    <li></li>

                  </ul>
                </li>
                <li>
                  <h4>내가 쓴글 조회</h4>
                  <ul>
                    <li>-</li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                  </ul>
                </li>
                <li>
                  <h4>회원정보 수정</h4>
                  <ul>
                    <li>-</li>
                    <li></li>
                    <li></li>
                    <li></li>
                  </ul>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <h4>헌혈로 사랑을 나눠요</h4>
                <p>레드플러스에서 헌혈 예약을 할 수 있습니다.</p>

              </div>
            </div>
          </div>
        </li>
        <li class="item">
          <div class="item__name"><a href="/view/bdCardLssued/bclMain.jsp">혈액등록</a></div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <h4></h4>
 
                </li>
                <li>
                  <h4></h4>
                
                </li>
                <li>
                  <h4>헌혈의집 예약</h4>
                </li>
                <li>
                  <h4>지정헌혈 예약</h4>
                  <ul>
                   
                  </ul>
                </li>
                <li>
                  <h4></h4>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <h4>헌혈로 사랑을 나눠요</h4>
                <p>레드플러스에서 헌혈 예약을 할 수 있습니다.</p>
              </div>
            </div>
          </div>
        </li>
        <li class="item">
          <div class="item__name">헌혈증발급</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <h4></h4>
 
                </li>
                <li>
                  <h4></h4>
                
                </li>
                <li>
                  <h4></h4>
                </li>
                <li>
                  <h4>기부하기</h4>
                  <ul>
                   
                  </ul>
                </li>
                <li>
                  <h4></h4>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <h4>헌혈로 사랑을 나눠요</h4>
                <p>레드플러스에서 헌혈 예약을 할 수 있습니다.</p>
              </div>
            </div>
          </div>
        </li>
        <li class="item">
          <div class="item__name">커뮤니티</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <h4></h4>
 
                </li>
                <li>
                  <h4></h4>
                
                </li>
                <li>
                  <h4></h4>
                </li>
                <li>
                  <h4></h4>
                  <ul>
                   
                  </ul>
                </li>
                <li>
                  <h4>커뮤니티</h4>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <h4>헌혈로 사랑을 나눠요</h4>
                <p>레드플러스에서 헌혈 예약을 할 수 있습니다.</p>
              </div>
            </div>
          </div>
        </li>
        <li class="item">
          <div class="item__name">헌혈정보</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <h4>헌혈의 필요성</h4>
                  <ul>
                    <li>마이 스타벅스 리워드 소개</li>
                    <li>등급 및 혜택</li>
                    <li>스타벅스 별</li>
                    <li>자주하는 질문</li>
                  </ul>
                </li>
                <li>
                  <h4>헌혈과정</h4>
                  <ul>
                    <li>스타벅스 카드 소개</li>
                    <li>스타벅스 카드 갤러리</li>
                    <li>등록 및 조회</li>
                    <li>충전 및 이용안내</li>
                    <li>분실신고/환불신청</li>
                    <li>자주하는 질문</li>
                  </ul>
                </li>
                <li>
                  <h4>혈액 관리시스템</h4>
                  <ul>
                    <li>스타벅스 카드 e-Gift 소개</li>
                    <li>이용안내</li>
                    <li>선물하기</li>
                    <li>자주하는 질문</li>
                  </ul>
                </li>
              </ul>
            </div>
            <div class="contents__texture">
              <div class="inner">
                <h4>헌혈로 사랑을 나눠요</h4>
                <p>레드플러스에서 헌혈 예약을 할 수 있습니다.</p>
              </div>
            </div>
          </div>
        </li>
      </ul>

    </div>


  </header>

  
  
  <!-- 컨테이너 래퍼 -->
  <div id="container">
    <!-- 이너 래퍼-->
    <div id="wrapper">
      <!-- 왼쪽 서브메뉴 래퍼 -->
      <aside id="sub_nav">

      <!-- 사이드 네비메뉴-->
      <div class="aside_menu">
        <div class="tit"><span>마이페이지</span></div>
        <ul>
          <li class="on"><a href="#">보유헌혈증</a></li>
          <li class=""><a href="#">헌혈 이력 조회</a></li>
          <li class=""><a href="#">내가 쓴글 조회</a></li>
          <li class=""><a href="#">회원정보 수정</a></li>
        </ul>
      </div>

      </aside>

      <!-- 아래부터 메인 컨텐츠(.main_contents) 공간 -->