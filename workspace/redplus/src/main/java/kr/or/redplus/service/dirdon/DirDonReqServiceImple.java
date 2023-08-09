package kr.or.redplus.service.dirdon;

import java.util.List;

import kr.or.redplus.dao.dirdon.DirDonReqDaoImple;
import kr.or.redplus.dao.dirdon.IDirDonReqDao;
import kr.or.redplus.vo.Direct_donaVO;

public class DirDonReqServiceImple implements IDirDonReqService{
	private static IDirDonReqService service;
	private static IDirDonReqDao dao;
	
	private DirDonReqServiceImple() {
		dao = DirDonReqDaoImple.getDao();
	}
	
	public static IDirDonReqService getService() {
		if(service==null) service = new DirDonReqServiceImple();
		return service;
	}
	
	
	@Override
	public List<Direct_donaVO> getPrevList(String hos_id) {
		return dao.getPrevList(hos_id);
	}

	@Override
	public List<Direct_donaVO> getPrevList(String hos_id, int page) {
		return dao.getPrevList(hos_id, page);
	}

	@Override
	public int writeDdReq(Direct_donaVO request) {
		return dao.writeDdReq(request);
	}

	@Override
	public int deleteDdReq(String dd_code) {
		return dao.deleteDdReq(dd_code);
	}

}
