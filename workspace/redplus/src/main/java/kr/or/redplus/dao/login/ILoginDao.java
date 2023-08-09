package kr.or.redplus.dao.login;

import kr.or.redplus.vo.ClientVO;

public interface ILoginDao {
	/**
	 * 사용자가 로그인한 정보를 토대로 존재하는지 여부 체크
	 * 
	 * @param vo 아이디, 비밀번호 정보
	 * @return true : client의 모든 정보 / false : null
	 */
	public ClientVO checkLogin(ClientVO vo);
}
