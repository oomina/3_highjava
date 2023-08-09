package kr.or.redplus.dao.bdhcard;

import java.util.List;

import kr.or.redplus.vo.BdCardLssuedVO;
import kr.or.redplus.vo.MemberVO;

public interface IBCLdao {
	/**
	 * 이름, 주민번호를 검색하여 유효한 사용자인지 체크하는 함수
	 * 
	 * @param vo 사용자 이름, 주민번호
	 * @return 존재하면 해당 유저 모든 정보 리턴, 없으면 null
	 */
	public MemberVO clientCheck(BdCardLssuedVO vo);
	
	/**
	 * 헌혈증 테이블의 데이터를 설정하는 함수(헌혈증 발급)
	 * 
	 * @param vo 헌혈증의 대한 모든 정보
	 * @return 성공 : 1 / 실패 : 0
	 */
	public int bdCardSet(BdCardLssuedVO vo);
	
	/**
	 * 사용자 아이디를 토대로 예약했던 모든 시간을 가져오는 함수
	 * 
	 * @param mem_id 사용자 아이디
	 * @return 모든 예약날짜
	 */
	public List<String> dayCodeGet(BdCardLssuedVO mem_id);
	
	/**
	 * 사용자 아이디를 토대로 헌혈증이 존재하는 모든 날짜를 가져오는 함수
	 * 
	 * @param mem_id 사용자 아이디
	 * @return 모든 예약날짜
	 */
	public List<String> bdDateGet(BdCardLssuedVO mem_id);
}
