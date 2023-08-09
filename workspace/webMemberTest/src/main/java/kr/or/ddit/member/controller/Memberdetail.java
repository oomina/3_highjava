package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/memberdetail.do")
public class Memberdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String memid = request.getParameter("memid");
		String update = request.getParameter("update");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVO vo = service.getMember(memid);
		
		request.setAttribute("member", vo);
		
		if(update != null) {
			request.getRequestDispatcher("/member/updateMember.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/member/memberdetail.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
