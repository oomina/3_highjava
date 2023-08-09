package kr.or.redplus.controller.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.join.IJoinService;
import kr.or.redplus.service.join.JoinServiceImpl;
import kr.or.redplus.service.login.LoginServiceImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.JoinVO;

@WebServlet("/memberInfoUpdatePage.do")
public class MemberInfoUpdatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher(request.getContextPath() + "/login.do").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		ClientVO ivo = (ClientVO)session.getAttribute("login");
		if(ivo == null) {
			request.getRequestDispatcher("/index.do").forward(request, response);
		}else {
			String client_pass = request.getParameter("client_pass");
			
			JoinVO vo = new JoinVO();
			vo.setMem_id(ivo.getClient_id());
			vo.setClient_pass(client_pass);
			
			IJoinService service = JoinServiceImpl.getService();
			
			JoinVO joinVO = service.memberInfo(vo);
			
			if(joinVO == null) {
				request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
				request.getRequestDispatcher("/view/mypage/member_info_password.jsp").forward(request, response);
			}else {
				request.setAttribute("joinVO", joinVO);
				request.getRequestDispatcher("/view/mypage/member_info_update.jsp").forward(request, response);
			}
		}
	}
}
