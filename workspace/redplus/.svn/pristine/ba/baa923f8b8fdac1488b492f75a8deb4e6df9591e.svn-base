package kr.or.redplus.controller.dirdon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.dirdon.DirDonReqServiceImple;
import kr.or.redplus.service.dirdon.IDirDonReqService;

/**
 * Servlet implementation class DirDonDelete
 */
@WebServlet("/hos/dirDonDelete.do")
public class DirDonDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String ddCode = request.getParameter("dd_code");
		
		IDirDonReqService service = DirDonReqServiceImple.getService();
		
		int cnt = service.deleteDdReq(ddCode);
		
		PrintWriter out = response.getWriter();
		
		if(cnt==1) { out.print(ddCode + "글 정상적으로 삭제되었습니다.");
		}else { out.print("삭제 실패하였습니다"); }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
