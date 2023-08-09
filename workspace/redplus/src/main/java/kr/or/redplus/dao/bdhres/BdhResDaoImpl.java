package kr.or.redplus.dao.bdhres;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.bdhres.BdhResVO;
import util.MybatisSqlSessionFactory;

public class BdhResDaoImpl implements IBdhResDao{
	private static IBdhResDao dao;
	private BdhResDaoImpl() {}
	public static IBdhResDao getDao() {
		if(dao==null)
			dao = new BdhResDaoImpl();
		return dao;
	}
	
	// 전자문진 예약 체크 후 만약 cnt=0이면 예약불가
	@Override
	public int checkRes(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.selectOne("bdhres.checkRes", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
	
	// 헌혈의집 찾기
	@Override
	public List<BdhResVO> searchBdh(String addr) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<BdhResVO> list = null;
		try {
			list = session.selectList("bdhres.searchBdh", addr);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return list;
	}
	
	// 예약하기
	@Override
	public int insertRes(BdhResVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.insert("bdhres.insertRes", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	
	// 예약취소하기
	@Override
	public int deleteRes(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.insert("bdhres.deleteRes", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	
	// 헌혈의집 아이디 추출
	@Override
	public String findBdhId(String bdhName) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		String res = null;
		try {
			res = session.selectOne("bdhres.findBdhId", bdhName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	
	// 헌혈가능 시간 조회
	@Override
	public List<BdhResVO> ableTime(BdhResVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<BdhResVO> list = null;
		try {
			list = session.selectList("bdhres.ableTime", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	@Override
	public BdhResVO memInfo(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		BdhResVO vo = null;
		try {
			vo = session.selectOne("bdhres.memInfo", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return vo;
	}
	@Override
	public int ableResUpdate(BdhResVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.update("bdhres.ableResUpdate", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	@Override
	public int chkAbleRes(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.selectOne("bdhres.chkAbleRes", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
	@Override
	public int chkAbleRes2(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.selectOne("bdhres.chkAbleRes2", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}
	@Override
	public String ableDate(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		String res = null;
		try {
			res = session.selectOne("bdhres.ableDate", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	@Override
	public String typePeriod(String dtType) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		String res = null;
		try {
			res = session.selectOne("bdhres.typePeriod", dtType);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	@Override
	public int updateAbledateSysdate(String memId) {
		int cnt = 0;
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		try {
			cnt = session.update("bdhres.updateAbledateSysdate", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	@Override
	public String lastDdRes(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		String res = null;
		try {
			res = session.selectOne("bdhres.lastDdRes", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	@Override
	public int chkDdRes(String memId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.selectOne("bdhres.chkDdRes", memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

}
