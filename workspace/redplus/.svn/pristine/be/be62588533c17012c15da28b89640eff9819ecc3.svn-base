package kr.or.redplus.controller.ddAccept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.ddAccept.DdAcceptServiceImpl;

/**
 * Servlet implementation class DeleteDd
 */
@WebServlet("/deleteDd.do")
public class DeleteDd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/view/mypage/ddCurList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String dd_code = request.getParameter("code");
		DdAcceptServiceImpl service = DdAcceptServiceImpl.getService();
		
		int result = service.deleteDd(dd_code);
		
		if(result > 0) {
			out.print("<script> alert('취소 완료') </script>");	
		}else {
			out.print("<script> alert('취소 실패') </script>");
		}	
		out.print("<script>location.href='/acceptCnt.do';</script>");	
	}

}
