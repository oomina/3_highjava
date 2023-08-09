package kr.or.redplus.controller.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.board.BoardServiceImpl;
import kr.or.redplus.service.board.IBoardService;
import kr.or.redplus.vo.BoardVO;
import kr.or.redplus.vo.ClientVO;

@WebServlet("/myboardList.do")
public class MyboardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO) session.getAttribute("login");
		String clientId = cvo.getClient_id();
		System.out.println(clientId);
		String board_modify = request.getParameter("board_modify");
		System.out.println("board_modify");
		
		// service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		// service 메소드 호출
		List<BoardVO> list = service.selectMyboard(clientId);
		
		// 결과값을 request에 저장
		request.setAttribute("myListValue", list);
		
//		if (cvo == null) {
//			response.sendRedirect("/loginerror.do");
//		} else {
//			// view 페이지로 이동
//			request.getRequestDispatcher("/view/mypage/myboardList.jsp").forward(request, response);
//		}
		
		// view 페이지로 이동
		request.getRequestDispatcher("/view/mypage/myboardList.jsp").forward(request, response);
	}
}
