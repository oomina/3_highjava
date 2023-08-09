package kr.or.redplus.service.common;

import kr.or.redplus.dao.common.CommonDaoImple;
import kr.or.redplus.dao.common.ICommonDao;
import kr.or.redplus.vo.common.BloodCountVO;

public class CommonServiceImple implements ICommonService {
	private static ICommonService service;
	private static ICommonDao dao;
	
	private CommonServiceImple() {
		dao = CommonDaoImple.getDao();
	}
	
	public static ICommonService getService() {
		if(service ==null) { service = new CommonServiceImple();}
		return service;
	}
	
	@Override
	public BloodCountVO getBloodCount(String date) {
		return dao.getBloodCount(date);
	}

}
