package kr.or.redplus.controller.hospital;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.hospital.HospitalServiceImple;
import kr.or.redplus.service.hospital.IHospitalSevice;
import kr.or.redplus.vo.Blood_applyVO;
import kr.or.redplus.vo.ClientVO;

/**
 * Servlet implementation class BdRequestClick
 */
@WebServlet("/hos/bloodstock/use.do")
public class HosStockUse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO) session.getAttribute("login");
		
		String bdCode = (String) request.getParameter("bdcode");
		
		IHospitalSevice service = HospitalServiceImple.getService();
		int cnt = 0;
		cnt = service.bdStockUse(bdCode);


		PrintWriter out = response.getWriter();
	
		if(cnt==1) { out.print("정상적으로 사용처리되었습니다.");
		}else { out.print("요청 실패하였습니다"); }
		
		
	}

}
