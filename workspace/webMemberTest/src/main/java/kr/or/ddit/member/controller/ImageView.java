package kr.or.ddit.member.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/images/image.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String memPhoto = request.getParameter("memphoto");
		
		String uploadPath = "d:/d_other/uploadFiles";
		
		File f = new File(uploadPath);
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String imgPath = uploadPath + File.separator + memPhoto;
		File imgFile = new File(imgPath);
		
		if(imgFile.exists()) {
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				bout = new BufferedOutputStream(response.getOutputStream());
				bin = new BufferedInputStream(new FileInputStream(imgFile));
				
				byte[] temp = new byte[1024];
				int len = 0;
				
				while((len=bin.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(bin != null) bin.close();
				if(bout != null) bout.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
