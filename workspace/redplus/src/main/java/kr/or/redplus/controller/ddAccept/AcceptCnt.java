package kr.or.redplus.controller.ddAccept;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.redplus.service.ddAccept.DdAcceptServiceImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.DdListVO;

/**
 * Servlet implementation class AcceptCnt
 */
@WebServlet("/acceptCnt.do")
public class AcceptCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptCnt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/view/mypage/ddCurList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		DdAcceptServiceImpl service = DdAcceptServiceImpl.getService();
		
		HttpSession session = request.getSession();
		
		ClientVO vo = (ClientVO)session.getAttribute("login");
		DdListVO dvo = new DdListVO();
		Gson gson = new Gson();
		String name, countStr;
		int count = service.getDdCount(vo.getClient_id());
		dvo = service.getDdList(vo.getClient_id());
       
		name = gson.toJson(vo.getClient_name());
        countStr = gson.toJson(count);
        Map<String, Object> data = new HashMap<>();
		
        if(dvo!=null) {
    	    data.put("info", dvo);
		}else {
			data.put("info", '0');
		}
		
	    data.put("name", name);
	    data.put("count", countStr);    
   
	    
	    String result = gson.toJson(data);
	    
		response.getWriter().write(result);
		response.flushBuffer();	
	}

}
