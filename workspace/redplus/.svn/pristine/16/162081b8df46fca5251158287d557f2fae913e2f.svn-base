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
import kr.or.redplus.vo.BdCardLssuedVO;
import kr.or.redplus.vo.ClientVO;

/**
 * Servlet implementation class InputStockList
 */
@WebServlet("/inputStockList.do")
public class InputStockList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InputStockList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		List<BdCardLssuedVO> lvo = new ArrayList<>();
		BloodStockServiceImpl service = BloodStockServiceImpl.getServcie();
		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");
		System.out.println(vo.getClient_id());
		
		lvo = service.NoStockList(vo.getClient_id());
		
		Gson gson = new Gson();

		String result = gson.toJson(lvo);

		response.getWriter().write(result);
		response.flushBuffer();
	
	}

}
