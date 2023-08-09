package kr.or.redplus.dao.reply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.ReplyVO;
import util.MybatisSqlSessionFactory;

public class ReplyDaoImpl implements IReplyDao{
	
	private static ReplyDaoImpl dao;
	private ReplyDaoImpl() { }
	public static ReplyDaoImpl getInstance() {
		if (dao == null) dao = new ReplyDaoImpl();
		return dao;
	}
	
	@Override
	public int insertReply(ReplyVO replyVo) {
		SqlSession session = null;
		int result = 0;	// 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.insert("reply.insertReply", replyVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public int deleteReply(ReplyVO replyCode) {
		SqlSession session = null;
		int result = 0;	// 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.delete("reply.deleteReply", replyCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public int updateReply(ReplyVO replyVo) {
		SqlSession session = null;
		int result = 0;	// 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.update("reply.updateReply", replyVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public List<ReplyVO> selectReply(String boardCode) {
		SqlSession session = null;
		List<ReplyVO> list = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			list = session.selectList("reply.selectReply", boardCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}
	@Override
	public int updateView(String boardCode) {
		SqlSession session = null;
		int result = 0;
		
		try {
			result = session.update("board.updateView",boardCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}
}
