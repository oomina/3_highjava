package kr.or.redplus.service.ddAccept;

import java.util.List;

import kr.or.redplus.vo.ClientVO;
import kr.or.redplus.vo.DdListVO;
import kr.or.redplus.vo.Direct_donaVO;
import kr.or.redplus.vo.Don_acceptVO;

public interface IDdAcceptService {
	/**
	 * 지정헌혈에서 수락되지 않는 요청 게시글을 호출하는 메소드
	 * 
	 * @return
	 */
	public List<Don_acceptVO> ddList();
	
	/**
	 * 사용자의 혈액형 정보를 가져오는 함수
	 * 
	 * @param client_id 사용자 아이디
	 * @return 사용자 혈액형 정보
	 */
	public String getBloodType(String client_id);
	
	/**
	 * 하나의 지정헌혈 게시글 확인하는 메소드
	 * 
	 * @param dd_code 확인할 지정헌혈 코드
	 * @return 지정헌혈요청 글 정보
	 */
	public Direct_donaVO ddDetail(String dd_code);
	
	/**
	 * 병원 정보를 가져오는 메소드
	 * 
	 * @param hos_id 병원아이디
	 * @return 병원 정보 리턴
	 */
	public ClientVO getHosInfo(String hos_id);
	
	/**
	 * 회원이 일반예약을 한 현황(시간)을 확인하는 메소드
	 * 
	 * @param user_id 확인할 회원 아이디
	 * @return 일반예약 마지막 가능시간
	 */
	public String resTimeCheck(String user_id);
	
	/**
	 * 회원이 지정예약을 한 현황(시간)을 확인하는 메소드
	 * 
	 * @param user_id 확인할 회원 아이디
	 * @return 지정예약 마지막 가능시간
	 */
	public String ddTimeCheck(String user_id);
	
	/**
	 * 지정헌혈수락 내역을 저장하는 메소드
	 * 
	 * @param vo 지정헌혈수락 추가할 내용
	 * @return 성공 : 1, 실패 : 0
	 */
	public int acceptSet(Don_acceptVO vo);
	
	/**
	 * 지정헌혈을 한 횟수를 가져오는 메소드
	 * 
	 * @param mem_id 회원ID
	 * @return 지정헌혈 횟수
	 */
	public int getDdCount(String mem_id);
	
	/**
	 * 지정헌혈의 대한 정보들을 가져오는 메소드
	 * 
	 * @param mem_id 회원ID
	 * @return 지정헌혈의 대한 정보
	 */
	public DdListVO getDdList(String mem_id);
	
	/**
	 * 지정헌혈 내역을 삭제하는 메소드
	 * 
	 * @param dd_code 삭제할 코드
	 * @return 성공 시 1 , 실패 시 0
	 */
	public int deleteDd(String dd_code);
	
	/**
	 * 예전 지정헌혈 내역을 가져오는 메소드
	 * 
	 * @param mem_id 회원ID
	 * @return
	 */
	public List<DdListVO> listDdAll(String mem_id);
	
}
