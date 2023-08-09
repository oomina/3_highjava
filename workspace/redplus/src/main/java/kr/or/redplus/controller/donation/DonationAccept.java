package kr.or.redplus.controller.donation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.donation.DonationServiceImpl;
import kr.or.redplus.service.donation.IDonationService;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.donation.DonationVO;

@WebServlet("/DonationAccept.do")
public class DonationAccept extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");
		if(vo == null) {
			out.print("<script>alert('로그인 후 이용 가능합니다.')</script>");
			out.print("<script>location.href='/login.do';</script>");
		}else {
			String memId = vo.getClient_id(); // 멤버아이디
			String memName = vo.getClient_name();
			IDonationService service = DonationServiceImpl.getService();
			int cnt = service.countBdCard(memId); // 헌혈증 개수
			request.setAttribute("memId", memId);
			request.setAttribute("memName", memName);
			request.setAttribute("cnt", cnt);
			request.getRequestDispatcher("/view/donation/donAccept.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IDonationService service = DonationServiceImpl.getService();
		String memId = request.getParameter("memId");
		List<DonationVO> list = service.allReqList(memId);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/donation/reqList.jsp").forward(request, response);		
	}

}
