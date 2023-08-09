package kr.or.redplus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.vo.BdhVO;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.HospitalVO;
import kr.or.redplus.vo.MemberVO;

/**
 * Servlet implementation class MainView
 */
@WebServlet("/MainView.do")
public class MainView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");
	
		
		if(vo==null || vo.getClient_id() ==null ) {
			request.getRequestDispatcher("/view/mypage/main.jsp").forward(request, response);
		}
		if(vo.getAuth_code()==1){
			request.getRequestDispatcher("/view/mypage/memMain.jsp").forward(request, response);
		}
		if(vo.getAuth_code()==2) {
			request.getRequestDispatcher("/view/mypage/bdhMain.jsp").forward(request, response);
		}
		if(vo.getAuth_code()==3) {
			request.getRequestDispatcher("/view/mypage/hosMain.jsp").forward(request, response);			
		}
		
		
		
		// 여기는 건들지 마세요!!!
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
