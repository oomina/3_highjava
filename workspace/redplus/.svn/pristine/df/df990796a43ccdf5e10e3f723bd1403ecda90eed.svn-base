package kr.or.redplus.controller.bdhres;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BdhRes3.do")
public class BdhRes3 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		String bdhName = request.getParameter("nameVal");
		String addr = request.getParameter("addrVal");
		String tel = request.getParameter("telVal");

		request.setAttribute("type", type);
		request.setAttribute("bdhName", bdhName);
		request.setAttribute("addr", addr);
		request.setAttribute("tel", tel);
		request.getRequestDispatcher("/view/bdhRes/bdhRes3.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
