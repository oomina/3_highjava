package kr.or.redplus.dao.hospital;

import java.util.List;

import kr.or.redplus.vo.Blood_applyVO;
import kr.or.redplus.vo.Blood_stockVO;

public interface IHospitalDao {

	/**
	 * 병원의 지역을 불러오는 메소드
	 * @param id
	 * @return 지역명
	 */
	public String getRegion(String id);
	
	/**
	 * 병원의 해당 권역의 혈액원의 혈액을 불러오는 메소드
	 * @param hos_id
	 * @return
	 */
	public List<Blood_stockVO> getBloodList(String hos_id);
	
	
	/**
	 * 병원이 해당 혈액 이송 요청
	 * @param requestInfo
	 * @return
	 */
	public int DeliveryReq(Blood_applyVO requestInfo);
	
	/**
	 * 병원의 해당 권역의 혈액원 미수령리스트 재고
	 * @param hos_id
	 * @return
	 */
	public List<Blood_stockVO> notRecieveList(String hos_id);
	
	/**
	 * 의료기관에서 혈액을 수령했을때 처리하는 메소드
	 * @param bloodInfo
	 * @return
	 */
	public int reciveBlood(Blood_applyVO bloodInfo);
	
	/**
	 * 해당 의료기관의 재고List를 가져오는 메소드
	 * @param hos_id
	 * @return
	 */
	public List<Blood_stockVO> getStockList(String hos_id);
	
	/**
	 * 혈액 사용 완료처리
	 * @param bd_code 혈액코드
	 * @return
	 */
	public int bdStockUse(String bd_code);
	
}
