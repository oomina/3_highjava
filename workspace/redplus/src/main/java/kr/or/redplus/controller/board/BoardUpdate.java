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

@WebServlet("/boardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String boardCode = request.getParameter("board_code");
		System.out.println(boardCode);
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		BoardVO boardVo = service.getBoardInfo(boardCode);
		
		request.setAttribute("board_code", boardVo);
		
		request.getRequestDispatcher("/view/board/boardUpdateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 게시판 정보 받기
		String boardCode = request.getParameter("board_code");
		String title = request.getParameter("board_title");
		String content = request.getParameter("board_content");
		//String clientId = request.getParameter("client_id");
		
		// 받아온 게시판 정보 VO에 저장
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_content(content);
		boardVo.setBoard_code(boardCode);
		//boardVo.setClient_id(clientId);
		
		// DB저장
		IBoardService service = BoardServiceImpl.getInstance();
		service.updateBoard(boardVo);
		
		// 작업 완료시 /view/board/board.jsp페이지로 이동 
		response.sendRedirect(request.getContextPath() + "/view/board/board.jsp");
	}

}
