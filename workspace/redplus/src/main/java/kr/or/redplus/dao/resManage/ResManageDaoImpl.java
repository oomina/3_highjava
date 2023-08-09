package kr.or.redplus.dao.resManage;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.ResDetailVO;
import kr.or.redplus.vo.Res_manageVO;
import util.MybatisSqlSessionFactory;

public class ResManageDaoImpl implements IResManageDao {
	private static ResManageDaoImpl dao;
	
	private ResManageDaoImpl() {
		
	}
	
	public static ResManageDaoImpl getDao() {
		if(dao==null) {
			dao = new ResManageDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<Res_manageVO> getResManage(Res_manageVO vo) {
		List<Res_manageVO> lvo = new ArrayList<>();
		SqlSession session = null;
		
		try {	
			session = MybatisSqlSessionFactory.getSqlSession();
			lvo = session.selectList("resManage.getResManage", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return lvo;
	}

	@Override
	public List<ResDetailVO> getResDetail(Res_manageVO vo) {
		List<ResDetailVO> lvo = new ArrayList<>();
		SqlSession session = null;
		
		try {	
			session = MybatisSqlSessionFactory.getSqlSession();
			lvo = session.selectList("resManage.getResDetail", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		return lvo;
	}

}
