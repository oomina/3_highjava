package kr.or.redplus.controller.bloodStock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.redplus.service.bloodStock.BloodStockServiceImpl;
import kr.or.redplus.vo.BdCardLssuedVO;

/**
 * Servlet implementation class DetailStockList
 */
@WebServlet("/detailStockList.do")
public class DetailStockList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailStockList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
			
		String bd_code = request.getParameter("bd_code"); 
		BdCardLssuedVO vo =new BdCardLssuedVO();
	
		BloodStockServiceImpl serviceImpl = BloodStockServiceImpl.getServcie();
		vo= serviceImpl.detailNoStock(bd_code);
			
		Gson gson = new Gson();

		String result = gson.toJson(vo);

		response.getWriter().write(result);
		response.flushBuffer();
	}

}
