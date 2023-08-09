package kr.or.redplus.controller.bdhres;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.bdhres.BdhResServiceImpl;
import kr.or.redplus.service.bdhres.IBdhResService;

import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.bdhres.BdhResVO;


@WebServlet("/BdhRes2.do")
public class BdhRes2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/view/bdhRes/bdhRes2.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		request.setCharacterEncoding("utf-8");
	
		String addr = request.getParameter("addr");
		System.out.println(addr);
		//ClientVO vo = (ClientVO)session.getAttribute("login");
		//String memId = vo.getClient_id();
		//System.out.println(memId);
		IBdhResService service = BdhResServiceImpl.getService();
		List<BdhResVO> list = service.searchBdh(addr);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/bdhRes/searchBdh.jsp").forward(request, response);
		
		
		
	}

}
