package kr.or.redplus.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.board.BoardServiceImpl;
import kr.or.redplus.service.board.IBoardService;

@WebServlet("/boardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String boardCode = request.getParameter("board_code");
		
		IBoardService service = BoardServiceImpl.getInstance();
		service.deleteBoardReply(boardCode);
		service.deleteBoard(boardCode);
		
		response.sendRedirect(request.getContextPath() + "/view/board/board.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
