package kr.or.redplus.controller.ddAccept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.ddAccept.DdAcceptServiceImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.Don_acceptVO;

/**
 * Servlet implementation class InputDd
 */
@WebServlet("/inputDd.do")
public class InputDd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputDd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
	 	PrintWriter out = response.getWriter();
		
		ClientVO cvo = (ClientVO)session.getAttribute("login");
		
		String dd_code = request.getParameter("code");
		String dda_date = request.getParameter("data");
		String dd_type = request.getParameter("type");
		String mem_id = cvo.getClient_id();
		
		Don_acceptVO vo = new Don_acceptVO();
		DdAcceptServiceImpl service = DdAcceptServiceImpl.getService();
		
		vo.setDd_code(dd_code);
		vo.setDd_date(dda_date);
		vo.setDd_bd_type(dd_type);
		vo.setClient_id(mem_id);
		
		int result = service.acceptSet(vo);
		
		System.out.println(vo.getDd_code());
		System.out.println(vo.getDd_date());
		System.out.println(vo.getDd_bd_type());
		System.out.println(vo.getClient_id());
		

		if(result > 0) {
			out.print("<script> alert('예약 완료') </script>");
			out.print("<script>location.href='/index.do';</script>");	
		}else {
			out.print("<script> alert('예약 실패') </script>");
			out.print("<script>location.href='/ddAccept.do';</script>");	
		}
	}

}
