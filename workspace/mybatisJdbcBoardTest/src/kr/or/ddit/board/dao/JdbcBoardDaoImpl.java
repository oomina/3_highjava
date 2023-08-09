package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.JdbcBoardVO;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	
	// 1번
	private static JdbcBoardDaoImpl dao;
	
	// 2번
	private JdbcBoardDaoImpl() { }
	
	// 3번 
	public static JdbcBoardDaoImpl getInstance() {
		if(dao == null) dao = new JdbcBoardDaoImpl();
		return dao;
	}
	
	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		SqlSession session = null;
		int cnt = 0;  // 반환값 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("board.insertBoard", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		SqlSession session = null;
		int cnt = 0;  // 반환값 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.delete("board.deleteBoard", boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		SqlSession session = null;
		int cnt = 0;  // 반환값 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.update("board.updateBoard", boardVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		SqlSession session = null;
		JdbcBoardVO boardVo = null;  // 반환값 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			boardVo = session.selectOne("board.getBoard", boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardVo;
	}

	@Override
	public List<JdbcBoardVO> getAllBoardList() {
		SqlSession session = null;
		List<JdbcBoardVO> boardList = null;  // 반환값 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			boardList = session.selectList("board.getAllBoard");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardList;
	}

	@Override
	public List<JdbcBoardVO> getSearchBoardList(String title) {
		SqlSession session = null;
		List<JdbcBoardVO> boardList = null;  // 반환값 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			boardList = session.selectList("board.getSearchBoard", title);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardList;
	}

	@Override
	public int setCountIncrement(int boardNo) {
		SqlSession session = null;
		int cnt = 0;  // 반환값 변수
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.update("board.setCountIncrement", boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

}
