package kr.or.redplus.controller.erorr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.vo.ClientVO;

/**
 * Servlet implementation class NoLogin
 */
@WebServlet("/loginerror.do")
public class LoginError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * 로그인이 되지 않은 사람들은 로그인 페이지로 던져주는 페이지
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO) session.getAttribute("login");
		
		if(cvo==null) {
		
		request.setAttribute("msg", "로그인이 필요한 페이지입니다.");
		request.setAttribute("url", "/login.do");
		request.getRequestDispatcher("/view/erorr/alert.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "페이지 접근권한이 없습니다.");
			request.setAttribute("url", "/index.do");
			request.getRequestDispatcher("/view/erorr/alert.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
