package kr.or.redplus.controller.ddAccept;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.redplus.service.ddAccept.DdAcceptServiceImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.Direct_donaVO;
import kr.or.redplus.vo.Don_acceptVO;

/**
 * Servlet implementation class DdAccept
 */
@WebServlet("/ddAccept.do")
public class DdAccept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/view/dd_accept/ddAcceptMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		ClientVO hvo = (ClientVO)session.getAttribute("login");
		
		List<Don_acceptVO> lvo = new ArrayList<>();
		DdAcceptServiceImpl service = DdAcceptServiceImpl.getService();
		
		lvo = service.ddList();
		
		String resTime = service.resTimeCheck(hvo.getClient_id());
		String ddTime = service.ddTimeCheck(hvo.getClient_id());
		LocalDate today = LocalDate.now();
		int result1 = 0;
		int result2 = 0;
		if(resTime!=null) {
			resTime = resTime.replaceAll("/", "-");
			LocalDate otherDate1 = LocalDate.parse(resTime);
			result1 = today.compareTo(otherDate1);
			System.out.println(result1);
		}
		if(ddTime!=null) {
			ddTime = ddTime.replaceAll("/", "-");
			LocalDate otherDate2 = LocalDate.parse(ddTime);
			result2 = today.compareTo(otherDate2);
		}
	
	    Gson gson = new Gson();
		
		if(result1 < 0 || result2 < 0) {
			String no = gson.toJson("goback");
			
			response.getWriter().write(no);
			response.flushBuffer();	
		}else {
	
	    String json = gson.toJson(lvo);
	    
	    response.getWriter().write(json);
	    response.flushBuffer();
		}
	}

}
