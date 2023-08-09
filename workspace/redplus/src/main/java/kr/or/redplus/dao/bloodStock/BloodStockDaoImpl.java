package kr.or.redplus.dao.bloodStock;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.BdCardLssuedVO;
import kr.or.redplus.vo.Blood_stockVO;
import util.MybatisSqlSessionFactory;

public class BloodStockDaoImpl implements IBloodStockDao {
	private static BloodStockDaoImpl dao;
	
	private BloodStockDaoImpl() {
		
	}
	
	public static BloodStockDaoImpl getDao() {
		if(dao == null) {
			dao = new BloodStockDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<Blood_stockVO> AllStockList(Blood_stockVO vo) {
		List<Blood_stockVO> lvo = new ArrayList<>();
		SqlSession session = null;
		
		try {
		  session = MybatisSqlSessionFactory.getSqlSession();
		  lvo = session.selectList("stock.AllStockList", vo);
		} catch (Exception e) {
		  e.printStackTrace();	
		} finally {
		  session.commit();
		  session.close();
		}
		
		return lvo;
	}
	
	@Override
	public List<Blood_stockVO> AllResStockList(Blood_stockVO vo) {
		List<Blood_stockVO> lvo = new ArrayList<>();
		SqlSession session = null;
		
		try {
		  session = MybatisSqlSessionFactory.getSqlSession();
		  lvo = session.selectList("stock.AllResStockList", vo);
		} catch (Exception e) {
		  e.printStackTrace();	
		} finally {
		  session.commit();
		  session.close();
		}
		
		return lvo;
	}

	@Override
	public List<BdCardLssuedVO> NoStockList(String bdh_id) {
		List<BdCardLssuedVO> lvo = new ArrayList<>();
		SqlSession session = null;
				
		try {
		  session = MybatisSqlSessionFactory.getSqlSession();
		  lvo = session.selectList("stock.NoStockList", bdh_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return lvo;
	}

	@Override
	public BdCardLssuedVO detailNoStock(String bd_code) {
		BdCardLssuedVO vo = new BdCardLssuedVO();
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			vo = session.selectOne("stock.detailNoStock", bd_code);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return vo;
	}

	@Override
	public int stockSet(Blood_stockVO vo) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.insert("stock.stockSet", vo);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public String getRegion(String bdh_id) {
		String region = null;
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			region = session.selectOne("stock.getRegion", bdh_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return region;
	}



}
