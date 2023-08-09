package kr.or.redplus.controller.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.join.IJoinService;
import kr.or.redplus.service.join.JoinServiceImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.JoinVO;
import kr.or.redplus.vo.MemberVO;

@WebServlet("/Insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("mem_id");
		String clientPass = request.getParameter("client_pass");
		String clientName = request.getParameter("client_name");
		String bloodType = request.getParameter("mem_blood_type");
		String memRegno1 = request.getParameter("mem_regno1");
		String memRegno2 = request.getParameter("mem_regno2");
		String clientTel = request.getParameter("client_tel");
		String clientAddr = request.getParameter("client_addr");
		
		JoinVO vo = new JoinVO();
		vo.setMem_id(memId);
		vo.setClient_pass(clientPass);
		vo.setClient_name(clientName);
		vo.setMem_blood_type(bloodType);
		vo.setMem_regno1(memRegno1);
		vo.setMem_regno2(memRegno2);
		vo.setClient_tel(clientTel);
		vo.setClient_addr(clientAddr);
		
		IJoinService service = JoinServiceImpl.getService();
		int cnt = service.regnoChk(vo);
		int res;
		if(cnt == 0) {
			res = service.insertClient(vo);
			int res2 = service.insertMember(vo);
			request.setAttribute("res", res);
			request.getRequestDispatcher("/view/join/Insert.jsp").forward(request, response);
		}else {
			res = -1;
			request.setAttribute("res", res);
			request.getRequestDispatcher("/view/join/Insert.jsp").forward(request, response);
		}
	}
}
