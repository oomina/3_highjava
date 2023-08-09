package kr.or.redplus.controller.bdhres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.bdhres.BdhResServiceImpl;
import kr.or.redplus.service.bdhres.IBdhResService;
import kr.or.redplus.vo.ClientVO;


@WebServlet("/BdhRes1.do")
public class BdhRes1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");
		
		if(vo == null) {
			out.print("<script>alert('로그인 후 신청가능합니다.')</script>");
			out.print("<script>location.href='/login.do';</script>");
		}else {
			IBdhResService service = BdhResServiceImpl.getService();
			String memId = vo.getClient_id();
			int cnt = service.checkRes(memId); // 전자문진 확인여부
			
			String lastDdDate = service.lastDdRes(memId);
			
			int dDcnt = service.chkDdRes(memId);
			if(dDcnt==0 && cnt>0) {
				int ableCnt = service.chkAbleRes(memId);
				int ableCnt2 = service.chkAbleRes2(memId);
				String ableDate = service.ableDate(memId);
				if((ableCnt>=0 && ableCnt2==0)||ableDate == null) {
					request.getRequestDispatcher("/view/bdhRes/bdhRes1.jsp").forward(request, response);			
				}else {
					out.print("<script>alert('예약가능일이 아닙니다. 다음 헌혈 가능날짜는 : "+ableDate+"입니다.')</script>");
					out.print("<script>location.href='/index.do';</script>");
				}
			}else {
				if(dDcnt > 0) {
					out.print("<script>alert('예약가능일이 아닙니다. 다음 헌혈 가능날짜는 : "+lastDdDate+"입니다.')</script>");
					out.print("<script>location.href='/index.do';</script>");
					return;
				}
				if(cnt==0) {
					out.print("<script>alert('전자문진 완료 후 다시 시도해주세요.')</script>");
					out.print("<script>location.href='/index.do';</script>");
					return;
				}
			}
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
