package kr.or.redplus.dao.eq;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.eq.EqVO;
import util.MybatisSqlSessionFactory;

public class EqDaoImpl implements IEqDao{
	private static IEqDao dao;
	private EqDaoImpl() {}
	public static IEqDao getDao() {
		if(dao==null)
			dao = new EqDaoImpl();
		return dao;
	}
	
	@Override
	public String eqLogin(EqVO vo) {
		String res = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			res = session.selectOne("eq.eqLogin", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();			
		}
		return res;
	}

	@Override
	public int insertEq(String memId) {
		int cnt = 0;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			cnt = session.insert("eq.insertEq", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

}
