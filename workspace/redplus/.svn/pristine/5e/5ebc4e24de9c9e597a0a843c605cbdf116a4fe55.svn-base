package kr.or.redplus.dao.donation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.donation.DonationVO;
import util.MybatisSqlSessionFactory;

public class DonationDaoImpl implements IDonationDao{
	private static IDonationDao dao;
	private DonationDaoImpl() {}
	public static IDonationDao getDao(){
		if(dao == null)
			dao = new DonationDaoImpl();
		return dao;
	}
	
	@Override
	public int reqDon(DonationVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.insert("donation.reqDon", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	@Override
	public int countBdCard(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.selectOne("donation.countBdCard", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
	@Override
	public List<DonationVO> allReqList(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<DonationVO> list = null;
		try {
			list = session.selectList("donation.allReqList",memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	@Override
	public DonationVO regno(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		DonationVO vo = null;
		try {
			vo = session.selectOne("donation.regno", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return vo;
	}
	@Override
	public String changeName(String clientId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		String res = null;
		try {
			res = session.selectOne("donation.changeName", clientId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	@Override
	public List<String> bdCode(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<String> res = null;
		try {
			res = session.selectList("donation.bdCode", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	@Override
	public int donationCard(DonationVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int res = 0;
		try {
			res = session.update("donation.donationCard", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return res;
	}
	@Override
	public List<DonationVO> cardList(String memId) {
		List<DonationVO> list = null;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			list = session.selectList("donation.cardList", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
}
