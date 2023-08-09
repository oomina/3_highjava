package kr.or.redplus.controller.donation;

import java.io.IOException;
import java.io.PrintWriter;

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


@WebServlet("/DonationReq.do")
public class DonationReq extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");
		if(vo == null) {
			out.print("<script>alert('로그인 후 요청가능합니다.')</script>");
			out.print("<script>location.href='/login.do';</script>");
		}else {
			String memId = vo.getClient_id();
			request.setAttribute("memId", memId);
			request.getRequestDispatcher("/view/donation/donation.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String memId = request.getParameter("id");
		String title = request.getParameter("title");
		String location = request.getParameter("location");
		String content = request.getParameter("content");
		DonationVO vo = new DonationVO();
		vo.setMem_id(memId);
		vo.setDr_title(title);
		vo.setDr_loc(location);
		vo.setDr_content(content);
		
		IDonationService service = DonationServiceImpl.getService();
		
		int cnt = service.reqDon(vo);
		if(cnt>0) {
			out.print("<script>alert('요청글이 등록되었습니다')</script>");
			out.print("<script>location.href='/index.do';</script>");
		}
		request.setAttribute("vo", vo);
	}

}
