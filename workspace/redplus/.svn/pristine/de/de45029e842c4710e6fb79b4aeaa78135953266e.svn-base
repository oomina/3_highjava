package kr.or.redplus.dao.resList;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.bdhres.BdhResVO;
import util.MybatisSqlSessionFactory;

public class ResListDaoImpl implements IResListDao {
	private static IResListDao dao;
	private ResListDaoImpl() {}
	public static IResListDao getDao() {
		if(dao==null)
			dao = new ResListDaoImpl();
		return dao;
	}
	
	@Override
	public String nextResDate(String memId) {
		String res = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			res = session.selectOne("resList.nextResDate", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}

	@Override
	public int countBd(String memId) {
		int cnt = 0;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			cnt = session.selectOne("resList.countBd", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public String bdhId(String memId) {
		String res = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			res = session.selectOne("resList.bdhId", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}

	@Override
	public String bbName(String bdhId) {
		String res = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			res = session.selectOne("resList.bbName", bdhId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}

	@Override
	public String findBdhId(String bdhName) {
		String res = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			res = session.selectOne("resList.findBdhId", bdhName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}

	@Override
	public List<BdhResVO> lastRes(String vo) {
		List<BdhResVO> vo2 = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			vo2 = session.selectList("resList.lastRes", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return vo2;
	}

	@Override
	public List<BdhResVO> curRes(String vo) {
		List<BdhResVO> vo2 = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			vo2 = session.selectList("resList.curRes", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return vo2;
	}
	@Override
	public String resCode(BdhResVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		String res = null;
		try {
			res = session.selectOne("resList.resCode", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	@Override
	public int deleteRes(String resCode) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int res = 0;
		try {
			res = session.delete("resList.deleteRes", resCode);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return res;
	}

}
