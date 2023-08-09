package kr.or.redplus.service.ddAccept;

import java.util.List;

import kr.or.redplus.dao.ddAccept.DdAcceptDaoImpl;
import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.DdListVO;
import kr.or.redplus.vo.Direct_donaVO;
import kr.or.redplus.vo.Don_acceptVO;

public class DdAcceptServiceImpl implements IDdAcceptService {
	private static DdAcceptServiceImpl service;
	private DdAcceptDaoImpl dao;
	
	private DdAcceptServiceImpl() {
		dao = DdAcceptDaoImpl.getDao();
	}
	
	public static DdAcceptServiceImpl getService() {
		if(service==null) {
			service = new DdAcceptServiceImpl();
		}
		return service;
	}
	@Override
	public List<Don_acceptVO> ddList() {
		return dao.ddList();
	}

	@Override
	public String getBloodType(String client_id) {
		return dao.getBloodType(client_id);
	}

	@Override
	public Direct_donaVO ddDetail(String dd_code) {
		return dao.ddDetail(dd_code);
	}

	@Override
	public ClientVO getHosInfo(String hos_id) {
		return dao.getHosInfo(hos_id);
	}

	@Override
	public String resTimeCheck(String user_id) {
		return dao.resTimeCheck(user_id);
	}

	@Override
	public String ddTimeCheck(String user_id) {
		return dao.ddTimeCheck(user_id);
	}

	@Override
	public int acceptSet(Don_acceptVO vo) {
		return dao.acceptSet(vo);
	}

	@Override
	public int getDdCount(String mem_id) {
		return dao.getDdCount(mem_id);
	}

	@Override
	public DdListVO getDdList(String mem_id) {
		return dao.getDdList(mem_id);
	}

	@Override
	public int deleteDd(String dd_code) {
		return dao.deleteDd(dd_code);
	}

	@Override
	public List<DdListVO> listDdAll(String mem_id) {
		return dao.listDdAll(mem_id);
	}
	
	

}
