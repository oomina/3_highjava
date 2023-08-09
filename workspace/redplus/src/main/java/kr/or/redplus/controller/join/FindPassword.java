package kr.or.redplus.controller.join;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.redplus.service.join.IJoinService;
import kr.or.redplus.service.join.JoinServiceImpl;
import kr.or.redplus.vo.JoinVO;

@WebServlet("/findPassword.do")
public class FindPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("mem_id");
		String clientName = request.getParameter("client_name");
		String memRegno1 = request.getParameter("mem_regno1");
		String memRegno2 = request.getParameter("mem_regno2");
		
		JoinVO vo = new JoinVO();
		vo.setMem_id(memId);
		vo.setClient_name(clientName);
		vo.setMem_regno1(memRegno1);
		vo.setMem_regno2(memRegno2);
		
		IJoinService service = JoinServiceImpl.getService();
		
		String res = service.findPassword(vo);
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("pwd", res);
		
		Gson gson = new Gson();
		String str = gson.toJson(jsonObject);
		
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
	}
}
