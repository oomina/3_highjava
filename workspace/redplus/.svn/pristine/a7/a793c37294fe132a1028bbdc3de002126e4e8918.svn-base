package kr.or.redplus.controller.eq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.eq.EqServiceImpl;
import kr.or.redplus.service.eq.IEqService;
import kr.or.redplus.vo.eq.EqVO;


@WebServlet("/EqChk.do")
public class EqChk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String regno1 = request.getParameter("regno1");
		String regno2 = request.getParameter("regno2");
		
		EqVO vo = new EqVO();
		vo.setClient_name(name);
		vo.setMem_regno1(regno1);
		vo.setMem_regno2(regno2);
		
		IEqService service = EqServiceImpl.getService();
		String memId = service.eqLogin(vo);
		
		if(memId!=null) {			
			request.setAttribute("memId", memId);
			request.getRequestDispatcher(request.getContextPath()+"/view/eq/eqView.jsp").forward(request, response);
		}else {
			request.setAttribute("chk", "no");
			response.sendRedirect(request.getContextPath()+"/view/eq/questionLogin.jsp?chk=no");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
