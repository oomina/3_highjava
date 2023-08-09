package kr.or.redplus.controller.eq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.eq.EqServiceImpl;
import kr.or.redplus.service.eq.IEqService;


@WebServlet("/EqEnd.do")
public class EqEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String memId = request.getParameter("memId");
		
		
		
		PrintWriter out = response.getWriter();
		
		
		IEqService service = EqServiceImpl.getService();
		int cnt = service.insertEq(memId);
		if(cnt>0) {
			out.print("<script>alert('전자문진이 제출되었습니다.')</script>");
			out.print("<script>location.href='/index.do';</script>");
		}else {
			out.print("<script>alert('제출실패!')</script>");
			out.print("<script>location.href='/index.do';</script>");
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
