package kr.or.redplus.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.board.BoardServiceImpl;
import kr.or.redplus.service.board.IBoardService;
import kr.or.redplus.vo.BoardVO;

@WebServlet("/boardInfo.do")
public class BoardInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String boardCode = request.getParameter("board_code");
		
		// service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		// service 메소드 호출
		BoardVO boardVo = service.getBoardInfo(boardCode);
		
		// 결과값을 request에 저장
		request.setAttribute("boardVo", boardVo);
		
		// view 페이지로 이동
		request.getRequestDispatcher("/view/board/boardInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
