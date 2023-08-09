package kr.or.redplus.controller.board;

import java.io.IOException;

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


@WebServlet("/boardWrite.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO) session.getAttribute("login");

		if (cvo == null) {
			response.sendRedirect("/loginerror.do");
		} else {
			// GET방식 게시글 입력 폼
			request.getRequestDispatcher("/view/board/boardForm.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 게시판 정보 받기
		String clientId = request.getParameter("client_id");
		String title = request.getParameter("board_title");
		String content = request.getParameter("board_content");
		
		// 받아온 게시판 정보 VO에 저장하기
		BoardVO boardVo = new BoardVO();
		boardVo.setClient_id(clientId);
		boardVo.setBoard_title(title);
		boardVo.setBoard_content(content);
		
		// service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		service.insertBoard(boardVo);
		
		// 작업 완료시 /view/board/board.jsp페이지로 이동
		response.sendRedirect(request.getContextPath() + "/view/board/board.jsp");
		
	}

}
