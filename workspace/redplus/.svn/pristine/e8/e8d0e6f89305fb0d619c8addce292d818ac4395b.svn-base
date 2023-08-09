package kr.or.redplus.service.resManage;

import java.util.List;

import kr.or.redplus.dao.resManage.ResManageDaoImpl;
import kr.or.redplus.vo.ResDetailVO;
import kr.or.redplus.vo.Res_manageVO;

public class ResManageServiceImpl implements IResManageService {
	private static ResManageServiceImpl service;
	private ResManageDaoImpl dao;
	
	private ResManageServiceImpl() {
		dao = ResManageDaoImpl.getDao();
	}
	
	public static ResManageServiceImpl getService() {
		if(service==null) {
			service = new ResManageServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<Res_manageVO> getResManage(Res_manageVO vo) {
		return dao.getResManage(vo);
	}

	@Override
	public List<ResDetailVO> getResDetail(Res_manageVO vo) { 
		return dao.getResDetail(vo);
	}

}
