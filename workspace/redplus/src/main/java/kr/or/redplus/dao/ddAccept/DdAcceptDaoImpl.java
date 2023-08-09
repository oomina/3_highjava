package kr.or.redplus.dao.ddAccept;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.DdListVO;
import kr.or.redplus.vo.Direct_donaVO;
import kr.or.redplus.vo.Don_acceptVO;
import util.MybatisSqlSessionFactory;

public class DdAcceptDaoImpl implements IDdAcceptDao {
	private static DdAcceptDaoImpl dao;
	
	private DdAcceptDaoImpl() {
		
	}
	
	public static DdAcceptDaoImpl getDao() {
		if(dao==null) {
			dao=new DdAcceptDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<Don_acceptVO> ddList() {
		List<Don_acceptVO> lvo = new ArrayList<>();
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			lvo = session.selectList("ddAccept.ddList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return lvo;
	}

	@Override
	public String getBloodType(String client_id) {
		String blood_type = null;
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			blood_type = session.selectOne("ddAccept.getBloodType", client_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return blood_type;
	}

	@Override
	public Direct_donaVO ddDetail(String dd_code) {
		Direct_donaVO dvo = new Direct_donaVO();
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			dvo = session.selectOne("ddAccept.ddDetail", dd_code);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return dvo;
	}

	@Override
	public ClientVO getHosInfo(String hos_id) {
		ClientVO vo = new ClientVO();
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			vo = session.selectOne("ddAccept.getHosInfo", hos_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return vo;
	}

	@Override
	public String resTimeCheck(String user_id) {
		String resTime = null;
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			resTime = session.selectOne("ddAccept.resTimeCheck", user_id);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return resTime;
	}

	@Override
	public String ddTimeCheck(String user_id) {
		String ddTime = null;
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			ddTime = session.selectOne("ddAccept.ddTimeCheck", user_id);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return ddTime;
	}

	@Override
	public int acceptSet(Don_acceptVO vo) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.insert("ddAccept.acceptSet", vo);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public int getDdCount(String mem_id) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			count = session.selectOne("ddAccept.getDdCount", mem_id);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return count;
	}

	@Override
	public DdListVO getDdList(String mem_id) {
		DdListVO vo = new DdListVO();
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			vo = session.selectOne("ddAccept.getDdList", mem_id);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return vo;
	}

	@Override
	public int deleteDd(String dd_code) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			result = session.delete("ddAccept.deleteDd", dd_code);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	@Override
	public List<DdListVO> listDdAll(String mem_id) {
		List<DdListVO> lvo = new ArrayList<>();
		SqlSession session = null;
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			lvo = session.selectList("ddAccept.listDdAll", mem_id);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return lvo;
	}

}
