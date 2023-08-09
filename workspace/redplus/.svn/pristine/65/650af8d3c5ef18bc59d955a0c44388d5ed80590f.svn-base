package kr.or.redplus.controller.join;

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

@WebServlet("/findIdPage.do")
public class FindIdPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		request.getRequestDispatcher(request.getContextPath() + "/view/join/find_id.jsp").forward(request, response);
	}
}
