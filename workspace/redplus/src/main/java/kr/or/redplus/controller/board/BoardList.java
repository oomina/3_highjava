package kr.or.redplus.controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.redplus.service.board.BoardServiceImpl;
import kr.or.redplus.service.board.IBoardService;
import kr.or.redplus.vo.BoardVO;
import kr.or.redplus.vo.PageVO;

@WebServlet("/boardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 전송데이터 가져오기
		int page = Integer.parseInt(request.getParameter("page")); // 최초 실행시 1이다.
		String stype = request.getParameter("stype"); // 최초 실행시 없다.
		String sword = request.getParameter("sword"); // 최초 실행시 없다.
		
		// service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		// service 메소드 호출
		PageVO vo = service.pageInfo(page, stype, sword);
		
		// service메소드 - list를 select 결과값 받기
		Map<String, Object> map = new HashMap<>();
		map.put("start",  vo.getStart());
		map.put("end", vo.getEnd());
		map.put("stype", stype);
		map.put("sword", sword);
		
		List<BoardVO> list = service.selectByPage(map);
		
		// 결과값을 request에 저장
		request.setAttribute("listValue", list);
		request.setAttribute("startPage", vo.getStartPage());
		request.setAttribute("endPage", vo.getEndPage());
		request.setAttribute("totalPage", vo.getTotalPage());
		
		// view 페이지로 이동
		request.getRequestDispatcher("/view/board/boardList.jsp").forward(request, response);
	}

}