package kr.or.redplus.service.donation;

import java.util.List;

import kr.or.redplus.dao.donation.DonationDaoImpl;
import kr.or.redplus.dao.donation.IDonationDao;
import kr.or.redplus.vo.donation.DonationVO;

public class DonationServiceImpl implements IDonationService{
	private static IDonationService service;
	private IDonationDao dao;
	private DonationServiceImpl() {
		dao = DonationDaoImpl.getDao();
	}
	public static IDonationService getService() {
		if(service==null)
			service = new DonationServiceImpl();
		return service;
	}
	
	@Override
	public int reqDon(DonationVO vo) {
		return dao.reqDon(vo);
	}
	@Override
	public int countBdCard(String memId) {
		return dao.countBdCard(memId);
	}
	@Override
	public List<DonationVO> allReqList(String memId) {
		return dao.allReqList(memId);
	}
	@Override
	public DonationVO regno(String memId) {
		return dao.regno(memId);
	}
	@Override
	public String changeName(String clientId) {
		return dao.changeName(clientId);
	}
	@Override
	public List<String> bdCode(String memId) {
		return dao.bdCode(memId);
	}
	@Override
	public int donationCard(DonationVO vo) {
		return dao.donationCard(vo);
	}
	@Override
	public List<DonationVO> cardList(String memId) {
		return dao.cardList(memId);
	}

}
