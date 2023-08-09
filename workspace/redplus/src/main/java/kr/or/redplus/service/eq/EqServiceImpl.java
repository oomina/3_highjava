package kr.or.redplus.service.eq;

import kr.or.redplus.dao.eq.EqDaoImpl;
import kr.or.redplus.dao.eq.IEqDao;
import kr.or.redplus.vo.eq.EqVO;

public class EqServiceImpl implements IEqService{
	private static IEqService service;
	private IEqDao dao;
	private EqServiceImpl() {
		dao = EqDaoImpl.getDao();
	}
	public static IEqService getService() {
		if(service==null)
			service = new EqServiceImpl();
		return service;
	}
	
	@Override
	public String eqLogin(EqVO vo) {
		return dao.eqLogin(vo);
	}

	@Override
	public int insertEq(String memId) {
		return dao.insertEq(memId);
	}

}
