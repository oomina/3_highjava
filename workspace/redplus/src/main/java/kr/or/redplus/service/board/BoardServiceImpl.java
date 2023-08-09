package kr.or.redplus.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.redplus.dao.board.BoardDaoImpl;
import kr.or.redplus.dao.board.IBoardDao;
import kr.or.redplus.vo.BoardVO;
import kr.or.redplus.vo.PageVO;

public class BoardServiceImpl implements IBoardService{
	
	private IBoardDao dao;
	private static BoardServiceImpl service;
	private BoardServiceImpl() { 
		dao = BoardDaoImpl.getInstance();
	}
	public static BoardServiceImpl getInstance() {
		if (service == null) service = new BoardServiceImpl();
		return service;
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		return dao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(String boardCode) {
		return dao.deleteBoard(boardCode);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return dao.updateBoard(boardVo);
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		return dao.totalCount(map);
	}
	
	/**
	 * 전체 글 갯수 구하기
	 */
	@Override
	public PageVO pageInfo(int page, String stype, String sword) {
		Map<String, Object> map = new HashMap<>();
		map.put("sword", sword);
		map.put("stype", stype);
		
		int count = this.totalCount(map);
		
		// 전체페이지수 구하기
		int totalPage = (int)Math.ceil((double)count / PageVO.getPerList());
		
		// start, end 구하기 19
		int start = (page-1) * PageVO.getPerList() + 1;
		int end = start + PageVO.getPerList() - 1;
		if(end > count) end = count;
		
		// 시작페이지 끝페이지
		int perPage = PageVO.getPerPage();
		int startPage = ((page-1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		PageVO vo = new PageVO();
		vo.setStart(start);
		vo.setEnd(end);
		
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotalPage(totalPage);
		
		return vo;
	}
	@Override
	public BoardVO getBoardInfo(String boardCode) {
		return dao.getBoardInfo(boardCode);
	}
	@Override
	public int deleteBoardReply(String boardCode) {
		return dao.deleteBoardReply(boardCode);
	}
	@Override
	public List<BoardVO> selectMyboard(String clientId) {
		return dao.selectMyboard(clientId);
	}
	@Override
	public int updateView(String boardCode) {
		return dao.updateView(boardCode);
	}
}
