package kr.or.redplus.dao.donation;

import java.util.List;

import kr.or.redplus.vo.donation.DonationVO;

public interface IDonationDao {
	/**
	 * 기부 요청하기
	 * @param vo
	 * @return
	 */
	public int reqDon(DonationVO vo);
	
	/**
	 * 헌혈증 개수
	 */
	public int countBdCard(String memId);
	
	/**
	 * 요청글 리스트
	 */
	public List<DonationVO> allReqList(String memId);
	
	/**
	 * 주민번호 추출
	 */
	public DonationVO regno(String memId);
	
	/**
	 * 변경된 카드오너 이름 추출
	 */
	public String changeName(String clientId);
	
	/**
	 * 헌혈증 코드 추출
	 */
	public List<String> bdCode(String memId);
	
	/**
	 * 헌혈증 기부
	 */
	public int donationCard(DonationVO vo);
	/**
	 * 보유 헌혈증 목록
	 */
	public List<DonationVO> cardList(String memId);
}
