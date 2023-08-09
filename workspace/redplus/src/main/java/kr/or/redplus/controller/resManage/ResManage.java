package kr.or.redplus.controller.resManage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.redplus.service.resManage.ResManageServiceImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.Res_manageVO;

/**
 * Servlet implementation class ResManage
 */
@WebServlet("/resManage.do")
public class ResManage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		request.getRequestDispatcher("/view/bdhManage/bdhManageMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");

		HttpSession session = request.getSession();
		List<Res_manageVO> lvo = new ArrayList<>();
		String today = request.getParameter("today");
		ClientVO cvo = (ClientVO) session.getAttribute("login");
		
		Res_manageVO rvo = new Res_manageVO();
		rvo.setBdh_id(cvo.getClient_id());
		rvo.setDay_code(today);

		ResManageServiceImpl service = ResManageServiceImpl.getService();

		lvo = service.getResManage(rvo);

		Gson gson = new Gson();

		String result = gson.toJson(lvo);

		response.getWriter().write(result);
		response.flushBuffer();

	}

}
