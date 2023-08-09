package kr.or.ddit.basic.json;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.LprodVO;

public class LprodDaoImpl implements ILprodDao {
	
	private static LprodDaoImpl dao;
	
	private LprodDaoImpl() { }
	
	public static LprodDaoImpl getInstance() {
		if(dao == null) dao = new LprodDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<LprodVO> getLprodList() {
		SqlSession session = null;
		
		List<LprodVO> lprodlist = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			lprodlist = session.selectList("lprod.getAllLprod");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return lprodlist;
	}
}
