package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/insertMember.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 100 )
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String uploadPath = "d:/d_other/uploadFiles";
		
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String memId = request.getParameter("memid");
		String memPass = request.getParameter("mempass");
		String memName = request.getParameter("memname");
		String memTel = request.getParameter("memtel");
		String memAddr = request.getParameter("memaddr");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(memId);
		vo.setMem_pass(memPass);
		vo.setMem_name(memName);
		vo.setMem_tel(memTel);
		vo.setMem_addr(memAddr);
		
		String fileName = "";
		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
			if (!"".equals(fileName)) {
				vo.setMem_photo(fileName);
				
				try {
					part.write(uploadPath + File.separator + fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		service.insertMember(vo);
		
		response.sendRedirect(request.getContextPath() + "/memberList.do");
	}

	private String extractFileName(Part part) {
		String fileName = "";

		String headerValue = part.getHeader("content-disposition");

		String[] items = headerValue.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return fileName;
	}
}
