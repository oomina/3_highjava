package kr.or.redplus.controller.bdhres;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.bdhres.BdhResServiceImpl;
import kr.or.redplus.service.bdhres.IBdhResService;

import kr.or.redplus.vo.bdhres.BdhResVO;


@WebServlet("/ResChoice.do")
public class ResChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String bdhName = request.getParameter("bdhName");
		String date = request.getParameter("date");
		
		IBdhResService service = BdhResServiceImpl.getService();
		String bdhId = service.findBdhId(bdhName);
		
		BdhResVO vo = new BdhResVO();
		vo.setBdh_id(bdhId);
		vo.setDt_type(type);
		vo.setDay_code(date);
		
		List<BdhResVO> list = service.ableTime(vo);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/bdhRes/ableList.jsp").forward(request, response);
	}

}
