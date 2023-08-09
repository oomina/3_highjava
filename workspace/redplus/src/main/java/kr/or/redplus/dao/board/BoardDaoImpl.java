package kr.or.redplus.dao.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.BoardVO;
import util.MybatisSqlSessionFactory;

public class BoardDaoImpl implements IBoardDao{
	
	private static BoardDaoImpl dao;
	private BoardDaoImpl() { }
	public static BoardDaoImpl getInstance() {
		if (dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		SqlSession session = null;
		int result = 0; // 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.insert("board.insertBoard", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public int deleteBoard(String boardCode) {
		SqlSession session = null;
		int result = 0; // 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.delete("board.deleteBoard", boardCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		SqlSession session = null;
		int result = 0; // 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.update("board.updateBoard", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public int updateView(String boardCode) {
		SqlSession session = null;
		int result = 0; // 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.update("board.updateView", boardCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		SqlSession session = null;
		List<BoardVO> list = null; // 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			list = session.selectList("board.selectByPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		SqlSession session = null;
		int result = 0; // 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.selectOne("board.totalCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}
	@Override
	public BoardVO getBoardInfo(String boardCode) {
		SqlSession session = null;
		BoardVO boardVo = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			boardVo = session.selectOne("board.getBoardInfo",boardCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return boardVo;
	}
	
	public int deleteBoardReply(String boardCode) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.delete("board.deleteBoardReply", boardCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}
	@Override
	public List<BoardVO> selectMyboard(String clientId) {
		SqlSession session = null;
		List<BoardVO> list = null; // 반환값이 저장될 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			list = session.selectList("board.selectMyboard", clientId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}
	
}
