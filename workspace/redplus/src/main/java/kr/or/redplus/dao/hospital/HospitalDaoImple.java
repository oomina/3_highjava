package kr.or.redplus.dao.hospital;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.Blood_applyVO;
import kr.or.redplus.vo.Blood_stockVO;
import util.MybatisSqlSessionFactory;

public class HospitalDaoImple implements IHospitalDao{

	private static IHospitalDao dao = null;
	private static SqlSession session = null;
	
	private HospitalDaoImple() {
	}
	
	public static IHospitalDao getDao() {
		if(dao==null) dao = new HospitalDaoImple();
		
		return dao;
	}
	
	@Override
	public String getRegion(String id) {
		String region = "값없음";
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			region = session.selectOne("hos.getRegion", id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return region;
	}
	
	@Override
	public List<Blood_stockVO> getBloodList(String hos_id) {
		List<Blood_stockVO> lvo = new ArrayList<>();
		
		try {
		  session = MybatisSqlSessionFactory.getSqlSession();
		  lvo = session.selectList("hos.getBloodList", hos_id);
		} catch (Exception e) {
		  e.printStackTrace();	
		} finally {
		  session.commit();
		  session.close();
		}
		
		return lvo;
	}

	@Override
	public int DeliveryReq(Blood_applyVO requestInfo) {
		int cnt1 = 0;
		int cnt2 = 0;
		
		try {
			  session = MybatisSqlSessionFactory.getSqlSession();
			  cnt1 = session.insert("hos.bloodApply", requestInfo);
			  cnt2 = session.update("hos.updateReleaseDay", requestInfo.getBd_code());
			  
			  
			} catch (Exception e) {
			  e.printStackTrace();	
			} finally {
			  session.commit();
			  session.close();
			}
		
		return cnt1+cnt2;
	}

	@Override
	public List<Blood_stockVO> notRecieveList(String hos_id) {
List<Blood_stockVO> lvo = new ArrayList<>();
		
		try {
		  session = MybatisSqlSessionFactory.getSqlSession();
		  lvo = session.selectList("hos.notRecieveList", hos_id);
		} catch (Exception e) {
		  e.printStackTrace();	
		} finally {
		  session.commit();
		  session.close();
		}
		
		return lvo;
	}

	@Override
	public int reciveBlood(Blood_applyVO bloodInfo) {
		int cnt1 = 0;
		int cnt2 = 0;
		
		try {
			  session = MybatisSqlSessionFactory.getSqlSession();
			  cnt1 = session.update("hos.recevieCheck", bloodInfo.getBd_code());
			  cnt2 = session.update("hos.bloodPosition", bloodInfo);
			  
			  
			} catch (Exception e) {
			  e.printStackTrace();	
			} finally {
			  session.commit();
			  session.close();
			}
		
		return cnt1+cnt2;
	}

	@Override
	public List<Blood_stockVO> getStockList(String hos_id) {
		List<Blood_stockVO> lvo = new ArrayList<>();
		
		try {
		  session = MybatisSqlSessionFactory.getSqlSession();
		  lvo = session.selectList("hos.getStockList", hos_id);
		} catch (Exception e) {
		  e.printStackTrace();	
		} finally {
		  session.commit();
		  session.close();
		}
		
		return lvo;
	}

	@Override
	public int bdStockUse(String bd_code) {
		int cnt = 0;
		
		try {
			  session = MybatisSqlSessionFactory.getSqlSession();
			  cnt = session.update("bdStockUse", bd_code);
			} catch (Exception e) {
			  e.printStackTrace();	
			} finally {
			  session.commit();
			  session.close();
			}
		
		return cnt;
	}
	
	
	

}
