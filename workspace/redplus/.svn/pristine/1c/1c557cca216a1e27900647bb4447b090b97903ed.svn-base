package kr.or.redplus.controller.ddAccept;

import java.io.IOException;
import java.io.PrintWriter;
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
import kr.or.redplus.vo.Direct_donaVO;

/**
 * Servlet implementation class DdCheck
 */
@WebServlet("/ddCheck.do")
public class DdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		DdAcceptServiceImpl service = DdAcceptServiceImpl.getService();

		HttpSession session = request.getSession();
		ClientVO vo = (ClientVO)session.getAttribute("login");
		String dd_blood_type = request.getParameter("dd_blood_type");
		String dd_code = request.getParameter("dd_code");
		String btype = service.getBloodType(vo.getClient_id());
		Gson gson = new Gson();
		
		if(!dd_blood_type.equals(btype)) {
			String no = gson.toJson("no");
			
			response.getWriter().write(no);
			response.flushBuffer();	
		}else {
			Direct_donaVO dvo = new Direct_donaVO();
			
			dvo = service.ddDetail(dd_code);			
			ClientVO cvo = new ClientVO();
			cvo = service.getHosInfo(dvo.getHos_id());

			
			Map<String, Object> data = new HashMap<>();
		    data.put("dd", dvo);
		    data.put("hos", cvo);    
		 
		    String result = gson.toJson(data);
		    
			response.getWriter().write(result);
			response.flushBuffer();	
		}
	}

}
