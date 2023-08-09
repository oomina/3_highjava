package kr.or.redplus.controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.redplus.service.join.IJoinService;
import kr.or.redplus.service.join.JoinServiceImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.JoinVO;

@WebServlet("/memberInfoPassword.do")
public class MemberInfoPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		ClientVO ivo = (ClientVO)session.getAttribute("login");
		if(ivo == null) {
			request.getRequestDispatcher("/index.do").forward(request, response);
		}else {
			request.getRequestDispatcher("/view/mypage/member_info_password.jsp").forward(request, response);
		}
	}
}
