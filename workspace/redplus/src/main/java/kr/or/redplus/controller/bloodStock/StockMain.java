package kr.or.redplus.controller.bloodStock;

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

import kr.or.redplus.service.bloodStock.BloodStockServiceImpl;
import kr.or.redplus.vo.Blood_stockVO;
import kr.or.redplus.vo.ClientVO;

/**
 * Servlet implementation class StockMain
 */
@WebServlet("/stockMain.do")
public class StockMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");

		HttpSession session = request.getSession();
		List<Blood_stockVO> lvo = new ArrayList<>();
		
		String today = request.getParameter("day");
		String type = request.getParameter("type");
		String btype = request.getParameter("btype");
		String possession = request.getParameter("possession");
		
		ClientVO cvo = (ClientVO) session.getAttribute("login");
		
		Blood_stockVO rvo = new Blood_stockVO();
		rvo.setBdh_id(cvo.getClient_id());
		rvo.setStore_day(today);
		rvo.setDt_type(type);
		rvo.setBs_blood_type(btype);

		System.out.println(rvo.getDt_type());
		System.out.println(rvo.getBs_blood_type());
		System.out.println(possession);
		BloodStockServiceImpl service = BloodStockServiceImpl.getServcie();

		if(possession.equals("입고")) {
			lvo = service.AllStockList(rvo);			
		}else {
			lvo = service.AllResStockList(rvo);			
		}

		Gson gson = new Gson();

		String result = gson.toJson(lvo);

		response.getWriter().write(result);
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
