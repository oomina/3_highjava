package kr.or.redplus.dao.join;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.redplus.vo.JoinVO;
import kr.or.redplus.vo.JoinZipVO;
import util.MybatisSqlSessionFactory;

public class JoinDaoImpl implements IJoinDao {
	
	private SqlSessionFactory sessionFactory;
	private static IJoinDao dao;
	
	private JoinDaoImpl() {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
	}
	
	public static IJoinDao getDao() {
		if(dao == null) dao = new JoinDaoImpl();
		
		return dao;
	}
	
	@Override
	public int insertClient(JoinVO vo) {
		int cnt = 0;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			cnt = session.insert("join.insertClient", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	
	@Override
	public int insertMember(JoinVO vo) {
		int cnt = 0;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			cnt = session.insert("join.insertMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	
	@Override
	public String idCheck(String id) {
		String res = null;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			res = session.selectOne("join.idCheck", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public List<JoinZipVO> selectByDong(String dong) {
		List<JoinZipVO> list = null;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("join.selectByDong", dong);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}
	
	@Override
	public String findId(JoinVO vo) {
		String res = null;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			res = session.selectOne("join.findId", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}
	
	@Override
	public String findPassword(JoinVO vo) {
		String res = null;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			res = session.selectOne("join.findPassword", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}
	
	@Override
	public void updatePassword(JoinVO vo) {
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			session.update("join.updatePassword", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
	}
	
	@Override
	public JoinVO memberInfo(JoinVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			vo = session.selectOne("join.memberInfo", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return vo;
	}
	
	@Override
	public int updateMember(JoinVO vo) {
		int cnt = 0;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			cnt = session.update("join.updateMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int regnoChk(JoinVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.selectOne("join.regnoChk", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
}
