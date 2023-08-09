package kr.or.ddit.basic.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.vo.LprodVO;


@WebServlet("/lprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");  // JSON으로 응답할 때 ContentType설정
		
		ILprodService service = LprodServiceImpl.getInstance();
		
		List<LprodVO> lprodList = service.getLprodList();
		
		Gson gson = new Gson();
		
		String jsonData = gson.toJson(lprodList);
		
		response.getWriter().write(jsonData);
		response.flushBuffer();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
