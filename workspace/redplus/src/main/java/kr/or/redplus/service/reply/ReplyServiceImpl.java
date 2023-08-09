package kr.or.redplus.service.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.redplus.dao.reply.IReplyDao;
import kr.or.redplus.dao.reply.ReplyDaoImpl;
import kr.or.redplus.vo.PageVO;
import kr.or.redplus.vo.ReplyVO;

public class ReplyServiceImpl implements IReplyService{
	
	private IReplyDao dao;
	private static ReplyServiceImpl service;
	private ReplyServiceImpl() {
		dao = ReplyDaoImpl.getInstance();
	}
	public static ReplyServiceImpl getInstance() {
		if (service == null) service = new ReplyServiceImpl();
		return service;
	}
	
	@Override
	public int insertReply(ReplyVO replyVo) {
		return dao.insertReply(replyVo);
	}

	@Override
	public int deleteReply(ReplyVO replyCode) {
		return dao.deleteReply(replyCode);
	}

	@Override
	public int updateReply(ReplyVO replyVo) {
		return dao.updateReply(replyVo);
	}

	@Override
	public List<ReplyVO> selectReply(String boardCode) {
		return dao.selectReply(boardCode);
	}
}
