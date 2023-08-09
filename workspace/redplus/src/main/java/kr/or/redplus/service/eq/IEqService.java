package kr.or.redplus.service.eq;

import kr.or.redplus.vo.eq.EqVO;

public interface IEqService {
	/**
	 * 전자문진 하기전에 회원인지 체크
	 * @param vo
	 * @return
	 */
	public String eqLogin(EqVO vo);
	
	/**
	 * 전자문진 완료 후 문진 여부 db삽입
	 * @param memId
	 * @return
	 */
	public int insertEq(String memId);
}
