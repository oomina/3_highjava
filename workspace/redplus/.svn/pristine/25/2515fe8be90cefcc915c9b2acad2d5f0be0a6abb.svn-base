package kr.or.redplus.dao.dirdon;

import java.util.List;

import kr.or.redplus.vo.Direct_donaVO;

public interface IDirDonReqDao {

	/**
	 * 병원(의료기관)에서 기존에 요청한 지정헌혈 리스트 출력 (초기페이지 1)
	 * @param hos_id 병원ID
	 * @return Dir_donaVO 리스트
	 */
	public List<Direct_donaVO> getPrevList(String hos_id);

	/**
	 * 병원(의료기관)에서 기존에 요청한 지정헌혈 리스트 출력 (파라미터 - 페이지)
	 * @param hos_id 병원ID
	 * @param page 페이지
	 * @return
	 */
	public List<Direct_donaVO> getPrevList(String hos_id, int page);
	
	
	/**
	 * 병원에서 지정헌혈 요청글 작성
	 * @param request
	 * @return
	 */
	public int writeDdReq(Direct_donaVO request);
	
	/**
	 * 기존 요청리스트를 삭제하는 메소드
	 * @param dd_code 지정헌혈코드
	 * @return
	 */
	public int deleteDdReq(String dd_code);
	
}
