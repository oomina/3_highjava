package kr.or.redplus.controller.reply;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.reply.IReplyService;
import kr.or.redplus.service.reply.ReplyServiceImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.ReplyVO;

@WebServlet("/replyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String boardCode = request.getParameter("board_code");
		
		IReplyService service = ReplyServiceImpl.getInstance();
		
		List<ReplyVO> list = service.selectReply(boardCode);
	
		request.setAttribute("replyList", list);
		
		request.getRequestDispatcher("/view/reply/replyList.jsp").forward(request, response);
		
	}

}
