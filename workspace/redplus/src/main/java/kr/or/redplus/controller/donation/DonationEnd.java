package kr.or.redplus.controller.donation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.donation.DonationServiceImpl;
import kr.or.redplus.service.donation.IDonationService;
import kr.or.redplus.vo.donation.DonationVO;

/**
 * Servlet implementation class DonationEnd
 */
@WebServlet("/DonationEnd.do")
public class DonationEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String memId = request.getParameter("memId"); // 현재 로그인한 아이디
		String bdCode = request.getParameter("bdCode"); //혈혈증코드
		String reqId = request.getParameter("reqId"); // 요청자아이디
		
		IDonationService service = DonationServiceImpl.getService();
		DonationVO vo = service.regno(reqId); // 요청자 생년월일 성별
		String regno1 = vo.getMem_regno1();
		String regno2 = vo.getMem_regno2();
		String gNum = regno2.substring(0, 1);
		String gender = null;
		if(gNum.equals("1") || gNum.equals("3")) {
			gender = "남";
		}else {
			gender = "여";
		}
		String reqName = service.changeName(reqId);

	    DonationVO donVo = new DonationVO();
	    donVo.setMem_id(reqId);
	    donVo.setCard_owner(reqName);
	    donVo.setBd_regno1(regno1);
	    donVo.setBd_gender(gender);
	    donVo.setBd_code(bdCode);
	    int result = service.donationCard(donVo);
//	    if(result>0) {
//	    	request.getRequestDispatcher("/DonationAccept.do").forward(request, response);
//	    }else {
//	    	System.out.println("실패");
//	    }      
			
		
	}

}
