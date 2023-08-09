package kr.or.redplus.service.resList;

import java.util.List;

import kr.or.redplus.dao.resList.IResListDao;
import kr.or.redplus.dao.resList.ResListDaoImpl;
import kr.or.redplus.vo.bdhres.BdhResVO;

public class ResListServiceImpl implements IResListService {
	private static IResListService service;
	private IResListDao dao;
	private ResListServiceImpl() {
		dao = ResListDaoImpl.getDao();
	}
	public static IResListService getService() {
		if(service==null)
			service = new ResListServiceImpl();
		return service;
	}
	@Override
	public String nextResDate(String memId) {
		return dao.nextResDate(memId);
	}

	@Override
	public int countBd(String memId) {
		return dao.countBd(memId);
	}

	@Override
	public String bdhId(String memId) {
		return dao.bdhId(memId);
	}

	@Override
	public String bbName(String bdhId) {
		return dao.bbName(bdhId);
	}

	@Override
	public String findBdhId(String bdhName) {
		return dao.findBdhId(bdhName);
	}

	@Override
	public List<BdhResVO> lastRes(String vo) {
		return dao.lastRes(vo);
	}

	@Override
	public List<BdhResVO> curRes(String vo) {
		return dao.curRes(vo);
	}
	@Override
	public String resCode(BdhResVO vo) {
		return dao.resCode(vo);
	}
	@Override
	public int deleteRes(String resCode) {
		return dao.deleteRes(resCode);
	}

}
