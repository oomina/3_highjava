package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() { }
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		SqlSession session = null;
		int cnt = 0;  // 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("member.insertMember", memVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		SqlSession session = null;
		int cnt = 0;  // 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.delete("member.deleteMember", memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		SqlSession session = null;
		int cnt = 0;  // 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.update("member.updateMember", memVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		SqlSession session = null;
		List<MemberVO> memList = null;  // 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			memList = session.selectList("member.getAllMember");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		SqlSession session = null;
		int count = 0;  // 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			count = session.selectOne("member.getMemIdCount", memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return count;
	}
	
	// Map의 정보 ==> key값 : 수정할 컬럼명(field), 수정할 데이터(data), 검색할 회원ID(memId)
	@Override
	public int updateMember2(Map<String, String> paramMap) {
		SqlSession session = null;
		int cnt = 0;  // 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.update("member.updateMember2", paramMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	
	@Override
	public int updateMember3(Map<String, String> dataMap) {
		
//		if(dataMap.size() == 1) return 0;
		
		SqlSession session = null;
		int cnt = 0;  // 반환값이 저장될 변수
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.update("member.updateMember3", dataMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
}
