package kr.or.redplus.dao.reply;

import java.util.List;
import java.util.Map;

import kr.or.redplus.vo.ReplyVO;

public interface IReplyDao {
	/**
	 * 댓글 작성
	 * ReplyVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param replyVo insert할 자료가 저장될 ReplyVO
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertReply(ReplyVO replyVo);
	
	/**
	 * 댓글 삭제
	 * 댓글 코드(replyCode)로 delete하는 메서드
	 * 
	 * @param replyCode
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteReply(ReplyVO replyCode);
	
	/**
	 * 댓글 수정
	 * 수정할 데이터가 저장된 객체를 메개변수로 받아서 update 메서드
	 * 
	 * @param replyVo update할 자료가 저장될 ReplyVO
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateReply(ReplyVO replyVo);
	
	public List<ReplyVO> selectReply(String boardCode);
	
	// 조회수 증가
	public int updateView(String boardCode);
}
