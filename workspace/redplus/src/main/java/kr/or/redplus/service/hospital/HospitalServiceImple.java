package kr.or.redplus.service.hospital;

import java.util.List;

import kr.or.redplus.dao.hospital.HospitalDaoImple;
import kr.or.redplus.dao.hospital.IHospitalDao;
import kr.or.redplus.vo.Blood_applyVO;
import kr.or.redplus.vo.Blood_stockVO;

public class HospitalServiceImple implements IHospitalSevice{

	private static IHospitalSevice service = null;
	private static IHospitalDao dao = null;
	
	private HospitalServiceImple() {
		dao = HospitalDaoImple.getDao();
	}
	
	public static IHospitalSevice getService() {
		if(service==null) service = new HospitalServiceImple();
		
		return service;
	}
	
	@Override
	public String getRegion(String id) {
		return dao.getRegion(id);
	}

	@Override
	public List<Blood_stockVO> getBloodList(String hos_id) {
		return dao.getBloodList(hos_id);
	}

	@Override
	public int DeliveryReq(Blood_applyVO requestInfo) {
		return dao.DeliveryReq(requestInfo);
	}

	@Override
	public List<Blood_stockVO> notRecieveList(String hos_id) {
		return dao.notRecieveList(hos_id);
	}

	@Override
	public int reciveBlood(Blood_applyVO bloodInfo) {
		return dao.reciveBlood(bloodInfo);
	}

	@Override
	public List<Blood_stockVO> getStockList(String hos_id) {
		return dao.getStockList(hos_id);
	}

	@Override
	public int bdStockUse(String bd_code) {
		return dao.bdStockUse(bd_code);
	}

	

}
