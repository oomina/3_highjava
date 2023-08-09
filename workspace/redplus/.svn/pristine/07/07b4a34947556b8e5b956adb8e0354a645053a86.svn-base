package kr.or.redplus.dao.board;

import java.util.List;
import java.util.Map;

import kr.or.redplus.vo.BoardVO;

public interface IBoardDao {
	/**
	 * 게시글코드를 인수값으로 받아서 해당 게시글 정보를 검색하여 반환하는 메서드
	 * @param boardCode
	 * @return 검색된 게시글 정보가 저장된 BoardVO객체
	 */
	public BoardVO getBoardInfo(String boardCode);
	
	/**
	 * 게시글 작성
	 * BoardVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param boardVo insert할 자료가 저장될 BoardVO
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertBoard(BoardVO boardVo);
		
	/**
	 * 게시글 삭제
	 * 게시글 코드(boardCode)로 DB delete하는 메서드
	 *  
	 * @param boardCode delete할 게시글 코드
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteBoard(String boardCode);
		
	/**
	 * 게시글 수정
	 * 수정할 데이터가 저장된 객체를 매개변수로 받아서 update 메서드
	 *  
	 * @param boardVo update할 자료가 저장될 BoardVO
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateBoard(BoardVO boardVo);
	
	/**
	 * 조회수 증가
	 *  
	 * @param boardCode
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateView(String boardCode);
		
	/**
	 * 리스트 출력 및 검색
	 * 
	 * @param map
	 * @return 게시판 글 정보가 저장된 List객체
	 */
	public List<BoardVO> selectByPage(Map<String, Object> map);
		
		
	/**
	 * 전체 글 갯수 구하기
	 * @param map
	 * @return 
	 */
	public int totalCount(Map<String, Object> map);
	
	public int deleteBoardReply(String boardCode);
	
	List<BoardVO> selectMyboard(String clientId);
}
