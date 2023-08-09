package kr.or.redplus.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.common.CommonServiceImple;
import kr.or.redplus.service.common.ICommonService;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.common.BloodCountVO;

/**
 * Servlet implementation class MainView
 */
@WebServlet("/index.do")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 헌혈통계 출력 메소드
		BloodCountVO countVo = new BloodCountVO();
		ICommonService comServ = CommonServiceImple.getService();
		
		//시스템 날짜 조회
		LocalDate today_ = LocalDate.now();
		LocalDate yesterday_ = today_.minusDays(1); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String today = today_.format(formatter);
		String yesterday = yesterday_.format(formatter);
		
		BloodCountVO todayInfo = comServ.getBloodCount(today);
		BloodCountVO yesterdayInfo =  comServ.getBloodCount(yesterday);
		
		request.setAttribute("stats_to", todayInfo);
		request.setAttribute("stats_yes", yesterdayInfo);
		
		
		//로그인 권한 세션 확인 메소드
		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");	
		
		
		if(vo==null || vo.getClient_id() == null || "".equals(vo.getClient_id())) {
			request.getRequestDispatcher("/view/layout/common/homepage.jsp").forward(request, response);
		}
		
		if (vo!=null) {
			if (vo.getAuth_code() == 1) {
				request.getRequestDispatcher("/view/mypage/memMain.jsp").forward(request, response);
			}
			if (vo.getAuth_code() == 2) {
				request.getRequestDispatcher("/view/layout/bdh/bdh_homepage.jsp").forward(request, response);
			}
			if (vo.getAuth_code() == 3) {
				request.getRequestDispatcher("/view/layout/hos/hos_homepage.jsp").forward(request, response);
			} 
		}
		
		// 여기는 건들지 마세요!!!
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
