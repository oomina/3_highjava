package kr.or.redplus.controller.dirdon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.dirdon.DirDonReqServiceImple;
import kr.or.redplus.service.dirdon.IDirDonReqService;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.Direct_donaVO;

@WebServlet("/hos/ddwrite.do")
public class DirDonWriteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO) session.getAttribute("login");

		if (cvo == null || cvo.getAuth_code() != 3) {
			response.sendRedirect("/loginerror.do");
		} else {
		
		request.getRequestDispatcher("/view/hospital/ddwriteform.jsp").forward(request, response);
		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		Direct_donaVO dvo = new Direct_donaVO();

	
		
		dvo.setHos_id(request.getParameter("hos_id"));
		dvo.setDd_date(request.getParameter("dd_date").replace("-", "/").substring(2));
		  dvo.setDd_blood_type(request.getParameter("dd_blood_type"));
		  dvo.setDd_bd_type(request.getParameter("dd_bd_type"));
		 

		IDirDonReqService service = DirDonReqServiceImple.getService();
		int cnt = 0;
		cnt = service.writeDdReq(dvo);
		
		if(cnt==1) {
			request.setAttribute("msg", "정상등록되었습니다");
			request.setAttribute("url", "/hos/ddrequest.do");
			request.getRequestDispatcher("/view/erorr/alert.jsp").forward(request, response);
		}
		
		if(cnt==0) {
			request.setAttribute("msg", "등록실패했습니다.");
			request.setAttribute("url", "/index.do");
			request.getRequestDispatcher("/view/erorr/alert.jsp").forward(request, response);
		}


	}

}
