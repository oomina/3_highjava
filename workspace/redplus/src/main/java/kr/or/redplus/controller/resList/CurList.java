package kr.or.redplus.controller.resList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.bdhres.BdhResServiceImpl;
import kr.or.redplus.service.bdhres.IBdhResService;
import kr.or.redplus.service.resList.IResListService;
import kr.or.redplus.service.resList.ResListServiceImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.bdhres.BdhResVO;


@WebServlet("/CurList.do")
public class CurList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");
		
		
		if(vo != null) {
			String memId = vo.getClient_id(); // 회원 아이디
			String memName = vo.getClient_name();//회원 이름
			IResListService service = ResListServiceImpl.getService();
			String bdhId = service.bdhId(memId); // 헌혈의집 아이디
			String bbName = service.bbName(bdhId); //혈액원 아이디
			int cntBd = service.countBd(memId); // 헌혈한 횟수
			
//			IBdhResService service2 = BdhResServiceImpl.getService();
//			int updateNext = service2.updateAbledateSysdate(memId);	
			String nextResDate = service.nextResDate(memId); // 다음 헌혈가능 날짜
			BdhResVO vo2 = new BdhResVO();
			vo2.setMem_id(memId);
			vo2.setClient_name(memName);
			vo2.setClient_id(bdhId);
			vo2.setBdh_id(bdhId);
			vo2.setBb_name(bbName);
						
			request.setAttribute("cntBd", cntBd); // 헌혈한 횟수
			
			
			request.setAttribute("nextResDate", nextResDate); // 다음 헌혈가능날짜
			request.setAttribute("vo2", vo2);
			request.getRequestDispatcher("/view/mypage/curList.jsp").forward(request, response);
		}else {
			out.print("<script>alert('로그인 후 이용가능합니다.')</script>");
			out.print("<script>location.href='/login.do';</script>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bdhId = request.getParameter("bdhId");
		String memId = request.getParameter("memId");
		String clientId = request.getParameter("clientId");

		IResListService service = ResListServiceImpl.getService();
		BdhResVO vo = new BdhResVO();
		vo.setMem_id(memId);
		vo.setBdh_id(bdhId);
		vo.setClient_id(clientId);
		
		List<BdhResVO> lastVo = service.curRes(memId);
		request.setAttribute("lastVo", lastVo);
		request.getRequestDispatcher("/view/mypage/lastResList.jsp").forward(request, response);
	}

}
