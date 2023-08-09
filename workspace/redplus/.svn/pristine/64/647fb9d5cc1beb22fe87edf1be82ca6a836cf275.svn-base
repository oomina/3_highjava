package kr.or.redplus.controller.reply;

import java.io.IOException;
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

@WebServlet("/replyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO) session.getAttribute("login");
		
		String replyCode = request.getParameter("reply_code");
		String rcont = request.getParameter("content");
		
		ReplyVO vo = new ReplyVO();
		vo.setReply_content(rcont);
		vo.setReply_code(replyCode);
		
		IReplyService service = ReplyServiceImpl.getInstance();
		
		if (cvo == null) {
			response.sendRedirect("/loginerror.do");
		} else {
			vo.setClient_id(cvo.getClient_id());
			int res = service.updateReply(vo);
			request.setAttribute("result", res);
			request.getRequestDispatcher("/view/reply/result.jsp").forward(request, response);
		}
	}
}
