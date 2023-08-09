package kr.or.redplus.controller.donation;

import java.io.IOException;
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


@WebServlet("/BdCardList.do")
public class BdCardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");
		
		String memId = vo.getClient_id();
		IDonationService service = DonationServiceImpl.getService();
		
		List<DonationVO> list = service.cardList(memId);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/donation/reqList.jsp").forward(request, response);

	}

}
