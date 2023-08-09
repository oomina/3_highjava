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

@WebServlet("/replyWrite.do")
public class ReplyWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		ClientVO cvo = (ClientVO) session.getAttribute("login");
//		
//		if (cvo == null) {
//			response.sendRedirect("/loginerror.do");
//		} else {
//			
//		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 댓글 정보 받기
		String clientId = request.getParameter("replyClient_id");
		System.out.println(clientId);
		String boardCode = request.getParameter("board_code");
		String replyContent = request.getParameter("reply_content");
		
		// 받아온 댓글 정보 VO에 저장하기
		ReplyVO replyVo = new ReplyVO();
		replyVo.setClient_id(clientId);
		replyVo.setBoard_code(boardCode);
		replyVo.setReply_content(replyContent);
		
		// service 객체 얻기
		IReplyService service = ReplyServiceImpl.getInstance();
		
		service.insertReply(replyVo);
		
//		if(cnt>0) {
//			response.sendRedirect(request.getContextPath()+"/boardInfo.do?board_code="+boardCode);
//		}else {
//			System.out.println("error");
//		}
		
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO) session.getAttribute("login");
		
		if (cvo == null) {
			response.sendRedirect("/loginerror.do");
		} else {
			response.sendRedirect(request.getContextPath()+"/boardInfo.do?board_code="+boardCode);
		}
	}

}
