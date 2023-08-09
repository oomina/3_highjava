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
import kr.or.redplus.vo.bdhres.BdhResVO;


@WebServlet("/BdhRes4.do")
public class BdhRes4 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/view/bdhRes/bdhRes4.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String dayCode = request.getParameter("resDate");
		String timeCode = request.getParameter("resTime");
		String resType = request.getParameter("resType");
		String bdhName = request.getParameter("bdhName");
		
		timeCode = timeCode.replaceAll("시", "");
		IBdhResService service = BdhResServiceImpl.getService();
		String bdhId = service.findBdhId(bdhName);
		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");
		String memId = vo.getClient_id();
		
		BdhResVO bVo = new BdhResVO();
		BdhResVO infoVo = service.memInfo(memId);
		
		
		bVo.setRes_type(resType);
		bVo.setMem_id(memId);
		bVo.setBdh_id(bdhId);
		bVo.setDay_code(dayCode);
		bVo.setTime_code(timeCode);
		bVo.setDt_type(resType);
		
		request.setAttribute("bVo", bVo);
		request.setAttribute("infoVo", infoVo);
		request.getRequestDispatcher("/view/bdhRes/bdhRes4.jsp").forward(request, response);

	}

}
