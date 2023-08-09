package kr.or.redplus.controller.reply;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/replyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		ReplyVO vo = new ReplyVO();
		String replyCode = request.getParameter("reply_code");
		vo.setReply_code(replyCode);
		
		ClientVO cvo = (ClientVO) session.getAttribute("login");
		
		IReplyService service = ReplyServiceImpl.getInstance();
		
		
		if (cvo == null) {
			response.sendRedirect("/loginerror.do");
		} else {
			vo.setClient_id(cvo.getClient_id());
			int res = service.deleteReply(vo);
			request.setAttribute("result", res);			
			request.getRequestDispatcher("/view/reply/result.jsp").forward(request,response);
		}
		
	}
}
