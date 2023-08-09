package kr.or.redplus.controller.dirdon;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

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

@WebServlet("/hos/ddrequest.do")
public class DirDonReqController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO) session.getAttribute("login");

		if (cvo == null || cvo.getAuth_code() != 3) {
			response.sendRedirect("/loginerror.do");
		} else {
		

			IDirDonReqService service = DirDonReqServiceImple.getService();
			List<Direct_donaVO> list = service.getPrevList(cvo.getClient_id());
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/view/hospital/prevrequestlist.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}
