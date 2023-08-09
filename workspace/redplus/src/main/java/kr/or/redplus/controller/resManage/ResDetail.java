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
import kr.or.redplus.vo.ResDetailVO;
import kr.or.redplus.vo.Res_manageVO;

/**
 * Servlet implementation class ResDetail
 */
@WebServlet("/resDetail.do")
public class ResDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");

		HttpSession session = request.getSession();
		List<ResDetailVO> lvo = new ArrayList<>();
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		
		ClientVO cvo = (ClientVO) session.getAttribute("login");
		time = time.replaceAll("시", "");
		Res_manageVO rvo = new Res_manageVO();
		rvo.setBdh_id(cvo.getClient_id());
		rvo.setDay_code(day);
		rvo.setTime_code(time);

		System.out.println(rvo.getBdh_id());
		System.out.println(rvo.getDay_code());
		System.out.println(rvo.getTime_code());

		ResManageServiceImpl service = ResManageServiceImpl.getService();

		lvo = service.getResDetail(rvo);

		Gson gson = new Gson();

		String result = gson.toJson(lvo);

		response.getWriter().write(result);
		response.flushBuffer();
	}

}
