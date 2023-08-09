package kr.or.redplus.dao.bdhres;

import java.util.List;

import kr.or.redplus.vo.bdhres.BdhResVO;

public interface IBdhResDao {
	/**
	 * 헌혈예약전에 전자문진을 했을경우에만 예약할수있다.
	 * @param memId
	 * @return
	 */
	public int checkRes(String memId);
	
	/**
	 * 헌혈의집 찾는 메서드
	 * @param addr
	 * @return
	 */
	public List<BdhResVO> searchBdh(String addr);
	
	/**
	 * 예약 하기
	 * @param vo
	 * @return
	 */
	public int insertRes(BdhResVO vo);
	
	
	/**
	 * 예약 취소하기
	 * @param memId
	 * @return
	 */
	public int deleteRes(String memId);
	
	/**
	 * 헌혈의집 아이디 추출
	 * @param bdhName
	 * @return
	 */
	public String findBdhId(String bdhName);
	
	/**
	 * 헌혈가능 시간 조회
	 */
	public List<BdhResVO> ableTime(BdhResVO vo);
	
	/**
	 *  회원 개인정보
	 */
	public BdhResVO memInfo(String memId);
	
	/**
	 * 다시 예약할 수있는 날짜 업데이트
	 */
	public int ableResUpdate(BdhResVO vo);
	
	/**
	 * 헌혈종류 기간
	 */
	public String typePeriod(String dtType);
	
	/**
	 * 예약 가능여부 체크(기간 만족시 예약 페이지로 이동할수있다)
	 */
	public int chkAbleRes(String memId);
	public int chkAbleRes2(String memId);
	
	/**
	 * 다음 예약가능일
	 */
	public String ableDate(String memId);
	
	public int updateAbledateSysdate(String memId);
	
	/**
	 * 마지막 지정헌혈 날짜
	 */
	public String lastDdRes(String memId);
	
	/**
	 * 예약 여부 체크(지정헌헐예약이 있을경우 예약 불가)
	 */
	public int chkDdRes(String memId);
}
