package kr.or.redplus.controller.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.join.IJoinService;
import kr.or.redplus.service.join.JoinServiceImpl;

@WebServlet("/idCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("id");
		
		IJoinService service = JoinServiceImpl.getService();
		
		String res = service.idCheck(userId);
		
		request.setAttribute("resvalue", res);
		
		request.getRequestDispatcher("/view/join/idcheck.jsp").forward(request, response);
		
	}
}
