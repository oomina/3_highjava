package kr.or.redplus.service.join;

import java.util.List;
import java.util.UUID;

import kr.or.redplus.dao.join.IJoinDao;
import kr.or.redplus.dao.join.JoinDaoImpl;
import kr.or.redplus.vo.JoinVO;
import kr.or.redplus.vo.JoinZipVO;

public class JoinServiceImpl implements IJoinService {
	
	private IJoinDao dao;
	private static IJoinService service;
	
	private JoinServiceImpl() {
		dao = JoinDaoImpl.getDao();
	}
	
	public static IJoinService getService() {
		if(service == null) {
			service = new JoinServiceImpl();
		}
		
		return service;
	}
	
	@Override
	public int insertClient(JoinVO vo) {
		return dao.insertClient(vo);
	}
	
	@Override
	public int insertMember(JoinVO vo) {
		return dao.insertMember(vo);
	}
	
	@Override
	public String idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public List<JoinZipVO> selectByDong(String dong) {
		return dao.selectByDong(dong);
	}

	@Override
	public String findId(JoinVO vo) {
		String res = "";
		res = dao.findId(vo);
		return res; 
	}

	@Override
	public String findPassword(JoinVO vo) {
		String res = "";
		String id = dao.findPassword(vo);
		if(id != null) {
			UUID uuid = UUID.randomUUID();
			String uuidPass = uuid.toString();
			uuidPass = uuidPass.substring(0,8);
			vo.setClient_pass(uuidPass);
			dao.updatePassword(vo);
			res = uuidPass;
		}
		return res;
	}

	@Override
	public JoinVO memberInfo(JoinVO vo) {
		return dao.memberInfo(vo);
	}

	@Override
	public int updateMember(JoinVO vo) {
		return dao.updateMember(vo);
	}

	@Override
	public int regnoChk(JoinVO vo) {
		return dao.regnoChk(vo);
	}
}
