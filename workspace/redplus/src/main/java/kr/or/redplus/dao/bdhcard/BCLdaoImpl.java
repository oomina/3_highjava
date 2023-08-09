package kr.or.redplus.dao.bdhcard;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.BdCardLssuedVO;
import kr.or.redplus.vo.MemberVO;
import util.MybatisSqlSessionFactory;

public class BCLdaoImpl implements IBCLdao {
	private static BCLdaoImpl dao;
	
	private BCLdaoImpl() {
		
	}
	
	public static BCLdaoImpl getDao() {
		if(dao==null) {
			dao = new BCLdaoImpl();
		}
		return dao;
	}
	
	@Override
	public MemberVO clientCheck(BdCardLssuedVO vo) {
		SqlSession session = null;
		MemberVO mvo = new MemberVO();
		
		try {
			session=MybatisSqlSessionFactory.getSqlSession();
			mvo = session.selectOne("BCL.clientCheck", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return mvo;
	}

	@Override
	public int bdCardSet(BdCardLssuedVO vo) {
		SqlSession session = null;
		int result = 0;
		
		try {
			session=MybatisSqlSessionFactory.getSqlSession();
			result = session.insert("BCL.bdCardSet", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public List<String> dayCodeGet(BdCardLssuedVO vo) {
		List<String> ls = new ArrayList<>();
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			ls = session.selectList("BCL.dayCodeGet", vo);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return ls;
	}

	@Override
	public List<String> bdDateGet(BdCardLssuedVO vo) {
		List<String> ls = new ArrayList<>();
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			ls = session.selectList("BCL.bdCodeGet", vo);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return ls;
	}
	
	
	

}
