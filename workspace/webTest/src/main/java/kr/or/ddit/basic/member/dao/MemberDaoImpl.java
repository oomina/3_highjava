package kr.or.ddit.basic.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {
	}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public MemberVO getMember(String id) {
		SqlSession session = null;
		MemberVO vo = null;
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			vo = session.selectOne("member.getMember", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return vo;
	}

	@Override
	public List<MemberVO> getAllMember() {
		SqlSession session = null;
		List<MemberVO> list = null;
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			list = session.selectList("member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return list;
	}

	@Override
	public int insertMember(MemberVO vo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("member.insertMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if (session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO vo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.update("member.updateMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if (session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String id) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.delete("member.deleteMember", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if (session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int idCheck(String id) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			cnt = session.selectOne("member.idCheck", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return cnt;
	}

}
