package kr.or.redplus.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.board.BoardServiceImpl;
import kr.or.redplus.service.board.IBoardService;

@WebServlet("/updateView.do")
public class UpdateView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardCode = request.getParameter("board_code");
		System.out.println(boardCode);
		IBoardService service = BoardServiceImpl.getInstance();
		
		int res = service.updateView(boardCode);
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/view/board/result.jsp").forward(request, response);
	}
}
