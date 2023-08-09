package kr.or.redplus.controller.bloodStock;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.bloodStock.BloodStockServiceImpl;
import kr.or.redplus.vo.Blood_stockVO;
import kr.or.redplus.vo.ClientVO;

/**
 * Servlet implementation class InputStock
 */
@WebServlet("/inputStock.do")
public class InputStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputStock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Blood_stockVO vo = new Blood_stockVO();
		BloodStockServiceImpl service = BloodStockServiceImpl.getServcie();
		HttpSession session = request.getSession();
		
		ClientVO cvo = (ClientVO)session.getAttribute("login");
		
		String region = service.getRegion(cvo.getClient_id());
		System.out.println(region);

		vo.setBd_code(request.getParameter("code"));
		vo.setStore_day(request.getParameter("day"));
		vo.setDt_type(request.getParameter("type"));
		vo.setBs_blood_type(request.getParameter("btype"));
		vo.setBdh_id(request.getParameter("id"));
		vo.setBd_region(region);
		
		int result = service.stockSet(vo);
		

		if(result>0) {
			out.print("<script> alert('등록 완료'); </script>");
			out.print("<script>location.href='/view/bloodStock/stockMain.jsp';</script>");	
		}else {
			out.print("<script> alert('등록 실패'); </script>");
			out.print("<script>location.href='/stockMain.do';</script>");	
		}
	}

}
