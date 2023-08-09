package kr.or.redplus.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.login.LoginServiceImpl;
import kr.or.redplus.vo.BdhVO;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.HospitalVO;
import kr.or.redplus.vo.MemberVO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/view/login/login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		String id = (String) request.getParameter("id");
		String pass = (String) request.getParameter("pass");

		ClientVO vo = new ClientVO();
		
		vo.setClient_id(id);
		vo.setClient_pass(pass);

		LoginServiceImpl service = LoginServiceImpl.getService();
		
		ClientVO ivo = service.checkLogin(vo);

		if (ivo == null) {
			request.setAttribute("loginCheck", "no");
			request.getRequestDispatcher(request.getContextPath() + "/view/login/loginerror.jsp").forward(request, response);
		} else {
			session.setAttribute("login", ivo);
			response.sendRedirect("/index.do");
		}

	}


}
