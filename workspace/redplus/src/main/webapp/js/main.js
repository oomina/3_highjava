/*메뉴이동을 구성하는 자바스크립트 삭제금지
 수정요청은 기태에게*/
 function goToMenu(menu) {
    const menuMap = {
      "home": "/index.do",
      "login": "/login.do",
      "logout": "/logout.do",
      "join": "/view/join/join.jsp",
      "findid": "/view/join/find_id.jsp",
      "findps": "/view/join/find_password.jsp",
      "board": "/view/board/board.jsp",
      "mem_mypage_main": "#",
      "mem_mp_mycard": "/MyBdCardList.do",
      "mem_mp_prev_dona": "/ResList.do",
      "mem_mp_prev_dd": "/mypage/ddprevlist.do",
      "mem_mp_prev_res": "/CurList.do",
      "mem_mp_res_bd": "/CurList.do",
      "mem_mp_res_direct": "/acceptCnt.do",
      "mem_mp_myarticle": "/mypage/myboard.do",
      "mem_mp_modify": "/mypage/editprofile.do",
      "mem_res1": "/BdhRes1.do",
      "mem_res2": "/reserve/ddonation.do",
      "mem_eq": "/EqLogin.do",
      "mem_don_req": "/DonationReq.do",
      "mem_don_list": "/DonationAccept.do",     
      "mem_binfo1": "/view/bdInfo/bd_necessity.jsp",
      "mem_binfo2": "/view/mypage/bloodinfo.jsp",
      "mem_binfo3": "/view/bdInfo/bd_procedure.jsp",
      "bdh_res_man": "/view/bdhManage/bdhManageMain.jsp",
      "bdh_stock": "/view/bloodStock/stockMain.jsp",
      "bdh_card_ins": "/view/bdCardLssued/bclMain.jsp",
      "hos_bld_req" : "/hos/bdrequest.do",
      "hos_dd_req" : "/hos/ddrequest.do",
      "hos_stock" : "/hos/bloodstock.do",      
      "#": "#"
      
    };
  
    window.location.href = menuMap[menu];
  }
/**
 * 순서대로 나타나는 기능
 */
// 나타날 요소들(.fade-in) 찾기.
const fadeEls = document.querySelectorAll('.visual .fade-in')
// 나타날 요소들을 하나씩 반복해서 처리!
fadeEls.forEach(function (fadeEl, index) {
  // 각 요소들을 순서대로(delay) 보여지게 함!
  gsap.to(fadeEl, 1, {
    delay: (index + 1) * .7,
    opacity: 1
  })
})