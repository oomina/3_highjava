package kr.or.redplus.controller.hospital;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.redplus.service.hospital.HospitalServiceImple;
import kr.or.redplus.service.hospital.IHospitalSevice;
import kr.or.redplus.vo.Blood_stockVO;
import kr.or.redplus.vo.ClientVO;

/**
 * Servlet implementation class HosStockList
 */
@WebServlet("/hos/bloodstock.do")
public class HosStockList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO) session.getAttribute("login");
	
		if (cvo == null || cvo.getAuth_code() != 3) {
			response.sendRedirect("/loginerror.do");
		} else {
		
			cvo.getClient_id();
			
			IHospitalSevice hosServ = HospitalServiceImple.getService();
			String region = hosServ.getRegion(cvo.getClient_id());
			request.setAttribute("region", region);
			
			List<Blood_stockVO> list = hosServ.getStockList(cvo.getClient_id());
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/view/hospital/hos_stock.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		IHospitalSevice hosServ = HospitalServiceImple.getService();
		
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO)session.getAttribute("login");
		
		List<Blood_stockVO> list = new ArrayList<>();
		list =  hosServ.getStockList(cvo.getClient_id());
		
		Gson gson = new Gson();

		String result = gson.toJson(list);

		response.getWriter().write(result);
		response.flushBuffer();
	}

}
