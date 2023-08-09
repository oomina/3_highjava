package kr.or.redplus.dao.resManage;

import java.util.List;

import kr.or.redplus.vo.ResDetailVO;
import kr.or.redplus.vo.Res_manageVO;

public interface IResManageDao {
	/**
	 * 특정 날짜에 resManage정보를 가져오는 함수
	 * 
	 * @param vo 세션 헌혈의집 아이디, 날짜 정보
	 * @return 해당 아이디, 날짜에 맞는 모든 정보 리턴
	 */
	public List<Res_manageVO> getResManage(Res_manageVO vo);
	
	/**
	 * 상세 예약 정보를 확인하는 함수
	 * 
	 * @param vo 세션 헌혈의집 아이디, 날짜 정보, 시간 정보
	 * @return 해당 헌혈의집 아이디, 날짜, 시간에 맞는 모든 사용자 정보
	 */
	
	public List<ResDetailVO> getResDetail(Res_manageVO vo);
}
