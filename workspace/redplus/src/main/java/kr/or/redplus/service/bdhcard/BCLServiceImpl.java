package kr.or.redplus.service.bdhcard;

import java.util.List;

import kr.or.redplus.dao.bdhcard.BCLdaoImpl;
import kr.or.redplus.vo.BdCardLssuedVO;
import kr.or.redplus.vo.MemberVO;

public class BCLServiceImpl implements IBCLService {
	private static BCLServiceImpl service;
	private BCLdaoImpl dao;
	
	private BCLServiceImpl() {
		dao = BCLdaoImpl.getDao();
	}
	
	public static BCLServiceImpl getService() {
		if(service==null) {
			service = new BCLServiceImpl();
		}
		return service;
	}
	
	@Override
	public MemberVO clientCheck(BdCardLssuedVO vo) {
		return dao.clientCheck(vo);
	}

	@Override
	public int bdCardSet(BdCardLssuedVO vo) {
		return dao.bdCardSet(vo);
	}

	@Override
	public List<String> dayCodeGet(BdCardLssuedVO vo) {
		return dao.dayCodeGet(vo);
	}

	@Override
	public List<String> bdDateGet(BdCardLssuedVO vo) {
		return dao.bdDateGet(vo);
	}

}
