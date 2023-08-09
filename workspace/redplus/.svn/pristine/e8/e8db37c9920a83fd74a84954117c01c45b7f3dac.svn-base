package kr.or.redplus.controller.resList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.resList.IResListService;
import kr.or.redplus.service.resList.ResListServiceImpl;
import kr.or.redplus.vo.bdhres.BdhResVO;


@WebServlet("/DelRes.do")
public class DelRes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String resDate = request.getParameter("resDate");
		String memId = request.getParameter("memId");
		BdhResVO vo = new BdhResVO();
		vo.setDay_code(resDate);
		vo.setMem_id(memId);
		
		IResListService service = ResListServiceImpl.getService();
		String resCode = service.resCode(vo);
		
		int cnt = service.deleteRes(resCode);
		if(cnt>0) {
			
			request.getRequestDispatcher("/CurList.do").forward(request, response);
		}else {
			System.out.println("fail");
		}
	}

}
