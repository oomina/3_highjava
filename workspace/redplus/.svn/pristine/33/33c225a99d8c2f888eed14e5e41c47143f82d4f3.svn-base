package kr.or.redplus.dao.resList;

import java.util.List;

import kr.or.redplus.vo.bdhres.BdhResVO;

public interface IResListDao {
	/**
	 * 다음 헌혈가능 날짜
	 */
	public String nextResDate(String memId);
	
	/**
	 * 헌혈한 회수
	 */
	public int countBd(String memId);
	
	/**
	 * 헌혈의집아이디
	 */
	public String bdhId(String memId);
	/**
	 * 혈액원 이름
	 */
	public String bbName(String bdhId);
	
	/**
	 *  헌혈의집 ID추출
	 */
	public String findBdhId(String bdhName);
	
	/**
	 * 과거헌혈 기록
	 */
	public List<BdhResVO> lastRes(String memId);
	
	/**
	 * 현재헌혈 예약
	 */
	public List<BdhResVO> curRes(String memId);
	
	/**
	 * 헌혈예약코드
	 */
	public String resCode(BdhResVO vo);
	
	/**
	 * 예약취소
	 */
	public int deleteRes(String resCode);
}
