package kr.or.redplus.service.bdhres;

import java.util.List;

import kr.or.redplus.dao.bdhres.BdhResDaoImpl;
import kr.or.redplus.dao.bdhres.IBdhResDao;
import kr.or.redplus.vo.bdhres.BdhResVO;

public class BdhResServiceImpl implements IBdhResService{
	private static IBdhResService service;
	private IBdhResDao dao;
	private BdhResServiceImpl() {
		dao = BdhResDaoImpl.getDao();
	}
	public static IBdhResService getService() {
		if(service == null)
			service = new BdhResServiceImpl();
		return service;
	}
	
	@Override
	public int checkRes(String memId) {
		return dao.checkRes(memId);
	}

	@Override
	public List<BdhResVO> searchBdh(String addr) {
		return dao.searchBdh(addr);
	}

	@Override
	public int insertRes(BdhResVO vo) {
		return dao.insertRes(vo);
	}

	@Override
	public int deleteRes(String memId) {
		return dao.deleteRes(memId);
	}
	
	@Override
	public String findBdhId(String bdhName) {
		return dao.findBdhId(bdhName);
	}
	@Override
	public List<BdhResVO> ableTime(BdhResVO vo) {
		return dao.ableTime(vo);
	}
	@Override
	public BdhResVO memInfo(String memId) {
		return dao.memInfo(memId);
	}
	@Override
	public int ableResUpdate(BdhResVO vo) {
		return dao.ableResUpdate(vo);
	}
	@Override
	public int chkAbleRes(String memId) {
		return dao.chkAbleRes(memId);
	}
	@Override
	public int chkAbleRes2(String memId) {
		return dao.chkAbleRes2(memId);
	}
	@Override
	public String ableDate(String memId) {
		return dao.ableDate(memId);
	}
	@Override
	public String typePeriod(String dtType) {
		return dao.typePeriod(dtType);
	}
	@Override
	public int updateAbledateSysdate(String memId) {
		return dao.updateAbledateSysdate(memId);
	}
	@Override
	public String lastDdRes(String memId) {
		return dao.lastDdRes(memId);
	}
	@Override
	public int chkDdRes(String memId) {
		return dao.chkDdRes(memId);
	}

}
