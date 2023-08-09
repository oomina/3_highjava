package kr.or.redplus.service.login;

import kr.or.redplus.dao.login.LoginDaoImpl;
import kr.or.redplus.vo.ClientVO;

public class LoginServiceImpl implements ILoginService {
	private static LoginServiceImpl service;
	private LoginDaoImpl dao;
	
	private LoginServiceImpl() {
		dao = LoginDaoImpl.getDao();
	}
	
	public static LoginServiceImpl getService() {
		if(service==null) {
			service = new LoginServiceImpl();
		}
		return service;
	}
	
	@Override
	public ClientVO checkLogin(ClientVO vo) {
		return dao.checkLogin(vo);
	}

}
