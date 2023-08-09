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

@WebServlet("/updateMemberInfo.do")
public class UpdateMember extends HttpServlet {
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
			String memPass = request.getParameter("mem_pass");
			String memHp = request.getParameter("mem_hp");
			String memAdd1 = request.getParameter("mem_add1");
			String memAdd2 = request.getParameter("mem_add2");
			
			JoinVO vo = new JoinVO();
			vo.setMem_id(ivo.getClient_id());
			vo.setClient_pass(memPass);
			vo.setClient_tel(memHp);
			vo.setClient_addr(memAdd1 + "," + memAdd2);
			
			IJoinService service = JoinServiceImpl.getService();
			
			service.updateMember(vo);
			
			request.setAttribute("msg", "회원정보 수정이 완료되었습니다!");
			
			request.getRequestDispatcher("/view/mypage/member_info_update.jsp").forward(request, response);
		}
	}
}
