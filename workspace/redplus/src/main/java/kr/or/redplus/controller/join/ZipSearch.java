package kr.or.redplus.controller.join;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.join.IJoinService;
import kr.or.redplus.service.join.JoinServiceImpl;
import kr.or.redplus.vo.JoinZipVO;
import kr.or.redplus.vo.ZipVO;

@WebServlet("/ZipSearch.do")
public class ZipSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String dong = request.getParameter("dong");
		
		IJoinService service = JoinServiceImpl.getService();
		
		List<JoinZipVO> list = service.selectByDong(dong);
		
		request.setAttribute("listvalue", list);
		
		request.getRequestDispatcher("/view/join/zipList.jsp").forward(request, response);
		
	}
}
