package kr.or.redplus.dao.login;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.ClientVO;
import util.MybatisSqlSessionFactory;

public class LoginDaoImpl implements ILoginDao {
	private static LoginDaoImpl dao;
	
	private LoginDaoImpl() {
		
	}
	
	public static LoginDaoImpl getDao() {
		if(dao==null) {
			dao = new LoginDaoImpl();
		}
		return dao;
	}
	
	@Override
	public ClientVO checkLogin(ClientVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		ClientVO ovo = null;
		
		try {
			ovo = session.selectOne("login.checkLogin", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return ovo;
	}


}
