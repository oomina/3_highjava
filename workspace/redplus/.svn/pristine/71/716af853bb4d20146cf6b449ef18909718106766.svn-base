package kr.or.redplus.service.bloodStock;

import java.util.List;

import kr.or.redplus.dao.bloodStock.BloodStockDaoImpl;
import kr.or.redplus.vo.BdCardLssuedVO;
import kr.or.redplus.vo.Blood_stockVO;

public class BloodStockServiceImpl implements IBloodStockService {
	private static BloodStockServiceImpl service;
	private BloodStockDaoImpl dao;
	
	private BloodStockServiceImpl() {
		dao = BloodStockDaoImpl.getDao();
	}
	
	public static BloodStockServiceImpl getServcie() {
		if(service==null) {
			service = new BloodStockServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<Blood_stockVO> AllStockList(Blood_stockVO vo) {
		return dao.AllStockList(vo);
	}
	
	@Override
	public List<Blood_stockVO> AllResStockList(Blood_stockVO vo) {
		return dao.AllResStockList(vo);
	}

	@Override
	public List<BdCardLssuedVO> NoStockList(String bdh_id) {
		return dao.NoStockList(bdh_id);
	}

	@Override
	public BdCardLssuedVO detailNoStock(String bd_code) {
		return dao.detailNoStock(bd_code);
	}

	@Override
	public int stockSet(Blood_stockVO vo) {
		return dao.stockSet(vo);
	}

	@Override
	public String getRegion(String bdh_id) {
		return dao.getRegion(bdh_id);
	}


	

}
