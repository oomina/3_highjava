package kr.or.redplus.controller.bdcard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.bdhcard.BCLServiceImpl;
import kr.or.redplus.vo.BdCardLssuedVO;
import kr.or.redplus.vo.ClientVO;

/**
 * Servlet implementation class BdCardInput
 */
@WebServlet("/bdCardInput.do")
public class BdCardInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/view/bdCardLssued/bclInputForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
	 	
		int result = 0;
	 	BCLServiceImpl service = BCLServiceImpl.getService();
	 	PrintWriter out = response.getWriter();
	 	
	 	BdCardLssuedVO vo = new BdCardLssuedVO();
	 	
		
		vo.setBd_date(request.getParameter("day"));
		vo.setBd_type(request.getParameter("bloodType"));
		vo.setBlood_location(request.getParameter("bdhName"));
		vo.setBdh_id(request.getParameter("bdhId"));
		vo.setMem_id(request.getParameter("memId"));
		vo.setCard_owner(request.getParameter("name"));
		vo.setCard_form(request.getParameter("bloodForm"));
		vo.setBd_btype(request.getParameter("bloodBType"));
		vo.setMem_regno1(request.getParameter("br"));
		vo.setBd_gender(request.getParameter("gender"));
		
		result = service.bdCardSet(vo);
		
		if(result>0) {
			out.print("<script> alert('발급 완료'); </script>");
			out.print("<script>location.href='/clientCheck.do';</script>");	
		}else {
			out.print("<script> alert('발급 실패'); </script>");
			out.print("<script>location.href='/bdCardInput.do';</script>");	
		}
		
	}

}
