package kr.or.redplus.controller.bdhres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.bdhres.BdhResServiceImpl;
import kr.or.redplus.service.bdhres.IBdhResService;
import kr.or.redplus.vo.bdhres.BdhResVO;


@WebServlet("/submitRes.do")
public class submitRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String resType = request.getParameter("resType");
		String memId = request.getParameter("memId");
		String bdhId = request.getParameter("bdhId");
		String dayCode = request.getParameter("dayCode");
		String timeCode = request.getParameter("timeCode");
		
		BdhResVO vo = new BdhResVO();
		vo.setRes_type(resType);
		vo.setMem_id(memId);
		vo.setBdh_id(bdhId);
		vo.setDay_code(dayCode);
		vo.setTime_code(timeCode);
		vo.setDt_type(resType);
		IBdhResService service = BdhResServiceImpl.getService();
		int cnt = service.insertRes(vo);
		if(cnt>0) {
			int cnt2 = service.ableResUpdate(vo);
			if(cnt2>0) {
				out.print("<script>alert('헌혈예약이 완료되었습니다.')</script>");
				out.print("<script>location.href='/index.do';</script>");				
			}else {
				out.print("<script>alert('헌혈예약에 실패하였습니다.')</script>");
				out.print("<script>location.href='/index.do';</script>");
			}
		}else {
			out.print("<script>alert('헌혈예약에 실패하였습니다.')</script>");
			out.print("<script>location.href='/index.do';</script>");
		}
	}

}
