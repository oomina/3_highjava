package kr.or.redplus.controller.bdcard;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.redplus.service.bdhcard.BCLServiceImpl;
import kr.or.redplus.vo.BdCardLssuedVO;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.MemberVO;

/**
 * Servlet implementation class ClientCheck
 */
@WebServlet("/clientCheck.do")
public class ClientCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientCheck() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/view/bdCardLssued/bclMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ClientVO cvo = (ClientVO)session.getAttribute("login");
		
		String name = request.getParameter("name");
		String regno1 = request.getParameter("regno1");
		String regno2 = request.getParameter("regno2");
		List<String> rdate = new ArrayList<>();	
		List<String> cdate = new ArrayList<>();	
		List<String> idate = new ArrayList<>();
		
		LocalDate today = LocalDate.now();

		BdCardLssuedVO vo = new BdCardLssuedVO();
		vo.setMem_name(name);
		vo.setMem_regno1(regno1);
		vo.setMem_regno2(regno2);
		
		BCLServiceImpl service = BCLServiceImpl.getService();
		
		MemberVO mvo = service.clientCheck(vo);
		
		
		if(mvo==null) {
			out.print("<script> alert('해당 정보가 존재하지 않습니다.') </script>");
			out.print("<script>location.href='/clientCheck.do';</script>");	
		}else {
			vo.setMem_id(mvo.getMem_id()); 
			vo.setBdh_id(cvo.getClient_id()); 
			rdate = service.dayCodeGet(vo);
			cdate = service.bdDateGet(vo);
			cdate.add("a");
			
			if(!rdate.isEmpty()) {
				for(String r : rdate) {
					r = r.replaceAll("/", "-");
					LocalDate otherDate = LocalDate.parse(r);
					int result = today.compareTo(otherDate);
					r = r.replaceAll("-", "/");
					if(!cdate.contains(r)&&result >= 0) {
						idate.add(r);
					}
				}
				if(idate.isEmpty()){
					out.print("<script> alert('모든 헌혈증이 발급 완료되었습니다.') </script>");
					out.print("<script>location.href='/clientCheck.do';</script>");	
				}else {
					request.setAttribute("day", idate);
					request.setAttribute("name", vo.getMem_name());
					request.setAttribute("mvo", mvo);
					request.getRequestDispatcher(request.getContextPath() + "/view/bdCardLssued/bclInputForm.jsp").forward(request, response);
				}	
			}else{
				out.print("<script> alert('헌혈 내역이 없습니다.') </script>");
				out.print("<script>location.href='/clientCheck.do';</script>");	
			}
			
		}
	
	}

}
