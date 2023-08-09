package kr.or.redplus.dao.dirdon;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.Direct_donaVO;
import util.MybatisSqlSessionFactory;

public class DirDonReqDaoImple implements IDirDonReqDao{
	private static DirDonReqDaoImple dao;
	private SqlSession session = null; 
	
	private DirDonReqDaoImple() {
	}
	
	public static DirDonReqDaoImple getDao() {
		if(dao==null) dao = new DirDonReqDaoImple();
		return dao;
	}
	
	@Override
	public List<Direct_donaVO> getPrevList(String hos_id) {
		session = MybatisSqlSessionFactory.getSqlSession();
		List<Direct_donaVO> list = null;
		
		try {
			list = session.selectList("ddon.getPrevList", hos_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Direct_donaVO> getPrevList(String hos_id, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int writeDdReq(Direct_donaVO request) {
		session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt =  session.insert("ddon.writeDdReq", request);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteDdReq(String dd_code) {
		session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt =  session.insert("ddon.deleteDdReq", dd_code);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	

}
